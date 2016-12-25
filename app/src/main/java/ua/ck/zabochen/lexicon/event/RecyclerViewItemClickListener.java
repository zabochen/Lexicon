package ua.ck.zabochen.lexicon.event;

public class RecyclerViewItemClickListener {

    private int itemId;

    public RecyclerViewItemClickListener(int itemId) {
        this.itemId = itemId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

}
