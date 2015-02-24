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

-- 測試資料
INSERT INTO `product` (`id`, `category`, `name`, `price`, `reserve`, `off`, `imageUrl`)
VALUES
	(1,8,'無瑕的程式碼：敏捷軟體開發技巧守則',580,30,79,'http://localhost:8080/resources/image/1.jpeg'),
	(2,8,'改變世界的九大演算法：讓今日電腦無所不能的最強概念',360,30,79,NULL),
	(3,8,'無瑕的程式碼 番外篇：專業程式設計師的生存之道',360,25,70,'http://localhost:8080/resources/image/3.jpeg');
