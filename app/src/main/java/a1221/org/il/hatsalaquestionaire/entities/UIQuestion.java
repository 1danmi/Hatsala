package a1221.org.il.hatsalaquestionaire.entities;

import java.util.List;

/**
 * Created by Daniel on 12/29/2016.
 */

public class UIQuestion {

    private int _ID;

    private String title;

    private String qHebrew;

    private String qTranslation;

    private boolean isScale;

    private List<UIAnswer> uiAnswers;

    public UIQuestion() {
    }

    public UIQuestion(int _ID,String title, String qHebrew, String qTranslation, boolean isScale, List<UIAnswer> uiAnswers) {
        this._ID = _ID;
        this.title = title;
        this.qHebrew = qHebrew;
        this.qTranslation = qTranslation;
        this.isScale = isScale;
        this.uiAnswers = uiAnswers;
    }

    public int get_ID() {
        return _ID;
    }

    public void set_ID(int _ID) {
        this._ID = _ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getqHebrew() {
        return qHebrew;
    }

    public void setqHebrew(String qHebrew) {
        this.qHebrew = qHebrew;
    }

    public String getqTranslation() {
        return qTranslation;
    }

    public void setqTranslation(String qTranslation) {
        this.qTranslation = qTranslation;
    }

    public boolean isScale() {
        return isScale;
    }

    public void setScale(boolean scale) {
        isScale = scale;
    }

    public List<UIAnswer> getUiAnswers() {
        return uiAnswers;
    }

    public void setUiAnswers(List<UIAnswer> uiAnswers) {
        this.uiAnswers = uiAnswers;
    }
}
