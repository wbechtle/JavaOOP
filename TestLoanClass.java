//Name: Wyatt Bechtle
//Date: 17 April 2023
//Program: Test Calculator Class

//Algorithm
//---------
//Step 1) Display program explanation.
//Step 2) Get user input.
//Step 3) Calculate the output values based on validated user input.
//Step 4) Prompt user to quit or go again.
import java.util.InputMismatchException;
import java.util.Scanner;

public class TestLoanClass {    
    public static void main(String[] args) {
    
        // Create a Scanner
        Scanner input = new Scanner(System.in);

        // Display program explanation
        System.out.println("Greetings...\n" + 
                            "This programs calculates the loan date, monthly payment, and\n" +
                            "total payment of a loan based on interest rate, number of years\n" +
                            "and total loan amount.");

        // Declare a boolean variable to hold if values are valid.
        boolean notValid;

        // Declare input variables out side of blocks for maximum scope.
        double annualInterestRate;
        int numberOfYears;
        double loanAmount;
        String userInput;

        // Declare boolean to iterate program based on user's input. 
        boolean goAgain = false;

        // Loop is used to iterate program pending user's input.
        do {

            // Loop and try-catch blocks used to iterate program pending faulty input.
            do {
                try {
                    // Enter annual interest rate 
                    System.out.print("\nEnter annual interest rate(such as 8.25): ");
                    annualInterestRate = input.nextDouble();

                    // Enter number of years 
                    System.out.print("Enter number of years as an integer(such as 15): ");
                    numberOfYears = input.nextInt();

                    // Enter loan amount 
                    System.out.print("Enter loan amount(such as 120000): ");
                    loanAmount = input.nextDouble();

                    // Create a Loan object 
                    Loan loan = new Loan(annualInterestRate, numberOfYears, loanAmount);

                    // Display loan date, monthly payment, and total payment 
                    System.out.printf("\nThe loan was created on %s\n" +
                    "The monthly payment is $%,.2f\n" + 
                    "The total payment is $%,.2f\n", 
                    loan.getLoanDate().toString(), 
                    loan.getMonthlyPayment(),
                    loan.getTotalPayment());
                    notValid = false;
                }
                // First catch is indended for mismatched input. The exception will be thrown
                // and caught within the TestLoanClass
                catch (InputMismatchException exception) {
                    System.out.println("\n" + exception + " : Only enter numerical values for\n" +
                    "annual interest and loan amount. Only enter integer values for number of years.");
                    notValid = true;
                    input.nextLine(); // Clear user input
                }
                // Second catch is for when user inputs 0 or less input annualInterestRate,
                // numberOfYear, and loan amount
                catch (IllegalArgumentException exception) {
                    System.out.println("\n" + exception);
                    notValid = true;
                    input.nextLine(); // Clear user input
                }
            } while (notValid);

            // Prime notValid for another input validation loop
            notValid = true;

            // Loop is used to get user input and validate user input
            do {

                System.out.print("\nEnter \"Y\" to go again or \"N\" to quit: ");
                userInput = input.next();

                // Go again
                if (userInput.equalsIgnoreCase("Y")) {
                    goAgain = true;
                    notValid = false;
                }
                // Quit
                else if (userInput.equalsIgnoreCase("N")) {
                    goAgain = false;
                    notValid = false;
                }
                // Invalid input
                else {
                    System.out.println("\nError: Only enter \"Y\" or \"N\"");
                }
                input.nextLine();// Clear user input
            } while (notValid);
        } while (goAgain);
    }
}