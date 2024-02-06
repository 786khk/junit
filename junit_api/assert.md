# Assert
- junit 에서 제공하는 API
- 개발자가 매번 작성된 코드의 동작을 확인할 때 비지니스 로직에서의 디버깅, System.out.println()으로 확인할 시간과 비용을 절감

## 문법
### assertEquals(expected, result, "message")
- 기대값(expected)과 결과값(result)을 비교한다.
- 기대값과 결과값이 다를 경우 "message"를 출력
```java

int a = 0;
int b = 1;

assertEquals(a*b, a+b,"a와 b는 다르다.")

```
### assertThrows(MyCustomException)
- 커스텀된 예외처리를 발생시킨다. 
- 예외처리를 테스트할 때 유용

```java

assertThrows(()->MyException("occured error"));

```

### 