package a1221.org.il.hatsalaquestionaire;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import a1221.org.il.hatsalaquestionaire.adapters.LanguageRecyclerAdapter;
import a1221.org.il.hatsalaquestionaire.adapters.LanguageRecyclerViewListener;
import a1221.org.il.hatsalaquestionaire.database.DBManager;
import a1221.org.il.hatsalaquestionaire.database.DBManagerFactory;

public class QuestionActivity extends AppCompatActivity  implements LanguageRecyclerViewListener.OnRecyclerClickListener  {

    private RecyclerView languageRecyclerView;
    private LanguageRecyclerAdapter answerRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        languageRecyclerView = (RecyclerView) findViewById(R.id.answer_recycler_view);
        languageRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        DBManager dbmanager = (DBManager) DBManagerFactory.getManager();
        dbmanager.getLanguages();
        answerRecyclerAdapter = new LanguageRecyclerAdapter(getApplicationContext());

        languageRecyclerView.setAdapter(answerRecyclerAdapter);

        languageRecyclerView.addOnItemTouchListener(new LanguageRecyclerViewListener(this, languageRecyclerView,this));
    }

    @Override
    public void onitemClick(View v, int position) {

    }
}
