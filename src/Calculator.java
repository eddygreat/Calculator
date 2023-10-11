import java.util.ArrayList;
import java.util.Scanner;

public class Calculator {

    //initializing your variables
    int result = 0;
    int count = 0;

    public void endProgram() {
        //method to notify the user of entering an invalid character
        System.out.println("Opps: you entered an invalid character");
    }



    public void welcomeMessage() {
        //Welcome message
        System.out.println("Welcome to Edwards Limited Edition Calculator");
        System.out.println("Hello; type in your input elements here separated with a single space");
    }

    public void lenghtChecker () {

        //a method to check the lenght of our input variables
        if (count <= 5) {

            //this displays our result after performing all our calculations.
            System.out.println("Thank you for your time, your result is: " + result);

        } else if (count >= 6) {

            System.out.println("Opps: you can't work with more than three numbers per time, try again");
            System.exit(0);

        }
    }

    public void inputField() {
        //The line of code below enables you to type in your input variables
        Scanner scan = new Scanner(System.in);
        String cal = scan.nextLine();

        //This line gets printed to show your input variables before displaying your solution
        System.out.println("Your input expression is " + cal);

        //initializing your variables
        int digit = 0;
        String opp = "0";

        //spliting the input variables using empty space
        String[] value = cal.split(" ");

        //an arrayList to capture our input variables
        ArrayList<String> inputValues = new ArrayList<String>();

        for (String a : value) {
            inputValues.add(a);
            count++;
        }
       // a for loop the iterate through our input variables using the variable count
        for (int i = 0; i < count; i++) {

            //declarations used to capture possible mathematical operations
            String add = "+";
            String minus = "-";
            String multiply = "*";
            String divide = "/";

            //checking for variables with an index number that is divisible by two.
            if (i % 2 == 0) {

                //utilizing a try and catch to ensure that inputs that are not convertible to integers are
                // not allowed in our code
                try {
                    //converts our string values to integer values.
                    int number = Integer.parseInt(inputValues.get(i));

                    // an if statement to capture the first digit of the expression and the other digits
                    if (i == 0) {

                        //checking for integers that are greater than 10.
                        if (number > 10) {
                            endProgram();
                            System.exit(0);

                        } else {
                            result = number;
                        }
                    } else {

                        if (number > 10) {
                            endProgram();
                            System.exit(0);

                        } else {
                            digit = number;

                            //a variable to check for characters that are not math operators
                            var b1 = opp.equals(add) || opp.equals(minus) || opp.equals(divide) || opp.equals(multiply);

                            //an if statement to capture calculations involving the last element in
                            //our input variable
                            if (i == (count - 1)) {

                                //comparing our input operation values with standard maths values
                                //and checking that we have a minimum of two values to work with
                                //while computing for the last element in the input variable
                                if (opp.equals(add) && digit != 0) {

                                    result = result + digit;

                                } else if (opp.equals(minus) && digit != 0) {

                                    result = result - digit;

                                } else if (opp.equals(multiply) && digit != 0) {

                                    result = result * digit;

                                } else if (opp.equals(divide) && digit != 0) {

                                    result = result / digit;

                                    //checking for invalid characters
                                } else if (!b1) {

                                    //System.out.println("you entered an invalid character");
                                    endProgram();
                                    System.exit(0);
                                }

                                //comparing our input operation values with standard maths values
                                //and checking that we have a minimum of two values to work with
                                //while computing for the other element in the input variable
                            } else if (opp.equals(add) && digit != 0) {

                                result = result + digit;

                            } else if (opp.equals(minus) && digit != 0) {

                                result = result - digit;

                            } else if (opp.equals(multiply) && digit != 0) {

                                result = result * digit;

                            } else if (opp.equals(divide) && digit != 0) {

                                result = result / digit;
                               //checking for invalid characters
                            } else if (!b1) {

                                endProgram();
                                System.exit(0);
                            }

                        }
                    }


                } catch (NumberFormatException e){
                    endProgram();
                    System.exit(0);
                }

                } else{
                    // checks for elements in the input variable that represents
                    // mathematical operation symbols
                    opp = inputValues.get(i);

                }

            }
        }


}









