import java.text.DecimalFormat;
import java.util.Scanner;
public class BankRateCalculatorApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#.##");

        // Get user input for repetitions
        System.out.print("Enter the number of loan scenarios: ");
        int numScenarios = scanner.nextInt();

        // Array for constructor
        BankRateCalculator[] calculators = new BankRateCalculator[numScenarios];

        for (int i = 0; i < numScenarios; i++) {
            System.out.println("\nScenario " + (i + 1) + ":");

            // Validate the cost of the item
            double cost;
            do {
                System.out.print("Enter the cost of the item: ");
                cost = scanner.nextDouble();

                if (cost < 0) {
                    System.out.println("Cost must be non-negative. Please enter a valid cost.");
                }
            } while (cost < 0);

            // Validate the length of the loan
            int length;
            do {
                System.out.print("Enter the length of the loan (in years): ");
                length = scanner.nextInt();

                if (length < 1) {
                    System.out.println("Length must be at least one. Please enter a valid length.");
                }
            } while (length < 1);

            // Validate the interest rate
            double rate;
            do {
                System.out.print("Enter the interest rate: ");
                rate = scanner.nextDouble();

                if (rate < 0) {
                    System.out.println("Interest rate must be non-negative. Please enter a valid rate.");
                }
            } while (rate < 0);

            calculators[i] = new BankRateCalculator(cost, length, rate);
        }

        // Calculate and display results
        for (int i = 0; i < numScenarios; i++) {
            double totalCost = calculators[i].calculateTotalCost();
            System.out.println("\nTotal cost for Scenario " + (i + 1) + ": $" + df.format(totalCost));
        }
    }
}
