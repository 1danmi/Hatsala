package a1221.org.il.hatsalaquestionaire.database;

import android.content.Context;

/**
 * Created by Daniel on 12/27/2016.
 */

public class DBManagerFactory {

    static IDBManager manager = null;


    public static IDBManager getManager(Context context) {
        if (manager == null)
            manager = new DBManager(context);
        return manager;
    }


}
