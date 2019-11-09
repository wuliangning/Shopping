package com.ssm.service;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.ssm.dao.MemberMapper;
import com.ssm.model.Member;

@Service
public class MemberService {

	@Resource
	private MemberMapper memberMapper;
	
    public int load(Member member){
    	return memberMapper.load(member);
    }
    
    public List<Member> getMemberList(){
    	return memberMapper.getMemberList();
    }
    
    public Member getMember(Member member){
		return memberMapper.getMember(member);
	}

	public void addMember(HttpServletRequest request){
		Member member = new Member();
		//用不了！request.setCharacterEncoding("UTF-8");
		String loginName = request.getParameter("loginName");
		String pwd = request.getParameter("pwd");
		String ageString = request.getParameter("age");
		int age;
		if (ageString.equals(null)||ageString.equals("")){
			age=0;
		}else {
			age = Integer.parseInt((ageString).trim());
		}

		String nickName = request.getParameter("nickName");
		byte[] bytes= new byte[0];
		try {
			bytes = loginName.getBytes("ISO-8859-1");
			loginName = new String(bytes,"UTF-8");
			bytes = nickName.getBytes("ISO-8859-1");
			nickName= new String(bytes,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		member.setId(loginName);
		member.setLoginName(loginName);
		member.setPwd(pwd);
		member.setNickName(nickName);
		member.setAge(age);
    	memberMapper.addMember(member);
	}

	public void delete(Member member){
		byte[] bytes= new byte[0];
		try {
			bytes =member.getId().getBytes("ISO-8859-1");
			member.setId(new String(bytes,"UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		memberMapper.delete(member);
	}

	public void update(Member member){
		try {
			byte[] bytes=  member.getNickName().getBytes("ISO-8859-1");
			member.setNickName(new String(bytes,"UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		System.out.println(member+"++++++++++++++++++++++++++++++");
		memberMapper.update(member);
	}

	public List<Member> keyWord(HttpServletRequest request) {
		// TODO Auto-generated method stub
		String keyWord = null;
		byte[] bytes= new byte[0];
		try {
			bytes =request.getParameter("keyWord").getBytes("ISO-8859-1");
			keyWord=new String(bytes,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		keyWord="%"+keyWord+"%";
		System.out.println(keyWord);
		return memberMapper.keyWord(keyWord);
	}
    
}
