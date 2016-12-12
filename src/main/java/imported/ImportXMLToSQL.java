package imported;

import model.Translation;
import utils.ManageFile;

import java.util.ArrayList;

/***********************************************************************************************************************
 * Created by anartzmugika on 7/12/16.
 **********************************************************************************************************************/
public class ImportXMLToSQL {
    private ArrayList<Translation> translations;
    public void readFileResources(String fileName, boolean add_data_in_db)
    {
        translations = new ArrayList<Translation>();
        String select_language = "en";
        if(add_data_in_db) //Add
        {
            ManageFile manageFile = new ManageFile();
            manageFile.readXMLFile(manageFile.getFile(fileName), translations, select_language);
        }

    }
}
