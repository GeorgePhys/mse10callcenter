 -- Always Delete Before Insert Thats THE LAW
DELETE FROM `Holder` WHERE `Holder`.`code` in (1,2,3,4,5,6,7,8);
 -- Complete list of Holders
INSERT INTO `Holder` (`id`, `lastModifiedDate`, `code`, `descriptionBg`, `descriptionEn`) VALUES 
(NULL, '2011-07-08 09:08:32', '1', 'Държави', 'Countries'),
(NULL, '2011-07-08 09:08:32', '2', 'Общини', 'Municipalities'),
(NULL, '2011-07-08 09:08:32', '3', 'Градове', 'Cities'),
(NULL, '2011-07-08 09:08:32', '4', 'Привилегии', 'Privileges'),
(NULL, '2011-07-08 09:08:32', '5', 'Тип на потребителите', 'Type of users'),
(NULL, '2011-07-08 09:08:32', '6', 'Статус на потребители/фирми', 'Status of users / companies'),
(NULL, '2011-07-08 09:08:32', '7', 'Статуси на поръчка', 'Status of order');
(NULL, '2011-07-08 09:08:32', '8', 'Тип на продукта', 'Type of product');