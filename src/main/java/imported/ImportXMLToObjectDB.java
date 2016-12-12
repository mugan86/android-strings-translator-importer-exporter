package imported;

import db.DBManage;
import model.Translation;
import values.ConstantValues;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/***********************************************************************************************************************
 * Created by anartzmugika on 7/12/16.
 **********************************************************************************************************************/
public class ImportXMLToObjectDB {
    private ArrayList<Translation> translations;
    private DBManage info_manage;
    public static void main(String[] args) throws IOException {

        String fileName = "en/strings.xml";
        //new ImportXMLToObjectDB().readFileResources();
        new ImportXMLToObjectDB().readFileResources(fileName, false);

    }

    private File getFile(String fileName)
    {
        // Getting ClassLoader obj
        ClassLoader classLoader = getClass().getClassLoader();
        // Getting resource(File) from class loader
        return new File(classLoader.getResource(fileName).getFile());
    }

    private void readFileResources(String fileName, boolean add_data_in_db)
    {
        translations = new ArrayList<Translation>();

        DBManage info_manage = new DBManage(ConstantValues.DEFAULT_DB_PATH);
        //info_manage.getRegisterCount();
        info_manage.setUselanguage(fileName);

        if(add_data_in_db) //Add
        {
            new Translation().readXMLFile(getFile(fileName), translations, info_manage.getSelect_language());
            info_manage.addTranslationsInSelectLanguage(translations);
        }

        info_manage.showAllTranslationsRegisters();
        info_manage.closeDataBase();
    }

}
