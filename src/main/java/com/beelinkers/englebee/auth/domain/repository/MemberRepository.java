package com.beelinkers.englebee.auth.domain.repository;

import com.beelinkers.englebee.auth.domain.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

}