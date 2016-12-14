package values;

/*******************************************************************
 * Created by anartzmugika on 8/12/16.
 ******************************************************************/
public class ConstantValues {

    //DB
    public static final String DEFAULT_DB_PATH = "db/translations.odb";
    //SQL
    public static final String ALL_TRANSLATIONS = "SELECT t FROM Translation t";
    public static final String COUNT_TRANSLATIONS_REGISTERS = "SELECT COUNT(p) FROM Translation p";
    public static final String GET_ALL_TRANSLATIONS_INFO_BY_ORDER_WITH_ID = "SELECT FROM Translation ORDER BY id";

    public static final String GET_INFO_IN_SELECT_LANGUAGE = "SELECT p FROM Translation p WHERE text_%s != null";

    //SQL Import/Export constants
    public static final String CREATE_DATABASE = "CREATE DATABASE IF NOT EXISTS %s DEFAULT CHARACTER SET utf8 " +
                                                                    "  DEFAULT COLLATE utf8_general_ci;";

    public static final String CREATE_TRANSLATION_TABLE = "CREATE TABLE IF NOT EXISTS `translations` (\n" +
            "  `id` int(11) NOT NULL,\n" +
            "  `name` varchar(100) NOT NULL,\n" +
            "  `text_eu` text,\n" +
            "  `text_en` text,\n" +
            "  `text_es` text,\n" +
            "  `text_ca` text,\n" +
            "  `text_ga` text,\n" +
            "  `text_pt` text,\n" +
            "  `text_it` text,\n" +
            "  `app_id` varchar(200) NOT NULL,\n" +
            "  PRIMARY KEY (`name`,`app_id`),\n" +
            "  KEY `app_id` (`app_id`)\n" +
            ") ENGINE=InnoDB DEFAULT CHARSET=utf8;";

    public static final String CREATE_APP_TO_TRANSLATE = "CREATE TABLE IF NOT EXISTS `app` (\n" +
                                                                            "  `id` varchar(200) NOT NULL,\n" +
                                                                            "  `name` varchar(200) NOT NULL,\n" +
                                                                            "  `description` text NOT NULL,\n" +
                                                                            "  `first_published` date NOT NULL,\n" +
                                                                            "  `last_update` date NOT NULL,\n" +
                                                                            "  `original_language` varchar(20) NOT NULL,\n" +
                                                                            "  PRIMARY KEY (`id`)\n" +
                                                                            ") ENGINE=InnoDB DEFAULT CHARSET=utf8;";

    public static final String CREATE_APP_TRANSLATION_RELATION = "ALTER TABLE `translations`\n" +
            "  ADD CONSTRAINT `translations_ibfk_1` FOREIGN KEY (`app_id`) REFERENCES `app` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;";

    public static final String ADD_APP_INFO_IF_NOT_EXISTS = "INSERT IGNORE INTO `app` (`id`, `name`, `description`, `first_published`, `last_update`, `original_language`)" +
            "VALUES ('%s', '%s', '%s', '%s', '%s', '%s');";

    public static final String ADD_TRANSLATION_IF_NOT_EXISTS = "INSERT IGNORE INTO `translations` (`id`, `name`, `text_eu`, `text_en`, `text_es`, `text_ca`, `text_ga`, `text_pt`, `text_it`, `app_id`)" +
                                                                "VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s');";
    //Messages
    public static final String DELETE_ROWS_MSG = "%d registers delete!!!";
}
