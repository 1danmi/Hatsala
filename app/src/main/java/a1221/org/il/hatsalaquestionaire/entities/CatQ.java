package a1221.org.il.hatsalaquestionaire.entities;

import java.io.Serializable;

/**
 * Created by Daniel on 12/28/2016.
 */

public class CatQ implements Serializable{

    private static final long serialVersionUID = 10L;

    private int _ID;

    private int c_ID;

    private int q_ID;

    public CatQ(int _ID, int c_ID, int q_ID) {
        this._ID = _ID;
        this.c_ID = c_ID;
        this.q_ID = q_ID;
    }

    public int get_ID() {
        return _ID;
    }

    public void set_ID(int _ID) {
        this._ID = _ID;
    }

    public int getC_ID() {
        return c_ID;
    }

    public void setC_ID(int c_ID) {
        this.c_ID = c_ID;
    }

    public int getQ_ID() {
        return q_ID;
    }

    public void setQ_ID(int q_ID) {
        this.q_ID = q_ID;
    }
}
