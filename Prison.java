import java.util.Random;

public class Prison {
  //True : the prisoner betrayed.
  //False : the prisoner stayed silent.
  final static boolean BETRAYED = true;
  final static boolean SILENT = false;

  public static void main(String[] args){
 //the first move made by playerA will always start as betrayed

String [] strategies = {"Revenge", "Peace", "ZigZeg", "WarAtThree", "titForTat"};
    //The last choice of each prisoner.
    int Rev =0;
    int Pea = 0;
    int Zig = 0;
    int War = 0;
    int tit = 0;
    for(int i = 0; i < 25; i++){
    boolean [] playerA = StartGame((i/5), i % 5,0);
    boolean [] playerB = StartGame((i/5), i % 5,1);
    int playerAScore = finalScores(playerA, playerB,0);
    int playerBScore = finalScores(playerA, playerB,1);
    System.out.println("PrisonerA: " + strategies[(int)(i / 5)] +" " +playerAScore + "  years. " + "Prisoner B: " + strategies[i % 5]+" " + playerBScore + "  years");
    if ((i/5)==0){
       Rev = playerAScore + Rev;
    }
    if ((i/5)==1){
       Pea = playerAScore + Pea;
    }
    if ((i/5)==2){
       Zig = playerAScore + Zig;
    }
    if ((i/5)==3){
       War = playerAScore + War;
    }
    if ((i/5)==4){
       tit = playerAScore + tit;
    }
  }
  System.out.println("\n"+"Total years for each strategy in comparison to all the strategies");
  System.out.println("Revenge " +Rev + "\n"+ "Peace " + Pea + "\n" + "ZigZeg "+ Zig + "\n" + "WarAtThree "+ War + "\n" + "titForTat "+ tit+ "\n");
  System.out.println("If you think about it, those answers make sense! \nand if you look at the iterations you see some differences in the results \nThis happens becuase the first move is random but then we always have the same player starting the game.");
}

public static boolean Revange(boolean lastChoice){
      int check = 0;
      while (lastChoice == BETRAYED && check ==0){
        check= check+1;
        return BETRAYED;
      }
      return SILENT;
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
    if (j%3 ==0){
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
static int j;
  //checks the last choice a player made
  public static boolean lastChoice(boolean [] player){
    boolean last = player[j];
    return last;
  }
  public static boolean randomMove(){
 double rand = Math.random();
  if (rand<0.5){
    return BETRAYED;
  }
  else {
    return SILENT;
  }
  }
  static boolean FirstmoveA = randomMove();
  static boolean FirstmoveB = randomMove();
  public static boolean [] StartGame(int strategy1,int strategy2,int n){
  boolean [] playerA = new boolean[100];
  boolean [] playerB = new boolean[100];
  playerA[0] = FirstmoveA;
  playerB[0] = FirstmoveB;
  for (j = 1; j<100; j++){
    playerA[j]= Switch(playerB,strategy1);
    playerB[j] = Switch(playerA,strategy2);

  }
  if (n==0){
    return playerA;
  }
  else {
    return playerB;

  }
}
//we give input of 0-4 to the strategy1 and 2 values. and player is choosing who plays
  public static boolean Switch(boolean [] player, int strategy){ // checks the moves that each player makes (compares the two strategies)

      if (strategy==0){
        boolean a =  Revange(lastChoice(player));
        return a;
      }
      if (strategy == 1){
        boolean b = Peace();
        return b;
      }
      if (strategy == 2){
        boolean c = ZigZeg(lastChoice(player));
        return c;
      }
      if(strategy== 3){
        boolean d =  WarAtThree(lastChoice(player));
        return d;
      }
      else {
        boolean e = titForTat(lastChoice(player));
        return e;
      }


}
  public static int finalScores(boolean [] playerA,boolean [] playerB, int n){ //compares the lists and adds up the total scores
    int i = 0;
    int playerAScore = 0;
    int playerBScore = 0;
    while(i < 100){
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
      if (playerA[i] == SILENT && playerB[i] == SILENT){
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
