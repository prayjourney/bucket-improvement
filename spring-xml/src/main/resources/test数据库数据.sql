-- 正在导出表  test.account 的数据：~2 rows (大约)
/*!40000 ALTER TABLE `account`
    DISABLE KEYS */;
INSERT INTO `account` (`id`, `name`, `balance`)
VALUES (1, '张三', 31900),
       (2, '李四', 17000);
/*!40000 ALTER TABLE `account`
    ENABLE KEYS */;

-- 正在导出表  test.book 的数据：~3 rows (大约)
/*!40000 ALTER TABLE `book`
    DISABLE KEYS */;
INSERT INTO `book` (`isbn`, `name`, `price`, `stock`)
VALUES (1, '雪山飞狐', 1000, 1),
       (2, 'Java编程思想', 1000, 4),
       (3, '面向对象编程', 50, 5);
/*!40000 ALTER TABLE `book`
    ENABLE KEYS */;

-- 正在导出表  test.employee 的数据：~12 rows (大约)
/*!40000 ALTER TABLE `employee`
    DISABLE KEYS */;
INSERT INTO `employee` (`id`, `name`, `age`, `salary`)
VALUES (1, '张飞', 35, 10000),
       (2, '刘备', 42, 50000),
       (3, '关羽', 39, 30000),
       (4, '赵云', 27, 12000),
       (5, '黄忠', 56, 20000),
       (6, '马超', 25, 17000),
       (8, '赵四', 38, 8000),
       (29, '马云', 52, 900000),
       (30, '马化腾', 49, 800000),
       (31, '李彦宏', 41, 300000),
       (32, '刘强东', 52, 400000),
       (33, '赵四', 38, 8000);

