import java.util.*;
import java.io.*;
import java.nio.*;

public class StepsPerMonth {

    // create the vectors for the days that we have in the months (per each month)
    //create the vectors with the name in each month
    //we use int type per the total of days and String for the names

        private static final int[] Days_Per_Month = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        private static final String[] Months_Year = {"January", "February", "March", "April", "May", "June", "July",
                "August", "September", "October", "November", "December"};

    //we need to find the .txt that we are going to use and make the called
    // create the main and we use the IO library to show if is not find the file .txt that we are going to use

    public static void main(String [] args) throws IOException{
        //Scanner to reads and open the .txt where we have the total steps in a year

        InputStream inputStream = StepsPerMonth.class.getResourceAsStream("/Steps.txt");

    //we need to create a condition if we do not find the file

        if(inputStream == null){
            throw new IOException("We couldn't find the file in the Resources");
        }

    //We need to create a scanner to read the file

        Scanner input = new Scanner(inputStream);

    // now we create the steps per month

        for (int month = 0; month < 12; month++) {
            int days = Days_Per_Month[month];
            String name = Months_Year[month];
            int totalSteps = 0;

            for (int day = 0; day < days; day++) {
                if (input.hasNextInt()) {
                    int steps = input.nextInt();
                    totalSteps += steps;
                } else {
                    System.out.println("No more data for " + name);
                    break;
                }
            }

            // Find the average of steps
            // we divide the total steps for the days in the month
            int averageSteps = totalSteps / days; //Integer because we do not need decimals for the Steps Average
            // is going to return String give us the result with 2 decimals and a jump in the other line
            System.out.printf("The average steps in the month of %s was: %d %n", name, averageSteps);
            //Some returns of the program are
            //The average steps in the month of July was: 5638
            //The average steps in the month of August was: 5759
            //The average steps in the month of September was: 6114
            //The average steps in the month of October was: 5411
            //The average steps in the month of November was: 4268
            //The average steps in the month of December was: 5138

        }
        // close enter of the data

    input.close();
    }
}