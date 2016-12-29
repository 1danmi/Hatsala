package a1221.org.il.hatsalaquestionaire.database;

import android.database.Cursor;

import java.util.ArrayList;
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
 * Created by Daniel on 12/28/2016.
 */

public class CursorAdapters {

    public static List<Question> cursorToQuestionList(Cursor cursor) {

        List<Question> result = new ArrayList<>();
        while (cursor.moveToNext()) {
            result.add(new Question(cursor.getInt(cursor.getColumnIndex(AppContract.Question._ID)),
                    cursor.getString(cursor.getColumnIndex(AppContract.Question.TITLE))));
        }
        cursor.close();

        return result;
    }

    public static List<Tag> cursorToTagList(Cursor cursor) {

        List<Tag> result = new ArrayList<>();
        while (cursor.moveToNext()) {
            result.add(new Tag(cursor.getInt(cursor.getColumnIndex(AppContract.Tag._ID)),
                    cursor.getString(cursor.getColumnIndex(AppContract.Tag.TEXT)),
                    cursor.getInt(cursor.getColumnIndex(AppContract.Tag.Q_ID))));
        }
        cursor.close();

        return result;
    }

    public static List<Answer> cursorToAnswerList(Cursor cursor) {
        boolean isScale;
        List<Answer> result = new ArrayList<>();
        while (cursor.moveToNext()) {
            if(cursor.getInt(cursor.getColumnIndex(AppContract.Answer.isScale))==0) {
                isScale = false;
            }else{
                isScale=true;
            }
            result.add(new Answer(cursor.getInt(cursor.getColumnIndex(AppContract.Answer._ID)),
                    isScale, cursor.getInt(cursor.getColumnIndex(AppContract.Answer.Q_ID))));
        }
        cursor.close();

        return result;
    }

    public static List<QTranslation> cursorToQTranslationList(Cursor cursor) {

        List<QTranslation> result = new ArrayList<>();
        while (cursor.moveToNext()) {
            result.add(new QTranslation(cursor.getInt(cursor.getColumnIndex(AppContract.QTranslation._ID)),
                    cursor.getString(cursor.getColumnIndex(AppContract.QTranslation.TEXT)),
                    cursor.getInt(cursor.getColumnIndex(AppContract.QTranslation.LANGUAGE)),
                    cursor.getInt(cursor.getColumnIndex(AppContract.QTranslation.Q_ID))));
        }
        cursor.close();

        return result;
    }

    public static List<ATranslation> cursorToATranslationList(Cursor cursor) {

        List<ATranslation> result = new ArrayList<>();
        while (cursor.moveToNext()) {
            result.add(new ATranslation(cursor.getInt(cursor.getColumnIndex(AppContract.ATranslation._ID)),
                    cursor.getString(cursor.getColumnIndex(AppContract.ATranslation.TEXT)),
                    cursor.getInt(cursor.getColumnIndex(AppContract.ATranslation.LANGUAGE)),
                    cursor.getInt(cursor.getColumnIndex(AppContract.ATranslation.A_ID))));
        }
        cursor.close();

        return result;
    }

    public static List<Category> cursorToCategoryList(Cursor cursor) {

        List<Category> result = new ArrayList<>();
        while (cursor.moveToNext()) {
            result.add(new Category(cursor.getInt(cursor.getColumnIndex(AppContract.Category._ID)),
                    cursor.getInt(cursor.getColumnIndex(AppContract.Category.FATHER_ID)),
                    cursor.getString(cursor.getColumnIndex(AppContract.Category.NAME))));
        }
        cursor.close();

        return result;
    }

    public static List<Language> cursorToLanguageList(Cursor cursor) {

        List<Language> result = new ArrayList<>();
        while (cursor.moveToNext()) {
            result.add(new Language(cursor.getInt(cursor.getColumnIndex(AppContract.Language._ID)),
                    cursor.getInt(cursor.getColumnIndex(AppContract.Language.SORT_ID)),
                    cursor.getString(cursor.getColumnIndex(AppContract.Language.TEXT))
                    ));
        }
        cursor.close();

        return result;
    }

    public static List<CatQ> cursorToCatQList(Cursor cursor) {

        List<CatQ> result = new ArrayList<>();
        while (cursor.moveToNext()) {
            result.add(new CatQ(cursor.getInt(cursor.getColumnIndex(AppContract.CatQ._ID)),
                    cursor.getInt(cursor.getColumnIndex(AppContract.CatQ.C_ID)),
                    cursor.getInt(cursor.getColumnIndex(AppContract.CatQ.Q_ID))
            ));
        }
        cursor.close();

        return result;
    }


}
