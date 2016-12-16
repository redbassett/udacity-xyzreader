package com.example.xyzreader.ui;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.util.AttributeSet;
import android.view.View;

/**
 * Based on code from
 * https://newfivefour.com/android-coordinatorlayout-scrolling-hide-fab-behavior.html
 */

public class ScrollAwareFabBehavior extends CoordinatorLayout.Behavior<FloatingActionButton> {
    public ScrollAwareFabBehavior(Context context, AttributeSet attrs) {
        super();
    }

    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout,
                                       final FloatingActionButton child,
                                       final View directChildTarget, final View target,
                                       final int nestedScrollAxes) {
        return true;
    }

    @Override
    public void onNestedScroll(final CoordinatorLayout coordinatorLayout,
                               final FloatingActionButton child, final View target,
                               final int dxConsumed, final int dyConsumed,
                               final int dxUnconsumed, final int dyUnconsumed) {
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed,
                dyUnconsumed);

        if (dyConsumed > 0 && child.getVisibility() == View.VISIBLE)
            child.hide();
        else if (dyConsumed < 0 && child.getVisibility() != View.VISIBLE)
            child.show();
    }
}
