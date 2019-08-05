-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema nonbucketlistdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `nonbucketlistdb` ;

-- -----------------------------------------------------
-- Schema nonbucketlistdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `nonbucketlistdb` DEFAULT CHARACTER SET utf8 ;
USE `nonbucketlistdb` ;

-- -----------------------------------------------------
-- Table `bucket`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bucket` ;

CREATE TABLE IF NOT EXISTS `bucket` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `activity` VARCHAR(1000) NULL,
  `description` VARCHAR(1000) NULL,
  `level_hate` INT ZEROFILL NULL,
  `active` TINYINT NULL DEFAULT 0,
  `how_happened` VARCHAR(2000) NULL,
  `how_experience` VARCHAR(2000) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS nonbucketlist@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'nonbucketlist'@'localhost' IDENTIFIED BY 'smatle';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'nonbucketlist'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `bucket`
-- -----------------------------------------------------
START TRANSACTION;
USE `nonbucketlistdb`;
INSERT INTO `bucket` (`id`, `activity`, `description`, `level_hate`, `active`, `how_happened`, `how_experience`) VALUES (1, 'Mow the lawn', 'Never want to have to push, ride or anything with mowing the lawn.', 3, 1, 'Bought a house and my wife was out of town and I had to mow.', 'Still incredibally never want to mow ever agian.');
INSERT INTO `bucket` (`id`, `activity`, `description`, `level_hate`, `active`, `how_happened`, `how_experience`) VALUES (2, 'Wrestle a Bear', 'Dont want to because i might die', 5, 0, NULL, NULL);
INSERT INTO `bucket` (`id`, `activity`, `description`, `level_hate`, `active`, `how_happened`, `how_experience`) VALUES (3, 'Skydiving', 'Have a fear of falling', 2, 1, 'Wedding gift from a friend for our wedding and could not say no.', 'After letting go of fact that I was falling it was amazing.');
INSERT INTO `bucket` (`id`, `activity`, `description`, `level_hate`, `active`, `how_happened`, `how_experience`) VALUES (4, 'Hang Gliding', 'Seems dumn to jump off a cliff with nothing to safe you.', 4, 0, NULL, NULL);
INSERT INTO `bucket` (`id`, `activity`, `description`, `level_hate`, `active`, `how_happened`, `how_experience`) VALUES (5, 'Surfing', 'Scared to get drowned by a wave not letting me up.', 2, 0, NULL, NULL);
INSERT INTO `bucket` (`id`, `activity`, `description`, `level_hate`, `active`, `how_happened`, `how_experience`) VALUES (6, 'Climbing a 14\'er', 'Extremely dislike the idea of walkin up a mountain, bought a jeep for a reason.', 5, 0, NULL, NULL);
INSERT INTO `bucket` (`id`, `activity`, `description`, `level_hate`, `active`, `how_happened`, `how_experience`) VALUES (7, 'Bungy Jumping', 'I mean really what if the bungy broke.', 4, 0, NULL, NULL);
INSERT INTO `bucket` (`id`, `activity`, `description`, `level_hate`, `active`, `how_happened`, `how_experience`) VALUES (8, 'Having Cavity', 'I have pride in having nice clean teeth so I nver want a cavity.', 1, 1, 'Was in the military.', 'Horrible!!! Brush your teeth!');
INSERT INTO `bucket` (`id`, `activity`, `description`, `level_hate`, `active`, `how_happened`, `how_experience`) VALUES (9, 'Breaking a Bone', 'To claustrophobic to have any body part constrained for any amount of time.', 5, 0, NULL, NULL);
INSERT INTO `bucket` (`id`, `activity`, `description`, `level_hate`, `active`, `how_happened`, `how_experience`) VALUES (10, 'Swimming with Sharks', 'Dont even want to do it in a cage neve4r', 4, 0, NULL, NULL);

COMMIT;

