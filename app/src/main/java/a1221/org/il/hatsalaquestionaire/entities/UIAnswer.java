package a1221.org.il.hatsalaquestionaire.entities;

/**
 * Created by Daniel on 12/29/2016.
 */

public class UIAnswer {

    private String aHebrew;

    private String aTranslation;

    public UIAnswer(String aHebrew, String aTranslation) {
        this.aHebrew = aHebrew;
        this.aTranslation = aTranslation;
    }

    public String getaHebrew() {
        return aHebrew;
    }

    public void setaHebrew(String aHebrew) {
        this.aHebrew = aHebrew;
    }

    public String getaTranslation() {
        return aTranslation;
    }

    public void setaTranslation(String aTranslation) {
        this.aTranslation = aTranslation;
    }
}
