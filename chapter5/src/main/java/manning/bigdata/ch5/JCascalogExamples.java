package manning.bigdata.ch5;

import java.util.ArrayList;
import java.util.List;

import cascalog.ops.RandLong;
import jcascalog.Api;
import jcascalog.Option;
import jcascalog.Subquery;
import jcascalog.op.Count;
import jcascalog.op.Div;
import jcascalog.op.GT;
import jcascalog.op.Limit;
import jcascalog.op.LT;
import jcascalog.op.Multiply;
import jcascalog.op.Plus;
import jcascalog.op.Sum;

import com.twitter.maple.tap.StdoutTap;

import static manning.bigdata.ch5.CustomFunctions.*;
import static manning.bigdata.ch5.Playground.*;
import static manning.bigdata.ch5.PredicateMacros.*;

public class JCascalogExamples {
  
  // SUBQUERIES
  
  public static Subquery peopleLess30() {
    return new Subquery("?person")
      .predicate(AGE, "?person", "?age")
      .predicate(new LT(), "?age", 30);
  }    
  
  public static Subquery numFollows() {
    return new Subquery("?person", "?count")
      .predicate(FOLLOWS, "?person", "_")
      .predicate(new Count(), "?count");
  }  
  
  public static Subquery countPeopleUnder30ByGender() {
    return new Subquery("?gender", "?count") 
      .predicate(GENDER, "?person", "?gender")
      .predicate(AGE, "?person", "?age") 
      .predicate(new LT(), "?age", 30) 
      .predicate(new Count(), "?count"); 
  }
  
  public static Subquery complicatedQuery() {
    return new Subquery("?a", "?avg")
      .predicate(VAL1, "?a", "?b")
      .predicate(VAL2, "?a", "?c")
      .predicate(new Multiply(), 2, "?b").out("?double-b")
      .predicate(new LT(), "?b", "?c")
      .predicate(new Count(), "?count")
      .predicate(new Sum(), "?double-b").out("?sum")
      .predicate(new Div(), "?sum", "?count").out("?avg")
      .predicate(new Multiply(), 2, "?avg").out("?double-avg")
      .predicate(new LT(), "?double-avg", 50);
  } 
  
  public static Subquery parseTransactionData(String path) {
    return new Subquery("?buyer", "?seller", "?amt", "?timestamp")
      .predicate(Api.hfsTextline(path), "?line")
      .predicate(new ParseTransactionRecord(), "?line")
      .out("?buyer", "?seller", "?amt", "?timestamp");
  }

  public static Subquery buyerNumTransactions(String path) {
    return new Subquery("?buyer", "?count")
      .predicate(parseTransactionData(path), "?buyer", "_", "_", "_")
      .predicate(new Count(), "?count");
  }  
  
  public static Subquery chainsLength3(Object pairs) {
    return new Subquery("?a", "?b", "?c")
      .predicate(pairs, "?a", "?b")
      .predicate(pairs, "?b", "?c");
  }
  
  public static Subquery chainsLength4(Object pairs) {
    return new Subquery("?a", "?b", "?c", "?d")
      .predicate(pairs, "?a", "?b")
      .predicate(pairs, "?b", "?c")
      .predicate(pairs, "?c", "?d");
  }
  
  public static Subquery chainsLengthN(Object pairs, int n) {
    List<String> genVars = new ArrayList<String>();
    for(int i=0; i<n; i++) {
      genVars.add(Api.genNullableVar());
    }
    
    Subquery ret = new Subquery(genVars);
    for(int i=0; i<n-1; i++) {
      ret = ret.predicate(pairs, genVars.get(i), genVars.get(i+1));
    }
    return ret;
  }

