CREATE DATABASE IF NOT EXISTS translations_texts DEFAULT CHARACTER SET utf8   DEFAULT COLLATE utf8_general_ci;
USE `translations_texts`;

CREATE TABLE IF NOT EXISTS `translations` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `text_eu` text,
  `text_en` text,
  `text_es` text,
  `text_ca` text,
  `text_ga` text,
  `text_pt` text,
  `text_it` text,
  `app_id` varchar(200) NOT NULL,
  PRIMARY KEY (`name`,`app_id`),
  KEY `app_id` (`app_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `app` (
  `id` varchar(200) NOT NULL,
  `name` varchar(200) NOT NULL,
  `description` text NOT NULL,
  `first_published` date NOT NULL,
  `last_update` date NOT NULL,
  `original_language` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE `translations`
  ADD CONSTRAINT `translations_ibfk_1` FOREIGN KEY (`app_id`) REFERENCES `app` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

INSERT IGNORE INTO `app` (`id`, `name`, `description`, `first_published`, `last_update`, `original_language`)VALUES ('com.amugika.servirace', 'Servirace', '', '2014-09-02', '2016-04-06', 'en');

INSERT IGNORE INTO `translations` (`id`, `name`, `text_eu`, `text_en`, `text_es`, `text_ca`, `text_ga`, `text_pt`, `text_it`, `app_id`)VALUES ('1', 'app_name', '', 'Manage Images and Upload', '', '', '', '', '', 'com.amugika.servirace');
INSERT IGNORE INTO `translations` (`id`, `name`, `text_eu`, `text_en`, `text_es`, `text_ca`, `text_ga`, `text_pt`, `text_it`, `app_id`)VALUES ('2', 'action_settings', '', 'Settings', '', '', '', '', '', 'com.amugika.servirace');
INSERT IGNORE INTO `translations` (`id`, `name`, `text_eu`, `text_en`, `text_es`, `text_ca`, `text_ga`, `text_pt`, `text_it`, `app_id`)VALUES ('3', 'title_select_option_image', '', 'Select image from device or take photo', '', '', '', '', '', 'com.amugika.servirace');
INSERT IGNORE INTO `translations` (`id`, `name`, `text_eu`, `text_en`, `text_es`, `text_ca`, `text_ga`, `text_pt`, `text_it`, `app_id`)VALUES ('4', 'camera_label', '', 'Photo Camera', '', '', '', '', '', 'com.amugika.servirace');
INSERT IGNORE INTO `translations` (`id`, `name`, `text_eu`, `text_en`, `text_es`, `text_ca`, `text_ga`, `text_pt`, `text_it`, `app_id`)VALUES ('5', 'device_label', '', 'Device Images', '', '', '', '', '', 'com.amugika.servirace');
INSERT IGNORE INTO `translations` (`id`, `name`, `text_eu`, `text_en`, `text_es`, `text_ca`, `text_ga`, `text_pt`, `text_it`, `app_id`)VALUES ('6', 'send_label', '', 'Save', '', '', '', '', '', 'com.amugika.servirace');
INSERT IGNORE INTO `translations` (`id`, `name`, `text_eu`, `text_en`, `text_es`, `text_ca`, `text_ga`, `text_pt`, `text_it`, `app_id`)VALUES ('7', 'send_to_server_label', '', 'Synchronize', '', '', '', '', '', 'com.amugika.servirace');
INSERT IGNORE INTO `translations` (`id`, `name`, `text_eu`, `text_en`, `text_es`, `text_ca`, `text_ga`, `text_pt`, `text_it`, `app_id`)VALUES ('8', 'cancel_label', '', 'Cancel', '', '', '', '', '', 'com.amugika.servirace');
INSERT IGNORE INTO `translations` (`id`, `name`, `text_eu`, `text_en`, `text_es`, `text_ca`, `text_ga`, `text_pt`, `text_it`, `app_id`)VALUES ('9', 'upload_photo', '', 'Upload image', '', '', '', '', '', 'com.amugika.servirace');
INSERT IGNORE INTO `translations` (`id`, `name`, `text_eu`, `text_en`, `text_es`, `text_ca`, `text_ga`, `text_pt`, `text_it`, `app_id`)VALUES ('10', 'download_data_progress', '', 'Send data…', '', '', '', '', '', 'com.amugika.servirace');
INSERT IGNORE INTO `translations` (`id`, `name`, `text_eu`, `text_en`, `text_es`, `text_ca`, `text_ga`, `text_pt`, `text_it`, `app_id`)VALUES ('11', 'download_image_data_progress', '', 'Send image…', '', '', '', '', '', 'com.amugika.servirace');
INSERT IGNORE INTO `translations` (`id`, `name`, `text_eu`, `text_en`, `text_es`, `text_ca`, `text_ga`, `text_pt`, `text_it`, `app_id`)VALUES ('12', 'image_no_take_correctly', '', 'Not take correct image, please try again.', '', '', '', '', '', 'com.amugika.servirace');
INSERT IGNORE INTO `translations` (`id`, `name`, `text_eu`, `text_en`, `text_es`, `text_ca`, `text_ga`, `text_pt`, `text_it`, `app_id`)VALUES ('13', 'image_upload_successfully', '', 'Image upload sucess. Thank you!', '', '', '', '', '', 'com.amugika.servirace');
INSERT IGNORE INTO `translations` (`id`, `name`, `text_eu`, `text_en`, `text_es`, `text_ca`, `text_ga`, `text_pt`, `text_it`, `app_id`)VALUES ('14', 'image_upload_no_correct', '', 'Image NOT upload sucess. Please try again.', '', '', '', '', '', 'com.amugika.servirace');
INSERT IGNORE INTO `translations` (`id`, `name`, `text_eu`, `text_en`, `text_es`, `text_ca`, `text_ga`, `text_pt`, `text_it`, `app_id`)VALUES ('15', 'no_granted_access', '', 'Not available permission.', '', '', '', '', '', 'com.amugika.servirace');
INSERT IGNORE INTO `translations` (`id`, `name`, `text_eu`, `text_en`, `text_es`, `text_ca`, `text_ga`, `text_pt`, `text_it`, `app_id`)VALUES ('16', 'data_correct_send', '', 'Data send sucessfully!!', '', '', '', '', '', 'com.amugika.servirace');
INSERT IGNORE INTO `translations` (`id`, `name`, `text_eu`, `text_en`, `text_es`, `text_ca`, `text_ga`, `text_pt`, `text_it`, `app_id`)VALUES ('17', 'data_no_correct_send', '', 'Data NOT send sucessfully, please try again.', '', '', '', '', '', 'com.amugika.servirace');
INSERT IGNORE INTO `translations` (`id`, `name`, `text_eu`, `text_en`, `text_es`, `text_ca`, `text_ga`, `text_pt`, `text_it`, `app_id`)VALUES ('18', 'show_in_map_text', '', 'In Map', '', '', '', '', '', 'com.amugika.servirace');
INSERT IGNORE INTO `translations` (`id`, `name`, `text_eu`, `text_en`, `text_es`, `text_ca`, `text_ga`, `text_pt`, `text_it`, `app_id`)VALUES ('19', 'title_activity_main', '', 'MainActivity', '', '', '', '', '', 'com.amugika.servirace');
INSERT IGNORE INTO `translations` (`id`, `name`, `text_eu`, `text_en`, `text_es`, `text_ca`, `text_ga`, `text_pt`, `text_it`, `app_id`)VALUES ('20', 'make_your_language_selection', '', 'Selecciona el idioma deseado', '', '', '', '', '', 'com.amugika.servirace');
INSERT IGNORE INTO `translations` (`id`, `name`, `text_eu`, `text_en`, `text_es`, `text_ca`, `text_ga`, `text_pt`, `text_it`, `app_id`)VALUES ('21', 'spanish', '', 'Castellano', '', '', '', '', '', 'com.amugika.servirace');
INSERT IGNORE INTO `translations` (`id`, `name`, `text_eu`, `text_en`, `text_es`, `text_ca`, `text_ga`, `text_pt`, `text_it`, `app_id`)VALUES ('22', 'catalan', '', 'Catalán', '', '', '', '', '', 'com.amugika.servirace');
INSERT IGNORE INTO `translations` (`id`, `name`, `text_eu`, `text_en`, `text_es`, `text_ca`, `text_ga`, `text_pt`, `text_it`, `app_id`)VALUES ('23', 'deutchand', '', 'Alemán', '', '', '', '', '', 'com.amugika.servirace');
INSERT IGNORE INTO `translations` (`id`, `name`, `text_eu`, `text_en`, `text_es`, `text_ca`, `text_ga`, `text_pt`, `text_it`, `app_id`)VALUES ('24', 'english', '', 'Inglés', '', '', '', '', '', 'com.amugika.servirace');
INSERT IGNORE INTO `translations` (`id`, `name`, `text_eu`, `text_en`, `text_es`, `text_ca`, `text_ga`, `text_pt`, `text_it`, `app_id`)VALUES ('25', 'basque', '', 'Euskera', '', '', '', '', '', 'com.amugika.servirace');
INSERT IGNORE INTO `translations` (`id`, `name`, `text_eu`, `text_en`, `text_es`, `text_ca`, `text_ga`, `text_pt`, `text_it`, `app_id`)VALUES ('26', 'francais', '', 'Francés', '', '', '', '', '', 'com.amugika.servirace');
INSERT IGNORE INTO `translations` (`id`, `name`, `text_eu`, `text_en`, `text_es`, `text_ca`, `text_ga`, `text_pt`, `text_it`, `app_id`)VALUES ('27', 'galizian', '', 'Gallego', '', '', '', '', '', 'com.amugika.servirace');
INSERT IGNORE INTO `translations` (`id`, `name`, `text_eu`, `text_en`, `text_es`, `text_ca`, `text_ga`, `text_pt`, `text_it`, `app_id`)VALUES ('28', 'italian', '', 'Italiano', '', '', '', '', '', 'com.amugika.servirace');
INSERT IGNORE INTO `translations` (`id`, `name`, `text_eu`, `text_en`, `text_es`, `text_ca`, `text_ga`, `text_pt`, `text_it`, `app_id`)VALUES ('29', 'reference_to_other_string', '@string/app_name', '@string/app_name', '@string/app_name', '@string/app_name', '@string/app_name', '@string/app_name', '@string/app_name', 'com.amugika.servirace');
INSERT IGNORE INTO `translations` (`id`, `name`, `text_eu`, `text_en`, `text_es`, `text_ca`, `text_ga`, `text_pt`, `text_it`, `app_id`)VALUES ('30', 'language_string_@string/catalan', '@string/catalan', '@string/catalan', '@string/catalan', '@string/catalan', '@string/catalan', '@string/catalan', '@string/catalan', 'com.amugika.servirace');
INSERT IGNORE INTO `translations` (`id`, `name`, `text_eu`, `text_en`, `text_es`, `text_ca`, `text_ga`, `text_pt`, `text_it`, `app_id`)VALUES ('31', 'language_string_@string/basque', '@string/basque', '@string/basque', '@string/basque', '@string/basque', '@string/basque', '@string/basque', '@string/basque', 'com.amugika.servirace');
INSERT IGNORE INTO `translations` (`id`, `name`, `text_eu`, `text_en`, `text_es`, `text_ca`, `text_ga`, `text_pt`, `text_it`, `app_id`)VALUES ('32', 'language_string_@string/spanish', '@string/spanish', '@string/spanish', '@string/spanish', '@string/spanish', '@string/spanish', '@string/spanish', '@string/spanish', 'com.amugika.servirace');
INSERT IGNORE INTO `translations` (`id`, `name`, `text_eu`, `text_en`, `text_es`, `text_ca`, `text_ga`, `text_pt`, `text_it`, `app_id`)VALUES ('33', 'language_codes_ca', '', 'ca', '', '', '', '', '', 'com.amugika.servirace');
INSERT IGNORE INTO `translations` (`id`, `name`, `text_eu`, `text_en`, `text_es`, `text_ca`, `text_ga`, `text_pt`, `text_it`, `app_id`)VALUES ('34', 'language_codes_eu', '', 'eu', '', '', '', '', '', 'com.amugika.servirace');
INSERT IGNORE INTO `translations` (`id`, `name`, `text_eu`, `text_en`, `text_es`, `text_ca`, `text_ga`, `text_pt`, `text_it`, `app_id`)VALUES ('35', 'language_codes_es', '', 'es', '', '', '', '', '', 'com.amugika.servirace');
INSERT IGNORE INTO `translations` (`id`, `name`, `text_eu`, `text_en`, `text_es`, `text_ca`, `text_ga`, `text_pt`, `text_it`, `app_id`)VALUES ('36', 'language_codes_en', '', 'en', '', '', '', '', '', 'com.amugika.servirace');
INSERT IGNORE INTO `translations` (`id`, `name`, `text_eu`, `text_en`, `text_es`, `text_ca`, `text_ga`, `text_pt`, `text_it`, `app_id`)VALUES ('37', 'language_codes_gl', '', 'gl', '', '', '', '', '', 'com.amugika.servirace');
INSERT IGNORE INTO `translations` (`id`, `name`, `text_eu`, `text_en`, `text_es`, `text_ca`, `text_ga`, `text_pt`, `text_it`, `app_id`)VALUES ('38', 'language_codes_de', '', 'de', '', '', '', '', '', 'com.amugika.servirace');
INSERT IGNORE INTO `translations` (`id`, `name`, `text_eu`, `text_en`, `text_es`, `text_ca`, `text_ga`, `text_pt`, `text_it`, `app_id`)VALUES ('39', 'language_codes_fr', '', 'fr', '', '', '', '', '', 'com.amugika.servirace');
INSERT IGNORE INTO `translations` (`id`, `name`, `text_eu`, `text_en`, `text_es`, `text_ca`, `text_ga`, `text_pt`, `text_it`, `app_id`)VALUES ('40', 'language_codes_it', '', 'it', '', '', '', '', '', 'com.amugika.servirace');
