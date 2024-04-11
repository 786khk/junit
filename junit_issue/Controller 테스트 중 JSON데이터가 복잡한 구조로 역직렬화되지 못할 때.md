# 발단
- MockMvcResult 로 컨트롤러 API 요청에 대한 테스트 도중 결과값을 json문자열로 가져온다.
- ObjectMapper로 json 타입의 데이터를 객체로 형변환할 때 복잡한 구조의 데이터일 경우 생성자가 없다는 예외가 발생한다.

```sql
Cannot construct instance of `...MyDto` (no Creators, like default constructor, exist): cannot deserialize from Object value (no delegate- or property-based Creator)

```
```json
{
	"datetime":"2024-03-13T10:21:55.8579676",
	"apiResult":true,
	"resultData":[
		{
			"name":"이름",
			"id":"id"
		}
	],
	"paging":{
		"page":1,
		"size":1,
		"totalPage":1,
		"totalSize":1
	}
}

```

## ObjectMapper를 사용할 때 기본 생성자가 필요한 이유
- ObjectMapper를 쓸 때 별도의 생성자를 바인딩하라는 로직이 없으면 `기본 생성자`가 필요하다.
- 즉 기본생성자가 있으면 `Setter가 없어도 데이터 바인딩이 가능`하다.
- spring boot는 Jackson 라이브러리를 사용해 직렬화와 역직렬화를 진행한다.

```java


//org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter

private Object readJavaType(JavaType javaType, HttpInputMessage inputMessage) throws IOException {
		...
		try {
			InputStream inputStream = StreamUtils.nonClosing(inputMessage.getBody());
			if (inputMessage instanceof MappingJacksonInputMessage) {
				Class<?> deserializationView = ((MappingJacksonInputMessage) inputMessage).getDeserializationView();
				if (deserializationView != null) {
					ObjectReader objectReader = objectMapper.readerWithView(deserializationView).forType(javaType);
					if (isUnicode) {
						return objectReader.readValue(inputStream);
					}
					else {
						Reader reader = new InputStreamReader(inputStream, charset);
						return objectReader.readValue(reader);
					}
				}
			}
			...
		}
            ...
	}

```
- spring boot에서 보면 json데이터를 역직렬화 할 때 ObjectMapper를 사용하는 것을 볼 수 있다.
- ObjectMapper.java를 살펴보면 Json데이터 인지 확인하고 객체를 반환하는 과정을 볼 수 있다.
- 구글링을 할 때 블로그 정보와 내가 직접 찾아간 클래스가 다를 수 있다.


```java
//ObjectMapper.java
     
    public <T> T readValue(String content, Class<T> valueType)
        throws JsonProcessingException, JsonMappingException
    {
        _assertNotNull("content", content); 
        return readValue(content, _typeFactory.constructType(valueType));
    } 

    @SuppressWarnings("unchecked")
    public <T> T readValue(String content, JavaType valueType)
        throws JsonProcessingException, JsonMappingException
    {
        _assertNotNull("content", content);                         // null인지 확인
        try { // since 2.10 remove "impossible" IOException as per [databind#1675]
            return (T) _readMapAndClose(_jsonFactory.createParser(content), valueType);
            
        } catch (JsonProcessingException e) {
            throw e;
        } catch (IOException e) { // shouldn't really happen but being declared need to
            throw JsonMappingException.fromUnexpectedIOE(e);
        }
    } 

    protected Object _readMapAndClose(JsonParser p0, JavaType valueType)
        throws IOException
    {
        try (JsonParser p = p0) {
            final Object result;
            final DeserializationConfig cfg = getDeserializationConfig();
            final DefaultDeserializationContext ctxt = createDeserializationContext(p, cfg);
            JsonToken t = _initForReading(p, valueType);
            if (t == JsonToken.VALUE_NULL) {
                // Ask JsonDeserializer what 'null value' to use:
                result = _findRootDeserializer(ctxt, valueType).getNullValue(ctxt);
            } else if (t == JsonToken.END_ARRAY || t == JsonToken.END_OBJECT) {
                result = null;
            } else { 
                result = ctxt.readRootValue(p, valueType,
                        _findRootDeserializer(ctxt, valueType), null);
                        // JSONDeserializer를 찾고 해당jsonDeserializer로 역직렬화
                ctxt.checkUnresolvedObjectId();
            }
            if (cfg.isEnabled(DeserializationFeature.FAIL_ON_TRAILING_TOKENS)) {
                _verifyNoTrailingTokens(p, ctxt, valueType);
            }
            return result;
        }
    }

    // jsonData인지 확인
    public Object readRootValue(JsonParser p, JavaType valueType,
            JsonDeserializer<Object> deser, Object valueToUpdate)
        throws IOException
    {
        if (_config.useRootWrapping()) {
            return _unwrapAndDeserialize(p, valueType, deser, valueToUpdate); //"{로 시작하는지 확인"
        }
        if (valueToUpdate == null) {
            return deser.deserialize(p, this);
        }
        return deser.deserialize(p, this, valueToUpdate);
    }



    protected Object _unwrapAndDeserialize(JsonParser p,
            JavaType rootType, JsonDeserializer<Object> deser,
            Object valueToUpdate)
        throws IOException
    {
        PropertyName expRootName = _config.findRootName(rootType);
        // 12-Jun-2015, tatu: Should try to support namespaces etc but...
        String expSimpleName = expRootName.getSimpleName();
        if (p.currentToken() != JsonToken.START_OBJECT) {
            reportWrongTokenException(rootType, JsonToken.START_OBJECT, // JsonToken.START_OBJECT == "{" 
                    "Current token not START_OBJECT (needed to unwrap root name %s), but %s",
                    ClassUtil.name(expSimpleName), p.currentToken());
        }
            ...
       
        return result;
    }
```
    - ObjectMapper를 사용해 객체를 생성한 후 JsonData를 해장 객체 필드에 할당한다.
    - 기본생성자가 없으면 객체를 생성할 수 없기때문에 InvalidDefinitionException 예외 발생
    - 참고로 객체 내부 값을 써야할다면 @Getter, @Setter를 추가해야 한다.


# 해결
## 기본 생성자 추가
    - 해당 기능은 기본생성자를 지원하지 않아 json결과값이 역직렬화에 실패하는것으로 추측.
    1. 어노테이션 추가
    - 클래스에 @NoArgsConstructor 를 추가한다.
    
```java
    @NoArgsConstructor
    public class MyClass {

    }
```
    1. 기본생성자 추가
    - 클래스에 @NoArgsConstructor 를 추가한다.
    
```java
    public class MyClass {
        public Myclass() {

        }
    }
```
    1. Json데이터에 대한 생성자 생성 
    - 기존 생성자에 @JsonCreator 를 추가한다.

```java

    @JsonCreator
    public class MyClass {
        public Myclass() {

        }
    }
```
