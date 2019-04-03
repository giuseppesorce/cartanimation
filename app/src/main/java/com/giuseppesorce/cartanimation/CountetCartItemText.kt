package com.giuseppesorce.cartanimation

import android.animation.Animator
import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.animation.ValueAnimator
import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.appcompat.widget.AppCompatTextView


/**
 * @author Giuseppe Sorce
 */
class CountetCartItemText : AppCompatTextView {

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    private var scaleAnimation: ObjectAnimator? = null
    private var bAnimation: Boolean = false

    fun setCount(countCart: Int) {
        if (countCart > 0) {
            this.visibility = View.VISIBLE
        }
        var lastNumber = Integer.parseInt(this.text.toString())

        if (countCart != lastNumber) {

            if (bAnimation) {
                setText(countCart.toString())
            }

            scaleAnimation = ObjectAnimator.ofPropertyValuesHolder(
                this,
                PropertyValuesHolder.ofFloat(View.SCALE_X, 1.9f),
                PropertyValuesHolder.ofFloat(View.SCALE_Y, 1.9f)

            )

            scaleAnimation?.repeatCount = 1
            scaleAnimation?.duration = 250
            scaleAnimation?.interpolator = AccelerateDecelerateInterpolator()
            scaleAnimation?.repeatMode = ValueAnimator.REVERSE
            scaleAnimation?.addListener(object : Animator.AnimatorListener {
                override fun onAnimationStart(animation: Animator) {
                }

                override fun onAnimationEnd(animation: Animator) {
                    bAnimation = false
                    text= countCart.toString()

                }

                override fun onAnimationCancel(animation: Animator) {

                }
                override fun onAnimationRepeat(animation: Animator) {
                    text=  countCart.toString()
                }
            })
            if (!bAnimation) {
                scaleAnimation?.start()
                bAnimation = true
            }
        }
    }
}