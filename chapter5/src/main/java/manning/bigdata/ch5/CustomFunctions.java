package manning.bigdata.ch5;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONValue;

import cascading.flow.FlowProcess;
import cascading.operation.AggregatorCall;
import cascading.operation.BufferCall;
import cascading.operation.FilterCall;
import cascading.operation.FunctionCall;
import cascading.operation.OperationCall;
import cascading.tuple.Tuple;
import cascading.tuple.TupleEntry;
import cascalog.CascalogAggregator;
import cascalog.CascalogBuffer;
import cascalog.CascalogFilter;
import cascalog.CascalogFunction;
import cascalog.ParallelAgg;

@SuppressWarnings({"rawtypes", "serial", "unchecked"})
public class CustomFunctions {
  
  public static class Split extends CascalogFunction {
    public void operate(FlowProcess process, FunctionCall call) {
      String sentence = call.getArguments().getString(0);
      for(String word: sentence.split(" ")) {
        call.getOutputCollector().add(new Tuple(word));
      }
    }
  }
  
  public static class GreaterThanTenFilter extends CascalogFilter {
    public boolean isKeep(FlowProcess process, FilterCall call) {
      return call.getArguments().getInteger(0) > 10;
    }
  }
  
  public static class IncrementFunction extends CascalogFunction {
    public void operate(FlowProcess process, FunctionCall call) {
      int v = call.getArguments().getInteger(0); 
      call.getOutputCollector().add(new Tuple(v + 1)); 
    }
  }
  
  public static class TryParseInteger extends CascalogFunction {
    public void operate(FlowProcess process, FunctionCall call) {
      String s = call.getArguments().getString(0);
      try {
        int i = Integer.parseInt(s);
        call.getOutputCollector().add(new Tuple(i));
      } catch(NumberFormatException e) {}
    }
  }
 
  public static class SumAggregator extends CascalogAggregator {
    public void start(FlowProcess process, AggregatorCall call) {
      call.setContext(0);
    }

    public void aggregate(FlowProcess process, AggregatorCall call) {
      int total = (Integer) call.getContext();
      call.setContext(total + call.getArguments().getInteger(0));
    }

    public void complete(FlowProcess process, AggregatorCall call) {
      int total = (Integer) call.getContext();
      call.getOutputCollector().add(new Tuple(total));
    }
  }
  
  public static class SumBuffer extends CascalogBuffer {
    public void operate(FlowProcess process, BufferCall call) {
      Iterator<TupleEntry> it = call.getArgumentsIterator();
      int total = 0;
      while(it.hasNext()) {
        TupleEntry t = it.next();
        total+=t.getInteger(0);
      }
      call.getOutputCollector().add(new Tuple(total));
    }        
  }

  public static class SumParallel implements ParallelAgg {
    public void prepare(FlowProcess process, OperationCall call) {}

    public List<Object> init(List<Object> input) {
      return input;
    }

    public List<Object> combine(List<Object> input1, List<Object> input2) {
      int val1 = (Integer) input1.get(0);
      int val2 = (Integer) input2.get(0);
      return Arrays.asList((Object) (val1 + val2));
    }
  }

  public static class CountParallel implements ParallelAgg {
    public void prepare(FlowProcess process, OperationCall call) {}

    public List<Object> init(List<Object> input) {
      return Arrays.asList((Object) 1);
    }

    public List<Object> combine(List<Object> input1,
        List<Object> input2) {
      int val1 = (Integer) input1.get(0);
      int val2 = (Integer) input2.get(0);
      return Arrays.asList((Object) (val1 + val2));
    }
  }    
  
  public static class ParseTransactionRecord extends CascalogFunction {
    public void operate(FlowProcess process, FunctionCall call) {
      String line = call.getArguments().getString(0);
      Map parsed = (Map) JSONValue.parse(line);
      call.getOutputCollector().add(
          new Tuple(parsed.get("buyer"),
                    parsed.get("seller"),
                    parsed.get("amt"),
                    parsed.get("timestamp")));            
    }
  }  
  
  public static class DistinctCountAgg extends CascalogAggregator {
    static class State {
      int count = 0;
      Tuple last = null;
    }

    public void start(FlowProcess process, AggregatorCall call) {
      call.setContext(new State());
    }

    public void aggregate(FlowProcess process, AggregatorCall call) {
      State s = (State) call.getContext();
      Tuple t = call.getArguments().getTupleCopy();
      if(s.last==null || !s.last.equals(t)) {
        s.count++;
      }
      s.last = t;
    }

    public void complete(FlowProcess process, AggregatorCall call) {
      State s = (State) call.getContext();
      call.getOutputCollector().add(new Tuple(s.count));
    }        
  }
}
