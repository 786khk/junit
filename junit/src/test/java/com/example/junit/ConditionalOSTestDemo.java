package com.example.junit;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

public class ConditionalOSTestDemo {
    @Test
    @EnabledOnOs(OS.WINDOWS)
    void windowOS(){
        System.out.println("Window 에서 실행");
    }

    @Test
    @DisabledOnOs(OS.WINDOWS)
    void noWindowOS(){
        System.out.println("Window 에서 실행");
    }

    @Test
    @EnabledOnOs(OS.LINUX)
    void linuxOS(){
        System.out.println("Linux 에서 실행");
    }
    @Test
    @EnabledOnOs(OS.MAC)
    void macOS(){
        System.out.println("Mac 에서 실행");
    }
    @Test
    @EnabledOnOs(OS.SOLARIS)
    void solarisOS(){
        System.out.println("Solaris 에서 실행");
    }
    @Test
    @EnabledOnOs(OS.OTHER)
    void otherOS(){
        System.out.println("other 에서 실행");
    }
}
