-- phpMyAdmin SQL Dump
-- version 3.3.9
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Sep 08, 2011 at 04:07 PM
-- Server version: 5.5.8
-- PHP Version: 5.3.5

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `callcenter`
--

-- --------------------------------------------------------

--
-- Table structure for table `software`
--

CREATE TABLE IF NOT EXISTS `software` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` text,
  `pictureHard` longblob,
  `price` double DEFAULT NULL,
  `productName` varchar(80) DEFAULT NULL,
  `serialNumber` varchar(15) DEFAULT NULL,
  `version` varchar(10) DEFAULT NULL,
  `picture` blob,
  `lastModifiedDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `software`
--

INSERT INTO `software` (`id`, `description`, `pictureHard`, `price`, `productName`, `serialNumber`, `version`, `picture`, `lastModifiedDate`) VALUES
(1, 'In cooperation with SpringPublisher we will organize giveaway for users of our site. All you need is to comment this article (it would be nice if you would fb share it, tweet or something like that) and leave a valid email and we will get back to you.\r\n\r\nSpringPublisher allows you to create flyers, business cards, letterheads, postcards. This is professional and easy to use software that can be used by both designers and regular users that wish to create some interesting design and print cards, postcards, announcements and more.\r\n\r\nWhile other software products of this type are very expensive SpringPublisher is freeware. You can design, print and save your work as JPG file at no cost.\r\n\r\nSpringPublisher includes a nice library of templates as well as an online template store. The software features a powerful multi-layer editor, detailed help files. Without being an artist, you can design and print business cards, flyers, postcards, letterheads and other artwork in just a few minutes.', NULL, 305.95, 'SpringPublisher Giveaway', '16599', '2.1', NULL, NULL),
(2, 'BDlot DVD ISO Master will create ISO image from any DVD that you have in your collection. This way your data will be secure from damage and lose. All you favorite images, videos, movies, music will be saved to your HDD as ISO and you wont have to worry about backup. With this freeware software you can save your DVD’s as ISO or burn ISO files to DVD. With clean and user friendly interface you can easily operate BDlot DVD ISO Master and create backups fast.\r\n\r\nBDlot DVD ISO Master is able to remove all DVD copy protections including Region Code, CSS, CPRM, CPPM, APS, UOPs, ARccOS, Rip-Guard, and Disney X protection. So you can use it to backup any homemade, commercial and encrypted DVDs.', NULL, 250, 'BDlot DVD ISO Master', '12458', '1.2', NULL, NULL),
(3, 'Avast! Free Antivirus is one of the best free antivirus solutions that you can get. There are many antivirus software products and it is important to chose the best one, Avast experience in this field is a good recommendation for their products. This antivirus will protect you from various malware that will try to steal your valuable information. You can download Avast! Free Antivirus from our site for free and use it for non commercial & home use.', NULL, 600, 'Avast! Free Antivirus', '11125', '1.6', NULL, NULL),
(4, 'XnView can read more that 400 various file formats that can be viewed, converted and browsed with this software. All major formats are supported like, PNG, JPG, JPEG, MPEG, AVI, Quicktime, GIF, TARGA, MOV, WMV, and many others. With integrated image viewer you can browse all your directories and you can check it’s content.\r\n\r\nFile viewer is similar to Explorer so you will not have any trouble to adjust.\r\n\r\nXnView supports red eye correction, crops and transforms JPEG images losslessly, generates HTML pages and contact sheets, and provides Batch conversion and batch renaming. Slide shows with transitions effects, screen capturing, WIA & TWAIN support (scanner & digital cameras), image comparison, file operations.', NULL, 640.3, 'XnView', '15283', '3.6', NULL, NULL),
(5, 'rueCrypt will automatically add data to the encrypted drive so you do not have to go through complicated procedures every time you need something encrypted. There is no need for user action to crypt or decrypt files, it is done automatically before load or save of the file. Also this software allows you to easily and fast establish new encrypted drive. Encrypted data can be read only with password or encryption key, same goes when you want to add more data to encrypted volume.\r\n\r\nUntil decrypted, a TrueCrypt volume appears to be nothing more than a series of random numbers. The entire file system is encrypted (i.e., file names, folder names, contents of every file, and free space).', NULL, 999.99, 'TrueCrypt', '2569', '7.1', NULL, NULL);
