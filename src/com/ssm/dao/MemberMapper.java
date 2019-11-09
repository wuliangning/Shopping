package com.ssm.dao;


import java.util.List;

import com.ssm.model.Member;
import com.ssm.model.Wares;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


public interface MemberMapper {
	
	public int load(Member member);
	
	public List<Member> getMemberList();
	
	public Member getMember(Member member);

	public void addMember(Member member);
	@Delete(" delete from member where id= #{id} ")
	public void delete(Member member);
	@Update("update member set loginName=#{loginName},pwd=#{pwd},nickName=#{nickName},age=#{age} where id=#{id}")
	public void update(Member member);
	@Select("select * from member where loginName like #{keyWord}")
	public List<Member> keyWord(String keyWord);
}
