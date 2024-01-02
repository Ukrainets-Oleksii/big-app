CREATE TABLE `replies` (
                           `head_comment_id` bigint DEFAULT NULL,
                           `id` bigint NOT NULL AUTO_INCREMENT,
                           `content` varchar(255) DEFAULT NULL,
                           PRIMARY KEY (`id`),
                           KEY `FK9uts4gkfoqkq3qhk4vwsxnjo7` (`head_comment_id`),
                           CONSTRAINT `FK9uts4gkfoqkq3qhk4vwsxnjo7` FOREIGN KEY (`head_comment_id`) REFERENCES `comments` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
