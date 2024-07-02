package com.example.junit.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.TestInstancePostProcessor;

@TestInstance(Lifecycle.PER_CLASS) // 인스턴스를 생성할 때 클래스 단위로 생성
public class MessageDTOTest {
    @BeforeEach
    void setup() throws Exception {}

    @Test
    @DisplayName("assert 메세지 테스트")
    void messageAssertTesting () {
        MessageDto messageDto1 = new MessageDto(0,"messageTest. 테스트를 위한 메세지 내용입니다.", LocalDateTime.now());
        MessageDto messageDto2 = new MessageDto(1,"messageTest", LocalDateTime.now());
        MessageDto messageDto3 = new MessageDto(1,"messageTest", LocalDateTime.now());
        List<MessageDto> messageList = new ArrayList<>();
        messageList.add(messageDto1);
        messageList.add(messageDto2);
        messageList.add(messageDto3);
        assertTrue(messageList.get(0).getSeq()==0);
        assertEquals(messageDto3.getContents(), messageDto2.getContents(),"contents가 다릅니다.");
        assertNotEquals(messageDto3.getContents(), messageDto1.getContents(),"contents가 다릅니다.");
        
    }

    @Test
    @DisplayName("assertJ 메세지 테스트")
    void messageFiltering () {
        MessageDto messageDto1 = new MessageDto(0,"messageTest. 테스트를 위한 메세지 내용입니다.", LocalDateTime.now());
        MessageDto messageDto2 = new MessageDto(1,"messageTest", LocalDateTime.now());
        MessageDto messageDto3 = new MessageDto(1,"messageTest", LocalDateTime.now());
        List<MessageDto> messageList = new ArrayList<>();
        messageList.add(messageDto1);
        messageList.add(messageDto2);
        messageList.add(messageDto3);

        assertThat(messageList.get(0))
            .as("seq 라는 필드는 없다.")
            .hasFieldOrProperty("seq"); //seq라는 필드를 가지고 있다.
        assertThat(messageList).isNotNull();
        
    }
    

}
