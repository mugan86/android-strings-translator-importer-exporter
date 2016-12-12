import imported.ImportXMLToObjectDB;

/***********************************************************************************************************************
 * Created by anartzmugika on 12/12/16.
 * --------------------------------------
 * Test main to import xml (strings.xml) from resources to make operation (read only or read and add in database data)
 ***********************************************************************************************************************/
public class TestToImportXMLToObjectDB {
    public static void main(String[] args)
    {
        String fileName = "en/strings.xml";
        //new ImportXMLToObjectDB().readFileResources();
        new ImportXMLToObjectDB().readFileResources(fileName, false);
    }
}
