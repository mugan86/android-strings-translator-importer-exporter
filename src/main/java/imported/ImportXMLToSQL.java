package imported;

import model.Translation;
import utils.ManageFile;
import values.ConstantValues;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/***********************************************************************************************************************
 * Created by anartzmugika on 7/12/16.
 **********************************************************************************************************************/
public class ImportXMLToSQL {
    private ArrayList<Translation> translations;
    public void readFileResources(String fileName)
    {
        translations = new ArrayList<Translation>();
        String select_language = "en";
        ManageFile manageFile = new ManageFile();
        translations = manageFile.readXMLFile(manageFile.getFile(fileName), translations, select_language);
        generateSQLInstructions(select_language);
    }

    private void generateSQLInstructions(String select_lang)
    {
        createDirectoryAndFile(select_lang);
    }

    private void createDirectoryAndFile(String select_lang)
    {
        String directory_to_create = String.format("translations-%s", select_lang );
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
        createFile(select_lang);
    }

    private void createFile(String select_lang)
    {
        BufferedWriter bfw;
        try
        {
            //Sartutakoa zer fitxategitan gordeko dan zehaztuko da "true" propeitatearekin
            //idaztean ez duela aurrekoa matxakatuko, hau da aurrekoak mantenduz sartutako
            //gehituko da
            bfw = new BufferedWriter(new FileWriter(String.format("translations-%s/translations.sql", select_lang ), false));
            bfw.write(String.format(ConstantValues.CREATE_DATABASE, "translations_texts"));
            bfw.newLine();
            bfw.newLine();
            bfw.write(ConstantValues.CREATE_TRANSLATION_TABLE);
            //bfw.write("{\"result\":[");
            for (int i = 0; i < translations.size (); i++)
            {
                Translation translation = translations.get(i);
                String insert = String.format(ConstantValues.ADD_TRANSLATION_IF_NOT_EXISTS,
                        translation.getName(), translation.getText_eu(), translation.getText_en(),
                        translation.getText_es(), translation.getText_ca(), translation.getText_ga(), translation.getText_pt(), translation.getText_it());

                bfw.newLine();
                bfw.write(insert);


            }
            bfw.newLine();


            //itxi fitxategiaren fluxua herria gorde ondoren
            bfw.close();
        }catch (IOException ioe)
        {
            System.out.println("IOException: "+ioe.getMessage().toString());
        }
    }
}
