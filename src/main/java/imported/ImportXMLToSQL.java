package imported;

import model.Translation;
import utils.ManageFile;

import java.util.ArrayList;

/***********************************************************************************************************************
 * Created by anartzmugika on 7/12/16.
 **********************************************************************************************************************/
public class ImportXMLToSQL {
    private ArrayList<Translation> translations;
    public void readFileResources(String fileName)
    {
        String select_language = "en";
        ManageFile manageFile = new ManageFile();
        translations = manageFile.readXMLFile(manageFile.getFile(fileName), translations, select_language);

    }
}
