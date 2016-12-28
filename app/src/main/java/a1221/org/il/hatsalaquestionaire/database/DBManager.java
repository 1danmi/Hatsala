package a1221.org.il.hatsalaquestionaire.database;

import java.util.ArrayList;

import a1221.org.il.hatsalaquestionaire.entities.Category;
import a1221.org.il.hatsalaquestionaire.entities.Language;
import a1221.org.il.hatsalaquestionaire.entities.Question;

/**
 * Created by Daniel on 12/27/2016.
 */

public class DBManager implements IDBManager {

    public static ArrayList<Language> languages;
    public static ArrayList<Category> categories;
    public static ArrayList<Question> questions;




    @Override
    public void getLanguages() {
        languages = new ArrayList<>();
        languages.add(new Language(1,1,"עברית"));
        languages.add(new Language(2,2,"English"));
        languages.add(new Language(3,3,"عَرَبِيّ"));
        languages.add(new Language(4,4,"Русский"));
        languages.add(new Language(5,5,"አማርኛ"));
        languages.add(new Language(6,6,"Español"));
        languages.add(new Language(7,7,"Português"));
        languages.add(new Language(8,8,"हिन्दी"));
    }

    @Override
    public void getCategories() {
        categories =  new ArrayList<>();
        categories.add(new Category(1,0,"מחלות"));
        categories.add(new Category(2,0,"טראומה"));
    }

    @Override
    public void getQuestion() {
        questions = new ArrayList<>();
        questions.add(new Question(1,"כאב ראש"));
        questions.add(new Question(2,"כאב בטן"));
        questions.add(new Question(3,"כאב גב"));
    }



}
