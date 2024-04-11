# 발단
- ID와 객체를 담은 API 요청을 하던 중 여러 ID값과 객체 내 필수값이 비어있는  여러 경우를 하나의 메서드에 테스트 하고 싶었음
- 두개의 메서드를 한번에 사용하지 못함


```java

@Parameterized
@valueSource(strings = {"", null})
@methodSource({"provideDto"})
void MyTestMethod(String id, MyDto dto) {

}

private Stream<MyDto> provideDto() {
    MyDto result = new MyDto();
        ...
    return Stream.of(result); 
}

```


# 안되는 사정
- @valueSource와 @methodSource는 인자를 매개변수로 전달하는 동일한 목적을 지닌다.
- @methodSource는 테스트 메서드의 인자를 제공하는 메서드를 지정해 Stream<Argument>로 반환한다. 
- @valueSource는 특정 값의 배열인자로 직접 지정해 테스트를 한다.
- 둘은 동시에 목적성이 충돌한다.
- `Junit에서는 이러한 어노테이션을 동시에 사용할 수 없도록 지정`되어있다.