package ua.ck.zabochen.lexicon.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import ua.ck.zabochen.lexicon.R;
import ua.ck.zabochen.lexicon.fragment.WordsFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setUi();
        setFragment(savedInstanceState);
    }

    private void setUi() {
        // Layout
        setContentView(R.layout.activity_main);
    }

    private void setFragment(Bundle bundle) {
        if (bundle == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(new WordsFragment(), WordsFragment.class.getSimpleName())
                    .commit();
        }
    }
}
