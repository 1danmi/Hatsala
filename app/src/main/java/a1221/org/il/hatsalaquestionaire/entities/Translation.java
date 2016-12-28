package a1221.org.il.hatsalaquestionaire.entities;

import java.io.Serializable;

/**
 * Created by Daniel on 12/28/2016.
 */

public class Translation implements Serializable {

    private static final long serialVersionUID = 4L;

    private int _ID;

    private String text;

    public Translation(int _ID, String text) {
        this._ID = _ID;
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
