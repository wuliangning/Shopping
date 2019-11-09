package com.ssm.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ssm.model.Member;
import com.ssm.model.Wares;
import com.ssm.service.MemberService;
		
@Controller
@RequestMapping("/member")
public class MemberController {

	@Resource
	private MemberService memberService;
	
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
    public String index(){
    	return "/login"; 
    }
	
	@RequestMapping(value="/index",method=RequestMethod.POST)
    public String add(Member member){
		
		int count = memberService.load(member);
		if(count >0)
			return "/index"; 
		else 
			return "/login"; 
    }
	
	@RequestMapping(value="/main",method=RequestMethod.GET)
    public String main(){
    	return "/introduce"; 
    }
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String  getUserList(Model model){
		List<Member> members = memberService.getMemberList();
		Map<String, Member> mapList = new HashMap<String, Member>();
		for (Member m : members) {
			mapList.put(m.getId(), m);
		}
		model.addAttribute("mapList",mapList);
		return "/memberList"; 
	}
	
	@RequestMapping(value="/get",method=RequestMethod.GET)
	public ModelAndView get(Member member) throws Exception{
		 member.setId("admin");
		 Member m = memberService.getMember(member);
		 ModelAndView mav = new ModelAndView();
		 mav.addObject("member", m);
		 mav.setViewName("/member");
		 return mav; 
	}

	@RequestMapping(value="/doAddMember",method=RequestMethod.GET)
	public ModelAndView doAddMember(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		memberService.addMember(request);
		mav.setViewName("redirect:/member/list");

		return mav;
	}
	@RequestMapping(value="/AddMember",method=RequestMethod.GET)
	public String AddMember(){
		return "addMember";
	}
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String delete(Member member){
		memberService.delete(member);
		return "redirect:/member/list";
	}

	@RequestMapping(value="/updateMember",method=RequestMethod.GET)
	public String updateMember(Member member) throws UnsupportedEncodingException {
		byte[] bytes=  member.getNickName().getBytes("ISO-8859-1");
		member.setNickName(new String(bytes,"UTF-8"));
		return "updateMember";
	}
	@RequestMapping(value="/doUpdateMember",method=RequestMethod.GET)
	public String  doUpdateMember(Member member){
		memberService.update(member);
		return "redirect:/member/list";
	}
	@RequestMapping(value="/keyWord",method=RequestMethod.GET)
	public ModelAndView  keyWord(HttpServletRequest request){
		List<Member> member=memberService.keyWord(request);
		Map<String, Member> mapList = new HashMap<String, Member>();
		for (Member m : member) {
			mapList.put(m.getId(), m);
		}
		for (Member m:member) {
			System.out.println(m);
		}
		return new ModelAndView("/memberList", "mapList",mapList);
	}
	
}
