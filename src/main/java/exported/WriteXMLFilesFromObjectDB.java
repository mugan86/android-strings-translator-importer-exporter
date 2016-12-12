package exported;

import com.sun.org.apache.xml.internal.serializer.OutputPropertiesFactory;
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
import java.util.List;

/***********************************************************************************************************************
 * Created by anartzmugika on 9/12/16.
 **********************************************************************************************************************/
public class WriteXMLFilesFromObjectDB {

    //Test with files
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


        DBManage dbManage = new DBManage(ConstantValues.DEFAULT_DB_PATH);
        String default_language = "en";

        //Add all languages to available
        String [] languages = new String[] { "es", "ca", "eu", "pt", "it", "ga", "en"};

        //Loop in all languages
        for (int i = 0; i < languages.length; i++)
        {
            //If default language not select and pass next language
            if (default_language.equals(languages[i]) && i == languages.length-1) return;
            if (default_language.equals(languages[i])) i++;

            //Select current language to generate strings file
            String select_lang = languages[i];
            System.out.println(dbManage.getTranslations(select_lang).size());

            List<Translation> translations = dbManage.getTranslations(select_lang);

            if (translations.size() > 0)
            {
                String directory_to_create = String.format("values-%s", select_lang );
                System.out.println("Directory create: " + directory_to_create);
                File theDir = new File(directory_to_create);

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

                /*
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
                }*/
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
                        Element string_element = doc.createElement("string");

                        rootElement.appendChild(string_element);

                        // set attribute to string element
                        Attr attr = doc.createAttribute("name");
                        attr.setValue(translation.getName());
                        string_element.setTextContent(translation.getCurrentSelectTextTranslation());
                        string_element.setAttributeNode(attr);

                    }


                    // write the content into xml file
                    TransformerFactory transformerFactory = TransformerFactory.newInstance();

                    Transformer transformer = transformerFactory.newTransformer();
                    transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
                    transformer.setOutputProperty(OutputKeys.INDENT, "yes"); //Add indent to show pretty
                    transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes"); //Not show header declaration
                    transformer.setOutputProperty(OutputPropertiesFactory.S_KEY_INDENT_AMOUNT, "2"); //Indent xml elements

                    DOMSource source = new DOMSource(doc);

                    StreamResult result = new StreamResult(new File(String.format("values-%s/strings.xml", select_lang )));

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
                System.out.println("NOT VALUES to add in strings!!!");
            }
        }

    }
}
