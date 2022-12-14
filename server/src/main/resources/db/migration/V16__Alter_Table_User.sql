ALTER TABLE `users`
CHANGE COLUMN `account_non_expired` `account_non_expired` BIT(1) NULL DEFAULT 1 ,
CHANGE COLUMN `account_non_locked` `account_non_locked` BIT(1) NULL DEFAULT 1 ,
CHANGE COLUMN `credentials_non_expired` `credentials_non_expired` BIT(1) NULL DEFAULT 1 ,
CHANGE COLUMN `enabled` `enabled` BIT(1) NULL DEFAULT 1 ;
