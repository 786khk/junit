package com.example.junit;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestClassOrder;

public class TagFilteringTest {
    @Test
    @Tag("tag1")
    void tag1() { 
        System.out.println("tag 1");
    }
    @Test
    @Tag("tag2")
    void tag2() { 
        System.out.println("tag 2");
    }

    @Test
    @Tag("tag1")
    @Tag("tag3")
    void tag3() { 
        System.out.println("tag 1,3");
    }

    
    @Test
    @Tag("tag4")
    void tag4() { 
        System.out.println("tag 4");
    }
    /*
     java -jar junit-platform-console-standalone-[myVersion].jar \
    -cp build/classes/java/test \
    --select-class com.example.junit.TagFilteringTest \
    -e junit-jupiter \
    --include-tag "tag1 & tag3"
     */
}