  public static Subquery fixedRandomSample(Object data, int n) {
    List<String> inputVars = new ArrayList<String>();
    List<String> outputVars = new ArrayList<String>();
    for(int i=0; i < Api.numOutFields(data); i++) {
      inputVars.add(Api.genNullableVar());
      outputVars.add(Api.genNullableVar());
    }
    
    String randVar = Api.genNullableVar();
    return new Subquery(outputVars)
      .predicate(data, inputVars)
      .predicate(new RandLong(), randVar)
      .predicate(Option.SORT, randVar)
      .predicate(new Limit(n), inputVars).out(outputVars);
    }
  
  public static Subquery distinctCountManual() {
    return new Subquery("?unique-followers-count")
      .predicate(FOLLOWS, "?person", "_")
      .predicate(Option.SORT, "?person")
      .predicate(new DistinctCountAgg(), "?person")
      .out("?unique-followers-count");
  }

  public static Subquery repetitiveFunction() {
    return new Subquery("?x", "?y", "?z")
      .predicate(TRIPLETS, "?a", "?b", "?c")
      .predicate(new IncrementFunction(), "?a").out("?x")
      .predicate(new IncrementFunction(), "?b").out("?y")
      .predicate(new IncrementFunction(), "?c").out("?z");
  }
  
  public static Subquery eachFunction() {
    return new Subquery("?x", "?y", "?z")
      .predicate(TRIPLETS, "?a", "?b", "?c")
      .predicate(new Each(new IncrementFunction()), "?a", "?b", "?c")
        .out("?x", "?y", "?z");
  }  
  
  public static Object Increment = new Partial(new Plus(), 1);
  
  public static Subquery partialUse() {
    return new Subquery("?x", "?y", "?z")
      .predicate(TRIPLETS, "?a", "?b", "?c")
      .predicate(new Each(new Partial(new Plus(), 1)),
        "?a", "?b", "?c").out("?x", "?y", "?z");      
  } 
  
  public static Subquery partialExpanded() {
    return new Subquery("?x", "?y", "?z")
      .predicate(TRIPLETS, "?a", "?b", "?c")
      .predicate(new Plus(), 1, "?a").out("?x")
      .predicate(new Plus(), 1, "?b").out("?y")
      .predicate(new Plus(), 1, "?c").out("?z");       
  }   
  

  // EXECUTIONS
  
  public static void wordCount() {
    Api.execute(new StdoutTap(),
        new Subquery("?word", "?count")
    .predicate(SENTENCE, "?sentence")
    .predicate(new Split(), "?sentence").out("?word")
    .predicate(new Count(), "?count"));
  }

  public static void followsManyFollows() {
    Subquery manyFollows = new Subquery("?person")                    
      .predicate(FOLLOWS, "?person", "_")
      .predicate(new Count(), "?count")
      .predicate(new GT(), "?count", 2);
    Api.execute(new StdoutTap(),
        new Subquery("?person1", "?person2")
          .predicate(manyFollows, "?person1")
          .predicate(manyFollows, "?person2")
          .predicate(FOLLOWS, "?person1", "?person2"));        
  }
  
  public static void wordCountCounts() {
    Subquery wordCount = new Subquery("?word", "?count")
      .predicate(SENTENCE, "?sentence")
      .predicate(new Split(), "?sentence").out("?word")
      .predicate(new Count(), "?count");
    Api.execute(new StdoutTap(),
        new Subquery("?count", "?num-words")
          .predicate(wordCount, "?word", "?count")
          .predicate(new Count(), "?num-words"));
  }
  
  // ADDITIONAL MATERIAL
  
  public static Subquery aggExamples() {
    return new Subquery("?count")
      .predicate(AGE, "_", "?age")
      .predicate(new LT(), "?age", 30)
      .predicate(new Count(), "?count");
  }

  public static Subquery peopleFromAge() {
    return new Subquery("?person")
      .predicate(AGE, "?person", "?age");
  }

  public static Subquery people25() {
    return new Subquery("?person")
      .predicate(AGE, "?person", 25);
  } 

