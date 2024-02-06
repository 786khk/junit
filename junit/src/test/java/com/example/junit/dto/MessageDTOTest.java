package com.example.junit.dto;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.TestInstancePostProcessor;

@TestInstance(Lifecycle.PER_CLASS)
@ExtendWith(TestInstancePostProcessor.class)
public class MessageDTOTest {
    @BeforeEach
    void setup() throws Exception {

    }

    @Test
    @DisplayName("메세지 필터링 테스트")
    void messageFiltering () {
        MessageDto messageDto1 = new MessageDto(0,"messageTest", LocalDateTime.now());
        MessageDto messageDto2 = new MessageDto(1,"messageTest2", LocalDateTime.now());
        List<MessageDto> messageList = new ArrayList<>();
        messageList.add(messageDto1);
        messageList.add(messageDto2);
        assertTrue(messageList.get(0).getSeq()==0);
        
    }
    

}
