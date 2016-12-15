package utils;

import model.Translation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/***********************************************************************************************************************
 * Created by anartzmugika on 12/12/16.
 *
 * Class to manage xml files and extract data to import Object DB or SQL file
 ***********************************************************************************************************************/
public class ManageFile {

    public File getFile(String fileName)
    {
        // Getting ClassLoader obj
        ClassLoader classLoader = getClass().getClassLoader();
        // Getting resource(File) from class loader
        return new File(classLoader.getResource(fileName).getFile());
    }

    public ArrayList<Translation> readXMLFile(File file, ArrayList<Translation> translations, String select_language)
    {
        DocumentBuilderFactory docFactory= DocumentBuilderFactory.newInstance();
        docFactory.setIgnoringElementContentWhitespace(true);
        DocumentBuilder docBuilder;
        try {
            docBuilder = docFactory.newDocumentBuilder();
            Document doc=docBuilder.parse(file);


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


                translations.add(new Translation(name, text, select_language));
            }

            NodeList strings_array= doc.getElementsByTagName("string-array");
            System.out.println(strings_array.getLength());
            for(int j = 0; j < strings_array.getLength(); j++)
            {
                NodeList items_inside_string_array = strings_array.item(j).getChildNodes();
                for (int n = 0; n < items_inside_string_array.getLength(); n++)
                {
                    Node node = items_inside_string_array.item(n);
                    System.out.println(node.getTextContent().trim().replaceAll("\\s+",""));
                }
                System.out.println(items_inside_string_array.getLength() + strings_array.item(j).getChildNodes().toString());


                //translations.add(new Translation(name, text, select_language));
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return translations;
    }


}
