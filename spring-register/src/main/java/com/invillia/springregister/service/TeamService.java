package com.invillia.springregister.service;

import com.invillia.springregister.domain.Member;
import com.invillia.springregister.domain.Team;
import com.invillia.springregister.repository.MemberRepository;
import com.invillia.springregister.repository.TeamRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class TeamService {

    private final TeamRepository teamRepository;
    private final MemberRepository memberRepository;

    public TeamService(TeamRepository teamRepository, MemberRepository memberRepository) {
        this.teamRepository = teamRepository;
        this.memberRepository = memberRepository;
    }

    public Object findAll() {
        return teamRepository.findAll();
    }

    public void insertNewTeam(Team team) {
        teamRepository.save(team);
    }

    public Optional<Team> findById(long id) {
        return teamRepository.findById(id);
    }

    public void delete(Team team) {
        teamRepository.delete(team);
    }

    @Transactional
    public void updateMember(Team team){
        Team persisted = teamRepository.findById(team.getId()).orElseThrow(IllegalArgumentException::new);
        persisted.setName(team.getName());
        teamRepository.save(persisted);
    }

    public List<Member> findMembersByTeamId(long id) {
        return memberRepository.findByTeamId(id);
    }

}
