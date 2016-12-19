package ua.ck.zabochen.lexicon.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ua.ck.zabochen.lexicon.R;
import ua.ck.zabochen.lexicon.adapter.WordsAdapter;

public class WordsFragment extends Fragment {

    private WordsAdapter mWordsAdapter = null;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View wordsFragmentLayout = inflater.inflate(R.layout.fragment_words, container, false);

        // Set UI
        mWordsAdapter = new WordsAdapter();

        RecyclerView recyclerView = (RecyclerView) wordsFragmentLayout.findViewById(R.id.fragment_words_recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        recyclerView.setAdapter(mWordsAdapter);

        return wordsFragmentLayout;
    }

}
