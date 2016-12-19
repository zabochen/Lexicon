package ua.ck.zabochen.lexicon.utils;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;

import ua.ck.zabochen.lexicon.R;

public class Utils {

    public static int getRandomColor(Context context) {
        TypedArray typedArrayColors = context.getResources().obtainTypedArray(R.array.item_words_background_colors);
        int index = (int) (Math.random() * typedArrayColors.length());
        int color = typedArrayColors.getColor(index, Color.BLACK);
        typedArrayColors.recycle();
        return color;
    }
}
