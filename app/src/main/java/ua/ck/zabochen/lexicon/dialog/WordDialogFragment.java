package ua.ck.zabochen.lexicon.dialog;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ua.ck.zabochen.lexicon.R;
import ua.ck.zabochen.lexicon.controller.RealmController;

public class WordDialogFragment extends DialogFragment {

    private static final String TAG = WordDialogFragment.class.getSimpleName();

    public WordDialogFragment() {
    }

    public static WordDialogFragment newInstance(int id) {
        WordDialogFragment wordDialogFragment = new WordDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("id", id);
        wordDialogFragment.setArguments(bundle);
        return wordDialogFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_fragment_word, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Find DialogFragment View
        TextView wordName = (TextView) view.findViewById(R.id.dialog_fragment_word_name);
        TextView wordTranscription = (TextView) view.findViewById(R.id.dialog_fragment_word_transcription);
        TextView wordTranslate = (TextView) view.findViewById(R.id.dialog_fragment_word_translate);

        // SetData
        int itemId = getArguments().getInt("id");
        wordName.setText(RealmController.getInstance().getWord(itemId).getName().toUpperCase());
        wordTranscription.setText(RealmController.getInstance().getWord(itemId).getTranscription());
        wordTranslate.setText(RealmController.getInstance().getWord(itemId).getTranslation().toUpperCase());
    }
}
