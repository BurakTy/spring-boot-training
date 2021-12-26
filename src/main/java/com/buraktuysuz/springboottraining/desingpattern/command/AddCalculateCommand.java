package com.buraktuysuz.springboottraining.desingpattern.command;

import java.math.BigDecimal;

public class AddCalculateCommand implements CalculateCommand {

    @Override
    public BigDecimal calculate(BigDecimal number1, BigDecimal number2) {
        return number1.add(number2);
    }
}
