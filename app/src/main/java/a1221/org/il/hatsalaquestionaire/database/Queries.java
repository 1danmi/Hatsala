package a1221.org.il.hatsalaquestionaire.database;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.ArrayList;
import java.util.List;

import a1221.org.il.hatsalaquestionaire.constants.Constants;
import a1221.org.il.hatsalaquestionaire.entities.ATranslation;
import a1221.org.il.hatsalaquestionaire.entities.Answer;
import a1221.org.il.hatsalaquestionaire.entities.QTranslation;
import a1221.org.il.hatsalaquestionaire.entities.Question;
import a1221.org.il.hatsalaquestionaire.entities.UIAnswer;
import a1221.org.il.hatsalaquestionaire.entities.UIQuestion;

/**
 * Created by Daniel on 12/28/2016.
 */

public class Queries {

    private static DBManager dbmanager;
    private static SharedPreferences sharedPreferences;

    public Queries(Context context) {
        dbmanager = (DBManager) DBManagerFactory.getManager(context);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        dbmanager.getQuestions();
        dbmanager.getAnswers();
        dbmanager.getLanguages();
        dbmanager.getATranslations();
        dbmanager.getQTranslations();
        dbmanager.getCatq();
        dbmanager.getCategories();
    }

    public static UIQuestion getQuestionDetails(int q_ID){

        int langID = sharedPreferences.getInt(Constants.MAIN_LANGUAGE,0);

        UIQuestion uiQuestion = new UIQuestion();
        uiQuestion.set_ID(q_ID);
        uiQuestion.setTitle(getQuestion(q_ID).getTitle());
        uiQuestion.setqHebrew(getQTranslation(q_ID,1));
        uiQuestion.setqTranslation(getQTranslation(q_ID,langID));
        Answer answer = getAnswer(q_ID);
        uiQuestion.setScale(answer.isScale());
        uiQuestion.setUiAnswers(getAnswers(answer.get_ID(),langID));
        return uiQuestion;
    }

    public static Question getQuestion(int q_ID){

        for (Question q : dbmanager.questions){
            if(q.get_ID()==q_ID){
                return q;
            }
        }
        return null;
    }
    public static String getQTranslation(int q_ID, int language){
        for(QTranslation qt : dbmanager.qtranslations){
            if(qt.getL_ID()==language&&qt.getQ_ID()==q_ID){
                return qt.getText();
            }
        }
        return "Translation doesn\'t exist";
    }

    public static String getATranslation(int a_ID, int language){
        for(ATranslation qt : dbmanager.atranslations){
            if(qt.getL_ID()==language&&qt.getA_ID()==a_ID){
                return qt.getText();
            }
        }
        return "Translation doesn\'t exist";
    }

    public static Answer getAnswer(int q_ID){
        for(Answer a : dbmanager.answers){
            if(a.getQ_ID()==q_ID){
                return a;
            }
        }
        return null;
    }

    public static List<UIAnswer> getAnswers(int a_ID, int language){
        List<UIAnswer> uiAnswers = new ArrayList<>();
        for(ATranslation a : dbmanager.atranslations){
            if(a.getA_ID()==a_ID){
                uiAnswers.add(new UIAnswer(getATranslation(a_ID,1),getATranslation(a_ID,language)));
            }
        }
        return uiAnswers;
    }



}
