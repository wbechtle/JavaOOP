//Name: Wyatt Bechtle
//Date: 13 April 2023
//Program: Loan Class
//----------------------------------------
public class Loan {

    // Attributes...
    private double annualInterestRate;
    private int numberOfYears;
    private double loanAmount;
    private java.util.Date loanDate;
 
    //Default constructor
    //no-arg constructor...  
    public Loan() {
        this(2.5, 1, 1000);
    }

    //instantiate a loan with specified annual interest rate, number of years, 
    //and loan amount 
    //constructor...        
    public Loan(double annualInterestRate, int numberOfYears,
                double loanAmount) {
        
        this.setAnnualInterestRate(annualInterestRate);
        this.setNumberOfYears(numberOfYears);
        this.setLoanAmount(loanAmount);
        loanDate = new java.util.Date();
    }

    //Return annualInterestRate 
    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    //Set a new annualInterestRate, throw exception if bad value(n <= 0).
    public void setAnnualInterestRate (double annualInterestRate) 
    throws IllegalArgumentException {
        if (annualInterestRate <= 0) {
            throw new IllegalArgumentException("Interest rate must be a value greater than 0.");
        }
        else {
            this.annualInterestRate = annualInterestRate;
        }
    }

    //Return numberOfYears
    public int getNumberOfYears() {
        return numberOfYears;
    }

    //Set a new numberOfYears, throw exception if bad value(n <= 0).
    public void setNumberOfYears(int numberOfYears) 
    throws IllegalArgumentException {
        if (numberOfYears <= 0) {
            throw new IllegalArgumentException("Years must be a value greater than 0.");
        }
        else {
            this.numberOfYears = numberOfYears;
        }
    }

    //Return loanAmount
    public double getLoanAmount() {
        return loanAmount;
    }

    //Set a new loanAmount, throw exception if bad value(n <= 0). 
    public void setLoanAmount(double loanAmount)  
    throws IllegalArgumentException {
        if (loanAmount <= 0) {
            throw new IllegalArgumentException("Loan amount must be a value greater than 0.");
        }
        else {
            this.loanAmount = loanAmount;
        }
    }

    //Find monthly payment(formula from textbook)
    public double getMonthlyPayment() {
        double monthlyInterestRate = annualInterestRate / 1200;
        double monthlyPayment = loanAmount * monthlyInterestRate / (1 - 
        (1 / Math.pow(1 + monthlyInterestRate, numberOfYears * 12)));
        return monthlyPayment; 
    }

    //Find total payment(formula from textbook)
    public double getTotalPayment() {
        double totalPayment = getMonthlyPayment() * numberOfYears * 12;
        return totalPayment;
    }

    //Return loan date
    public java.util.Date getLoanDate() {
        return loanDate;
    }
}