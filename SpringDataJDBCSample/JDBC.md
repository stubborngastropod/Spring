### JDBC

ORM: Object/RDB Maper, 애플리케이션의 객체와 RDB의 데이터 매핑

스프링 데이터의 메서드를 상속해 사용 가능

- application.properties에서 스프링 부트 프로젝트 환경 설정

```java
// application.properties
spring.datasource.driver-class0name=org.postgresql.Driver
spring.datasource.url=jdbc:postgresql://localhost:5432/postgres
spring.datasource.username=qwer
spring.datasource.password=qwer
```

- 엔터티 생성

```java
// ㅡ
package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    @Id
    private Integer id;
    private String name;
}
```

Data:  클래스 전 필드에 대해 getter/setter로 액세스 가능

NoArgsConstructor: 클래스 기본 생성자 자동 생성

AllArgsConstructor: 클래스 전 필드 초기화 값을 인수로 가지는 생성자 자동 생성

- 레파지토리 생성

```java
// MemberCrudRepository interface
package repository;

import entity.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberCrudRepository extends CrudRepository<Member, Integer> {
}
```

spring data의 CrudRepository 상속

- 클래스 생성

```java
package com.example.SpringDataJDBCSample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.Member;
import com.example.demo.repository.MemberCrudRepository;

@SpringBootApplication
public class SpringDataJdbcSampleApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringDataJdbcSampleApplication.class, args)
                .getBean(SpringDataJdbcSampleApplication.class).execute();
    }

    @Autowired
    MemberCrudRepository repository;

    private void execute() {
        executeInsert();
        executeSelect();
    }

    private void executeInsert() {
        Member member = new Member(2, "nono");
        member = repository.save(member);
        System.out.println("data:" + member);
    }

    private void executeSelect() {
        System.out.println("all data");
        Iterable<Member> members = repository.findAll();
        for (Member member : members) {
            System.out.println(member);
        }
    }
}
```
