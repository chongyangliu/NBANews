package com.example.lcy.nbanews.util;

import android.content.res.Resources;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.TextView;

import com.example.lcy.nbanews.R;
import com.example.lcy.nbanews.base.BaseApplication;

/**
 * 与其憧憬未来，不如把握现在。
 * Created by lcy on 2016-7-12.
 */
public class SnackBarUtils {

    public static void showSnackBar(View view, String text) {
        Resources resources  = BaseApplication.getContext().getResources();
        Snackbar sb = Snackbar.make(view, text, Snackbar.LENGTH_SHORT);
        setSnackbarMessageTextColor(sb);
        sb.getView().setBackgroundColor(resources.getColor( R.color.main_bg));
        sb.show();
    }

    public static void setSnackbarMessageTextColor(Snackbar snackbar) {
        View view = snackbar.getView();
        ((TextView) view.findViewById(R.id.snackbar_text)).setTextColor(Color.parseColor("#448AFF"));
    }
}
