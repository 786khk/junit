# JUnit기본 어노테이션 - 생명주기

## @TestInstance
- 테스트 생명주기를 명시
### LifeCycle.class
- 실행시 인스턴스를 생성할 때 
## @DisplayNameGeneration
- 테스트 클래스에 사용자 지정 표기 이름을 명시
```java

@DisplayNameGeneration(DisplayNameGenerator.IndicativeSentences.class)
public class MyTestClass{

@Order(1)
@Test
void when_read_list() {}
...
}
```


## @BeforeAll
- 클래스에 있는 모든 테스트 전 한번 실행
- static함수로 구성
## @AfterAll 
- 클래스에 있는 모든 테스트 실행 후 한번 실행 
- static함수로 구성
## @BeforeEach
- 각 테스트 실행 전 한번씩 실행
## @AfterEach 
- 각 테스트 실행 후에 한 번씩 실행
## @Disabled (junit4 에서는 @Ignore)
- 해당 테스트를 사용하지 않음 표시





참고 : https://www.devkuma.com/docs/junit5/