package com.mohaji.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.data.repository.query.Param;

import com.mohaji.model.Popboard;


@Mapper
public interface PopboardMapper {

	@Select("SELECT COUNT(*) FROM popboard")
	int countPopboard();
		
		@Select("SELECT COUNT(*) FROM popboard WHERE pop_code = #{popCode}")
		int countByPopCode(String popCode);
		
		@Select("select * from popboard")
		List<Popboard> selectAllPopboard();
		
		@Select("select * from popboard where POP_CODE=#{popCode}")
		List<Popboard> selectPopboard(String popCode);
		
		@Select("select * from popboard where USER_ID=#{userId}")
		List<Popboard> selectIdPopboard(String userId);
		
		@Insert("INSERT INTO popboard (USER_ID,POP_CODE,title,content,star)"
				+ "VALUES (#{userId}, #{popCode}, #{title},#{content},#{star})")       
		void insertPopboard(Popboard popboard);
		
		@Delete("delete from popboard where num= #{num}")
	    void deletePopboard(Long num);
		
		@Update("UPDATE popboard SET title = #{title}, "
		        + "content = #{content}, "
		        + "star = #{star}, "
		        + "regtime = NOW() "
		        + "WHERE num = #{num}")
		void updatePopboard(Popboard popboard);
		
		@Select("SELECT * FROM popboard WHERE POP_CODE = #{popCode} LIMIT #{offset}, #{limit}")
		List<Popboard> selectPopboardWithPagination(@Param("popCode") String popCode, @Param("offset") int offset, @Param("limit") int limit);
		
}
