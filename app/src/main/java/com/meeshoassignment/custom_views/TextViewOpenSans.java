package com.meeshoassignment.custom_views;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

public class TextViewOpenSans extends AppCompatTextView {
    private static final String asset = "fonts/OpenSans-Bold.ttf";

    public TextViewOpenSans(Context context) {
        super(context);
    }

    public TextViewOpenSans(Context context, AttributeSet attrs) {
        super(context, attrs);
        setCustomFont(context, asset);
    }

    public TextViewOpenSans(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setCustomFont(context, asset);
    }

    public boolean setCustomFont(Context ctx, String asset) {
        setTypeface(TypeFace.get(ctx, asset));
        return true;
    }
}

