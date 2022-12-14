ALTER TABLE `users`
CHANGE COLUMN `user_name` `user_name` VARCHAR(255) NOT NULL ,
CHANGE COLUMN `full_name` `full_name` VARCHAR(255) NOT NULL ,
CHANGE COLUMN `password` `password` VARCHAR(255) NOT NULL ;
