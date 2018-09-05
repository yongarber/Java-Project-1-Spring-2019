import java.util.Random;

public class Prison {

  public static void main(String[] args){
    //The last choice of each prisoner.
    //True : the prisoner betrayed.
    //False : the prisoner stayed silent.
    boolean lastChoicePrisonerA = false;
    boolean lastChoicePrisonerB;

    lastChoicePrisonerB = randomChoice(lastChoicePrisonerA);

    System.out.println(lastChoicePrisonerB);
  }

  public static boolean randomChoice(boolean lastChoice){
      Random rand = new Random();
      return lastChoice && rand.nextBoolean();
  }

}