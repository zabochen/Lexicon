package ua.ck.zabochen.lexicon.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import ua.ck.zabochen.lexicon.R;
import ua.ck.zabochen.lexicon.adapter.WordsAdapter;
import ua.ck.zabochen.lexicon.dialog.WordDialogFragment;
import ua.ck.zabochen.lexicon.event.RecyclerViewItemClickListener;

public class WordsFragment extends Fragment {

    private WordsAdapter mWordsAdapter = null;

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View wordsFragmentLayout = inflater.inflate(R.layout.fragment_words, container, false);

        // Set & inflate RecyclerView
        mWordsAdapter = new WordsAdapter();

        RecyclerView recyclerView = (RecyclerView) wordsFragmentLayout.findViewById(R.id.fragment_words_recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(mWordsAdapter);

        return wordsFragmentLayout;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(Object event) {
        if (event instanceof RecyclerViewItemClickListener) {
            WordDialogFragment wordDialogFragment = WordDialogFragment.newInstance(((RecyclerViewItemClickListener) event).getItemId());
            wordDialogFragment.show(getActivity().getSupportFragmentManager(), WordsFragment.class.getSimpleName());
        }

    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }
}
