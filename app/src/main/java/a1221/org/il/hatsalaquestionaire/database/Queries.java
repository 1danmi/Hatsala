package a1221.org.il.hatsalaquestionaire.database;

import android.content.Context;

import a1221.org.il.hatsalaquestionaire.entities.Question;
import a1221.org.il.hatsalaquestionaire.entities.UIQuestion;

/**
 * Created by Daniel on 12/28/2016.
 */

public class Queries {

    private static DBManager dbmanager;

    public Queries(Context context) {
        dbmanager = (DBManager) DBManagerFactory.getManager(context);
        dbmanager.getQuestions();
        dbmanager.getAnswers();
        dbmanager.getLanguages();
        dbmanager.getATranslations();
        dbmanager.getQTranslations();
    }

    public static UIQuestion getQuestionDetails(int q_ID){

        UIQuestion uiQuestion = new UIQuestion();
        uiQuestion.set_ID(q_ID);

        return uiQuestion;
    }

    public static Question getQuestion(int q_ID){

        dbmanager.getQuestions();
        return null;
    }
}
