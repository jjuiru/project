데이터 코드

비밀번호 기입시 https://bcrypt-generator.com/ 에서 round10으로 암호화


insert members values(0, now(), null, null, null, '이메일', 1,null, 0, 0, 'id', '이름', 'pw', '전화번호','ROLE');
insert professors values(0, now(), null, null, null, '임용일', 학부ID, 교직원번호, 직위id(미구현 = null), member_id);
insert students values(0, now(), null, null, null, '2024-03-11', 1, null, 'NEWLY_ADMITTED', 'STUDENT202419', 1, 9);

insert into criteria_common values('dc01','학과공통기준');
insert into criteria_common values('rc01','과목성적등급기준');

insert into criteria_detail values('dc0101','모든 학과 공통','졸업요구학점', 130, null, null, null, null, 'dc01');

insert into criteria_detail values('rc0101','95초과 100이하 / GPA 4.3 / 수료가능','A', 95, 100, 4.3, 'Y', null, 'rc01');
insert into criteria_detail values('rc0102','92초과 95이하 / GPA 4.0 / 수료가능','A0', 92, 95, 4.0, 'Y', null, 'rc01');
insert into criteria_detail values('rc0103','89초과 92이하 / GPA 3.7 / 수료가능','A-', 89, 92, 3.7, 'Y', null, 'rc01');
insert into criteria_detail values('rc0104','85초과 89이하 / GPA 3.3 / 수료가능','B+', 85, 89, 3.3, 'Y', null, 'rc01');
insert into criteria_detail values('rc0105','82초과 85이하 / GPA 3.0 / 수료가능','B0', 82, 85, 3.0, 'Y', null, 'rc01');
insert into criteria_detail values('rc0106','79초과 82이하 / GPA 2.7 / 수료가능','B-', 79, 82, 2.7, 'Y', null, 'rc01');
insert into criteria_detail values('rc0107','75초과 79이하 / GPA 2.3 / 수료불가','C+', 75, 79, 2.3, 'N', null, 'rc01');
insert into criteria_detail values('rc0108','72초과 75이하 / GPA 2.0 / 수료불가','C0', 72, 75, 2.0, 'N', null, 'rc01');
insert into criteria_detail values('rc0109','70초과 72이하 / GPA 1.7 / 수료불가','C-', 70, 72, 1.7, 'N', null, 'rc01');
insert into criteria_detail values('rc01010','0이상 70미만 / GPA 0 / 수료불가','F', 0, 70, 0, 'N', null, 'rc01');
insert into criteria_detail values('rc0111','패스','Satisfied', null, null, null, null, null, 'rc01');
insert into criteria_detail values('rc0112','논패스','Unsatisfied', null, null, null, null, null, 'rc01');


insert into department values(0,'여기는 컴공과','컴퓨터공학과',130);


insert into subject values(0,'파이썬을 공부해보자','파이썬 기초', 10, 1, 3,'전공선택','2024-04-12 00:00:00','2024-05-12 23:59:59','2024-05-13 00:00:00','2024-06-05 23:59:59',3);


insert into video values
(0,'파이썬 기초 강의', 541,'파이썬 기초 강의 [1강.파이썬 시작하기]', 'UMfCZMuZoRk');
(0,'파이썬 기초 강의', 1094,'파이썬 기초 강의 [2강.파이썬 기초 문법]', 'sS3NQrnfGzQ');
(0,'파이썬 기초 강의', 1800,'파이썬 기초 강의 [3강. 자료형]', 'WRhCvVooCUo');
(0,'파이썬 기초 강의', 1621,'파이썬 기초 강의 [4강. 숫자 다루기]', '6XInJD_ZBc0');
(0,'파이썬 기초 강의', 1708,'파이썬 기초 강의 [5강. 문자열 다루기]', '2oxlrjGw5vE');
(0,'파이썬 기초 강의', 696,'파이썬 기초 강의 [6강. if문]', 'B8DRdil2N88');
(0,'파이썬 기초 강의', 642,'파이썬 기초 강의 [7강. while문]', '-HpnldGdgbY');
(0,'파이썬 기초 강의', 700,'파이썬 기초 강의 [8강. for문]', 'WMVzz4XKy9c');
(0,'파이썬 기초 강의', 334,'파이썬 기초 강의 [9강. 기타 제어문]', 'clb38RLVSDk');
(0,'파이썬 기초 강의', 574,'파이썬 기초 강의 [10강. 제어문 중첩]', 'wvLLHPhCMVM');

insert into session values
                        (0, '2024-04-21 23:59:59', '2024-04-15 00:00:00',  1, '파이썬 시작하기', 4, 1),
                        (0, '2024-04-28 23:59:59', '2024-04-22 00:00:00',  2, '파이썬 기초 문법', 4, 2 ),
                        (0, '2024-05-05 23:59:59', '2024-04-29 00:00:00', 3, '자료형', 4, 3),
                        (0, '2024-05-12 23:59:59', '2024-05-06 00:00:00', 4, '숫자 다루기', 4, 4),
                        (0, '2024-05-19 23:59:59', '2024-05-13 00:00:00', 5, '문자열 다루기', 4, 5),
                        (0, '2024-05-26 23:59:59', '2024-05-20 00:00:00', 6, 'if문', 4, 7),
                        (0, '2024-06-02 23:59:59', '2024-05-27 00:00:00', 7, 'while문', 4, 8),
                        (0, '2024-06-09 23:59:59', '2024-06-03 00:00:00', 8, 'for문', 4, 9),
                        (0, '2024-06-16 23:59:59', '2024-06-10 00:00:00', 9, '기타 제어문', 4, 10),
                        (0, '2024-06-23 23:59:59', '2024-06-17 00:00:00', 10, '제어문 중첩', 4, 11);

insert into asgn (asgn_ddate, asgn_desc, sub_id, asgn_sdate, asgn_title) values('2024-05-05', 'Hello Python을 출력 세가지 방법으로 작성해보세요',2,'2024-04-08','Hello Python 출력하기');
insert into asgn (asgn_ddate, asgn_desc, sub_id, asgn_sdate, asgn_title) values('2024-05-06', '구구단을 출력하는 코드를 세가지 방법으로 작성해보세요',2,'2024-06-02','구구단 출력하기');
insert into asgn (asgn_ddate, asgn_desc, sub_id, asgn_sdate, asgn_title) values('2024-06-03', '생년월일을 입력받아 나이를 계산하는 코드를 작성해보세요',2,'2024-06-30','나이 계산기');
insert into asgn (asgn_ddate, asgn_desc, sub_id, asgn_sdate, asgn_title) values('2024-07-08', '영화 제목 10개를 리스트에 추가하고 출력해보세요',4,'2024-07-01','리스트 활용');





