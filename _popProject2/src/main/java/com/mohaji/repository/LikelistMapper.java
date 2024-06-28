package com.mohaji.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.mohaji.model.Artboard;
import com.mohaji.model.Likelist;


@Mapper
public interface LikelistMapper {
	
	@Select("SELECT COUNT(*) FROM likelist WHERE pop_code = #{popCode}")
	int countByPopCode(String popCode);
	
	@Select("select * from likelist")
	List<Likelist> selectAllLikelist();
	
	@Select("SELECT l.LIKE_CODE, l.USER_ID, l.POP_CODE, a.POP_NAME, a.START_DAY, a.END_DAY, a.CONTENT "
	        + "FROM likelist l "
	        + "JOIN artboard a ON l.POP_CODE = a.POP_CODE "
	        + "WHERE l.USER_ID = #{userId};")
	List<Likelist> selectUserLikelist(String userId);
	
	@Insert("INSERT INTO likelist (USER_ID,POP_CODE)"
			+ "VALUES (#{userId}, #{popCode})")       
	void insertLikelist(String userId, String popCode);
	
	@Delete("delete from likelist where POP_CODE= #{popCode} and USER_ID= #{userId}")
    void deleteLikelist(String userId, String popCode);
	

}
