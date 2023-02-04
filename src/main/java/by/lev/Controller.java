package by.lev;

import java.util.List;
import java.util.Scanner;

public class Controller implements ControllerInterface {


    Checkable checker = new InputChecker();
    Convertable lineConverter = new LineConverter();

    public void getResult() {
        System.out.println("Выход: 'Q', 'Enter'.");
        System.out.print("Пример: ");
        String input = scanInput();

        if (input.trim().equalsIgnoreCase("q")) {
            System.exit(0);
        }

        String correctLine = lineConverter.getCorrectLine(input);

        if (!checker.checkInput(correctLine)) {
            System.out.println("В выражении допущена ошибка!\nПопробуйте снова\n- - - - -");
            getResult();
        }
        if (!checker.checkNotByZero(correctLine)) {
            System.out.println("На ноль делить нельзя!\nПопробуйте снова\n- - - - -");
            getResult();
        }
        List<String> lineElements = lineConverter.getExpressionElementsFromLine(correctLine);
        if (!checker.checkLengthOfNumbers(lineElements)) {
            System.out.println("Числа слишком длинные для вычисления!\nПопробуйте снова\n- - - - -");
            getResult();
        }
        Expression expression = lineConverter.setElements(lineElements);
        Double result = Calculator.doAction(expression);
        if (checker.checkResultValueNoBiggerThanAllowedValue(result)) {
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
