package imported;

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
import java.nio.file.Files;
import java.util.Scanner;

/**
 * Created by anartzmugika on 7/12/16.
 */
public class ImportXMLToSQL {
    String fileName = "strings.xml";
    public static void main(String[] args) throws IOException {
        //new ImportXMLToSQL().readFileResources();


        new ImportXMLToSQL().readFileResources();

    }

    private File getFile()
    {
        // Getting ClassLoader obj
        ClassLoader classLoader = getClass().getClassLoader();
        // Getting resource(File) from class loader
        return new File(classLoader.getResource(fileName).getFile());
    }

    private void readFileResources()
    {
        DocumentBuilderFactory docFactory= DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder= null;
        try {
            docBuilder = docFactory.newDocumentBuilder();
            Document doc=docBuilder.parse(getFile());


            NodeList strings= doc.getElementsByTagName("string");
            System.out.println(strings.getLength());
            System.out.println("***************************************");
            for(int i = 0; i < strings.getLength(); i++)
            {
                  Node nodeErosle= strings.item(i);
                //Erosle bakoitzaren informazioa eman ahal izateko luzeraren arabera
                Element erosleElementua = (Element)nodeErosle;
                //Elementuaren id atributua hartu eta bistaratuko du
                System.out.println("name: "+erosleElementua.getAttribute("name"));
                System.out.println("Text"+ erosleElementua.getTextContent());
                System.out.println("***************************************");
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
