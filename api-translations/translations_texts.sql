-- phpMyAdmin SQL Dump
-- version 4.5.2
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 15-12-2016 a las 11:45:32
-- Versión del servidor: 10.1.13-MariaDB
-- Versión de PHP: 5.6.23

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `translations_texts`
--
CREATE DATABASE IF NOT EXISTS `translations_texts` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `translations_texts`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `app`
--

CREATE TABLE `app` (
  `id` varchar(200) NOT NULL,
  `name` varchar(200) NOT NULL,
  `description` text NOT NULL,
  `first_published` date NOT NULL,
  `last_update` date NOT NULL,
  `original_language` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `app`
--

INSERT IGNORE INTO `app` (`id`, `name`, `description`, `first_published`, `last_update`, `original_language`) VALUES
('com.amugika.servirace', 'Servirace', '', '2014-09-02', '2016-04-06', 'en'),
('com.anartz.korrikakonbertidorea', 'Run Calculator', '', '2013-03-15', '2014-11-23', 'es');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `translations`
--

CREATE TABLE `translations` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `text_eu` text,
  `text_en` text,
  `text_es` text,
  `text_ca` text,
  `text_ga` text,
  `text_pt` text,
  `text_it` text,
  `app_id` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `translations`
--

INSERT IGNORE INTO `translations` (`id`, `name`, `text_eu`, `text_en`, `text_es`, `text_ca`, `text_ga`, `text_pt`, `text_it`, `app_id`) VALUES
(2, 'action_settings', '', 'Settings', '', '', '', '', '', 'com.amugika.servirace'),
(1, 'app_name', '', 'Manage Images and Upload', '', '', '', '', '', 'com.amugika.servirace'),
(4, 'camera_label', '', 'Photo Camera', '', '', '', '', '', 'com.amugika.servirace'),
(8, 'cancel_label', '', 'Cancel', '', '', '', '', '', 'com.amugika.servirace'),
(16, 'data_correct_send', '', 'Data send sucessfully!!', '', '', '', '', '', 'com.amugika.servirace'),
(17, 'data_no_correct_send', '', 'Data NOT send sucessfully, please try again.', '', '', '', '', '', 'com.amugika.servirace'),
(5, 'device_label', '', 'Device Images', '', '', '', '', '', 'com.amugika.servirace'),
(10, 'download_data_progress', '', 'Send data…', '', '', '', '', '', 'com.amugika.servirace'),
(11, 'download_image_data_progress', '', 'Send image…', '', '', '', '', '', 'com.amugika.servirace'),
(12, 'image_no_take_correctly', '', 'Not take correct image, please try again.', '', '', '', '', '', 'com.amugika.servirace'),
(14, 'image_upload_no_correct', '', 'Image NOT upload sucess. Please try again.', '', '', '', '', '', 'com.amugika.servirace'),
(13, 'image_upload_successfully', '', 'Image upload sucess. Thank you!', '', '', '', '', '', 'com.amugika.servirace'),
(15, 'no_granted_access', '', 'Not available permission.', '', '', '', '', '', 'com.amugika.servirace'),
(6, 'send_label', '', 'Save', '', '', '', '', '', 'com.amugika.servirace'),
(7, 'send_To_server_label', '', 'Synchronize', '', '', '', '', '', 'com.amugika.servirace'),
(18, 'show_in_map_text', '', 'In Map', '', '', '', '', '', 'com.amugika.servirace'),
(19, 'title_activity_main', '', 'MainActivity', '', '', '', '', '', 'com.amugika.servirace'),
(3, 'title_select_option_image', '', 'Select image from device or take photo', '', '', '', '', '', 'com.amugika.servirace'),
(9, 'upload_photo', '', 'Upload image', '', '', '', '', '', 'com.amugika.servirace');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `app`
--
ALTER TABLE `app`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `translations`
--
ALTER TABLE `translations`
  ADD PRIMARY KEY (`name`,`app_id`),
  ADD KEY `app_id` (`app_id`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `translations`
--
ALTER TABLE `translations`
  ADD CONSTRAINT `translations_ibfk_1` FOREIGN KEY (`app_id`) REFERENCES `app` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
