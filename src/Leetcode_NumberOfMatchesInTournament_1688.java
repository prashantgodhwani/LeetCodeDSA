public class Leetcode_NumberOfMatchesInTournament_1688 {
    public static void main(String[] args) {
        System.out.println(numberOfMatches(14, (7 -1) / 2, (7 -1) / 2));
    }

    public static int numberOfMatches(int teams, int matches, int totalMatches) {
        System.out.println("teams  = "  +teams + ", matches = " + matches + ", totalMatches = " + totalMatches);
        if(teams == 1){
            totalMatches += matches;
            return totalMatches;
        }

        if(teams % 2 == 0){
            teams = teams/2;
            System.out.println("teams = " + teams);
            totalMatches  = numberOfMatches(teams, teams/2, totalMatches + (teams/2));
        }else{
            teams = teams/2 + 1;
            totalMatches  =  numberOfMatches(teams, teams/2, totalMatches + teams/2);
        }
        return totalMatches;
    }
}
