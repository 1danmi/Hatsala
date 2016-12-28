package a1221.org.il.hatsalaquestionaire.entities;

import java.io.Serializable;

/**
 * Created by Daniel on 12/28/2016.
 */

public class Category implements Serializable {

    private static final long serialVersionUID = 2L;

    private int _ID;

    private int fatherID;

    private String name;

    public Category(int _ID, int fatherID, String name) {
        this._ID = _ID;
        this.fatherID = fatherID;
        this.name = name;
    }

    public int get_ID() {
        return _ID;
    }

    public void set_ID(int _ID) {
        this._ID = _ID;
    }

    public int getFatherID() {
        return fatherID;
    }

    public void setFatherID(int fatherID) {
        this.fatherID = fatherID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
