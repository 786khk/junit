# JUnit기본 어노테이션

## @Test
- 개별적으로 실행할 테스트메서드를 지칭.
- Junit5에서 Jupiter의 기능 제공해 별도의속성이 필요없고 상속이 필요 없음
## @ParameterizedTest
- 매게변수를 사용하는 테스트 메서드 임을 표시
- @Test와 동시에 사용할 수 없음
## @RepeatedTest
- 메서드 실행을 반복해 테스트하는 템플릿 명시
## @TestFactory
- 동적 테스트 를 나타내는 메서드 표시
- 테스트 자체가 아니라 테스트 케이스들을 위한 factory
- 동적테스트(Dynamic Test)란?
  - Runtime중 생성되는 동적 테스트 Given안에서 When이 연속적으로 이루어지는 형태
  - 시나리오 테스트라고 한다.
  - 기존의 테스트는 정적테스트로 컴파일 시점에서 완전히 지정되는 형태지만 동적 테스트는 런타임에서 완성이 됨
  - jenkins같이 배포툴을 이용해 실행할경우 간헐적으로 테스트가 실패할 수 있음

## @TestTemplate
- 등록된 공급자(TestTemplateInvocationContextProvider)가 반환한 호출 컨텍스트 수에 따라 여러 번 호출될 수 있도록 설계된 테스트 사례용 템플릿
- 클래스 또는 메서드 헤더에 확장으로 선언해야 사용할 수 있음
- 여러번 호출할 수 있게 설계된 테스트 템플릿
  

## @TestInstance
- 테스트 생명주기를 명시
## @DisplayName
- 테스트 클래스나 메서드에 사용자 지정 표기 이름을 명시
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


## @Timeout 
- 테스트 실행 시간을 걸정
- 시간은 밀리세컨드 단위로 입력

## @Nested 
- 중첩클래스

## @Tag
- 클래스나 메서드 수준의 테스트 필터링을 위함.


## @Timeout
- 실행시간이 명시한시간보다 초과한다면 테스트 실패.

## @ExtendWith 
- 확장을 선언적으로 등록하는데 사용.

## @RegisterExtension 
- 필드를 통해 프로그래밍 방식으로 확장을 등록하는데 사용.

## @TempDir 
- 임시 디렉토리 제공 시 사용.


참고 : https://www.devkuma.com/docs/junit5/