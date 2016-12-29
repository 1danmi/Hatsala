package a1221.org.il.hatsalaquestionaire.entities;

import java.io.Serializable;

/**
 * Created by Daniel on 12/28/2016.
 */

public class Answer implements Serializable {

    private static final long serialVersionUID = 6L;

    private int _ID;

    private boolean isScale;

    private int q_ID;

    public Answer(int _ID, boolean isScale, int q_ID) {
        this._ID = _ID;
        this.isScale = isScale;
        this.q_ID = q_ID;
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

    public int getQ_ID() {
        return q_ID;
    }

    public void setQ_ID(int q_ID) {
        this.q_ID = q_ID;
    }
}
