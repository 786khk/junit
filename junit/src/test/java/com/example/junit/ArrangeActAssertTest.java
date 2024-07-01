package com.example.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
public class ArrangeActAssertTest {
    @Test
    void testAAA(){
        int a = 1;
        int b = 3;
        Calculator calculator = new Calculator();
        calculator.add(a, b);

        assertEquals(4, calculator.getResult());
    }
}

class Calculator {
    private int result = 0;
    
    public int add(int a, int b) {
        result = a + b;
        return result;
    }
    public int getResult () {
        return this.result;
    }

}