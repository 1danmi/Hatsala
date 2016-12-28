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
import java.util.List;

import a1221.org.il.hatsalaquestionaire.adapters.LanguageRecyclerViewListener;
import a1221.org.il.hatsalaquestionaire.adapters.LanguageRecyclerAdapter;
import a1221.org.il.hatsalaquestionaire.database.DBManager;
import a1221.org.il.hatsalaquestionaire.database.DBManagerFactory;
import a1221.org.il.hatsalaquestionaire.entities.Language;

public class ListActivity extends AppCompatActivity implements LanguageRecyclerViewListener.OnRecyclerClickListener, android.widget.SearchView.OnQueryTextListener {

    private String mode = "Langs";
    private DBManager dbmanager;
    private RecyclerView listRecyclerView;
    private LanguageRecyclerAdapter languageRecyclerAdapter;
    private static List<Language> filter(List<Language> languages, String query) {
        final List<Language> filteredModelList = new ArrayList<>();
        for (Language l : languages) {
            final String text = l.getLanguage().toLowerCase();
            if (text.contains(query.toLowerCase())) {
                filteredModelList.add(l);
            }
        }
        return filteredModelList;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        setTitle("בחר שפה");

        listRecyclerView = (RecyclerView) findViewById(R.id.language_recycler_view);
        listRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        dbmanager = (DBManager) DBManagerFactory.getManager();
        dbmanager.getLanguages();
        languageRecyclerAdapter = new LanguageRecyclerAdapter(getApplicationContext());

        languageRecyclerAdapter.replaceAll(dbmanager.languages);


        listRecyclerView.setAdapter(languageRecyclerAdapter);

        listRecyclerView.addOnItemTouchListener(new LanguageRecyclerViewListener(this, listRecyclerView,this));

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
        // Here is where we are going to implement the filter logic

        final List<Language> filteredModelList = filter(dbmanager.languages, query);
        languageRecyclerAdapter.replaceAll(filteredModelList);
        listRecyclerView.scrollToPosition(0);
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }


}
