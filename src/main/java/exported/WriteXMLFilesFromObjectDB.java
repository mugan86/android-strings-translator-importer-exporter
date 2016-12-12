package exported;

import db.DBManage;
import model.Translation;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import values.ConstantValues;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

/********************************************
 * Created by anartzmugika on 9/12/16.
 */
public class WriteXMLFilesFromObjectDB {

    public void Test()
    {
        //ClassLoader classLoader = getClass().getClassLoader();
        try
        {
            String path = "src/main/res/string.xml";
            File file = new File("src/main/resources/string.xml");

            System.out.println(file.getAbsolutePath());

            // returns true if the file exists
            boolean bool = file.exists();

            // if file exists
            if(bool)
            {
                // get absolute path
                path = file.getAbsolutePath();

                // prints
                System.out.print("Absolute Pathname "+ path);
            }
            else
            {
                System.out.println("Not exist-------");
                file.createNewFile(); // if file already exists will do nothing
                FileOutputStream oFile = new FileOutputStream(file, false);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }



    }
    public static void main(String argv[]) {
        File f = null;
        String path = "";
        boolean bool = false;
        //new WriteXMLFilesFromObjectDB().Test();

        //TODO add default language code

        String default_language = "en";
        DBManage dbManage = new DBManage(ConstantValues.DEFAULT_DB_PATH);


        String [] languages = new String[] {"es", "ca", "eu", "pt", "it", "ga"};

        for (int i = 0; i < languages.length; i++)
        {
            String select_lang = languages[i];
            System.out.println(dbManage.getTranslations(select_lang).size());

            List<Translation> translations = dbManage.getTranslations(select_lang);

            if (translations.size() > 0)
            {
                File theDir = new File(String.format("values-%s", select_lang ));

                // if the directory does not exist, create it
                if (!theDir.exists()) {
                    System.out.println("creating directory: " + "values");
                    boolean result = false;

                    try{
                        theDir.mkdir();
                        result = true;
                    }
                    catch(SecurityException se){
                        //handle it
                    }
                    if(result) {
                        System.out.println("DIR created");
                    }
                }

                try{
                    // create new files
                    f = new File(String.format("values-%s", select_lang ));

                    // returns true if the file exists
                    bool = f.exists();

                    // if file exists
                    if(bool)
                    {
                        // get absolute path
                        path = f.getAbsolutePath();

                        // prints
                        System.out.print("Absolute Pathname "+ path);
                    }
                    else
                    {
                        System.out.println("Not exist");
                        f.createNewFile(); // if file already exists will do nothing
                        FileOutputStream oFile = new FileOutputStream(f, false);
                    }
                }catch(Exception e){
                    // if any error occurs
                    e.printStackTrace();
                }
                try {

                    DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
                    DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

                    // root elements
                    Document doc = docBuilder.newDocument();
                    Element rootElement = doc.createElement("resources");
                    doc.appendChild(rootElement);

                    for (int item = 0; item < translations.size(); item++)
                    {
                        Translation translation = translations.get(item);
                        translation.setSelect_language(select_lang);
                        // staff elements
                        Element staff = doc.createElement("string");
                        rootElement.appendChild(staff);

                        //TODO create dinamically strings elements values to add in strings files depending select language
                        // set attribute to staff element
                        Attr attr = doc.createAttribute("name");
                        attr.setValue(translation.getName());
                        staff.setTextContent(translation.getCurrentSelectTextTranslation());
                        staff.setAttributeNode(attr);

                    }

                    // write the content into xml file
                    TransformerFactory transformerFactory = TransformerFactory.newInstance();
                    Transformer transformer = transformerFactory.newTransformer();
                    transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
                    transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                    DOMSource source = new DOMSource(doc);

                    //TODO add correct path
                    StreamResult result = new StreamResult(new File(String.format("values-%s/strings.xml", select_lang )));

                    // Output to console for testing
                    // StreamResult result = new StreamResult(System.out);

                    transformer.transform(source, result);

                    System.out.println("File saved!");

                } catch (ParserConfigurationException pce) {
                    pce.printStackTrace();
                } catch (TransformerException tfe) {
                    tfe.printStackTrace();
                }
            }
            else
            {
                System.out.println("NOT VALUES!!!");
            }
        }

    }
}
