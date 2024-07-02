# JUnit기본 어노테이션 - 조건부 테스트
- OS,환경변수 등 스시템 관련사항에 따른 테스트를 할 수 있는 어노테이션
- 활성과 비활성 여부는 Enable~와 Disable~를 프리픽스로 해 사용한다.
- 환경변수, 시스템 변수는 어노테이션 값을 문자형태의 named와 문자형태의 mathces를 파라미터로 받음
## OS에 따른 테스트
- 특정 OS에 따른 조건으로 실행여부 설정
- @DisabledOS 와 @EnabledOS에 따라 특정 OS에서 실행
- value 로 특정 OS언급한다.

```java
    @EnabledOnOs(OS.LINUX)

    @DisabledOnOs(OS.WINDOWS)

```

## JDK  버전에 따른 테스트

```java
    @EnabledOnJre(JRE.JAVA_13)

     @DisabledOnJre(JRE.JAVA_15)

```

## System 변수에 따른 테스트
```java
    @EnabledIfSystemProperty(named="java.vendor", matches="Oracle.")

    @DisabledIfSystemProperty(named="java.vendor", matches="Oracle.")

```