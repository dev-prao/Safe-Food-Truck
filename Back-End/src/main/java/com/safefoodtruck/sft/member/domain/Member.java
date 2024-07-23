package com.safefoodtruck.sft.member.domain;

//@Entity
//@Table(name = "MEMBER")
//@AllArgsConstructor(access = AccessLevel.PROTECTED)
//@NoArgsConstructor
public class Member {

//    @Id
//    @Column(name = "member_email")
    private String email;
    String password;
    String name;
    String phoneNumber;
}
