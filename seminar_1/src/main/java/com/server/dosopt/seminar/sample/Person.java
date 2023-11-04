package com.server.dosopt.seminar.sample;

import lombok.*;

@Getter
//@Setter
//@AllArgsConstructor // 모든 매개변수를 받는 생성자
//@NoArgsConstructor // 기본 생성자(파라미터를 아무것도 갖지 않는 것)
//@RequiredArgsConstructor // 찾아보기 ~
public class Person {

    private String lastName;
    private String firstName;

    @Builder // 뭐가 뭐였는지 기억이 안 날때 -> 값이 제대로 들어가는지 checking하기 위해서 사용
    public Person(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
    }
}
