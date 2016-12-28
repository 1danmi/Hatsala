package a1221.org.il.hatsalaquestionaire.entities;

/**
 * Created by Arele-PC on 12/27/2016.
 */

public class QuestionTranslation {

    String ID;
   public String HebrewQ;
   public String Title;
   public String Transformat;
   public String TranslatedQ;

    public QuestionTranslation(String id, String title, String he, String lanQ, String hebQ) {
        ID= id;
        HebrewQ = hebQ;
        Title = title;
        TranslatedQ = lanQ;
        Transformat = he;
    }
}
