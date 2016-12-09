package exported;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by anartzmugika on 9/12/16.
 */
public class WriteXMLFilesFromObjectDB {

    public void Test()
    {
        ClassLoader classLoader = getClass().getClassLoader();
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
new WriteXMLFilesFromObjectDB().Test();
        File theDir = new File("values");

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
            f = new File("values/strings.xml");

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
            Element rootElement = doc.createElement("company");
            doc.appendChild(rootElement);

            // staff elements
            Element staff = doc.createElement("Staff");
            rootElement.appendChild(staff);

            // set attribute to staff element
            Attr attr = doc.createAttribute("id");
            attr.setValue("1");
            staff.setAttributeNode(attr);

            // shorten way
            // staff.setAttribute("id", "1");

            // firstname elements
            Element firstname = doc.createElement("firstname");
            firstname.appendChild(doc.createTextNode("yong"));
            staff.appendChild(firstname);

            // lastname elements
            Element lastname = doc.createElement("lastname");
            lastname.appendChild(doc.createTextNode("mook kim"));
            staff.appendChild(lastname);

            // nickname elements
            Element nickname = doc.createElement("nickname");
            nickname.appendChild(doc.createTextNode("mkyong"));
            staff.appendChild(nickname);

            // salary elements
            Element salary = doc.createElement("salary");
            salary.appendChild(doc.createTextNode("100000"));
            staff.appendChild(salary);

            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("/my/file.xml"));

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
}
