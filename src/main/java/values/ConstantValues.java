package values;

/**
 * Created by anartzmugika on 8/12/16.
 */
public class ConstantValues {

    //DB
    public static final String DEFAULT_DB_PATH = "db/translations.odb";
    //SQL
    public static final String ALL_TRANSLATIONS = "SELECT t FROM Translation t";
    public static final String COUNT_TRANSLATIONS_REGISTERS = "SELECT COUNT(p) FROM Translation p";


    //Messages
    public static final String DELETE_ROWS_MSG = "%d registers delete!!!";
}
