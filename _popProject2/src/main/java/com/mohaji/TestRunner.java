package com.mohaji;

import java.sql.Connection;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;


//@Component
@Slf4j // 로그 사용하려고 등록
public class TestRunner implements ApplicationRunner {
	
	@Autowired
	DataSource dataSource;	
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Override
	public void run(ApplicationArguments args) throws Exception {
		Connection connection=dataSource.getConnection();

		
		//  jdbctemplate	
//		jdbcTemplate.execute("INSERT INTO artboard (pop_code, pop_name, start_day, end_day, content, img, rink, place)"
//				+ "VALUES "
//    +"('a03', 'aaa PopUp', '2024-04-27', '2024-05-28', 'aaa 기념 팝업 스토어', NULL, 'https://youtu.be/u_V1rvUQpwY','더현대 서울');");
//
//	
//	jdbcTemplate.execute("INSERT INTO member (user_id, pass, email, uname, create_day, update_day, phone_num, birth, gender, uevent)"
//	+"VALUES"
//	   + "('ccc', 'ccc', 'ccc@ccc', 'ccc', NOW(), NULL, '01077603956', '1993-06-05', 'f', 'on')");
//	}
}
}

