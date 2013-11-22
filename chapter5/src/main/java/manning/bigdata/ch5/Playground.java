package manning.bigdata.ch5;

import java.util.Arrays;
import java.util.List;

@SuppressWarnings("unchecked")
public class Playground {
  public static List<?> SENTENCE = Arrays.asList(
      Arrays.asList("Four score and seven years ago our fathers brought forth on this continent a new nation"),
      Arrays.asList("conceived in Liberty and dedicated to the proposition that all men are created equal"),
      Arrays.asList("Now we are engaged in a great civil war testing whether that nation or any nation so"),
      Arrays.asList("conceived and so dedicated can long endure We are met on a great battlefield of that war"),
      Arrays.asList("We have come to dedicate a portion of that field as a final resting place for those who"),
      Arrays.asList("here gave their lives that that nation might live It is altogether fitting and proper"),
      Arrays.asList("that we should do this"),
      Arrays.asList("But in a larger sense we can not dedicate we can not consecrate we can not hallow"),
      Arrays.asList("this ground The brave men living and dead who struggled here have consecrated it"),
      Arrays.asList("far above our poor power to add or detract The world will little note nor long remember"),
      Arrays.asList("what we say here but it can never forget what they did here It is for us the living rather"),
      Arrays.asList("to be dedicated here to the unfinished work which they who fought here have thus far so nobly"),
      Arrays.asList("advanced It is rather for us to be here dedicated to the great task remaining before us"),
      Arrays.asList("that from these honored dead we take increased devotion to that cause for which they gave"),
      Arrays.asList("the last full measure of devotion that we here highly resolve that these dead shall"),
      Arrays.asList("not have died in vain that this nation under God shall have a new birth of freedom"),
      Arrays.asList("and that government of the people by the people for the people shall not perish"),
      Arrays.asList("from the earth")
      );    
    
  public static List<?> AGE = Arrays.asList(
      Arrays.asList("alice", 28),
      Arrays.asList("bob", 33),
      Arrays.asList("chris", 40),
      Arrays.asList("david", 25),
      Arrays.asList("emily", 25),
      Arrays.asList("george", 31),
      Arrays.asList("gary", 28),
      Arrays.asList("kumar", 27),
      Arrays.asList("luanne", 36)
      );

  public static List<?> GENDER = Arrays.asList(
      Arrays.asList("alice", "f"),
      Arrays.asList("bob", "m"),
      Arrays.asList("chris", "m"),
      Arrays.asList("david", "m"),
      Arrays.asList("emily", "f"),
      Arrays.asList("george", "m"),
      Arrays.asList("gary", "m"),
      Arrays.asList("harold", "m"),
      Arrays.asList("luanne", "f")
      );

  public static List<?> FOLLOWS = Arrays.asList(
      Arrays.asList("alice", "david"),
      Arrays.asList("alice", "bob"),
      Arrays.asList("alice", "emily"),
      Arrays.asList("bob", "david"),
      Arrays.asList("bob", "george"),
      Arrays.asList("bob", "luanne"),
      Arrays.asList("david", "alice"),
      Arrays.asList("david", "luanne"),
      Arrays.asList("emily", "alice"),
      Arrays.asList("emily", "bob"),
      Arrays.asList("emily", "george"),
      Arrays.asList("emily", "gary"),
      Arrays.asList("george", "gary"),
      Arrays.asList("harold", "bob"),
      Arrays.asList("luanne", "harold"),
      Arrays.asList("luanne", "gary")
      );

  public static List<?> INTEGER = Arrays.asList(
      Arrays.asList(-1),
      Arrays.asList(0),
      Arrays.asList(1),
      Arrays.asList(2),
      Arrays.asList(3),
      Arrays.asList(4),
      Arrays.asList(5),
      Arrays.asList(6),
      Arrays.asList(7),
      Arrays.asList(8),
      Arrays.asList(9)
      );

  public static List<?> VAL1 = Arrays.asList(
      Arrays.asList("a", 1),
      Arrays.asList("b", 2),
      Arrays.asList("c", 5),
      Arrays.asList("d", 12),
      Arrays.asList("d", 1)
      );

  public static List<?> VAL2 = Arrays.asList(
      Arrays.asList("b", 4),
      Arrays.asList("b", 6),
      Arrays.asList("c", 3),
      Arrays.asList("d", 15)
      );

  public static List<?> TRIPLETS = Arrays.asList(
      Arrays.asList(1, 2, 3),
      Arrays.asList(1, 4, 0),
      Arrays.asList(8, 5, 10),
      Arrays.asList(6, 89, 2)
      );
}