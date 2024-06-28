CREATE TABLE `reg_course` (
                              `cc_id` varchar(30) DEFAULT NULL,
                              `rc_asgn_score` int DEFAULT NULL,
                              `rc_att_score` int DEFAULT NULL,
                              `rc_grade` varchar(255) NOT NULL DEFAULT 'default_value',
                              `rc_progress` decimal(4,1) DEFAULT '0.0',
                              `rc_stat` enum('Attending','Completed','Cancelled') NOT NULL,
                              `member_id` int NOT NULL,
                              `sub_id` int NOT NULL,
                              PRIMARY KEY (`member_id`,`sub_id`),
                              KEY `FKb8866vgsufmy4u1snxuqln67v` (`sub_id`),
                              CONSTRAINT `FKb8866vgsufmy4u1snxuqln67v` FOREIGN KEY (`sub_id`) REFERENCES `subject` (`sub_id`),
                              CONSTRAINT `reg_course_ibfk_1` FOREIGN KEY (`member_id`) REFERENCES `students` (`member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

INSERT INTO reg_course (member_id, sub_id, cc_id, rc_stat, rc_progress, rc_asgn_score, rc_att_score, rc_grade)
VALUES
    (1, 2, 'rc01', 'Attending', 0, NULL, NULL, 'none'),
    (2, 2, 'rc01', 'Completed', 0, 95, 100, 'A+'),

CREATE TABLE `reg_detail` (
                              `rd_id` int NOT NULL AUTO_INCREMENT,
                              `rd_adate` datetime(6) NOT NULL,
                              `rd_cdate` datetime(6) DEFAULT NULL,
                              `rd_creason` varchar(100) DEFAULT NULL,
                              `member_id` int DEFAULT NULL,
                              `sub_id` int DEFAULT NULL,
                              PRIMARY KEY (`rd_id`),
                              UNIQUE KEY `UK_oeu2144qmypwcij16fnbh4w5d` (`member_id`,`sub_id`),
                              CONSTRAINT `FKtm0v8e4vi3o35p90j4y4j72l9` FOREIGN KEY (`member_id`, `sub_id`) REFERENCES `reg_course` (`member_id`, `sub_id`),
                              CONSTRAINT `reg_detail_ibfk_1` FOREIGN KEY (`member_id`) REFERENCES `reg_course` (`member_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

INSERT INTO reg_detail (member_id, sub_id, rd_adate, rd_cdate, rd_creason)
VALUES
    (1, 2, '2024-05-15 10:00:00', NULL, NULL),
    (2, 2, '2024-05-17 12:00:00', NULL, NULL),


CREATE TABLE `reg_asgn` (
                            `ra_id` int NOT NULL AUTO_INCREMENT,
                            `attached_id` int DEFAULT NULL,
                            `ra_content` varchar(4000) DEFAULT NULL,
                            `ra_feedback` varchar(4000) DEFAULT NULL,
                            `ra_score` int NOT NULL DEFAULT '0',
                            `ra_sdate` datetime(6) NOT NULL,
                            `asgn_id` int DEFAULT NULL,
                            `member_id` int DEFAULT NULL,
                            `sub_id` int DEFAULT NULL,
                            PRIMARY KEY (`ra_id`),
                            KEY `FK8pbdmdoobll0w6g6feoavye38` (`asgn_id`),
                            KEY `member_id` (`member_id`),
                            KEY `fk_sub_member` (`sub_id`,`member_id`),
                            CONSTRAINT `FK8pbdmdoobll0w6g6feoavye38` FOREIGN KEY (`asgn_id`) REFERENCES `asgn` (`asgn_id`),
                            CONSTRAINT `fk_sub_member` FOREIGN KEY (`sub_id`, `member_id`) REFERENCES `reg_course` (`sub_id`, `member_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

INSERT INTO reg_asgn (asgn_id, student_id, attached_id, ra_sdate, ra_content, ra_score, ra_feedback)
VALUES
    (1, 1, 1, '2024-05-15 10:00:00', 'Hello Python 출력', 80, '잘하셨습니다'),
    (1, 2, 2, '2024-05-16 11:00:00', 'Hello Python 출력', 80, '잘하셨습니다'),

INSERT INTO reg_asgn values(0,null,"def greet(): print("Hello, Python!") greet()", "훌륭합니다",10, DATE_FORMAT(NOW(), '%y-%m-%d'),1,1,2);


CREATE TABLE `reg_session` (
                               `rs_final` int NOT NULL,
                               `rs_max` int NOT NULL,
                               `rs_progress` decimal(4,1) NOT NULL,
                               `member_id` int NOT NULL,
                               `sub_id` int NOT NULL,
                               `session_id` int DEFAULT NULL,
                               PRIMARY KEY (`member_id`,`sub_id`),
                               KEY `FKlfdkofg840k1xk588m5642bqd` (`session_id`),
                               CONSTRAINT `FK3uyk4msxx8uy028whttlxleq1` FOREIGN KEY (`member_id`, `sub_id`) REFERENCES `reg_course` (`member_id`, `sub_id`),
                               CONSTRAINT `FKlfdkofg840k1xk588m5642bqd` FOREIGN KEY (`session_id`) REFERENCES `session` (`session_id`),
                               CONSTRAINT `reg_session_ibfk_1` FOREIGN KEY (`member_id`) REFERENCES `reg_course` (`member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

INSERT INTO reg_session (sub_id, member_id, session_id, rs_progress, rs_max, rs_final)
VALUES
    (2, 1, 1, 25.5, 100, 90),
    (2, 2, 2, 50.0, 100, 95),