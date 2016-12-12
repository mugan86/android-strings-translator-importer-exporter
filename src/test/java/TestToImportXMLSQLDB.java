import imported.ImportXMLToSQL;

/***********************************************************************************************************************
 * Created by anartzmugika on 12/12/16.
 * --------------------------------------
 * Test main to import xml (strings.xml) from resources to make operation (read only or read and add in database data)
 ***********************************************************************************************************************/
public class TestToImportXMLSQLDB {
    public static void main(String[] args)
    {
        String fileName = "en/strings.xml";
        //new ImportXMLToObjectDB().readFileResources();
        new ImportXMLToSQL().readFileResources(fileName, true);
    }
}
