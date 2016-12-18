package ua.ck.zabochen.lexicon.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ua.ck.zabochen.lexicon.R;

public class WordsFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View wordsFragmentLayout = inflater.inflate(R.layout.fragment_words, container, false);

        // Set UI
        RecyclerView recyclerView = (RecyclerView) wordsFragmentLayout.findViewById(R.id.fragment_words_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return wordsFragmentLayout;
    }

}
