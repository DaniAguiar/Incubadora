package com.invillia.springregister.controller;

import com.invillia.springregister.domain.Member;
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

@Controller
public class MemberController {

    private final MemberService memberService;
    private final TeamService teamService;

    @Autowired
    public MemberController(MemberService memberService, TeamService teamService) {
        this.memberService = memberService;
        this.teamService = teamService;
    }

    @GetMapping("/index/member")
    public String indexMember(Model model){
        model.addAttribute("members", memberService.findAll());
        return "index-member";
    }

    @GetMapping("/index/member/signup")
    public String showSignUpForm(Member member, Model model) {
        model.addAttribute("teams", teamService.findAll());
        return "add-member";
    }

    @PostMapping("/index/member/add")
    public String addMember(@Valid Member member, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/index/member/signup";
        }
        memberService.insertNewMember(member);
        return "redirect:/index/member";
    }

    @GetMapping("/index/member/edit/{id}")
    public String showUpdateForm2(@PathVariable("id") long id, Model model) {
        Member member = memberService.findById(id).orElseThrow(() -> new AcitonNotPermitedException(String.valueOf(id)));
        model.addAttribute("member", member);
        model.addAttribute("teams", teamService.findAll());
        return "update-member";
    }

    @PostMapping("/index/member/update/{id}")
    public String updateMember(@PathVariable("id") long id, @Valid Member member, BindingResult result) {
        if (result.hasErrors()) {
            member.setId(id);
        }
        memberService.updateMember(member);
        return "redirect:/index/member";
    }

    @GetMapping("/index/member/delete/{id}")
    public String deleteMember(@PathVariable("id") long id, Model model) {
        Member member = memberService.findById(id).orElseThrow(() -> new EntityNotFoundException(String.valueOf(id)));
        memberService.delete(member);
        model.addAttribute("members", memberService.findAll());
        return "redirect:/index/member";
    }

    @ExceptionHandler(AcitonNotPermitedException.class)
    public void exceptionHandler(HttpServletResponse response, Exception e) throws IOException {
        response.sendError(HttpStatus.NOT_ACCEPTABLE.value(), e.getMessage());
    }
}
