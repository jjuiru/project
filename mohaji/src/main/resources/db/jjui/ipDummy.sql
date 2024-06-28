CREATE TABLE `member_ip` (
                             `mip_id` int NOT NULL AUTO_INCREMENT,
                             `mip_ip` varchar(255) NOT NULL,
                             `mip_name` varchar(255) NOT NULL,
                             `member_id` int DEFAULT NULL,
                             PRIMARY KEY (`mip_id`),
                             UNIQUE KEY `UK_7l7vfpa3k34ta9voia080pj8l` (`mip_ip`),
                             KEY `FKe3u2jytx5roqsfetdexwur6nb` (`member_id`),
                             CONSTRAINT `FKe3u2jytx5roqsfetdexwur6nb` FOREIGN KEY (`member_id`) REFERENCES `members` (`member_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

INSERT INTO member_ip (member_id, mip_ip, mip_name)
VALUES
    (1, '192.168.1.1', 'PC1'),
    (1, '192.168.1.2', 'PC2'),
    (2, '192.169.1.2', 'PC1')