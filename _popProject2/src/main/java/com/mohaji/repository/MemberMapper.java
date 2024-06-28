package com.mohaji.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import com.mohaji.model.Member;

@Mapper
public interface MemberMapper {
	
	@Select("select count(*) from member")
	int count();
	
	@Select("select * from member")
	List<Member> selectAllMember();
	
	@Select("select * from member where USER_ID =#{userId}")
	Member selectOneMember(String userId);
	
	@Insert("INSERT INTO member (USER_ID, PASS, EMAIL, UNAME, \r\n"
			+ " CREATE_DAY, UPDATE_DAY,PHONE_NUM,birth,gender,uevent)"
			+ "VALUES ("
			+ "#{userId}, #{pass}, #{email} , #{uname}, NOW(), #{updateDay}, #{phoneNum}, #{birth},#{gender},#{uevent} )")       
	void insertMember(Member member);

	@Update("UPDATE member SET PASS = #{pass}, "
	        + "EMAIL = #{email}, "
	        + "UNAME = #{uname}, "
	        + "UPDATE_DAY = NOW(), "
	        + "PHONE_NUM = #{phoneNum}, "
	        + "BIRTH = #{birth}, "
	        + "UEVENT = #{uevent} "
	        + "WHERE USER_ID = #{userId}")
	void updateMember(Member member);
	
	@Delete("delete from member where USER_ID= #{userId}")
    void deleteMember(String userId);

}
