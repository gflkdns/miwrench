package com.miqt.miwrenchlib;

import android.animation.Animator;
import android.animation.RectEvaluator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.graphics.Rect;
import android.view.View;

public class MAnimUtils {
    /**
     * 以屏幕坐标为依据，从矩形1到矩形2的动画
     *
     * @param fromRect
     * @param toRect
     * @param taget
     * @param runnable
     */
    public void playAnim(Activity activity, final Rect fromRect, final Rect toRect, final View taget, final Runnable runnable) {
        final int sw = MScreenUtils.getScreenWidth(activity);
        final int sh = MScreenUtils.getScreenHeight(activity);
        ValueAnimator anim = ValueAnimator.ofObject(new RectEvaluator(), fromRect, toRect);
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Rect rect = (Rect) animation.getAnimatedValue();
                taget.setPadding(rect.left, rect.top, sw - rect.right, sh - rect.bottom);
            }
        });
        anim.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                if (runnable == null) {
                    return;
                }
                runnable.run();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        anim.setDuration(300);
        anim.start();
    }
}
