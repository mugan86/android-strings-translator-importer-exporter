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
    public static final String CREATE_DATABASE = "CREATE DATABASE %s DEFAULT CHARACTER SET utf8 " +
                                                                    "  DEFAULT COLLATE utf8_general_ci;";
    public static final String CREATE_TRANSLATION_TABLE = "CREATE TABLE IF NOT EXISTS translations ( name VARCHAR(100) PRIMARY KEY, text_eu TEXT,  text_en TEXT, text_es TEXT, text_ca TEXT,  text_ga TEXT, text_pt TEXT, text_it TEXT);";

    public static final String ADD_TRANSLATION_IF_NOT_EXISTS = "INSERT IGNORE INTO `translations` (`id`, `name`, `text_eu`, `text_en`, `text_es`, `text_ca`, `text_ga`, `text_pt`, `text_it`)" +
                                                                "VALUES (NULL, '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s');";
    //Messages
    public static final String DELETE_ROWS_MSG = "%d registers delete!!!";
}
