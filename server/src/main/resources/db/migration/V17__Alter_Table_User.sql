ALTER TABLE `users`
ADD COLUMN `permissao` VARCHAR(45) NULL DEFAULT '1' AFTER `enabled`;

