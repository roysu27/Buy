DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `category` int(11) NOT NULL,
  `name` varchar(50) NOT NULL DEFAULT '',
  `price` int(11) DEFAULT '0',
  `reserve` int(11) DEFAULT '0',
  `off` int(11) DEFAULT '100',
  `imageUrl` varchar(50) DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;