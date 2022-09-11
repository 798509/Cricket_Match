public class Team
 {
     private static final int noOfMatches=5;
    private String teamName;
    private int points;
    private char[] stats;
    public Team(String teamName,int points){
        this.teamName=teamName;
        this.points=points;
        this.stats=new char[noOfMatches];
    }
     public int getPoints() {
        return points;
    }
     public void addStats(char[] results) {
         for (int i = 0; i < noOfMatches; i++)
             this.stats[i] = results[i];
     }
     public boolean checkConsecutiveLossOrWin(int n){
        int count=1;
        for(int i=0;i<stats.length-1;i++){
            if(stats[i]=='L' && stats[i+1]=='L' || stats[i]=='W' && stats[i+1]=='W')
                count++;
            else
                count=1;
            if(count==n)
                return true;
        }
        return false;
     }
 }

class Match
{

    public static void main (String[] args) {
        Team teams[]=new Team[5];
       teams[0]=new Team("PBKS",6);
        teams[0].addStats(new char[]{'L', 'L', 'L', 'W', 'W'});
        teams[1]=new Team("SRH",20);
        teams[1].addStats(new char[]{'W', 'L', 'W', 'W', 'W'});
        teams[2]=new Team("LSG",6);
        teams[2].addStats(new char[]{'L', 'W', 'L', 'L', 'W'});
        teams[3]=new Team("RR",6);
        teams[3].addStats(new char[]{'L', 'L', 'L', 'W', 'W'});
        teams[4]=new Team("SRH",10);
        teams[4].addStats(new char[]{'L', 'W', 'L', 'W', 'L'});
        int n=2;     //enter the value of n for the nn consecutive win and loss//
        int totalTeams=0,sumOfPoints=0;
        for(int i=0;i<5;i++){
            if(teams[i].checkConsecutiveLossOrWin(n)) {
                sumOfPoints=sumOfPoints+teams[i].getPoints();
                totalTeams++;
            }
        }
        System.out.println("Total Teams:"+totalTeams+"  "+"AVG:"+sumOfPoints/totalTeams);
    }
}

