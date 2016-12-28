package a1221.org.il.hatsalaquestionaire.entities;

import java.io.Serializable;

/**
 * Created by Daniel on 12/28/2016.
 */

public class Option implements Serializable {

    private static final long serialVersionUID = 6L;

    private int _ID;

    public Option(int _ID) {
        this._ID = _ID;
    }

    public int get_ID() {
        return _ID;
    }

    public void set_ID(int _ID) {
        this._ID = _ID;
    }
}
