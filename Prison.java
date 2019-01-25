import java.util.Random;

public class Prison {

  //True : the prisoner betrayed.
  //False : the prisoner stayed silent.
  final static boolean BETRAYED = true;
  final static boolean SILENT = false;

  public static void main(String[] args){
  boolean [] playerA = [BETRAYED]; //for the first turn player A will always start  as Betrayed
  boolean [] playerB = []; //player B will change 
  int playerAScore = 0;
  int playerBScore = 0;

    //The last choice of each prisoner.

    boolean lastChoicePrisonerA //= BETRAYED; //Set initially to BETRAYED for testing
    boolean lastChoicePrisonerB;

  '''  //Example 1: PrisonerB using no prior information
    lastChoicePrisonerB = randomChoice();

    System.out.println("If Random Choice is the strategy, B decides to betray : "
       + lastChoicePrisonerB);

    //Example 2: PrisonerB using the last choice made by A to make a decision
    lastChoicePrisonerB = betrayIfBetrayed(lastChoicePrisonerA);

    System.out.println("If Betray If Betrayed is the strategy, B decides to betray : "
       + lastChoicePrisonerB);'''
  }

  public static boolean randomChoice(){
      Random rand = new Random();
      return rand.nextBoolean();
  }

  public static boolean betrayIfBetrayed(boolean lastChoice){
      if(lastChoice == BETRAYED)
        return BETRAYED;
      else
        return randomChoice();
  }
  public static boolean Revange(boolean lastChoice){
      while (lastChoice != BETRAYED)
        return SILENT;
      return BETRAYED;
    }
// Revange is silent until he gets betrayed and from then on he betrayes.
  public static boolean Peace(){
        return SILENT;
      }
// Peace is always giving Silens
  public static boolean ZigZeg(boolean lastChoice){
      if (lastChoice == BETRAYED)
        return SILENT;
      else
        return BETRAYED;
      }
  public static boolean War(boolean lastChoice){
      return BETRAYED;
    }
  public static boolean titForTat(boolean lastChoice){
      if (lastChoice == BETRAYED){
        return BETRAYED;
      }
      else{
        return SILENT;
      }
  }



  public static void finalScores(){
    int i = 0;
    while(i < playerA.size()){
    if (playerA[i] == BETRAYED && playerB[i] == BETRAYED){
      playerAScore = playerAScore + 2;
      playerBScore = playerBScore + 2;
    }
    if (playerA[i] == BETRAYED && playerB[i] == SILENT){
      playerBScore = playerBScore + 3;
    }
    if (playerA[i] == SILENT && playerB[i] == BETRAYED){
      playerAScore = playerAScore + 3;
    }
    if (playerA[i]) == SLILENT && playerBScore == SILENT){
      playerAScore = playerAScore + 1;
      playerBScore = playerBScore + 1;
    }
  }
    i = i + 1;
  }
  }
  // ZigZeg is for the previous choice of your own player you switch approach
