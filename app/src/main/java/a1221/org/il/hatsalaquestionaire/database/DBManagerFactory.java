package a1221.org.il.hatsalaquestionaire.database;

/**
 * Created by Daniel on 12/27/2016.
 */

public class DBManagerFactory {

    static IDBManager manager = null;


    public static IDBManager getManager() {
        if (manager == null)
            manager = new DBManager();
        return manager;
    }


}