  public static Subquery peopleLess30WithAge() {
    return new Subquery("?person", "?age")
      .predicate(AGE, "?person", "?age")
      .predicate(new LT(), "?age", 30);
  }
    
  public static Subquery peopleDoubleAge() {
    return new Subquery("?person", "?double-age")
      .predicate(AGE, "?person", "?age")
      .predicate(new Multiply(), "?age", 2).out("?double-age");
  }     

  public static Subquery peopleDoubleAgeAndIncrement() {
    return new Subquery("?person", "?double-age-plus-1")
      .predicate(AGE, "?person", "?age")
      .predicate(new Plus(), "?double-age", 1)
      .out("?double-age-plus-1")
      .predicate(new Multiply(), "?age", 2).out("?double-age");
  }    
    
  public static Subquery squareEqual() {
    return new Subquery("?n")
      .predicate(INTEGER, "?n")
      .predicate(new Multiply(), "?n", "?n").out("?n");
  }

  public static Subquery cubeEqual() {
    return new Subquery("?n")
      .predicate(INTEGER, "?n")
      .predicate(new Multiply(), "?n", "?n", "?n").out("?n");
  }

  public static Subquery ageGenderJoin() {
    return new Subquery("?person", "?age", "?gender")
      .predicate(AGE, "?person", "?age")
      .predicate(GENDER, "?person", "?gender");
  }

  public static Subquery emilyMaleFollows() {
    return new Subquery("?person")
      .predicate(FOLLOWS, "emily", "?person")
      .predicate(GENDER, "?person", "m");
  }     

  public static void outerJoinExamples() {
    new Subquery("?person", "?age", "!!gender")
      .predicate(AGE, "?person", "?age")
      .predicate(GENDER, "?person", "!!gender");

    new Subquery("?person", "!!age", "!!gender")
      .predicate(AGE, "?person", "!!age")
      .predicate(GENDER, "?person", "!!gender"); 
  }

  public static Subquery followYounger() {
    return new Subquery("?person1", "?person2")
      .predicate(FOLLOWS, "?person1", "?person2")
      .predicate(AGE, "?person1", "?age1")
      .predicate(AGE, "?person2", "?age2")
      .predicate(new LT(), "?age2", "?age1");
  } 
    
  public static Subquery numberLessThan30() {
    return new Subquery("?count")
      .predicate(AGE, "_", "?age")
      .predicate(new LT(), "?age", 30)
      .predicate(new Count(), "?count");
  }

  public static Subquery followsCount() {
    return new Subquery("?person", "?count")
      .predicate(FOLLOWS, "?person", "_")
      .predicate(new Count(), "?count");
  }    
    
  @SuppressWarnings("unused")
  public static void invalidAndValidAggs() {

    Subquery invalidQuery = new Subquery("?sum", "?count")
      .predicate(INTEGER, "?n")
      .predicate(new SumBuffer(), "?n").out("?sum")
      .predicate(new Count(), "?count");

    Subquery validQuery = new Subquery("?sum", "?count")
      .predicate(INTEGER, "?n")
      .predicate(new SumAggregator(), "?n").out("?sum")
      .predicate(new Count(), "?count");
  }    

  public static Subquery distinctCountExample() {
    return new Subquery("?unique-followers-count")
      .predicate(FOLLOWS, "?person", "_")
      .predicate(new DistinctCount(), "?person")
      .out("?unique-followers-count");
  }
    
  public static Subquery averageExample() {
    return new Subquery("?result")
      .predicate(INTEGER, "?n")
      .predicate(Average, "?n").out("?result");
  }
    
  public static Subquery averageExampleExpanded() {
    return new Subquery("?result")
    .predicate(INTEGER, "?n")
    .predicate(new Count(), "?count_gen1")
    .predicate(new Sum(), "?n").out("?sum_gen2")
    .predicate(new Div(), "?sum_gen2", "?count_gen1", "?result");
  }
}