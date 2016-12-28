package a1221.org.il.hatsalaquestionaire.database;

import java.util.ArrayList;

/**
 * Created by Daniel on 12/27/2016.
 */

public class DBManager implements IDBManager {

    public static ArrayList<String> languages;



    @Override
    public void getLanguages() {
        languages = new ArrayList<>();
        languages.add("עברית");
        languages.add("English");
        languages.add("عَرَبِيّ");
        languages.add("Русский");
        languages.add("አማርኛ");
        languages.add("Español");
        languages.add("Português");
        languages.add("हिन्दी");


    }
}
