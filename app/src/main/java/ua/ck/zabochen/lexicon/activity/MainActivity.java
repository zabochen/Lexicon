package ua.ck.zabochen.lexicon.activity;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import ua.ck.zabochen.lexicon.R;
import ua.ck.zabochen.lexicon.fragment.WordsFragment;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setUi();
        setFragment(savedInstanceState);
    }

    private void setUi() {
        // Layout
        setContentView(R.layout.activity_main);

        // Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.activity_main_toolbar);
        toolbar.setTitleTextColor(ContextCompat.getColor(getApplicationContext(), R.color.toolbar_title));
        setSupportActionBar(toolbar);
    }

    private void setFragment(Bundle bundle) {
        if (bundle == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.activity_main_frame_layout, new WordsFragment())
                    .commit();
        }
    }
}
