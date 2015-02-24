DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `parent` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 測試資料
INSERT INTO `category` (`id`, `name`, `parent`)
VALUES
	(1,'商業理財',0),
	(2,'電腦資訊',0),
	(3,'藝術設計',0),
	(4,'文學小說',0),
	(5,'投資理財',1),
	(6,'管理領導',1),
	(7,'經濟趨勢',1),
	(8,'程式設計',2),
	(9,'軟體工程',2),
	(10,'影像編修',2),
	(11,'繪畫',3),
	(12,'攝影',3),
	(13,'音樂',3),
	(14,'羅曼史',4),
	(15,'懸疑推理',4),
	(16,'科幻奇幻',4),
	(17,'生活風格',0),
	(18,'居家生活',17),
	(19,'旅遊',17),
	(20,'飲食',17);
