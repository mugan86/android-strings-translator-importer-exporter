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
    public static final String CREATE_DATABASE = "CREATE DATABASE %s;";
    public static final String CREATE_TRANSLATION_TABLE = "CREATE TABLE Translation ( name PRIMARY KEY, text TEXT);";


    //Messages
    public static final String DELETE_ROWS_MSG = "%d registers delete!!!";
}
