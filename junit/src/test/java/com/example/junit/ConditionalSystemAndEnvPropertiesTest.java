package com.example.junit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.DisabledIfSystemProperty;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;

public class ConditionalSystemAndEnvPropertiesTest {
    @Test
    @EnabledIfSystemProperty(named="java.vendor", matches="AdoptOpenJDK")
    void test1(){
        System.out.println("enabled AdoptOpenJDK");
    }

    @Test
    @EnabledIfSystemProperty(named="java.vendor", matches="Oracle.")
    void test2(){
        System.out.println("enabled Oracle");
    }

    // @Test
    // @DisabledIfSystemProperty(named="java.vendor", matches="AdoptOpenJDK")
    // void test3(){
    //     System.out.println("disabled AdoptOpenJDK");
    // }

    @Test
    @DisabledIfSystemProperty(named="java.vendor", matches="Oracle.")
    void test4(){
        System.out.println("disabled OpenJDK");
    }

    @Test
    @EnabledIfEnvironmentVariable(named="JAVA_HOME_17", matches=".\\\\AdoptOpenJDK\\\\.")
    void test5(){
        System.out.println("enabled OpenJDK 17");
    }
    @Test
    @DisabledIfEnvironmentVariable(named="JAVA_HOME_17", matches=".\\\\OpenJDK\\\\.")
    void test6(){
        System.out.println("disabled OpenJDK 17");
    }
}
