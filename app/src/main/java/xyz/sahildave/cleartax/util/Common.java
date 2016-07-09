package xyz.sahildave.cleartax.util;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Point;
import android.graphics.Typeface;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.view.Display;
import android.view.View;
import android.view.ViewPropertyAnimator;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sahil on 6/3/16.
 */
public class Common {
    public static final int DEFAULT_DURATION = -1;
    public static final int DURATION_SHORT = 150;
    public static final int DURATION_MEDIUM = 250;
    public static final int DURATION_LONG = 450;
    public static final int NO_DELAY = 0;


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

    public static void crossFadeViews(View fadeIn, View fadeOut, int duration) {
        fadeIn(fadeIn, duration);
        fadeOut(fadeOut, duration);
    }
    public static void crossFadeViews(View fadeIn, View fadeOut, int duration, AnimationCallback callback) {
        fadeIn(fadeIn, duration, NO_DELAY, callback);
        fadeOut(fadeOut, duration);
    }
    public static void fadeOut(View fadeOut, int duration) {
        fadeOut(fadeOut, duration, null);
    }
    public static void fadeOut(final View fadeOut, int durationMs,
                               final AnimationCallback callback) {
        fadeOut.setAlpha(1);
        final ViewPropertyAnimator animator = fadeOut.animate();
        animator.cancel();
        animator.alpha(0).withLayer().setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                fadeOut.setVisibility(View.GONE);
                if (callback != null) {
                    callback.onAnimationEnd();
                }
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                fadeOut.setVisibility(View.GONE);
                fadeOut.setAlpha(0);
                if (callback != null) {
                    callback.onAnimationCancel();
                }
            }
        });
        if (durationMs != DEFAULT_DURATION) {
            animator.setDuration(durationMs);
        }
        animator.start();
    }
    public static void fadeIn(View fadeIn, int durationMs) {
        fadeIn(fadeIn, durationMs, NO_DELAY, null);
    }
    public static void fadeIn(final View fadeIn, int durationMs, int delay,
                              final AnimationCallback callback) {
        fadeIn.setAlpha(0);
        final ViewPropertyAnimator animator = fadeIn.animate();
        animator.cancel();
        animator.setStartDelay(delay);
        animator.alpha(1).withLayer().setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                fadeIn.setVisibility(View.VISIBLE);
            }
            @Override
            public void onAnimationCancel(Animator animation) {
                fadeIn.setAlpha(1);
                if (callback != null) {
                    callback.onAnimationCancel();
                }
            }
            @Override
            public void onAnimationEnd(Animator animation) {
                if (callback != null) {
                    callback.onAnimationEnd();
                }
            }
        });
        if (durationMs != DEFAULT_DURATION) {
            animator.setDuration(durationMs);
        }
        animator.start();
    }
    public static class AnimationCallback {
        public void onAnimationEnd() {}
        public void onAnimationCancel() {}
    }
}
