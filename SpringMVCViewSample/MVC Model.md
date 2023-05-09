### MVC Model

프로그램의 역할을 Model, View, Controller로 분류해 사용하는 방법

- Model: 시스템의 목적을 처리하는 부분(비즈니스 로직)

- View: 시스템의 표현 부분(외형)

- Controller: 서비스 처리 담당, 뷰를 제어

역할 분담을 통한 효율적 개발, 엔지니어 분업화 용이, 설계 변경에 유연한 대응 등의 장점이 있음

- 스프링 MVC

요청 --> Dispatcher Servlet(요청을 수신하는 프런트 컨트롤러): 컨트롤러의 요청 핸들러 메서드 호출 --> 컨트롤러: 비즈니스 로직 처리 호출, 처리 결과 모델로 설정하여 뷰 이름 반환 --> Dispatcher Servlet이 뷰 이름에 대응하는 화면 표시 의뢰 --> 뷰에서 화면 표

```java
// HelloViewController.java
package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("hello")
public class HelloViewController {

    @GetMapping("view")
    public String helloView() {
        return "hello";
    }
}
```

@Controller: 애플리케이션 레이어의 컨트롤러 부여, 클라이언트와 데이터 입출력 제어

@RequestMapping: 컨트롤러의 요청 핸들러 메서드와 URL 매핑. value는 매핑할 URL 경로 지정, method는 HTTP 메서드 지정

@GetMapping: GET 요청 전용 어노테이션(POST 요청은 @PostMapping)

뷰는 resources/templates 디렉터리에 생성, CSS나 js는 resources/static에 배치

```html
// resources/templates/hello.html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <h1>Hello View!!!</h1>
</body>
</html>
```

- Thymeleaf: 스프링 부트는 자동으로 resources/templates 폴더를 참조하게 됨

- Template Engine: 데이터와 템플릿을 바인딩해서 뷰에 표시를 도움

```java
// HelloModelController.java
package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("hello")
public class HelloModelController {
    @GetMapping("model")
    public String helloView(Model model) {
        model.addAttribute("msg", "Thymeleaf!!!");

        return "helloThymeleaf";
    }
}
```

addAttribute 메서드는 msg에 "Thymeleaf!!!"를 담아서 인수로 저장, 이후 helloThymeleaf.html을 반환

```html
<!-- resources/templates/helloThymeleaf.html -->
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
  <h1 th:text="$msg">Model!!!</h1>
</body>
</html>
```

html 태그 내에서 타임리프 사용을 선언, th:text는 속성값에 지정된 값을 sanitize하여 출력한다는 뜻.

- sanitize: 위험한 코드나 데이터를 변환 또는 제거하여 무력화하는 것

위 html 파일은 "Model!!!"이라는 h1 태그를 화면 상에 반환하지만 코드 실행 시 msg에 저장된 "Thymeleaf!!!"를 화면 상에 반환하게 됨
