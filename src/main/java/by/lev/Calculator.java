package by.lev;

import java.util.function.BiFunction;

public class Calculator implements Countable {

    public Double doAction(Expression expression) {

        BiFunction<Double, Double, Double> function;
        Double result = null;

        switch (expression.getOperator()) {
            case '+':
                function = Double::sum;
                result = function.apply(expression.getNum1(), expression.getNum2());
                break;
            case '-':
                function = (x1, x2) -> x1 - x2;
                result = function.apply(expression.getNum1(), expression.getNum2());
                break;
            case '*':
                function = (x1, x2) -> x1 * x2;
                result = function.apply(expression.getNum1(), expression.getNum2());
                break;
            case '/':
                if (!(expression.getNum2() == 0)) {
                    function = (x1, x2) -> x1 / x2;
                    result = function.apply(expression.getNum1(), expression.getNum2());
                    break;
                } else {
                    throw new ArithmeticException();
                }
        }
        return result;
    }
}
