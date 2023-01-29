package by.lev;

import java.util.function.BiFunction;

public class Calculator implements Countable {

    public Double doAction(double num1, double num2, char operator) {

        BiFunction<Double, Double, Double> function;
        Double result = null;

        switch (operator) {
            case '+':
                function = Double::sum;
                result = function.apply(num1, num2);
                break;
            case '-':
                function = (x1, x2) -> x1 - x2;
                result = function.apply(num1, num2);
                break;
            case '*':
                function = (x1, x2) -> x1 * x2;
                result = function.apply(num1, num2);
                break;
            case '/':
                if (!(num2 == 0)) {
                    function = (x1, x2) -> x1 / x2;
                    result = function.apply(num1, num2);
                    break;
                } else {
                    throw new ArithmeticException();
                }
        }
        return result;
    }
}
