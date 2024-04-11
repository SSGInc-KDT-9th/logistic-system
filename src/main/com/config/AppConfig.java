package main.com.config;

import main.com.member.repository.MemberRepository;
import main.com.member.repository.MySqlMemberRepository;
public class AppConfig {
    private MemberRepository memberRepository= new MySqlMemberRepository();
}
