package manning.bigdata.ch5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jcascalog.Fields;
import jcascalog.Option;
import jcascalog.Predicate;
import jcascalog.PredicateMacro;
import jcascalog.PredicateMacroTemplate;
import jcascalog.op.Count;
import jcascalog.op.Div;
import jcascalog.op.Sum;

import static manning.bigdata.ch5.CustomFunctions.*;

public class PredicateMacros {
  
  public static PredicateMacroTemplate Average = 
      PredicateMacroTemplate.build("?val").out("?avg")
        .predicate(new Count(), "?count")
        .predicate(new Sum(), "?val").out("?sum")
        .predicate(new Div(), "?sum", "?count").out("?avg");
  
  public static class DistinctCount implements PredicateMacro {
    public List<Predicate> getPredicates(Fields inFields, Fields outFields) {
      List<Predicate> ret = new ArrayList<Predicate>();
      ret.add(new Predicate(Option.SORT, inFields));
      ret.add(new Predicate(new DistinctCountAgg(), inFields, outFields));
      return ret;
    }
  }
  
  public static class Each implements PredicateMacro {
    Object _op;

    public Each(Object op) {
      _op = op;
    }

    public List<Predicate> getPredicates(Fields inFields, Fields outFields) {
      List<Predicate> ret = new ArrayList<Predicate>();
      for(int i=0; i<inFields.size(); i++) {
        Object in = inFields.get(i);
        Object out = outFields.get(i);
        ret.add(new Predicate(_op, Arrays.asList(in), Arrays.asList(out)));
      }
      return ret;
    }        
  }
  
  public static class Partial implements PredicateMacro {
    Object _op;
    List<Object> _args;

    public Partial(Object op, Object... args) {
      _op = op;
      _args = Arrays.asList(args);
    }

    public List<Predicate> getPredicates(Fields inFields, Fields outFields) {
      List<Predicate> ret = new ArrayList<Predicate>();
      List<Object> input = new ArrayList<Object>();
      input.addAll(_args);
      input.addAll(inFields);
      ret.add(new Predicate(_op, input, outFields));
      return ret;
    }        
  }

}
