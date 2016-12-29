package a1221.org.il.hatsalaquestionaire.database;

import android.content.Context;

/**
 * Created by Arele-PC on 12/29/2016.
 */

public class QueryFactory {


    static Queries query = null;


    public static Queries getQuery(Context context, int language) {
        if (query == null)
            query = new Queries(context,language);
        return query;
    }

}
