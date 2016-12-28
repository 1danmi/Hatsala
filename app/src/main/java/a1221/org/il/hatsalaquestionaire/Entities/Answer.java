package a1221.org.il.hatsalaquestionaire.entities;

import java.io.Serializable;

/**
 * Created by Daniel on 12/28/2016.
 */

public class Answer implements Serializable {

    private static final long serialVersionUID = 6L;

    private int _ID;

    private boolean isScale;

    public Answer(int _ID, boolean isScale) {
        this._ID = _ID;
        this.isScale = isScale;
    }

    public int get_ID() {
        return _ID;
    }

    public void set_ID(int _ID) {
        this._ID = _ID;
    }

    public boolean isScale() {
        return isScale;
    }

    public void setScale(boolean scale) {
        isScale = scale;
    }
}
