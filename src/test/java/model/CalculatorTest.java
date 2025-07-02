package model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.Assert.assertEquals;

@ExtendWith(MockitoExtension.class)
public class CalculatorTest {
    private Calculator calc;

    @BeforeEach
    void setUp() { calc = new Calculator();}

    @Test
    public void addsTwoNumbers() {
        assertEquals(5, calc.add(2, 3));
    }
}
