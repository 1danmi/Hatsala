package a1221.org.il.hatsalaquestionaire;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

import a1221.org.il.hatsalaquestionaire.adapters.AnswersRecyclerAdapter;
import a1221.org.il.hatsalaquestionaire.adapters.RecyclerViewListener;
import a1221.org.il.hatsalaquestionaire.constants.Constants;
import a1221.org.il.hatsalaquestionaire.database.Queries;
import a1221.org.il.hatsalaquestionaire.entities.UIQuestion;

/**
 * Created by Arele-PC on 12/28/2016.
 */

public class AdditionalQuestionsActivity extends AppCompatActivity implements RecyclerViewListener.OnRecyclerClickListener {

    SharedPreferences sharedpreferences;


    private RecyclerView answerRecyclerView;
    private AnswersRecyclerAdapter answerRecyclerAdapter;


    TextView QHeb;
    TextView Qtranslated;
    TextView seekbartext;
    ImageButton HebSpeech;
    ImageButton Nextbutton;
    ImageButton TranslatedSpeech;
    UIQuestion current;
    SeekBar seek;
    TextToSpeech ttsobjEn;
    private static int id = 1;
    Queries queri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        queri = new Queries(getApplicationContext(), 2);

        setContentView(R.layout.activity_question);
        QHeb = (TextView) findViewById(R.id.hebrew_question);
        Qtranslated = (TextView) findViewById(R.id.translation_question);
        HebSpeech = (ImageButton) findViewById(R.id.hebrew_audio_btn);
        seek = (SeekBar) findViewById(R.id.seekBar);
        seekbartext = (TextView) findViewById(R.id.textViewseekbar);
        seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekbartext.setText((Integer.toString(progress)));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        HebSpeech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //dosome shit

            }
        });
        TranslatedSpeech = (ImageButton) findViewById(R.id.translation_audio_button);

        sharedpreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        final int langID = getIntent().getIntExtra(Constants.LANGUAGE_ID, 0);
        ttsobjEn = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    if (queri.getLanguage(langID).equals("English")) {
                        ttsobjEn.setLanguage(Locale.UK);
                    }
                    if (queri.getLanguage(langID).equals("Deutsch")) {
                        ttsobjEn.setLanguage(Locale.GERMANY);
                    }
                }
            }
        });
        HebSpeech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(),"clicked button1",Toast.LENGTH_SHORT).show();
                speak();
            }
        });
        TranslatedSpeech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(),"clicked button2",Toast.LENGTH_SHORT).show();
                speak();
            }
        });
        answerRecyclerView = (RecyclerView) findViewById(R.id.answer_recycler_view);
        Nextbutton = (ImageButton) findViewById(R.id.imageButton_Next);
        Nextbutton.setVisibility(View.GONE);


        TranslatedSpeech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //dosome shit

            }
        });
//        tempAddQuestions();
//        tempaddanswers();
        nextquestion();

        // answerRecyclerView.addOnItemTouchListener(new anRecyclerViewListener(this, answerRecyclerView,this));
    }

    private void speak() {
        String toSpeak = Qtranslated.getText().toString();
        ttsobjEn.speak(toSpeak, TextToSpeech.QUEUE_ADD, null);
    }

    public void nextquestion() {
        //todo here we ll get list of remaining items to display of general questions

        current = queri.getQuestionDetails(3);
        Intent intent;
        if (current == null) {
            intent = new Intent(getBaseContext(), SearchActivity.class);
            startActivity(intent);
        }
        //current = getQuestions(id);
//        QHeb.setText(current.HebrewQ);
//        Qtranslated.setText(current.TranslatedQ);
//        setTitle(current.Title);
        QHeb.setText(current.getqHebrew());
        Qtranslated.setText(current.getqTranslation());
        setTitle(current.getTitle());


        if (current.isScale()) {
            RecyclerView rec = (RecyclerView) findViewById(R.id.answer_recycler_view);
            rec.setVisibility(View.GONE);
            LinearLayout li = (LinearLayout) findViewById(R.id.seekBarlayout);
            li.setVisibility(View.VISIBLE);
        } else {
            //currentAns =  getAnswers(1);//answer.get_ID()
            RecyclerView rec = (RecyclerView) findViewById(R.id.answer_recycler_view);
            rec.setVisibility(View.VISIBLE);
            LinearLayout li = (LinearLayout) findViewById(R.id.seekBarlayout);
            li.setVisibility(View.GONE);
        }
        answerRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        answerRecyclerAdapter = new AnswersRecyclerAdapter(getApplicationContext(), current.getUiAnswers());
        answerRecyclerView.setAdapter(answerRecyclerAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        initItemByListView();
    }

    void initItemByListView() {


        if (current == null) {
            Toast.makeText(getApplicationContext(), "No questions Found", Toast.LENGTH_LONG).show();
            //// TODO: goto report activity
            return;
        }

    }

    @Override
    public void onitemClick(View v, int position) {


//
//        return uians;
//        //todo get answer for current question from db
//    }
//    public QuestionTranslation getQuestions(int id) {
//        return qList.get(id-1);
//        //Todo get next question from db
//    }
    }
}