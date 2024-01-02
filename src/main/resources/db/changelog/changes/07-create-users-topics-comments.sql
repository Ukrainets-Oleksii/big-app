CREATE TABLE `users_topics` (
                                `topics_id` bigint NOT NULL,
                                `user_id` bigint NOT NULL,
                                UNIQUE KEY `UK_lfk2urhcbac0p61ynleswyyon` (`topics_id`),
                                KEY `FKfb7stlmwc1ple1kkx4sn7y7uo` (`user_id`),
                                CONSTRAINT `FKeucnheo87qy2s60q2g65e4p2` FOREIGN KEY (`topics_id`) REFERENCES `topics` (`id`),
                                CONSTRAINT `FKfb7stlmwc1ple1kkx4sn7y7uo` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
