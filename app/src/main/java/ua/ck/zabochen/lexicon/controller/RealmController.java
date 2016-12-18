package ua.ck.zabochen.lexicon.controller;

import io.realm.Realm;
import io.realm.RealmResults;
import ua.ck.zabochen.lexicon.model.Word;

public class RealmController {

    private static RealmController sRealmController;
    private final Realm realm;

    private RealmController() {
        realm = Realm.getDefaultInstance();
    }

    public static RealmController getInstance() {
        if (sRealmController == null) {
            sRealmController = new RealmController();
        }
        return sRealmController;
    }

    public Realm getRealm() {
        return realm;
    }

    public RealmResults<Word> getWords() {
        RealmResults<Word> words = realm.where(Word.class).findAll();
        words.sort("id");
        return words;
    }

    public Word getWord(int id) {
        return null;
    }

    public int getSize() {
        RealmResults<Word> words = realm.where(Word.class).findAll();
        return words.size();
    }
}
