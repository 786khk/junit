# AssertJ
- JAVA 에서 제공하는 라이브러리
- 메러 메세지, 테스트 코드에서 가독성을 높이고 IDE에서 사용하시 쉬움
- JUnit의 assert에 비해 가독성이 높고 파라미터 순서가 까다로운 assertEquals와 다르게 순서에 구애없이 사용가능

```java

assertEquals(expected, actual);

assertThat(actual).isEqualsTo(expected);

```

## dependency

```xml
// maven
<dependency>
  <groupId>org.assertj</groupId>
  <artifactId>assertj-core</artifactId>
  <version>3.12.2</version>
  <scope>test</scope>
</dependency>

# gradle
testCompile("org.assertj:assertj-core:3.12.2")

```
출처: https://pjh3749.tistory.com/241 [JayTech의 기술 블로그:티스토리]

## Description - as()
- 테스트 상황을 설명할때 as() 파라미터로 작성한다.
- 반드시 assertion이 수행되기 전 작성한다.

```java
ResultDto result = new ResultDto("test", 0);

assertThat(result.getCount()).as("카운트 된 항목이 없습니다.").isEqualsTo(1);

/* 
org.opentest4j.AssertionFailedError: [카운트 된 항목이 없습니다.] 
expected: 1
but was: 0
*/	

```

## Filtering 
- Stream API Filter처럼 필터링이 가능하다.
- 