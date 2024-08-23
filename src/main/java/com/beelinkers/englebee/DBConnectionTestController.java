package com.beelinkers.englebee;

import com.beelinkers.englebee.auth.domain.entity.Member;
import com.beelinkers.englebee.auth.domain.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DBConnectionTestController {
  @Autowired
  private MemberRepository memberRepository;

  @GetMapping("/db/conn")
  public Member testDB(){
    return memberRepository.findById(1L).orElse(null);
  }

}
