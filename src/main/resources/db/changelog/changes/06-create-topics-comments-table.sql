CREATE TABLE `topics_comments` (
                                   `comments_id` bigint NOT NULL,
                                   `topic_id` bigint NOT NULL,
                                   UNIQUE KEY `UK_d2cbr2caer8s8abi34vk2xqsq` (`comments_id`),
                                   KEY `FKh60x4q0n4h4msd0ose25v9idw` (`topic_id`),
                                   CONSTRAINT `FKh60x4q0n4h4msd0ose25v9idw` FOREIGN KEY (`topic_id`) REFERENCES `topics` (`id`),
                                   CONSTRAINT `FKk6wv6bon1m5wkjmkkp4muteya` FOREIGN KEY (`comments_id`) REFERENCES `comments` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
