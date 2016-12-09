package imported;

import model.Translation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import db.DBManage;
import values.ConstantValues;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
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
        new ImportXMLToObjectDB().readFileResources(fileName);

    }

    private File getFile(String fileName)
    {
        // Getting ClassLoader obj
        ClassLoader classLoader = getClass().getClassLoader();

        // Getting resource(File) from class loader
        return new File(classLoader.getResource(fileName).getPath());
    }

    private void readFileResources(String fileName)
    {
        translations = new ArrayList<Translation>();

        DBManage info_manage = new DBManage(ConstantValues.DEFAULT_DB_PATH);
        //info_manage.getRegisterCount();
        info_manage.setUselanguage(fileName);

        /*DocumentBuilderFactory docFactory= DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder= null;
        try {
            docBuilder = docFactory.newDocumentBuilder();
            Document doc=docBuilder.parse(getFile(fileName));


            NodeList strings= doc.getElementsByTagName("string");
            System.out.println(strings.getLength());
            System.out.println("***************************************");
            for(int i = 0; i < strings.getLength(); i++)
            {
                Node node_str_element= strings.item(i);
                //Erosle bakoitzaren informazioa eman ahal izateko luzeraren arabera
                Element str_element = (Element)node_str_element;
                String name = str_element.getAttribute("name");
                String text = str_element.getTextContent();
                //Elementuaren id atributua hartu eta bistaratuko du
                System.out.println("name: "+ name);
                System.out.println("Text: "+ text);
                System.out.println("***************************************");


                translations.add(new Translation(name, text, info_manage.getSelect_language()));
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        //info_manage.addTranslationsInSelectLanguage(translations);
        info_manage.showAllTranslationsRegisters();
        info_manage.closeDataBase();
    }

}
