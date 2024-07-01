package com.example.junit;

import static org.junit.jupiter.api.DynamicTest.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.TestFactory;

import static org.assertj.core.api.Assertions.assertThat;
public class DynamicTestDemo {
    @TestFactory // 기존의 static test일 때 사용된 Junit test 라이프사이클 사용못함
    List<org.junit.jupiter.api.DynamicTest> readMessageList_MessageSearchDto_messageList() throws Exception {
        List<String> fistNameList = new ArrayList<String>();
        fistNameList.add("kim");
        fistNameList.add("lee");
        fistNameList.add("park");
        
        return List.of(
            dynamicTest("흔한 성씨 목록조회 Dynamic", () -> {
                assertThat(fistNameList.get(0)).isInstanceOf(String.class);
            })
        );
    }
}
// @TestFactory
//   List<DynamicTest> readMessageList_MessageSearchDto_messageList() throws Exception {


//     PageInfo pageInfo = new PageInfo();
//     MessageDto.SearchDto test = new MessageDto.SearchDto();
//     test.setLang("ko");
//     MessageDto.ListResponseDto messateListDto = new MessageDto.ListResponseDto("test.messageId",
//         "한글", "영문", LocalDateTime.now(), LocalDateTime.now(), "메세지 설명");
//     List<MessageDto.ListResponseDto> dataList = Arrays.asList(messateListDto);
//     Page<MessageDto.ListResponseDto> list =
//         new PageImpl<MessageDto.ListResponseDto>(dataList, Pageable.unpaged(), dataList.size());
//     PageResultDto<MessageDto.ListResponseDto> result =
//         messageService.getMessagesPage(test, Pageable.unpaged());
//     // messageService.getMessagesPage(searchDto.toList().get(0), Pageable.unpaged());

//     // assertThat(_e).hasFieldOrProperty("messageId");
//     // assertThat(_e).hasFieldOrProperty("messageKoName");
//     // assertThat(_e).hasFieldOrProperty("messageEnName");
//     // assertThat(_e).hasFieldOrProperty("messageDescription");
//     result.getList().stream().forEach(_e -> {
//       dynamicTest("메세지 목록조회 Dynamic", () -> {
//       });
//     });
//     return List.of(dynamicTest("메세지 목록조회 Dynamic", () -> {
//       assertThat(result.getList().get(0)).hasFieldOrProperty("messageId");
//       assertThat(result.getList().get(0)).hasFieldOrProperty("messageKoName");
//       assertThat(result.getList().get(0)).hasFieldOrProperty("messageEnName");
//       assertThat(result.getList().get(0)).hasFieldOrProperty("messageDescription");
//     }));
//   }