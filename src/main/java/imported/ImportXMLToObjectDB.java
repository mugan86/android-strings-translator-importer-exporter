package imported;

import db.DBManage;
import model.Translation;
import utils.ManageFile;
import values.ConstantValues;

import java.util.ArrayList;

/***********************************************************************************************************************
 * Created by anartzmugika on 7/12/16.
 **********************************************************************************************************************/
public class ImportXMLToObjectDB {
    private ArrayList<Translation> translations;
    public void readFileResources(String fileName, boolean add_data_in_db)
    {
        translations = new ArrayList<Translation>();

        DBManage info_manage = new DBManage(ConstantValues.DEFAULT_DB_PATH);
        info_manage.setUselanguage(fileName);

        if(add_data_in_db) //Add
        {
            ManageFile manageFile = new ManageFile();
            manageFile.readXMLFile(manageFile.getFile(fileName), translations, info_manage.getSelect_language());
            info_manage.addTranslationsInSelectLanguage(translations);
        }

        info_manage.showAllTranslationsRegisters();
        info_manage.closeDataBase();
    }
}
