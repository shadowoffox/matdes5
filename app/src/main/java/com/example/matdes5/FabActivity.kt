package com.example.matdes5

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.animation.LinearInterpolator
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.ViewCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton

class FabActivity(context: Context?, attrs: AttributeSet?) :
    FloatingActionButton.Behavior(context, attrs) {

    override fun onNestedScroll(
        coordinatorLayout: CoordinatorLayout,
        child: FloatingActionButton,
        target: View,
        dxConsumed: Int,
        dyConsumed: Int,
        dxUnconsumed: Int,
        dyUnconsumed: Int,
        type: Int
    ) {
        super.onNestedScroll(coordinatorLayout,child,target,dxConsumed,dyConsumed,dxUnconsumed,dyUnconsumed,type)

        if (dyConsumed > 0){
            val layoutParams : CoordinatorLayout.LayoutParams
            layoutParams = child.layoutParams as CoordinatorLayout.LayoutParams
            val fabBottomMargin : Int = layoutParams.bottomMargin
            child.animate().translationX((child.width+fabBottomMargin).toFloat()).setInterpolator(LinearInterpolator()).start()
        } else if (dyConsumed<0) {
            child.animate().translationX(0F).setInterpolator(LinearInterpolator()).start()
        }

    }

    override fun onStartNestedScroll(
        coordinatorLayout: CoordinatorLayout,
        child: FloatingActionButton,
        directTargetChild: View,
        target: View,
        axes: Int,
        type: Int
    ): Boolean {
        return axes ==ViewCompat.SCROLL_AXIS_VERTICAL
    }
}