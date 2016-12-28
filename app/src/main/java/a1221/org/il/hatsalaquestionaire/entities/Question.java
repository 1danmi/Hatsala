package a1221.org.il.hatsalaquestionaire.entities;

import java.io.Serializable;

/**
 * Created by Daniel on 12/28/2016.
 */

public class Question implements Serializable{

    private static final long serialVersionUID = 3L;

    private int _ID;

    private String title;

    public Question(int _ID, String title) {
        this._ID = _ID;
        this.title = title;
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
}
