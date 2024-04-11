# 발단
- controller 테스트 중 Mock 데이터 결과값을 검증할 때 아래와 같은 에러가 발생함
  
```log
    com.fasterxml.jackson.databind.exc.InvalidDefinitionException: Java 8 date/time type `java.time.LocalDateTime` not supported by default: add Module "com.fasterxml.jackson.datatype:jackson-datatype-jsr310" to enable handling
    at [Source: (String)"{"timestamp":"2024-03-13T09:16:49.65932",
    ...
```

# 원인
- response 를 내가 만든 클래스로 형변환을 할 때 java8의 API인 LocalDatetime을 변환하지 못한다.
- 참고
    - 역직렬화: JSON데이터가 Controller 요청으로 전송될 때 객체형태로 변환
    - 직렬화: 요청에 대한 응답을 JSON데이터로 변환하는 과정
  - RequestBody가 없는 POST 전송, PUT전송과 같은 @RequestBody를 사용할 때 Spring boot에서 역직렬화를 지원함.
  - GET 전송은 RequestBody가 있어 어노테이션 없이 직렬화 됨
  - spring boot는 내부적으로 Jackson을 사용해 직렬화, 역직렬화를 자동으로 처리함
  
# 해결
1. 의존성 추가
    - JSON을 지원하는 라이브러리 의존성 추가
    - 2.8.0 이전 버전들은 jackson-datatype-jsr310 를 지원하지 않기때문에 별도로 의존성을 추가해야 함
    
```xml

    <dependency>
      <groupId>com.fasterxml.jackson.datatype</groupId>
      <artifactId>jackson-datatype-jsr310</artifactId>
    </dependency>


```

    - 해당 의존성은 spring-boot-starter-web 에서 모듈로 지원된다.


1. 별도의 어노테이션 추가
   - 스프링 부트에서 별도의 어노테이션 없이 데이터 직렬화는 실패한다.
   - @JsonCreator로 별도의 생성자 표시
   - 해당기능은 자바 LocalDatetime 뿐만 아니라 복잡한 구조의 객체 형태로 변환할 때 사용

 ```java
 public class MyClass {
    @JsonCreator
    public MyClass(){}
 }

 ```
2. ObjectMapper 의 모듈 추가
```java

  ObjectMapper objectMapper = new ObjectMapper();
  objectMapper.modules(new JavaTimeModule());

```
