package by.lev;

import java.util.Scanner;

public class Controller {

    InputConverter inputConverter = new InputConverter();
    InputChecker lineChecker = new InputChecker();
    LineConverter lineConverter = new LineConverter();
    Calculator calculator = new Calculator();

    public void getResult(){
        System.out.print("Пример: ");
        String expression = scanInput();

        //String expression = "-456+1456";

        String formatExpression = inputConverter.getCorrectLine(expression);

        if (!lineChecker.checkInput(formatExpression)){
            System.out.println("В выражении допущена ошибка!\nПопробуйте снова\n- - - - -");
            getResult();
        }
        if (!lineChecker.checkNotByZero(formatExpression)){
            System.out.println("На ноль делить нельзя!\nПопробуйте снова\n- - - - -");
            getResult();
        }
        lineConverter.getExpressionElementsFromLine(formatExpression);
        String[] lineElements = lineConverter.getLineElements();
        if (!lineChecker.checkLengthOfNumbers(lineElements)){
            System.out.println("Числа слишком длинные для вычисления!\nПопробуйте снова\n- - - - -");
            getResult();
        }else {
            lineConverter.setNum1();
            lineConverter.setNum2();
            lineConverter.setOperator();
        }
        System.out.println(calculator.getAction(lineConverter.getNum1(),
                lineConverter.getNum2(),
                lineConverter.getOperator()));
        getResult();
    }











    private String scanInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }


}
