CREATE TABLE `users_comments` (
                                  `comments_id` bigint NOT NULL,
                                  `user_id` bigint NOT NULL,
                                  UNIQUE KEY `UK_8a9ff54pt2w205r0hlcbe8mm6` (`comments_id`),
                                  KEY `FKlpp3854cd31i91y1pc26727p6` (`user_id`),
                                  CONSTRAINT `FK3b83nq9ncocq7tb4e90dyqmqg` FOREIGN KEY (`comments_id`) REFERENCES `comments` (`id`),
                                  CONSTRAINT `FKlpp3854cd31i91y1pc26727p6` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
