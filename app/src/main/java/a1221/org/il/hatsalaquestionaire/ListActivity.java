package a1221.org.il.hatsalaquestionaire;

import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import a1221.org.il.hatsalaquestionaire.adapters.CategoryRecyclerViewAdapter;
import a1221.org.il.hatsalaquestionaire.adapters.LanguageRecyclerAdapter;
import a1221.org.il.hatsalaquestionaire.adapters.RecyclerViewListener;
import a1221.org.il.hatsalaquestionaire.adapters.QuestionRecyclerViewAdapter;
import a1221.org.il.hatsalaquestionaire.database.DBManager;
import a1221.org.il.hatsalaquestionaire.database.DBManagerFactory;
import a1221.org.il.hatsalaquestionaire.entities.Category;
import a1221.org.il.hatsalaquestionaire.entities.Language;
import a1221.org.il.hatsalaquestionaire.entities.Question;

public class ListActivity extends AppCompatActivity implements RecyclerViewListener.OnRecyclerClickListener, android.widget.SearchView.OnQueryTextListener {

    private String MODE;
    private DBManager dbmanager;
    private RecyclerView listRecyclerView;
    private LanguageRecyclerAdapter languageRecyclerAdapter;
    private CategoryRecyclerViewAdapter categoryRecyclerViewAdapter;
    private QuestionRecyclerViewAdapter questionRecyclerViewAdapter;
    private static List<Language> filterLanguage(List<Language> languages, String query) {
        final List<Language> filteredModelList = new ArrayList<>();
        for (Language l : languages) {
            final String text = l.getLanguage().toLowerCase();
            if (text.contains(query.toLowerCase())) {
                filteredModelList.add(l);
            }
        }
        return filteredModelList;
    }
    private static List<Category> filterCategory(List<Category> categories, String query) {
        final List<Category> filteredModelList = new ArrayList<>();
        for (Category c : categories) {
            final String text = c.getName().toLowerCase();
            if (text.contains(query.toLowerCase())) {
                filteredModelList.add(c);
            }
        }
        return filteredModelList;
    }private static List<Question> filterQuestion(List<Question> languages, String query) {
        final List<Question> filteredModelList = new ArrayList<>();
        for (Question q : languages) {
            final String text = q.getTitle().toLowerCase();
            if (text.contains(query.toLowerCase())) {
                filteredModelList.add(q);
            }
        }
        return filteredModelList;
    }
    private static final Comparator<Category> CATEGORY_COMPARATOR = new Comparator<Category>() {
        @Override
        public int compare(Category a, Category b) {
            return a.getName().compareTo(b.getName());
        }
    };

    private static final Comparator<Question> QUESTION_COMPARATOR = new Comparator<Question>() {
        @Override
        public int compare(Question a, Question b) {
            return a.getTitle().compareTo(b.getTitle());
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);


        listRecyclerView = (RecyclerView) findViewById(R.id.language_recycler_view);
        listRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        dbmanager = (DBManager) DBManagerFactory.getManager();

        MODE = "Questions";

        if(MODE.equals("Languages")){
            setTitle("בחר שפה");
            setLangugeAdapter();
        }else if(MODE.equals("Categories")){
            setTitle("בחר קטגוריה");
            setCategoryAdapters();
        }else if(MODE.equals("Questions")){
            setTitle("בחר שאלה");
            setQuestionAdapter();
        }




    }

    private void setQuestionAdapter() {
        dbmanager.getQuestion();

        questionRecyclerViewAdapter = new QuestionRecyclerViewAdapter(getApplicationContext(), QUESTION_COMPARATOR);

        questionRecyclerViewAdapter.replaceAll(dbmanager.questions);

        listRecyclerView.setAdapter(questionRecyclerViewAdapter);

        listRecyclerView.addOnItemTouchListener(new RecyclerViewListener(this, listRecyclerView,this));
    }

    private void setCategoryAdapters() {
        dbmanager.getCategories();

        categoryRecyclerViewAdapter = new CategoryRecyclerViewAdapter(getApplicationContext(), CATEGORY_COMPARATOR);

        categoryRecyclerViewAdapter.replaceAll(dbmanager.categories);

        listRecyclerView.setAdapter(categoryRecyclerViewAdapter);

        listRecyclerView.addOnItemTouchListener(new RecyclerViewListener(this, listRecyclerView,this));
    }

    private void setLangugeAdapter() {
        dbmanager.getLanguages();

        languageRecyclerAdapter = new LanguageRecyclerAdapter(getApplicationContext());

        languageRecyclerAdapter.replaceAll(dbmanager.languages);

        listRecyclerView.setAdapter(languageRecyclerAdapter);

        listRecyclerView.addOnItemTouchListener(new RecyclerViewListener(this, listRecyclerView,this));
    }

    @Override
    public void onitemClick(View v, int position) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search, menu);

        final MenuItem searchItem = menu.findItem(R.id.app_bar_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setOnQueryTextListener(this);

        return true;
    }

    @Override
    public boolean onQueryTextChange(String query) {
        // Here is where we are going to implement the filterLanguage logic

        if(MODE.equals("Languages")) {
            final List<Language> filteredModelList = filterLanguage(dbmanager.languages, query);
            languageRecyclerAdapter.replaceAll(filteredModelList);
        }else if(MODE.equals("Categories")){
            final List<Category> filteredModelList = filterCategory(dbmanager.categories, query);
            categoryRecyclerViewAdapter.replaceAll(filteredModelList);
        }else if(MODE.equals("Questions")){
            final List<Question> filteredModelList = filterQuestion(dbmanager.questions, query);
            questionRecyclerViewAdapter.replaceAll(filteredModelList);
        }

        listRecyclerView.scrollToPosition(0);
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }


}
