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

        assertEquals(4, calculator);
    }
}

class Calculator {
    public int add(int a, int b) {
        return a + b;
    }
}