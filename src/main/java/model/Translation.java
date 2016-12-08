package models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/******************************************************
 * Created by anartzmugika on 8/12/16.
 *****************************************************/
public class Translation implements Serializable {

    @Id @GeneratedValue
    private String name;

    private String text_eu;
    private String text_en;
    private String text_es;
    private String text_ca;
    private String text_ga;
    private String text_pt;
    private String text_it;
    private String select_language;

    public Translation(String name, String text, String select_language)
    {
        setName(name);
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
        return text_eu;
    }

    public void setText_eu(String text_eu) {
        this.text_eu = text_eu;
    }

    public String getText_en() {
        return text_en;
    }

    public void setText_en(String text_en) {
        this.text_en = text_en;
    }

    public String getText_es() {
        return text_es;
    }

    public void setText_es(String text_es) {
        this.text_es = text_es;
    }

    public String getText_ca() {
        return text_ca;
    }

    public void setText_ca(String text_ca) {
        this.text_ca = text_ca;
    }

    public String getText_ga() {
        return text_ga;
    }

    public void setText_ga(String text_ga) {
        this.text_ga = text_ga;
    }

    public String getText_pt() {
        return text_pt;
    }

    public void setText_pt(String text_pt) {
        this.text_pt = text_pt;
    }

    public String getText_it() {
        return text_it;
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

    private void setTextInSelectLanguage(String text)
    {
        if (select_language.equals("eu")) this.setText_eu(text);
        if (select_language.equals("en")) this.setText_en(text);
        if (select_language.equals("es")) this.setText_es(text);
        if (select_language.equals("ca")) this.setText_ca(text);
        if (select_language.equals("ga")) this.setText_ga(text);
        if (select_language.equals("pt")) this.setText_pt(text);
        if (select_language.equals("it")) this.setText_it(text);
    }
}
