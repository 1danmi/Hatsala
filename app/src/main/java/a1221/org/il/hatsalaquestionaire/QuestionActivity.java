package a1221.org.il.hatsalaquestionaire;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import a1221.org.il.hatsalaquestionaire.entities.UI_Answer;
import a1221.org.il.hatsalaquestionaire.entities.QuestionTranslation;
import a1221.org.il.hatsalaquestionaire.adapters.AnswersRecyclerAdapter;
import a1221.org.il.hatsalaquestionaire.adapters.RecyclerViewListener;

public class QuestionActivity extends AppCompatActivity  implements RecyclerViewListener.OnRecyclerClickListener  {

    private RecyclerView answerRecyclerView;
    private AnswersRecyclerAdapter answerRecyclerAdapter;
    private static ArrayList<QuestionTranslation> qList = new ArrayList<QuestionTranslation>();
    private static ArrayList<UI_Answer> aList = new ArrayList<UI_Answer>();

    TextView QHeb;
    TextView Qtranslated;
    ImageButton HebSpeech;
    ImageButton TranslatedSpeech;
    QuestionTranslation current;
    private static int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        QHeb = (TextView)findViewById(R.id.hebrew_question);
        Qtranslated = (TextView)findViewById(R.id.translation_question);
        HebSpeech = (ImageButton)findViewById(R.id.hebrew_audio_btn);
        HebSpeech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //dosome shit

            }
        });
        TranslatedSpeech = (ImageButton)findViewById(R.id.translation_audio_button);

        TranslatedSpeech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //dosome shit

            }
        });
        tempAddQuestions();
        tempaddanswers();
        id = 0;
        current = getQuestions(id);

        ArrayList<UI_Answer> currentAns = getAnswers(current);
        QHeb.setText(current.HebrewQ);
        Qtranslated.setText(current.TranslatedQ);
        setTitle(current.Title);
        answerRecyclerView = (RecyclerView) findViewById(R.id.answer_recycler_view);
        answerRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        answerRecyclerAdapter = new AnswersRecyclerAdapter(getApplicationContext(),currentAns);

        answerRecyclerView.setAdapter(answerRecyclerAdapter);

       // answerRecyclerView.addOnItemTouchListener(new anRecyclerViewListener(this, answerRecyclerView,this));
    }

    @Override
    public void onitemClick(View v, int position) {

    }
    public void nextquestion(){
        id = 0;//for now
        current = getQuestions(id);

        ArrayList<UI_Answer> currentAns = getAnswers(current);
        QHeb.setText(current.HebrewQ);
        Qtranslated.setText(current.TranslatedQ);
        setTitle(current.Title);
        answerRecyclerView = (RecyclerView) findViewById(R.id.answer_recycler_view);
        answerRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        answerRecyclerAdapter = new AnswersRecyclerAdapter(getApplicationContext(),currentAns);

        answerRecyclerView.setAdapter(answerRecyclerAdapter);


    }
    private void tempaddanswers() {
        aList.add(new UI_Answer("1","he","Ok","בסדר"));
        aList.add(new UI_Answer("1","he","very bad","ממש לא טוב"));
        aList.add(new UI_Answer("1","he","very bad","ממש לא טוב"));
        aList.add(new UI_Answer("1","he","very bad","ממש לא טוב"));
        aList.add(new UI_Answer("1","he","very bad","ממש לא טוב"));
    }
    private void tempAddQuestions() {
        qList.add(new QuestionTranslation("1","איך מרגיש","he","How do feel today? How do u feel?","מה שלומך היום? איך אתה מרגיש?"));
        qList.add(new QuestionTranslation("2","מממממ","he","sdffdsfsdf","ממממממממ"));
        qList.add(new QuestionTranslation("3","טט","he","sdffdsfsdf","טטטט"));
    }
    @Override
    protected void onResume() {
        super.onResume();
        initItemByListView();
    }
    void initItemByListView() {


        if(current == null) {
            Toast.makeText(getApplicationContext(), "No questions Found", Toast.LENGTH_LONG).show();
            //// TODO: goto report activity
            return;
        }

    }
    private ArrayList<UI_Answer> getAnswers(QuestionTranslation current) {
        return aList;
        //todo get answer for current question from db
    }
    public QuestionTranslation getQuestions(int counter) {
        return qList.get(counter);
        //Todo get next question from db
    }
}
