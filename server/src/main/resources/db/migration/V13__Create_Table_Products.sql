CREATE TABLE IF NOT EXISTS `products` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `name` varchar(100) NOT NULL,
    `description` varchar(100) NOT NULL,
    `purchase_price` DECIMAL(65,2)  NOT NULL,
    `selling_price` DECIMAL(65,2)  NOT NULL,
    `quantity` INT NOT NULL DEFAULT 0,
    `enabled` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
);