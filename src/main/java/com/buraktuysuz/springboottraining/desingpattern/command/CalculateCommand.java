package com.buraktuysuz.springboottraining.desingpattern.command;

import java.math.BigDecimal;

public interface CalculateCommand {

    BigDecimal calculate(BigDecimal number1, BigDecimal number2);
}
