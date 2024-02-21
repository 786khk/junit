package com.example.junit;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class GivenWhenThenTest {
    @Test
    void testGivenWhenThen() {
        //Given
        int no = 33;
        String name = "이름";
        
        //When
        Identify identify = new Identify();
        String result = identify.getRows(no, name);
        
        //Then
        assertThat(result).isNotBlank().contains("name");
    }
}

class Identify{
    public static String getRows(int no, String name){
        return "no : " + no + " name : " + name;
    }
}