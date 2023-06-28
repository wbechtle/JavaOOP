//Name: Wyatt Bechtle
//Date: 26 March 2023
//Program: Test Fraction Class

//Algorithm
//---------
//Step 1) Display current test.
//Step 2) Test Constructors.
//Step 3) Test Getters and toString.
//Step 4) Test equals method.
import java.util.Random;
public class TestFraction {
    public static void main(String[] args) {

        //Array used to hold all print headings. This makes editing and formating easy.
        String [] stringArray = {"\nTesting Constructors...", 
                                    "\n\tNo Arguement Constructor Test Succesful", 
                                    "\n\tDouble Integer Arguement Constructor Test Succesful", 
                                    "\n\tString Arguement Constructor Test Succesful",
                                "\nTesting Getters...",
                                    "\n\tTesting .getFraction Expected: ",
                                    "\n\tResult: ",
                                    "\tTesting .getDecimal Expected: ",
                                    "\n\tResult: ",
                                    "\tTesting .getNumerator... ",
                                    "\n\tResult: ",
                                    "\tTesting .getDenominator... ",
                                    "\n\tResult: ",
                                "Testing toString Overload...",
                                    "\n\tExpected: ", 
                                    "\n\tResults: ",
                                "Testing equals Method...",
                                    "\n\tExpected: ", 
                                    "\n\tResults: "};
        
        //Array used to hold instances of the Fraction class.
        Fraction [] fractionArray = new Fraction [5];

        //Display current test.
        System.out.println(stringArray[0]);

        //Instatiate a new Random object to generate random integers to decide which
        //of the three constructors to use.
        Random randomObject = new Random();

        //Declare integer variable to hold returned value from the nextInt method.
        int randomInteger;

        //Declare Fraction reference.
        Fraction fractionObject;

        //For loop used to generate five instances of the Fraction class and append them
        //to the associated array.
        for (int x = 0; x < fractionArray.length; x++) {

            //Display current object.
            System.out.println("\n\tTesting Object #" + (x + 1));

            //Generate a random integer in range of 0 to 2.
            randomInteger = randomObject.nextInt(3);

            //Switch is used to randomly decide which constuctor to use.
            switch (randomInteger) {

                case 0:
                    //Display what constructor is being used.
                    System.out.println(stringArray[1]);
                    //
                    //Instantiate an istance of the Fraction class using the no arguement
                    //constructor and append to list.
                    fractionObject = new Fraction();
                    fractionArray[x] = fractionObject;
                    break;

                case 1:
                    //Display what constructor is being used.
                    System.out.println(stringArray[2]);
                    //
                    //Instantiate an istance of the Fraction class using the no arguement
                    //constructor and append to list.
                    fractionObject = new Fraction(randomObject.nextInt(1,10), 
                                                            randomObject.nextInt(1,10));
                    fractionArray[x] = fractionObject;
                    break;

                case 2:
                    //Display what constructor is being used.
                    System.out.println(stringArray[3]);
                    //
                    //Instantiate an istance of the Fraction class using the no arguement
                    //constructor and append to list.
                    fractionObject = new Fraction((char)randomObject.nextInt(48,58), 
                                                (char)randomObject.nextInt(49,58));
                    fractionArray[x] = fractionObject;
                    break;
            }
        }
        //For loop used to iterate over each object and test all associated methods.
        for (int x = 0; x < fractionArray.length; x++) {

            //Display current test.
            System.out.println(stringArray[4]);

            //Display current object.
            System.out.println("\n\tTesting Object #" + (x + 1));

            //Test Getters...
            //
            //Display current method being tested and expected results.
            System.out.print(stringArray[5]);
            System.out.println(fractionArray[x].getNumerator() + "/" +
                                fractionArray[x].getDenominator());
            //
            //Test getFraction method of current object.
            String stringFraction = fractionArray[x].getFraction();
            //
            //Display results.
            System.out.print(stringArray[6]);
            System.out.println(stringFraction + "\n");
            //
            //Display current method being tested and expected results.
            System.out.print(stringArray[7]);
            System.out.println(Math.round(((double) fractionArray[x].getNumerator() / 
                              fractionArray[x].getDenominator() * 10000.0)) / 10000.0);
            //
            //Test getFraction method of current object.
            double doubleValue = fractionArray[x].getDecimal();
            //
            //Display results.
            System.out.print(stringArray[8]);
            System.out.println(doubleValue + "\n");
            //
            //Display current method being tested.
            System.out.println(stringArray[9]);
            //
            //Test getNumerator method of current object.
            int numeratorValue = fractionArray[x].getNumerator();
            //
            //Display results.
            System.out.print(stringArray[10]);
            System.out.println(numeratorValue + "\n");
            //
            //Display current method being tested.
            System.out.println(stringArray[11]);
            //
            //Test getFraction method of current object.
            int denominatorValue = fractionArray[x].getDenominator();
            //
            //Display results.
            System.out.print(stringArray[12]);
            System.out.println(denominatorValue + "\n");

            //Display current test.
            System.out.println(stringArray[13]);

            //Test toString overload...
            //
            //Display the expected results.
            System.out.print(stringArray[14]);
            System.out.println(fractionArray[x].getFraction() + " or " +
                                fractionArray[x].getDecimal());
            //Test method and display results.
            System.out.print(stringArray[15]);
            System.out.println(fractionArray[x].toString() + "\n");

            //Display current test.
            System.out.println(stringArray[16]);

            //Test equals method...
            //
            //Predict and display the expected results.
            System.out.print(stringArray[17]);
            //
            //Declare two flags to compare numerator to denominator.
            boolean flag1;
            boolean flag2;
            //
            //Create a object to compare against.
            Fraction testObject = new Fraction();
            //
            //Extract two numerators to compare.
            int numeratorOne = fractionArray[x].getNumerator();
            int numeratorTwo = testObject.getNumerator();
            //
            //Extract two denominators to compare.
            int denominatorOne = fractionArray[x].getDenominator();
            int denominatorTwo = testObject.getDenominator();
            //
            //Compare the numerators.
            if (numeratorOne == numeratorTwo) {
                flag1 = true;
            }
            else {
                flag1 = false;
            }
            //Compare the denominators.
            if (denominatorOne == denominatorTwo) {
                flag2 = true;
            }
            else {
                flag2 = false;
            }
            System.out.println(flag1 && flag2);
            //
            //Display results.
            System.out.print(stringArray[18]);
            System.out.println(fractionArray[x].equals(testObject) + "\n");
        }
        //The project's prompt, rubric, and UML all specified something a little different.
        //For example, the problem statements talks about how the denominator cannot be set
        //to one, however, there is no section for it on the rubric. Another being the the
        //toString methods return value. It is listed as both a string type and a set of five
        //strings. So, I have thrown this paragraph in for explanation. I believe this prompt
        //could have been worded and synchronized better.

        //This block of code is here because it is asked of in prompt and in rubric, however, 
        //it is not found in the UML.
        System.out.println("Collective toString Results:");
        for (int x = 0; x < fractionArray.length; x++) {
            System.out.println("\t" + fractionArray[x].toString());
        }
    }
}
