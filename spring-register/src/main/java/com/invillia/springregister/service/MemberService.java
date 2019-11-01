package com.invillia.springregister.service;

import com.invillia.springregister.domain.Member;
import com.invillia.springregister.repository.MemberRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Object findAll() {
        return memberRepository.findAll();
    }

    public void insertNewMember(Member member) {
        memberRepository.save(member);
    }

    public Optional<Member> findById(long id) {
        return memberRepository.findById(id);
    }

    public void delete(Member member) {
        memberRepository.delete(member);
    }

    @Transactional
    public void updateMember(Member member){
        Member persisted = memberRepository.findById(member.getId()).orElseThrow(IllegalArgumentException::new);
        persisted.setName(member.getName());
        persisted.setTeam(member.getTeam());
        memberRepository.save(persisted);
    }

    public List<Member> findByTeamId(long id) {
        return memberRepository.findByTeamId(id);
    }
}
