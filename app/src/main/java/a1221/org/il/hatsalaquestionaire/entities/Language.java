package a1221.org.il.hatsalaquestionaire.entities;

import java.io.Serializable;

/**
 * Created by Daniel on 12/28/2016.
 */

public class Language implements Serializable{

    private static final long serialVersionUID = 1L;

    private int _ID;

    private int sortID;

    private String language;

    public Language(int _ID, int sortID, String language) {
        this._ID = _ID;
        this.sortID = sortID;
        this.language = language;
    }

    public int get_ID() {
        return _ID;
    }

    public void set_ID(int _ID) {
        this._ID = _ID;
    }

    public int getSortID() {
        return sortID;
    }

    public void setSortID(int sortID) {
        this.sortID = sortID;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
