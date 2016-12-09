package db;

import model.Translation;
import values.ConstantValues;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/***********************************************************************************************************************
 * Created by anartzmugika on 8/12/16.
 **********************************************************************************************************************/
public class DBManage {

    private EntityManager entityManagerm;
    private EntityManagerFactory entityManageFactory;
    private String select_language;
    public DBManage(String database_path)
    {
        openDataBase(database_path);
    }
    public void openDataBase(String database_path)
    {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("db/translations.odb");
        EntityManager em = emf.createEntityManager();

        setEntityManageFactory(Persistence.createEntityManagerFactory(database_path));

        setEntityManagerm(getEntityManageFactory().createEntityManager());
    }

    public void getRegisterCount()
    {
        // Find the number of Point objects in the database:
        Query q1 = getEntityManagerm().createQuery(ConstantValues.COUNT_TRANSLATIONS_REGISTERS);
        System.out.println("Total Translations texts: " + q1.getSingleResult());
    }

    private void setEntityManageFactory(EntityManagerFactory entityManageFactory) {
        this.entityManageFactory = entityManageFactory;
    }

    private EntityManagerFactory getEntityManageFactory() {
        return this.entityManageFactory;
    }

    private void setEntityManagerm(EntityManager entityManagerm)
    {
        this.entityManagerm = entityManagerm;
    }

    private EntityManager getEntityManagerm()
    {
        return this.entityManagerm;
    }

    public void setUselanguage(String filepath)
    {
        this.select_language = filepath.substring(0,2);
    }

    public void addTranslationsInSelectLanguage(ArrayList<Translation> translations)
    {
        getEntityManagerm().getTransaction().begin();
        for (int i = 0; i < translations.size(); i++)
        {
            Translation translation = translations.get(i);
            Translation find_translation_object = findTranslationObject(translation.getName());
            if (find_translation_object == null) addTranslationObject(translation); //Object not exist, add new
            else //Object exist, update data in select object
            {
                find_translation_object.setSelect_language(translation.getSelect_language());
                find_translation_object.setTextInSelectLanguage(translation.getCurrentSelectTextTranslation());
                addTranslationObject(find_translation_object);
            }
        }
        getEntityManagerm().getTransaction().commit();
    }

    public void addTranslationObject(Translation translation)
    {
        getEntityManagerm().persist(translation);
    }

    /**********************************************************************
     *                  Show all translations
     **********************************************************************/
    public void showAllTranslationsRegisters()
    {
        //get all translations and print values:
        TypedQuery<Translation> query =
                    getEntityManagerm().createQuery(ConstantValues.ALL_TRANSLATIONS, Translation.class);
        List<Translation> results = query.getResultList();
        if(results.size()>0)
        {
            for (Translation p : results) {
                System.out.println(p);
            }
        }
        else
        {
            System.out.println("Database not contain register about translations!! Do you add correctly?");
        }

    }

    /**
     * Datu-baseko punturik altuena bueltatzen du metodo honek. Hau da, y koordenaturik txikiena daukana.
     *
     * @return datu-baseko punturik altuena
     */
    /*public Translation maximoa()
    {
        Query q1 = getEntityManagerm().createQuery("SELECT t FROM Point p");
        System.out.println("Min Y: " + q1.getSingleResult());

        TypedQuery<Point> query = em.createQuery(
                "SELECT p FROM Point p WHERE p.y = :altuena", Point.class);
        return query.setParameter("altuena", q1.getSingleResult()).getSingleResult();
    }
   */

    public String getSelect_language()
    {
        return this.select_language;
    }

    public void closeDataBase()
    {
        // Close the database connection:
        getEntityManagerm().close();
        getEntityManageFactory().close();
    }

    public Translation findTranslationObject(String name)
    {
        return getEntityManagerm().find(Translation.class, name);
    }
}
