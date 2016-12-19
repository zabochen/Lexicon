package ua.ck.zabochen.lexicon.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ua.ck.zabochen.lexicon.R;
import ua.ck.zabochen.lexicon.controller.RealmController;
import ua.ck.zabochen.lexicon.utils.Utils;

public class WordsAdapter extends RecyclerView.Adapter<WordsAdapter.MyViewHolder> {

    private Context mContext = null;

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.mContext = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View itemWordLayout = layoutInflater.inflate(
                R.layout.item_word,
                parent,
                false
        );
        return new MyViewHolder(itemWordLayout);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.cardView.setCardBackgroundColor(Utils.getRandomColor(mContext));
        holder.name.setText(RealmController.getInstance().getWords().get(position).getName());
        holder.translate.setText(RealmController.getInstance().getWords().get(position).getTranslation());
    }

    @Override
    public int getItemCount() {
        return RealmController.getInstance().getSize() > 0 ? RealmController.getInstance().getSize() : 0;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        TextView name;
        TextView translate;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.cardView = (CardView) itemView.findViewById(R.id.item_word_cardview);
            this.name = (TextView) itemView.findViewById(R.id.item_word_name);
            this.translate = (TextView) itemView.findViewById(R.id.item_word_translate);
        }
    }
}
