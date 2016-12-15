package model;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

/******************************************************
 * Created by anartzmugika on 8/12/16.
 *****************************************************/
@Entity
public class Translation implements Serializable {

    @GeneratedValue
    long id;
    @Id
    private String name;

    private String text_eu;
    private String text_en;
    private String text_es;
    private String text_ca;
    private String text_ga;
    private String text_pt;
    private String text_it;
    private String select_language;

    public Translation(){}
    public Translation(String name, String text, String select_language)
    {
        setName(name);
        if (select_language.contains("_all"))
        {
            setText_eu(text);
            setText_ca(text);
            setText_es(text);
            setText_en(text);
            setText_ga(text);
            setText_it(text);
            setText_pt(text);
            select_language = select_language.replace("_all", "");
        }

        setSelect_language(select_language);
        setTextInSelectLanguage(text);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText_eu() {
        return getText(text_eu);
    }

    public void setText_eu(String text_eu) {
        this.text_eu = text_eu;
    }

    public String getText_en() {
        return getText(text_en);
    }

    public void setText_en(String text_en) {
        this.text_en = text_en;
    }

    public String getText_es() {
        return getText(text_es);
    }

    public void setText_es(String text_es) {
        this.text_es = text_es;
    }

    public String getText_ca() {
        return getText(text_ca);
    }

    public void setText_ca(String text_ca) {
        this.text_ca = text_ca;
    }

    public String getText_ga() {
        return getText(text_ga);
    }

    public void setText_ga(String text_ga) {
        this.text_ga = text_ga;
    }

    public String getText_pt() {
        return getText(text_pt);
    }

    public void setText_pt(String text_pt) {
        this.text_pt = text_pt;
    }

    public String getText_it() {
        return getText(text_it);
    }

    public void setText_it(String text_it) {
        this.text_it = text_it;
    }

    public String getSelect_language() {
        return select_language;
    }

    public void setSelect_language(String select_language) {
        this.select_language = select_language;
    }

    public void setTextInSelectLanguage(String text)
    {
        if (select_language.equals("eu")) this.setText_eu(text);
        if (select_language.equals("en")) this.setText_en(text);
        if (select_language.equals("es")) this.setText_es(text);
        if (select_language.equals("ca")) this.setText_ca(text);
        if (select_language.equals("ga")) this.setText_ga(text);
        if (select_language.equals("pt")) this.setText_pt(text);
        if (select_language.equals("it")) this.setText_it(text);
        System.out.println("Select language: " + this.select_language);
    }
    public String getCurrentSelectTextTranslation()
    {
        System.out.println("Select language (Translation): " + this.select_language);
        if (select_language.equals("eu")) return getText_eu();
        if (select_language.equals("en")) return getText_en();
        if (select_language.equals("es")) return getText_es();
        if (select_language.equals("ca")) return getText_ca();
        if (select_language.equals("ga")) return getText_ga();
        if (select_language.equals("pt")) return getText_pt();
        return getText_it();
    }

    private String getText(String text)
    {
        if (text != null) return text.replace("'", "\\'");
        return "";
    }

    @Override
    public String toString()
    {
        return this.getName() + ": " + this.getText_eu()  + " / " + this.getText_es() + " / " + this.getText_ca()+ " / Select Language: " + this.getSelect_language();
    }
}
