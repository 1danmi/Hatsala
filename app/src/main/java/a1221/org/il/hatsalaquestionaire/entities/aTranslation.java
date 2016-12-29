package a1221.org.il.hatsalaquestionaire.entities;

import java.io.Serializable;

/**
 * Created by Daniel on 12/28/2016.
 */

public class ATranslation implements Serializable {

    private static final long serialVersionUID = 9L;

    private int _ID;

    private String text;

    private int l_ID;

    private int a_ID;

    public ATranslation(int _ID, String text, int l_ID, int a_ID) {
        this._ID = _ID;
        this.text = text;
        this.l_ID = l_ID;
        this.a_ID = a_ID;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int get_ID() {
        return _ID;
    }

    public void set_ID(int _ID) {
        this._ID = _ID;
    }

    public int getL_ID() {
        return l_ID;
    }

    public void setL_ID(int l_ID) {
        this.l_ID = l_ID;
    }

    public int getA_ID() {
        return a_ID;
    }

    public void setA_ID(int a_ID) {
        this.a_ID = a_ID;
    }
}
