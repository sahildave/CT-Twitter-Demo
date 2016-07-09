package xyz.sahildave.cleartax.util;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Point;
import android.graphics.Typeface;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.view.Display;
import android.view.View;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sahil on 6/3/16.
 */
public class Common {
    /**
     * Ensures that an object reference passed as a parameter to the calling method is not null.
     *
     * @param reference an object reference
     * @return the non-null reference that was validated
     * @throws NullPointerException if {@code reference} is null
     */
    public static <T> T checkNotNull(T reference) {
        if (reference == null) {
            throw new NullPointerException();
        }
        return reference;
    }

    public static boolean isJellyBean() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN;
    }

    public static boolean isLollipop() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP;
    }

    public static boolean isMarshmallow() {
        return (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M);
    }

    public static int dpToPx(Context context, float dp) {
        float density = context.getResources().getDisplayMetrics().density;
        return Math.round(dp * density);
    }

    public static int pxToDp(Context context, float px) {
        float density = context.getResources().getDisplayMetrics().density;
        return Math.round(px / density);
    }

    public static void setPaddingAll(View v, int paddingInDp) {
        v.setPadding(
                dpToPx(v.getContext(), paddingInDp),
                dpToPx(v.getContext(), paddingInDp),
                dpToPx(v.getContext(), paddingInDp),
                dpToPx(v.getContext(), paddingInDp));

    }

    public static Point getSizeOfScreen(Activity activity) {
        Display display = activity.getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        return size;
    }

    public static String mapToString(Map<String, Integer> map) {
        String result = "";
        for (Object key : map.keySet()) {
            Object value = map.get(key);
            result += key + " : "+value+"\n";
        }
        return result;
    }

    public static void showMessageOK(Context context, String title, String message, DialogInterface.OnClickListener okListener) {
        if(context == null) return;

        new AlertDialog.Builder(context)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(android.R.string.ok, okListener)
                .create()
                .show();
    }

    private static HashMap<String, Typeface> typefaces = new HashMap<String, Typeface>();
    public static Typeface getTypeface(Context context, String path){
        if (typefaces.containsKey(path)){
            return typefaces.get(path);
        }
        else{
            Typeface tf = Typeface.createFromAsset(context.getAssets(), path);
            typefaces.put(path, tf);
            return tf;
        }
    }
}
