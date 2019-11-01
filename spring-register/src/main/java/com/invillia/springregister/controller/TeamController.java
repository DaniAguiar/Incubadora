package com.invillia.springregister.controller;

import com.invillia.springregister.domain.Member;
import com.invillia.springregister.domain.Team;
import com.invillia.springregister.exception.AcitonNotPermitedException;
import com.invillia.springregister.exception.EntityNotFoundException;
import com.invillia.springregister.service.MemberService;
import com.invillia.springregister.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@Controller
public class TeamController {

    private final TeamService teamService;
    private final MemberService memberService;

    @Autowired
    public TeamController(TeamService teamService, MemberService memberService) {
        this.teamService = teamService;
        this.memberService = memberService;
    }

    @GetMapping("/index")
    public void index(){
    }

    @GetMapping("/index/team")
    public String indexTeam(Model model){
        model.addAttribute("teams", teamService.findAll());
        return "index-team";
    }

    @GetMapping("index/team/member/{id}")
    public String listMember(@PathVariable("id") long id, Model model){
        List<Member> members = memberService.findByTeamId(id);
        model.addAttribute("members", members);
        model.addAttribute("team", teamService.findById(id).get());
        return "list-member";
    }

    @GetMapping("/index/team/signup")
    public String showSignUpForm(Team team) {
        return "add-team";
    }

    @PostMapping("/index/team/add")
    public String addTeam(@Valid Team team, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "redirect:/index/team/signup";
        }
        teamService.insertNewTeam(team);
//        model.addAttribute("teams", teamService.findAll());
        return "redirect:/index/team";
    }

    @GetMapping("/index/team/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Team team = teamService.findById(id).orElseThrow(() -> new AcitonNotPermitedException(String.valueOf(id)));
        model.addAttribute("team", team);
        return "update-team";
    }

    @PostMapping("/index/team/update/{id}")
    public String updateTeam(@PathVariable("id") long id, @Valid Team team, BindingResult result) {
        if (result.hasErrors()) {
            team.setId(id);
            return "redirect:/index/team/edit/{id}";
        }
        teamService.updateMember(team);
        return "redirect:/index/team";
    }

    @GetMapping("/index/team/error-delete")
    public String errorView(){
        return "error-delete";
    }

    @GetMapping("/index/team/delete/{id}")
    public String deleteTeam(@PathVariable("id") long id) {
        Team team = teamService.findById(id).orElseThrow(() -> new EntityNotFoundException(String.valueOf(id)));
        if(teamService.findMembersByTeamId(id).isEmpty()){
            teamService.delete(team);
            return "redirect:/index/team";
        }
        else return "redirect:/index/team/error-delete";
    }

    @ExceptionHandler(AcitonNotPermitedException.class)
    public void exceptionHandler(HttpServletResponse response, Exception e) throws IOException {
        response.sendError(HttpStatus.NOT_ACCEPTABLE.value(), e.getMessage());
    }
}
