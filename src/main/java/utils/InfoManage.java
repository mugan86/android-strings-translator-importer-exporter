package utils;

import imported.Point;
import models.Translation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;

/***********************************************************************************************************************
 * Created by anartzmugika on 8/12/16.
 **********************************************************************************************************************/
public class InfoManage {

    private EntityManager entityManagerm;
    private EntityManagerFactory entityManageFactory;
    private String select_language;
    public InfoManage(String database_path)
    {
        openDataBase(database_path);
    }
    public void openDataBase(String database_path)
    {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("db/points.odb");
        EntityManager em = emf.createEntityManager();

        setEntityManageFactory(Persistence.createEntityManagerFactory(database_path));

        setEntityManagerm(getEntityManageFactory().createEntityManager());
    }

    public void getRegisterCount()
    {
        // Find the number of Point objects in the database:
        Query q1 = getEntityManagerm().createQuery("SELECT COUNT(p) FROM Translation p");
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
            getEntityManagerm().persist(translations.get(i));
        }
        getEntityManagerm().getTransaction().commit();
    }

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
}
