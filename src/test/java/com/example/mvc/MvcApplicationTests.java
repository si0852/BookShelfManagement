package com.example.mvc;

import com.example.mvc.domain.Member;
import com.example.mvc.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MvcApplicationTests {

	@Autowired
	MemberRepository memberRepository;


	@Test
	void 회원가입() {
		Member member = new Member();
		member.setName("testName");
		memberRepository.save(member);

		Member findMember = memberRepository.findById(member.getId()).get();
		Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
	}

}
