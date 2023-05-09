package com.example.demo.controller;

import com.example.demo.entity.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ThymeleafController {
    @GetMapping("show")
    public String showView(Model model) {
        Member member = new Member(1, "no.1");

        Member member1 = new Member(10, "no.10");
        Member member2 = new Member(20, "no.20");

        List<String> directionList = new ArrayList<String>();
        directionList.add("E");
        directionList.add("W");
        directionList.add("S");
        directionList.add("N");

        Map<String, Member> memberMap = new HashMap<>();
        memberMap.put("TEN1", member1);
        memberMap.put("TEN2", member2);

        List<Member> memberList = new ArrayList<>();
        memberList.add(member1);
        memberList.add(member2);

        model.addAttribute("name", "nono");
        model.addAttribute("mb", member);
        model.addAttribute("list", directionList);
        model.addAttribute("map", memberMap);
        model.addAttribute("members", memberList);

        return "useThymeleaf";
    }

    @GetMapping("a")
    public String showA() {
        return "pageA";
    }
}
