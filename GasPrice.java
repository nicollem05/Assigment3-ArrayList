import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class GasPrice {

    // Array that save the prices and it is double because has decimals
    static double[] gasPrices = new double[52];

    // Number of weeks in a year (12 months)
    private static final int[] Weeks_month = {4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4};

    // Names of the months of the year
    private static final String[] Months_Year = {
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
    };

    public static void main(String[] args) throws IOException {

        // Open the file .txt with all the values of the weekly averages
        InputStream inputStream = GasPrice.class.getResourceAsStream("/1994_Weekly_Gas_Averages.txt");

        if (inputStream == null) {
            throw new IOException("We couldn't find the file in the Resources folder.");
        }

        // Create scanner to read the values in the .txt
        Scanner input = new Scanner(inputStream);
        int index = 0;

        // Read the values of the .txt
        while (input.hasNextDouble() && index < 52) {
            gasPrices[index] = input.nextDouble();
            index++;
        }
        //stop the reading
        input.close();

        // find the max and min
        //we use two variable inicialized in 0 and 2 vectors to find the min and max
        //with a for to run across the vectors
        double lowest = gasPrices[0];
        double highest = gasPrices[0];
        int lowestIndex = 0;
        int highestIndex = 0;

        for (int i = 1; i < gasPrices.length; i++) {
            if (gasPrices[i] < lowest) {
                lowest = gasPrices[i];
                lowestIndex = i;
            }
            if (gasPrices[i] > highest) {
                highest = gasPrices[i];
                highestIndex = i;
            }
        }

        // Calculate when that happend and divided for the 4 weeks of a month
        int lowestMonth = lowestIndex / 4;
        int highestMonth = highestIndex / 4;

        System.out.println("We finished the search. And the results are:");
        System.out.println();
        System.out.printf("The lowest gas price is: $%.3f (Week %d of %s)%n",
                lowest, lowestIndex + 1, Months_Year[lowestMonth]);
        System.out.printf("The highest gas price is: $%.3f (Week %d of %s)%n",
                highest, highestIndex + 1, Months_Year[highestMonth]);

        // Calculate the Average annual price
        //we use a variable to save the value and is double for the decimals
        if (gasPrices.length > 0) {  // It needs to have values to return something
            double sum = 0;
            for (double price : gasPrices) {
                sum += price;
            }
            double average = sum / gasPrices.length;
            //return the value
            System.out.printf("%nThe average annual gas price is: $%.3f%n", average);
        } else {
            //if we do not have values it is going to return this message
            System.out.println("Error: no data available to calculate average.");
        }
    }
}