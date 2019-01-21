# Project 1
In this project, you will develop bots that play a simple game. Each bot has a different strategy. You will pit these bots against each other to determine which strategy is more successful in this context. These bots are incredibly simple, and consist of a few lines of code and methods that represent different strategies of play.

# Teams
Teams have been assigned for this project and will be posted on Blackboard. They are fixed - no switching or cooperating across team lines. It is up to teammates to ensure that their partner adheres to the <a href="https://www.american.edu/academics/integrity/code.cfm">American University Honor Code.</a> You may use [pair programming](https://en.wikipedia.org/wiki/Pair_programming), however, you must each take turns in the driver role on your own laptop. I should see commits on Github for each of you to get full credit for this assignment.

## Step 0 - Background Research.
1. **Both members** should review the description for the <a href="https://en.wikipedia.org/wiki/Prisoner%27s_dilemma">Prisoner's Dilemma</a> on Wikipedia. You *do not* need to become familiar with the intimate mathematical details of the Dilemma, just the general mechanism and the difference between the iterated dilemma and the non-iterated version (Introduction through the end of Section 3.1).
2. This topic has been debated endless in a variety of fields, so there is a lot of additional material available if you want to dig deeper. For this assignment, you will only be required to be familiar with the basics (e.g., you will not need to understand the Nash equilibrium or the proof that goes with it).
4. **Both members** should work together to devise five strategies for "winning" the prisoner's dilemma over a long number of iterations. I recommend first writing these strategies down in simple English rather than trying to jump directly into developing code. You may use the 'tit-for-tat' strategy as one of them, or come up with ones of your own.
5. **Optional** There are several good videos that can help make these concepts a little clearer. I recommend [this one](https://www.youtube.com/watch?v=BOvAbjfJ0x0), but there are many others.

## Step 1 - Create the Repo for your Team.
1. **Both members** of your team will visit <a href='https://classroom.github.com/g/jrobClld'> this link</a>. This will create a repo for your team in Github. For this assignment, you will share a Github repo with your teammate. If you are the first member of your team to visit the link, you can create the team and the repo - **make sure you create the right team**. If you are the second member to click the link, then **make sure** you join the right team.
2. **Both members** will clone the repository to your local machines (i.e., using `git clone <URL>`). You will then each have a local repository that is linked to the shared repository, and can work on the code together.
3. As a reference for how to use git, I suggest <a href='http://codingdomain.com/git/'>this site</a>, as it avoids some of the more complicated theory behind git and focuses on the bare minimum practicalities.

## Step 2 - Review the Provided Code.
In the repository is a starter class, `Prison`, that has the bare minimum for the prisoner's dilemma. There is a variable for the last choice made by each of two prisoners, (i.e., Prisoner A and Prisoner B).

```java
//The last choice of each prisoner.

    boolean lastChoicePrisonerA = BETRAYED; //Set initially to BETRAYED for testing
    boolean lastChoicePrisonerB;
```

Two examples are given. Prisoner B is using a `randomChoice()` strategy, in which B will randomly choose to *stay silent* or *betray* Prisoner A. This strategy does not use prior information to make the decision - it is equivalent to flipping a coin. The provided code gives an example of a second strategy: `betrayIfBetrayed()`. If A *betrayed* last time, then B will *betray* also. However, if A *stayed silent*, B will randomly choose to *stay silent* or *betray* based on the results of a coin flip. The coin flip is generated using the `Random` class, a more thorough description of which can be found <a href="https://docs.oracle.com/javase/10/docs/api/java/util/Random.html">here</a>.

```java
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
```

## Step 3 - Write one method for each strategy.
Following the design pattern for the example strategies, define one method for each of your team's five strategies (the example methods do not count). Assume that each prisoner can know the outcome of one or more previous encounters with the other prisoner through parameters passed to the method.

## Step 3.5 - Commit and Push to Github
Remember, this is not like using Blackboard for submitting assignments. As you are working with your teammate, you will need to frequently push code to the Github repo so that your teammate can access it. If you wait to the last minute, you could have conflicts that are difficult to resolve. It is much better to get into a rhythm with your partner early rather. To get full credit for your part in this, I need to see multiple commits from each team member.

## Step 4 - Write a method for scoring the outcome
If they both stay silent then both prisoners serve 1 year. If a prisoner *stays silent* and the other *betrays*, then the prisoner who stayed silent gets 3 years in prison while the other goes free. If both *betray*, then each prisoner serves 2 years. Write a method that assigns a score to a strategy based upon the outcome. A high score is a bad thing, as each point represents a number of additional years added to the prisoner's sentence.

&nbsp; | A betrays | A stays silent
-|-|-
B  betrays | A:2 / B:2| A:3 / B:0
B stays silent | A:0 / B:3 | A:1 / B:1

## Step 5 - Test your Strategies
Using your five strategies and your scoring method, determine which strategy is most effective by pitting them against each other. You are free to determine the extent to which you test your strategies, but for one strategy to be declared dominant to another in a pairing, they should compete over no fewer than 100 iterations.

## Step 6 - Push to Github
Do not forget to push your final submission to Github before the deadline.

## Step 7 - Peer and Self Review
A separate form will be made available for you to rate your own performance and your partner's.

# Grading
Grading will be assigned according to the following categories. As described in the syllabus, each category can receive a  &#10003; (satisfactory); a &#10003;+ (above and beyond); a &#10003;- (incorrect, incomplete, or sloppy); or in the worst case an &#10005;, meaning it was altogether missing or inappropriate (assigned at the instructor's discretion). A category assigned an &#10005; can carry significant grade penalties for this assignment.

1. Repository / Teamwork. Everyone contributed and used the repository well.
2. Comments and Code Formatting. The code is easy to follow and understand.
3. Project Design. The code is designed to do what the project requires.
4. Implementation. The code does what it was designed to do.

Rating | Repository | Form | Design | Implementation
-|-|-|-|-
&#10003;+ | Evidence of branching and merging. | Project is commented and styled according to [Javadoc](https://www.oracle.com/technetwork/java/javase/documentation/index-137868.html) Guidelines. | Project includes five strategies that are substantially different from each other; tests all combinations of them; provides a formatted printout of the outcomes | Project is free of logical and syntax errors; extensive and creative use of Java commands and classes to reduce length and/or complexity.
&#10003; | Multiple commits from each teammate | Project is commented and styled neatly. | Project includes five strategies that are different from each other; tests two of them; provides a printout of the winner | Project compiles
&#10003;- | Evidence that one teammate did most of the work and/or all commits were through web interface | Comments are sparse and/or code styling is difficult to follow. | Strategies are too similar or incomplete; minimal testing; printout of program execution status only | Project compiles with some minor correction