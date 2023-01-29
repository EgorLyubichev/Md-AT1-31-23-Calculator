package by.lev;

import java.util.List;
import java.util.Scanner;

public class Controller {

    InputConvertable inputConverter = new InputConverter();
    InputChecker checker = new InputChecker();
    LineConverter lineConverter = new LineConverter();
    Countable calculator = new Calculator();

    public void getResult() {
        System.out.print("Пример: ");
        String expression = scanInput();

        String formatExpression = inputConverter.getCorrectLine(expression);

        if (!checker.checkInput(formatExpression)) {
            System.out.println("В выражении допущена ошибка!\nПопробуйте снова\n- - - - -");
            getResult();
        }
        if (!checker.checkNotByZero(formatExpression)) {
            System.out.println("На ноль делить нельзя!\nПопробуйте снова\n- - - - -");
            getResult();
        }
        lineConverter.getExpressionElementsFromLine(formatExpression);
        List<String> lineElements = lineConverter.getLineElements();
        if (!checker.checkLengthOfNumbers(lineElements)) {
            System.out.println("Числа слишком длинные для вычисления!\nПопробуйте снова\n- - - - -");
            getResult();
        } else {
            lineConverter.setNum1();
            lineConverter.setNum2();
            lineConverter.setOperator();
        }
        Double result = calculator.getAction(lineConverter.getNum1(),
                lineConverter.getNum2(),
                lineConverter.getOperator());
        if (checker.equalResultValueAndDoubleMaxValue(result)) {
            System.out.println(result + "\n- - - - -");
            getResult();
        } else {
            System.out.println("Результат превышает допустимое значение!");
            getResult();
        }
    }

    private String scanInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
