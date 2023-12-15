public class BankRateCalculator {

    private double costOfItem;
    private int loanLength;
    private double interestRate;

    // Constructor
    public BankRateCalculator(double costOfItem, int loanLength, double interestRate) {
        this.costOfItem = costOfItem;
        this.loanLength = loanLength;
        this.interestRate = interestRate;
    }

    // Calculatoions to find total costs using info from other class
    public double calculateTotalCost() {
        double totalCost = this.costOfItem;

        for (int i = 0; i < this.loanLength; i++) {
            totalCost += totalCost * (this.interestRate / 100);
        }

        return totalCost;
    }
}
