package by.lev;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
public class Expression {

    private double num1;
    private double num2;
    private char operator;

}
