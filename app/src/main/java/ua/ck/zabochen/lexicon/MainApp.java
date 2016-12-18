package ua.ck.zabochen.lexicon;

import android.app.Application;

import java.io.IOException;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import ua.ck.zabochen.lexicon.model.Word;

public class MainApp extends Application {

    private static final String TAG = MainApp.class.getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();
        setRealm();
    }

    private void setRealm() {
        Realm.init(getApplicationContext());
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
                .name("lexicon.db")
                .schemaVersion(0)
                .build();
        Realm.setDefaultConfiguration(realmConfiguration);

        // Inflate RealmBase
        Realm realm = Realm.getDefaultInstance();
        if (realm.isEmpty()) {
            realm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    try {
                        realm.createAllFromJson(
                                Word.class,
                                getResources().openRawResource(R.raw.words)
                        );
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

}
