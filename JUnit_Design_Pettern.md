# JUnit 디자인 패턴
- 디자인 패턴으로 가독성, 유지보수성, 확장성을 향상

## Given-When-Then
- BDD 에서 가져온 테스트 방법론 중 하나
- 테스트의 의도를 명확하게 전달하는데 사용

```java

public class GivenWhenThenTest {
    @Test
    void testGivenWhenThen() {
        //Given
        int no = 33;
        String name = "이름";
        
        //When
        Identify identify = new Identify();
        String result = identify.getRows(no, name);
        
        //Then
        assertThat(result).isNotBlank().contains("name");
    }
}

class Identify{
    public static String getRows(int no, String name){
        return "no : " + no + " name : " + name;
    }
}

```
### Given
- 테스트 케이스의 시작지점. 
- 테스트 환굥을 설정하고 필요한 데이터 설정 
- 예: 객체 생성, 초기화
### When
- 테스트 하려는 작업을 수행하는 단계
- 주어진상황에서 어떤 동작이 수행(발생)될 때 
- 메서드 호출
### Then
- 예상되는 결과를 검증하는 단계

## Arrange-Act-Assert(AAA)
- 테스트의 준비, 작업, 덤증 단계를 명확하게 분리해 코드 구성
- Given-When-Then과 유사한 패턴
### Arrange 
- 테스트 실행하기 위한 준비
### Act
- 테스트 대상 동작을 수행
### Assert
- 결과 검증

```java
public class ArrangeActAssertTest {
    void testAAA(){
        int a = 1;
        int b = 3;
        Calculator calculator = new Calculator();
        calculator.add(a, b);

        assertEquals(4, calculator);
    }
}

class Calculator {
    public int add(int a, int b) {
        return a+b;
    }
}
```

#### AAA 와 Given-When-Then 패턴의 차이
- 컨텍스트 용도 
  - GWT은 BDD 컨텍스트에서, `사용자 스토리나 비지니스 요구사항`을 기반으로 테스트를 구성하는데 초점을 맞춘다.
  - AAA패턴은 `개발자가 일반적인 소프트웨어 테스팅`을 위해 사용하는 더 기술적인 접근 방식
- 목적과 명확성
  - GWT은 비지니스 요구사항을 명확히 하고 비 개발자도 이해할 수 있는 테스트 작성에 유용 
  - AAA는 개발자가 코드의 특정 부분을 테스트하는 데 있어서 명확한 구조를 제공
- **즉 관점이 다를 뿐 사용은 같음**

## Parameterized Tests
- 여러 입력값 또는 상황에 대해 단일테스느를 실행하는 기능을 제공
- 중복을 줄이고 테스트 케이스의 수를 줄인다.
### 동작 순서
  1. 테스트 메서드 정의
   - 테스트 대상 메서드 정의, 이 메서드가  @Parameterized 를 사용하도록 함
   - 매개변수가 없는 테스트라면 @Test로 어노테이션 사용
  2. 소스 제공
   - `@ValueSource`, `@CsvSource`, `@MethodSource`, `@EnumSource`로 매개변수 지정
  3. 매개변수 전달
   - 정의된 소스로 부터 매개변수 값들이 테스트 메서드에 순차적으로 전달.들어오는 매개변수가 두개 이상일 경우 테스트 메서드는 독립적으로 실행
  4. 실행 및 검증
   - 각매개변수 세트로 메서드가 실행될 때 해당 매개변수를 사용해 테스트 로직 검증됨. 매개변수 세트에 대해 반복
  5. 결과 레포팅
   - 모든 매개변수 세트에 대한 테스트 실행이 완료되면 각각의 실행결과 레포팅 됨 
   - 성공/ 실패/ 에러

## Mocking
- 외부 종속성을 가진 코드를 테스트 할 깨 사용
- Mock객체를 사용해 외부 종속성을 흉내내고 해당 동작을 검증
  - 즉 샘플데이터를 만들어 실제 DB의 데이터를 가져오지 않음

## Test Driven Development(TDD)
- 테스트를 먼저 작성하고 그 후 코드 구현
- 테스트가 코드의 요구사항과 일치하고 코드가 예상대로 동작하는지 확인

## BDD(Behavior Driven Development, 행위 주도 개발)
- 사용자의 행위 또는 기능에 초점을 맞춤, 소프트웨어가 어떻게 행동해야하는지를 중심으로 개발
- 소프트웨어 방법론중 하나
- 비지니스 요구사항을 테스트로 전달, 테스트를 통해 소프트웨어의 동작을 설명하는 방법론
- 주요 구성요소는 케스트, 도메인전문가와 개발자 간의 협업, 자연어에 가까운 테스트케이스
- 주요 방법
  - Given-When-Then 구조 사용해 명확하게 구분해 작성. 코드의 동작을 자연어에 가깝게 이해할 수 있다.
  
```java



```
## Fluent Assertions
- 가독성을 높이기 위해 테스트 결과의 검증을 위한 `메서드 체이닝`을 사용하는 패턴
- 테스트 의도를 명확하게 전달할 수 있다.

```java

assertThat(actual).isNotNull().isEqualsto(expected).hasProperties("myFieldName");

```

```java

    @Test
    void testFluentAssertions() {
        // 예시를 위해 리스트 생성
        List<String> list = Arrays.asList("apple", "banana", "orange");

        // Fluent Assertions를 사용하여 단언
        Assertions.assertThat(list)
                  .isNotEmpty()           // 리스트가 비어있지 않은지 확인
                  .hasSize(3)             // 리스트 크기가 3인지 확인
                  .contains("banana");    // "banana"가 리스트에 포함되어 있는지 확인
    }

// 위 메서드는 리스트가 비어있지않고 크기3인지, banana라는 인자가 포함되어있는지 확인한다
```


## Singleton Test
- 특정 기능이나 동작을 담당하는 테스트를 단일한 테스트 메서드로 작성하는 패턴
- 테스트 의도가 명확하며 유사한 테스트 케이스를 그룹화한다.

서술된 디자인패턴을 조합해 테스트 코드를 작성하면 가독성을 높이고 유지보수가 용이한 테스트 스위트(suite)를 구축할 수 있다.
하지만 어느 상황에 항상 이 패턴을 쓰는건 적합하지 않고 특정 상황에 맞게 적절히 조정한다.
