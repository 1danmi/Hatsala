package a1221.org.il.hatsalaquestionaire.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

import a1221.org.il.hatsalaquestionaire.entities.ATranslation;
import a1221.org.il.hatsalaquestionaire.entities.Answer;
import a1221.org.il.hatsalaquestionaire.entities.CatQ;
import a1221.org.il.hatsalaquestionaire.entities.Category;
import a1221.org.il.hatsalaquestionaire.entities.Language;
import a1221.org.il.hatsalaquestionaire.entities.QTranslation;
import a1221.org.il.hatsalaquestionaire.entities.Question;
import a1221.org.il.hatsalaquestionaire.entities.Tag;

/**
 * Created by Daniel on 12/27/2016.
 */

public class DBManager implements IDBManager {
    private static final String TAG = "DBManager";


    public static List<Question> questions;
    public static List<Answer> answers;
    public static List<Tag> tags;
    public static List<QTranslation> qtranslations;
    public static List<ATranslation> atranslations;
    public static List<Language> languages;
    public static List<Category> categories;
    public static List<CatQ> catq;
    private SQLiteDatabase sqLiteDatabase;
    private DBAdapter mDbHelper;





    public DBManager(Context context) {
        mDbHelper = new DBAdapter(context);
        mDbHelper.createDatabase();
        mDbHelper.open();

        this.sqLiteDatabase = mDbHelper.mDb;


    }

    public void closeDB(){
        mDbHelper.close();
    }

    @Override
    public void getLanguages() {
        Cursor query = sqLiteDatabase.rawQuery("SELECT * FROM language;",null);

        this.languages = CursorAdapters.cursorToLanguageList(query);
    }

    @Override
    public void getCategories() {
        Cursor query = sqLiteDatabase.rawQuery("SELECT * FROM category;",null);
        this.categories = CursorAdapters.cursorToCategoryList(query);
    }

    @Override
    public void getCatq() {
        Cursor query = sqLiteDatabase.rawQuery("SELECT * FROM catq;",null);

        this.catq = CursorAdapters.cursorToCatQList(query);
    }

    @Override
    public void getQuestions() {
        Cursor query = sqLiteDatabase.rawQuery("SELECT * FROM question;",null);
        this.questions = CursorAdapters.cursorToQuestionList(query);
    }

    @Override
    public void getAnswers() {
        Cursor query = sqLiteDatabase.rawQuery("SELECT * FROM answer;",null);
        this.answers = CursorAdapters.cursorToAnswerList(query);

    }

    @Override
    public void getTags() {
        Cursor query = sqLiteDatabase.rawQuery("SELECT * FROM tag;",null);
        this.tags = CursorAdapters.cursorToTagList(query);
    }

    @Override
    public void getQTranslations() {
        Cursor query = sqLiteDatabase.rawQuery("SELECT * FROM qtranslation;",null);
        this.qtranslations = CursorAdapters.cursorToQTranslationList(query);
    }

    @Override
    public void getATranslations() {
        Cursor query = sqLiteDatabase.rawQuery("SELECT * FROM atranslation;",null);
        this.atranslations = CursorAdapters.cursorToATranslationList(query);
    }


}
