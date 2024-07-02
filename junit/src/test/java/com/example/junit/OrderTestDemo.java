package com.example.junit;

import org.junit.jupiter.api.ClassOrderer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestClassOrder;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class) // apple > kiwi > banana
// 랜덤 실행 @TestMethodOrder(MethodOrderer.Random.class) 
// DisplayName 오름차순 실행 @TestMethodOrder(MethodOrderer.DisplayName.class) kiwi > banana > apple 
// mothod이름 오름차순 실행 @TestMethodOrder(MethodOrderer.DisplayName.class) apple > banana > kiwi
public class OrderTestDemo {
    @Test
    @Order(1)
    @DisplayName("red")
    void apple() throws Exception {
        System.out.println("apple");
    }

    @Test
    @Order(3)
    @DisplayName("yellow")
    void banana() throws Exception {
        System.out.println("banana");
    }
    
    @Test
    @Order(2)
    @DisplayName("green")
    void kiwi() throws Exception {
        System.out.println("kiwi");
    }
}
