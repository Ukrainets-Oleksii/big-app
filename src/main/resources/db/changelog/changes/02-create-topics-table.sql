CREATE TABLE `topics` (
                          `id` bigint NOT NULL AUTO_INCREMENT,
                          `owner_id` bigint DEFAULT NULL,
                          `content` varchar(255) DEFAULT NULL,
                          PRIMARY KEY (`id`),
                          KEY `FK37blcsb67llwnbp6n09wkaiej` (`owner_id`),
                          CONSTRAINT `FK37blcsb67llwnbp6n09wkaiej` FOREIGN KEY (`owner_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
