CREATE TABLE `comments` (
                            `id` bigint NOT NULL AUTO_INCREMENT,
                            `owner_id` bigint DEFAULT NULL,
                            `topic_id` bigint DEFAULT NULL,
                            `content` varchar(255) DEFAULT NULL,
                            PRIMARY KEY (`id`),
                            KEY `FKf0q13afod1ucykdp6skx4900t` (`owner_id`),
                            KEY `FK14w686ma11o8fbvbnvb6ujxgy` (`topic_id`),
                            CONSTRAINT `FK14w686ma11o8fbvbnvb6ujxgy` FOREIGN KEY (`topic_id`) REFERENCES `topics` (`id`),
                            CONSTRAINT `FKf0q13afod1ucykdp6skx4900t` FOREIGN KEY (`owner_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
