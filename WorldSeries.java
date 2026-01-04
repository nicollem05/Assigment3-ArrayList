import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class WorldSeries {

    public static void main(String[] args) throws IOException {
        //Read the txt with all the names of the teams that win and the years
        InputStream inputStream = WorldSeries.class.getResourceAsStream("/WorldSeriesWinners.txt");
        if (inputStream == null) {
            System.out.println("Error: We couldn't find the values.");
            return;
        }
        // Create a scanner to read the value
        //where the value that is find when we run the list is save in a list name winners
        Scanner fileScanner = new Scanner(inputStream);
        List<String> winners = new ArrayList<>();
        while (fileScanner.hasNextLine()) {
            winners.add(fileScanner.nextLine().trim());
        }
        //we clase the scanner
        fileScanner.close();

        // Create a map with the values 1903
        //return the teams with that number associate
        Map<Integer, String> yearToWinner = new HashMap<>();
        int year = 1903;
        for (String winner : winners) {
            yearToWinner.put(year, winner);
            year++;
            // Do not count this year
            if (year == 1904 || year == 1994) year++;
        }

        // // Create a scanner to read the value that the user wants to find
        Scanner sc = new Scanner(System.in);

        // I choose to use while cycle to give the chance to the user to do multiple consultants
        // unless the user type close, the program will continue asking for a team to fin how many times wins
        while (true) {
            System.out.print("Type the name of a team to find how many times wins (or put 'close' to finish the consultant): ");
            String team = sc.nextLine().trim();

            if (team.equalsIgnoreCase("close")) {
                System.out.println("End of the program.");
                break;
            }

            // Count titles and save the years
            int count = 0;
            List<Integer> teamYears = new ArrayList<>();
            for (Map.Entry<Integer, String> entry : yearToWinner.entrySet()) {
                if (entry.getValue().equalsIgnoreCase(team)) {
                    count++;
                    teamYears.add(entry.getKey());
                }
            }

            // Show the results
            System.out.printf("%s win %d times during 1903 and 2009.%n", team, count);
            if (!teamYears.isEmpty()) {
                System.out.println("Years that they win: " + teamYears);
            } else {
                System.out.println("This team did not win during that range of time.");
            }
        }
        //close the scanner
        sc.close();
    }
}