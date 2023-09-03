DROP SCHEMA IF EXISTS `codeverseuni`;

CREATE SCHEMA `codeverseuni`;

USE `codeverseuni`;

SET FOREIGN_KEY_CHECKS = 0;

CREATE TABLE `instructor_detail`(
	`id` int PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `salary` DECIMAL(10, 2)
);

CREATE TABLE `instructor`(
	`id` int PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `first_name` varchar(45),
	`last_name` varchar(45),
	`email` varchar(45),
     `instructor_detail_id` int ,
     CONSTRAINT `instructor_detail_fk` FOREIGN KEY(`instructor_detail_id`) REFERENCES `instructor_detail` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE `course`(
	`id` int PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `title` varchar(128),
	`instructor_id` int ,
    UNIQUE KEY `title_unique` (`title`),
	CONSTRAINT `instructor_fk` FOREIGN KEY(`instructor_id`) REFERENCES `instructor` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
);

CREATE TABLE `review`(
	`id` int PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `comment` varchar(256),
	`course_id` int ,
	CONSTRAINT `course_fk` FOREIGN KEY(`course_id`) REFERENCES `course` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE `student`(
	`id` int PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `first_name` varchar(45),
	`last_name` varchar(45),
	`email` varchar(45)
);

CREATE TABLE `course_student`(
	`course_id` int NOT NULL,
    `student_id` int NOT NULL,
    CONSTRAINT `course_student_pk` PRIMARY KEY(`course_id`, `student_id`),
	CONSTRAINT `course_student_course_fk` FOREIGN KEY(`course_id`) REFERENCES `course` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT `course_student_student_fk` FOREIGN KEY(`student_id`) REFERENCES `student` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE `_user`(    
    `id` INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    `first_name` VARCHAR(255),
    `last_name` VARCHAR(255),
    `password` VARCHAR(255),
    `email` VARCHAR(255),
    `role` ENUM('USER', 'ADMIN') NOT NULL,
    `enabled` BOOLEAN DEFAULT TRUE,
    `account_non_expired` BOOLEAN DEFAULT TRUE,
    `account_non_locked` BOOLEAN DEFAULT TRUE,
    `credentials_non_expired` BOOLEAN DEFAULT TRUE,
    UNIQUE KEY `email_unique` (`email`)
);

SET FOREIGN_KEY_CHECKS = 1;