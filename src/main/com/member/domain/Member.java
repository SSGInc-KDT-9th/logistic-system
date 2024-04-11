package main.com.member.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Member {
    private long id;
    private String member_name;
    private String member_id;
    private String member_password;
    private MemberRole member_role;

    @Builder
    public Member(String member_name, String member_id, String member_password, MemberRole member_role) {
        this.member_name = member_name;
        this.member_id = member_id;
        this.member_password = member_password;
        this.member_role = member_role;
    }
}