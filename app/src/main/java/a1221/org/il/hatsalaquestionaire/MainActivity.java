package a1221.org.il.hatsalaquestionaire;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import a1221.org.il.hatsalaquestionaire.constants.Constants;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(getBaseContext(),ListActivity.class);
        intent.putExtra(Constants.MODE,"Languages");
        startActivity(intent);
    }
}
