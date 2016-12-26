package ua.ck.zabochen.lexicon.activity;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import ua.ck.zabochen.lexicon.R;
import ua.ck.zabochen.lexicon.fragment.WordsFragment;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener {

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

        // BottomNavigation View
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.activity_main_bottom_navigation_view);
        bottomNavigationView.setOnClickListener(this);
    }

    private void setFragment(Bundle bundle) {
        if (bundle == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.activity_main_frame_layout, new WordsFragment())
                    .commit();
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.activity_main_bottom_navigation_view:
                break;
        }
    }
}
