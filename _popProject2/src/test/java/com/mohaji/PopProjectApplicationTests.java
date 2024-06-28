package com.mohaji;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mohaji.model.Likelist;
import com.mohaji.model.Artboard;
import com.mohaji.repository.ArtboardMapper;
import com.mohaji.repository.LikelistMapper;
import com.mohaji.repository.MemberMapper;

import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@SpringBootTest
class PopProjectApplicationTests {
	@Autowired
	MemberMapper memberMapper;
	@Autowired
	LikelistMapper likelistMapper;
	@Autowired
	ArtboardMapper artboardMapper;	
//	@Order(1)
//	@Test
//	@DisplayName("멤버카운트")
//	void contextLoads() {
//		System.out.println(memberMapper.count());
//		log.info("member 레코드 수 :{}",memberMapper.count());
//	}
//	@Order(2)
//	@Test
//	@DisplayName("아트보드카운트")
//	void contextLoads1() {
//		System.out.println(artboardMapper.count());
//		log.info("artboard 레코드 수 :{}",artboardMapper.count());
//	}
//	@Order(3)
//	@Test
//	@DisplayName("라이크리스트카운트")
//	void contextLoads2() {
//		System.out.println(likelistMapper.count());
//		log.info("likelist 레코드 수 :{}",likelistMapper.count());
//	}
//	
//	@Order(1)
//	@Test
//	@DisplayName("아트보드셀렉트")
//	void selectAllArtboard() {
//		System.out.println(artboardMapper.selectAllArtboard());
//		log.info("artboard 모든 :{}",artboardMapper.selectAllArtboard());
//	}
//	@Order(2)
//	@Test
//	@DisplayName("아트보드인서트")
//	void insertArtboard() {
//		Artboard art=Artboard.builder().popCode("b01").popName("전장의지배자")
//				.startDay("20240605").endDay("20240706").content("신난다신나")
//				.img("img").rink("link").build();
//		artboardMapper.insertArtboard(art);
//		System.out.println(artboardMapper.selectAllArtboard());
//		log.info("artboard 입력 :{}",artboardMapper.selectAllArtboard());
//	}
//	@Order(3)
//	@Test
//	@DisplayName("아트보드업뎃")
//	void updateArtboard() {
//		Artboard art=Artboard.builder().popName("b02")
//				.startDay("20200605").endDay("20200706").content("지친다!")
//				.img("img").rink("link").popCode("b01").build();
//		artboardMapper.updateArtboard();
//		System.out.println(artboardMapper.selectAllArtboard());
//		log.info("artboard 업뎃 :{}",artboardMapper.selectAllArtboard());
//	}
//	@Order(4)
//	@Test
//	@DisplayName("아트보드딜리트")
//	void deleteArtboard() {
//		artboardMapper.deleteArtboard("a01");
//		System.out.println(artboardMapper.selectAllArtboard());
//		log.info("artboard 삭제 :{}",artboardMapper.selectAllArtboard());
//	}
	
	@Order(2)
//	@Test
	@DisplayName("라이크셀렉트")
	void selectAllLikelist() {
		System.out.println(likelistMapper.selectAllLikelist());
		log.info("likelist 모든 :{}",likelistMapper.selectAllLikelist());
	}
	@Order(3)
	@Test
	@DisplayName("라이크셀렉트유저")
	void selectUserLikelist() {
		System.out.println(likelistMapper.selectUserLikelist("admin"));
		log.info("likelist 유저 :{}",likelistMapper.selectAllLikelist());
	}
//	@Order(1)
//	@Test
//	@DisplayName("라이크인서트")
//	void insertLikelist() {
//		Likelist list=Likelist.builder().popCode("a01").userId("admin").build();
//		likelistMapper.insertLikelist(list);
//		System.out.println(likelistMapper.selectAllLikelist());
//		log.info("likelist 입력 :{}",likelistMapper.selectAllLikelist());
//	}
//	@Order(4)
//	@Test
//	@DisplayName("라이크딜리트")
//	void deleteLikelist() {
//		likelistMapper.deleteLikelist("a01");
//		System.out.println(likelistMapper.selectAllLikelist());
//		log.info("likelist 삭제 :{}",likelistMapper.selectAllLikelist());
//	}
	
}
