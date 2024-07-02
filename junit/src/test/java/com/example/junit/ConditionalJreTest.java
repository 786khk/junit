package com.example.junit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfSystemProperty;
import org.junit.jupiter.api.condition.DisabledOnJre;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.JRE;

public class ConditionalJreTest {
    @Test
    @DisabledOnJre(JRE.JAVA_17)
    void disabledJre17(){
        System.out.println("disabled jre17");
    }


    @Test
    @DisabledOnJre(JRE.JAVA_13)
    void disabledJre13(){
        System.out.println("disabled jre13");
    }

    @Test
    @DisabledOnJre(JRE.JAVA_15)
    void disabledJre15(){
        System.out.println("disabled jre15");
    }

    @Test
    @EnabledOnJre(JRE.JAVA_17)
    void enabledJre17(){
        System.out.println("enabled jre17");
    }


    @Test
    @EnabledOnJre(JRE.JAVA_13)
    void enabledJre13(){
        System.out.println("enabled jre13");
    }

    @Test
    @EnabledOnJre(JRE.JAVA_15)
    void enabledJre15(){
        System.out.println("endisabled jre15");
    }
}
