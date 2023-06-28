//Name: Wyatt Bechtle
//Date: 26 March 2023
//Program: Fraction Class

//Class UML Provided in Problem Statement.
//----------------------------------------
public class Fraction {

    //Private instance variables and their default values.
    private int numerator = 2;
    private int denominator = 1;
    
    //Constructors...
    //
    //No arguement scenario.
    public Fraction() {
    }
    //Double integer arguement scenario.
    public Fraction(int num, int denom) {
        this.numerator = num;
        if (denom != 0) {
            this.denominator = denom;
        }
        else {
            this.denominator = 1;
        }
    }
    //String arguement scenario.
    public Fraction(String fString) {

        //Seperate numerator from denominator by finding the index of the 
        //slash and extracting the associated substrings.
        int slashIndex = fString.indexOf('/');
        
        String stringNumerator = fString.substring(0, slashIndex);
        String stringDenominator = fString.substring(slashIndex + 1);

        //Declare and initialize a variable to hold the integer numerator.
        int integerNumerator = 0;

        //For loop used to iterate over stringNumerator.
        for(int i = 0; i < stringNumerator.length(); i++)
    
            //Cast current char into integer, subtract 48 to get the correct integer value
            //multiple the current integerNumerator to append.
            integerNumerator = integerNumerator * 10 + ((int)stringNumerator.charAt(i) - 48);
    
        //Declare and initialize a variable to hold the integer denominator.
        int integerDenominator = 0;

        //For loop used to iterate over stringDenominator.
        for(int i = 0; i < stringDenominator.length(); i++)
    
            //Cast current char into integer, subtract 48 to get the correct integer value
            //multiple the current integerDenominator to append.
            integerDenominator = integerDenominator * 10 + ((int)stringDenominator.charAt(i) - 
                                                            48);
        //Set the numerator and denominator attributes.
        this.numerator = integerNumerator;
        if (integerDenominator != 0) {
            this.denominator = integerDenominator;
        }
        else {
            this.denominator = 1;
        }
    }  
    //Getters...
    //
    //This method is used to return a string version of the current fractional value.
    public String getFraction() {
        return this.numerator + "/" + this.denominator;
    } 
    //This method is used to return a decimal version of the current fractional value.
    public double getDecimal() {

        //Cast, double-divide, round, and double-divide to return a double value with
        //four places after the decimal place.
        double decimalValue = (double) this.numerator / this.denominator;
        return Math.round(decimalValue * 10000.0) / 10000.0;
    }
    //This method is used to return the current numerator value.
    public int getNumerator() {
        return this.numerator;
    }
    //This method is used to return the current denominator value.
    public int getDenominator() {
        return this.denominator;
    }
    //Overload toString method.
    public String toString() {
        return this.getFraction() + " or " + this.getDecimal();
    }
    //This method is used to test if current fraction is equal to another.
    public boolean equals(Fraction obj) {

        //Declare two flags to compare numerator to denominator.
        boolean flag1;
        boolean flag2;

        //Compare the numerators.
        if (this.getNumerator() == obj.getNumerator()) {
            flag1 = true;
        }
        else {
            flag1 = false;
        }
        //Compare the denominators.
        if (this.getDenominator() == obj.getDenominator()) {
            flag2 = true;
        }
        else {
            flag2 = false;
        }
        //Return the results.
        return flag1 && flag2;
    }
}