package a1221.org.il.hatsalaquestionaire.Entities;

/**
 * Created by Arele-PC on 12/27/2016.
 */

public class Question {

    String ID;
   public String HebrewQ;
   public String Title;
   public String Transformat;
   public String TranslatedQ;

    public Question(String id, String title, String he, String lanQ, String hebQ) {
        ID= id;
        HebrewQ = hebQ;
        Title = title;
        TranslatedQ = lanQ;
        Transformat = he;
    }
}
