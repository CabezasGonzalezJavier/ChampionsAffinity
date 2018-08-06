package com.thedeveloperworldisyours.championsaffinity;
import android.content.Context;
/**
 * Created by javiergonzalezcabezas on 5/8/18.
 */

public class SharedPreferences {
    public static boolean isVote(Context context, String dontShowGeneratePopup) {

        return context.getSharedPreferences(dontShowGeneratePopup, Context.MODE_PRIVATE)
                .getBoolean(dontShowGeneratePopup, false);
    }

    public static void setVote(Context context, String dontShowGeneratePopup, boolean valueDontShowGeneratePopup) {
        context.getSharedPreferences(dontShowGeneratePopup, Context.MODE_PRIVATE)
                .edit()
                .putBoolean(dontShowGeneratePopup, valueDontShowGeneratePopup)
                .apply();
    }
}
