CREATE TABLE `comments_replies` (
                                    `comment_id` bigint NOT NULL,
                                    `replies_id` bigint NOT NULL,
                                    UNIQUE KEY `UK_knd91c8871jix2ii13xkvyw54` (`replies_id`),
                                    KEY `FK5lsdr669plq10pl7lnp0o95xh` (`comment_id`),
                                    CONSTRAINT `FK5lsdr669plq10pl7lnp0o95xh` FOREIGN KEY (`comment_id`) REFERENCES `comments` (`id`),
                                    CONSTRAINT `FKokjba9sybs5n1x6cy01tj7onp` FOREIGN KEY (`replies_id`) REFERENCES `replies` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
