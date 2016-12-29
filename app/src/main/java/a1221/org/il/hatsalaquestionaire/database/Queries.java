package a1221.org.il.hatsalaquestionaire.database;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.ArrayList;
import java.util.List;

import a1221.org.il.hatsalaquestionaire.constants.Constants;
import a1221.org.il.hatsalaquestionaire.entities.ATranslation;
import a1221.org.il.hatsalaquestionaire.entities.Answer;
import a1221.org.il.hatsalaquestionaire.entities.CatQ;
import a1221.org.il.hatsalaquestionaire.entities.Category;
import a1221.org.il.hatsalaquestionaire.entities.Language;
import a1221.org.il.hatsalaquestionaire.entities.QTranslation;
import a1221.org.il.hatsalaquestionaire.entities.Question;
import a1221.org.il.hatsalaquestionaire.entities.UIAnswer;
import a1221.org.il.hatsalaquestionaire.entities.UIQuestion;

/**
 * Created by Daniel on 12/28/2016.
 */

public class Queries {

    private static int langID;
    private static DBManager dbmanager;
    private static SharedPreferences sharedPreferences;

    public Queries(Context context, int language) {
        dbmanager = (DBManager) DBManagerFactory.getManager(context);
        langID = language;
        dbmanager.getQuestions();
        dbmanager.getAnswers();
        dbmanager.getLanguages();
        dbmanager.getATranslations();
        dbmanager.getQTranslations();
        dbmanager.getCatq();
        dbmanager.getCategories();
    }

    public static UIQuestion getQuestionDetails(int q_ID){
        UIQuestion uiQuestion = new UIQuestion();
        uiQuestion.set_ID(q_ID);
        uiQuestion.setTitle(getQuestion(q_ID).getTitle());
        uiQuestion.setqHebrew(getQTranslation(q_ID,1));
        uiQuestion.setqTranslation(getQTranslation(q_ID,langID));
        List<Answer> answers = getAnswers(q_ID);
        if(answers.size()==0){
            uiQuestion.setScale(true);
        }else{
            uiQuestion.setScale(false);
        }
        uiQuestion.setUiAnswers(getAnswersTranslation(answers));
        return uiQuestion;
    }

    private static List<UIAnswer> getAnswersTranslation(List<Answer> answers) {
        List<UIAnswer> uiAnswer = new ArrayList<>();
        for(Answer a : answers){
            String sHebrew = getATranslation(a.get_ID(),1);
            String sTranslation = getATranslation(a.get_ID(),langID);
            uiAnswer.add(new UIAnswer(sHebrew,sTranslation));
        }
        return uiAnswer;
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

    public static List<Answer> getAnswers(int q_ID){
        List<Answer> answers = new ArrayList<>();
        for(Answer a : dbmanager.answers){
            if(a.getQ_ID()==q_ID){
                answers.add(a);
            }
        }
        return answers;
    }



    public static List<Category> getMainCategories(){
        List<Category> mainCategories = new ArrayList<>();
        for(Category c : dbmanager.categories){
            if(c.getFatherID()==0){
                mainCategories.add(c);
            }
        }
        return mainCategories;
    }
    public static List<Category> getSubCategories(int fatherID){
        List<Category> subCategories = new ArrayList<>();
        for(Category c : dbmanager.categories){
            if(c.getFatherID()==fatherID){
                subCategories.add(c);
            }
        }
        return subCategories;
    }

    public static Question getQuestionByID(int q_ID){
        for(Question q : dbmanager.questions){
            if(q.get_ID()==q_ID){
                return q;
            }
        }
        return null;
    }


    public static List<Question> getCategoryQuestions(int c_ID){
        List<Question> question = new ArrayList<>();
        for(CatQ cq : dbmanager.catq){
            if(cq.getC_ID()==c_ID) {
                question.add(getQuestionByID(cq.getQ_ID()));
            }
        }
        return question;
    }

    public static String getLanguage(int q_id){
        for(Language l : dbmanager.languages){
            if(l.get_ID()==q_id){
                return l.getLanguage();
            }
        }
        return null;
    }
}
