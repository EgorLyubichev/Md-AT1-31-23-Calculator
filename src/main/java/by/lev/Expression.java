package by.lev;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Builder
@Getter
@EqualsAndHashCode
@ToString
public class Expression {

    private double num1;
    private double num2;
    private char operator;

}
