package a1221.org.il.hatsalaquestionaire.entities;

/**
 * Created by Arele-PC on 12/27/2016.
 */
public class UIAnswer {

   public String hebrewanswer;
   public String translatedanswer;
   public String Languageformat;
   public String questionid;


   public UIAnswer(String id, String format, String ans1, String transans1) {
      questionid = id;
      hebrewanswer = ans1;
      translatedanswer = transans1;
      Languageformat = format;




   }

}
