package com.buraktuysuz.springboottraining.desingpattern.command;

import java.math.BigDecimal;

public class RemCalculateCommand implements CalculateCommand {
    @Override
    public BigDecimal calculate(BigDecimal number1, BigDecimal number2) {
        return number1.remainder(number2);
    }
}
