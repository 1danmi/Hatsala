package a1221.org.il.hatsalaquestionaire.entities;

import java.io.Serializable;

/**
 * Created by Daniel on 12/28/2016.
 */

public class QTranslation implements Serializable {

    private static final long serialVersionUID = 4L;

    private int _ID;

    private String text;

    private int l_ID;

    private int q_ID;

    public QTranslation(int _ID, String text, int l_ID, int q_ID) {
        this._ID = _ID;
        this.text = text;
        this.l_ID = l_ID;
        this.q_ID = q_ID;
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

    public int getQ_ID() {
        return q_ID;
    }

    public void setQ_ID(int q_ID) {
        this.q_ID = q_ID;
    }
}
