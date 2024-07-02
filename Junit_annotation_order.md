# JUnit기본 어노테이션 - 순서 지정

## @TestClassOrder
- 테스트 믈래스에 대란 실행순서 구성
- 테스트 클래스에 일반적으로 순서를 지정하는것은 지양하지만 가끔 순서를 지정해야 하는경우가 있을 때 사용
- 클래스 헤더에 어노테이션 사용
- @TestClassOrder(ClassOrderer.OrderAnnotation.class)

## @TestMethodOrder
- 어노테이션이 달린 메서드를 실행하는 순서 지정
- 메서드 실행 순서 제어
- 해당 어노테이션이 없다면 알파벳순으로 실행됨
- 1부터 시작
### MethodOrderer.MethodName.class
- 메서드 이름 순으로 실행
### MethodOrderer.OrderAnnotation.class
- 클래스 헤더에 해당 어노테이션이 있다면 메서드에 `@Order`라는 어노테이션으로 별도의 순서를 지정할 수 있음
- 기본적으로 `Integer.MAX_VALUE` 할당

```java
@TestMethodOrder(OrderAnnotation.class)
public class MyTestClass{

@Order(1)
@Test
void when_read_list() {}
...
}
```

### MethodOrderer.Random.class
- 메서드 실행순서 무작위 실행
- 실행때마다 순서가 바뀜


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




참고 : https://www.devkuma.com/docs/junit5/