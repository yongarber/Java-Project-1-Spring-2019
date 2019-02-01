import java.util.Random;

public class Prison {

  //True : the prisoner betrayed.
  //False : the prisoner stayed silent.
  final static boolean BETRAYED = true;
  final static boolean SILENT = false;

  public static void main(String[] args){
 //the first move made by playerA will always start as betrayed

  List strategies = new ArrayList("Revenge", "Peace", "ZigZeg", "WarAtThree", "titForTat");
    //The last choice of each prisoner.
    for(int i = 0; i < 25; i++){
    int playerA = StartGame((int)(i/5), i % 5,0);
    int PlayerB = StartGame((int)(i/5), i % 5,1);
    int playerAScore = finalScores(playerA, playerB,0);
    int playerBScore = finalScores(playerA, playerB,0);
    System.out.println("PrisonerA: " + strategies[(int)(i / 5)] + playerAScore + " years. " + "Prisoner B: " + strategies[i % 5] + plaerBScore + "years");
  }}
  //boolean lastChoicePrisonerA; //= BETRAYED; //Set initially to BETRAYED for testing
   // boolean lastChoicePrisonerB;

   //Example 1: PrisonerB using no prior information
  //   lastChoicePrisonerB = randomChoice();

  //   System.out.println("If Random Choice is the strategy, B decides to betray : "
  //      + lastChoicePrisonerB);

  //   //Example 2: PrisonerB using the last choice made by A to make a decision
  //   lastChoicePrisonerB = betrayIfBetrayed(lastChoicePrisonerA);

  //   System.out.println("If Betray If Betrayed is the strategy, B decides to betray : "
  //      + lastChoicePrisonerB);


  // public static boolean randomChoice(){
  //     Random rand = new Random();
  //     return rand.nextBoolean();
  // }

  // public static boolean betrayIfBetrayed(boolean lastChoice){
  //     if(lastChoice == BETRAYED)
  //       return BETRAYED;
  //     else
  //       return randomChoice();

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
  public static boolean WarAtThree(boolean lastChoice){
    if (PlayerA.size()%3 ==0){
      return BETRAYED;
    }
    else{
      return SILENT;
    }
    }
  public static boolean titForTat(boolean lastChoice){
      if (lastChoice == BETRAYED){
        return BETRAYED;
      }
      else{
        return SILENT;
      }
  }

  public static boolean lastChoice(player){ //checks the last choice a player made
    boolean last = player.get(player.size() - 1);
    return last;
  }
  public static boolean randomMove(){
  int rand = Math.random();
  if (rand<0.5){
    return BETRAYED;
  }
  else {
    return SILENT;
  }
  }
  public static void StartGame(strategy1,strategy2,n){
  boolean FirstmoveA = randomMove();
  boolean FirstmoveB = randomMove();
  boolean [] playerA = new Boolean[100];
  boolean [] playerB = new Boolean[100];
  playerA[0] = FirstmoveA;
  playerB[0] = FirstmoveB;
  for (int i = 0; i<100; i++){
    playerA.add(Switch(PlayerB,strategy1));
    playerB.add(Switch(PlayerA,strategy1));
  }
  if (n==0){
    return PlayerA;
  }
  else {
    return PlayerB;
  }
}
//we give input of 0-4 to the strategy1 and 2 values. and player is choosing who plays
  public static void Switch(player, strategy){ // checks the moves that each player makes (compares the two strategies)

    if (strategy == 0 ){
      if (n==0){
      return Revange(lastChoice(player));
      }
    if (strategy == 1){
      return Peace();
    }
    if (strategy == 2){
      return ZigZeg(lastChoice(player));
    }
    if(strategy== 3){
      return WarAtThree(lastChoice(player));
    }
    if (strategy == 4) {
      return titForTat(lastChoice(player));
    }
}
  }

  public static int finalScores(playerA[], playerB[], n){ //compares the lists and adds up the total scores
    int i = 0;
    int playerAScore = 0;
    int playerBScore = 0;
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
      if (playerA[i] == SLILENT && playerBScore == SILENT){
          playerAScore = playerAScore + 1;
          playerBScore = playerBScore + 1;
        }
        i = i + 1;
  }
  if (n ==0){
    return playerAScore;
  }
  else {
    return playerBScore;
  }
}
}
  // ZigZeg is for the previous choice of your own player you switch approach

  //main running Code
