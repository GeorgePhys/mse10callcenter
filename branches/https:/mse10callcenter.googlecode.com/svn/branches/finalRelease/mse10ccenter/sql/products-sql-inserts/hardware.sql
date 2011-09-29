-- phpMyAdmin SQL Dump
-- version 3.3.9
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Sep 08, 2011 at 07:23 PM
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
-- Table structure for table `hardware`
--

CREATE TABLE IF NOT EXISTS `hardware` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` text,
  `manufacturer` varchar(50) DEFAULT NULL,
  `picture` longblob,
  `pictureSoft` longblob,
  `price` double DEFAULT NULL,
  `productName` varchar(80) DEFAULT NULL,
  `serialNumber` varchar(15) DEFAULT NULL,
  `warranty` int(11) DEFAULT NULL,
  `weight` double DEFAULT NULL,
  `lastModifiedDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `hardware`
--

INSERT INTO `hardware` (`id`, `description`, `manufacturer`, `picture`, `pictureSoft`, `price`, `productName`, `serialNumber`, `warranty`, `weight`, `lastModifiedDate`) VALUES
(1, 'The Z305 sports a slightly more unconventional design by being bar-shaped; the two speakers are situated on two ends of a square bar instead of being split. There are two reasons for this design. Firstly, it makes it rather portable (it even comes with a travel case). Secondly, with the implementation of a clip, you can fit the speakers at the top and over the notebook’s display. That gets the speakers out of the way so that things doesn’t clutter. The speakers also only require USB connectivity to work, which reduces the hassle. It’s a great idea, and it’s an idea that works.', 'Logitech', NULL, NULL, 325.9, 'Logitech Laptop Speakers Z305', '125585', 1, 0.45, NULL),
(2, 'You know that thing they say about how having two is better than one? Well, Acer certainly has the idea, because their brand new tablet – The Acer ICONIA-6120 actually has two screens. And these are two 14-inch multi-touch HD Widescreen CineCrystal LED-backlid LCDs display, which goes at 1366 x 768 resolutions, which is made with Tempered Gorilla Glass. Flipped open, the bottom screen can be turned into a multi-touch virtual keyboard. Aside from that, Acer has implemented a pretty darn cool Acer Ring control scheme. It’ll be running Windows 7, and powered by an Intel Core i5 processor, 4GB of RAM and a 640GB hard drive. This, in our opinion, is something bold. And well all know fortune favors the bold.', 'Acer', NULL, NULL, 1200, 'Acer ICONIA-6120 Tablet', '36555', 2, 2, NULL),
(3, 'Nikon recently announced the new 16.2 megapixel Nikon D5100 Digital SLR designed for those ready to artistically express themselves and who need a versatile camera that can keep pace creatively. The Nikon D5100 includes features designed to enhance shooting experience, including an impressive new 3-inch, super sharp 921,000 dot Vari-angle LCD screen and full HD (1080p) movie recording with full-time autofocus. The 16.2 megapixel D5100 is also the first Nikon DSLR to provide in-camera effects that can be applied to both photos and movies to deliver even more creative expression.', 'Nikon ', NULL, NULL, 950.99, 'Nikon D5100 DSLR Camera', '33956', 3, 0.6, NULL),
(4, 'Leading the fleet, the GT780DXR comes in a brushed aluminum chassis with 17.3-inches of Full HD Non Reflection display and SteelSeries programmable backlit keyboard.  In addition to its high performance NVIDIA© GeForce© GPU and Intel® Core™ i7 processor, the gaming workhorse is supported by 12 GB of DDR3 system memory and 1TB of hard disk with Raid 0 or no redundancy.  For gamers craving even more dominance, the unit can be amped up with Blu-ray burner, 1.5TB of hard disk and 16GB of DDR3 memory.', 'NVIDIA', NULL, NULL, 9080, 'NVIDIA Geforce GTX 570M Gaming Laptop ', '95664', 3, 3, NULL);
