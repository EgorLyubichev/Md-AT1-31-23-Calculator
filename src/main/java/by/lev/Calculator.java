package by.lev;

public class Calculator implements Countable {

    private double getAddition(double num1, double num2) {
        return num1 + num2;
    }

    private double getSubstraction(double num1, double num2) {
        return num1 - num2;
    }

    private double getMultiplication(double num1, double num2) {
        return num1 * num2;
    }

    private double getDivision(double num1, double num2) {
        if (num2 == 0){
            throw new ArithmeticException();
        }
        return num1 / num2;
    }

    public Double getAction(double num1, double num2, char operator) {

        switch (operator) {
            case '+':
                return getAddition(num1, num2);
            case '-':
                return getSubstraction(num1, num2);
            case '*':
                return getMultiplication(num1, num2);
            case '/':
                return getDivision(num1, num2);
            default:
                return null;
        }
    }

}
