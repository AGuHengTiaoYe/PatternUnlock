package com.example.example_unlock

import android.widget.ImageView

class ViewModel(
    val view: ImageView,
    val normalResId: Int,
    val errorResId: Int
) {
    fun changeImage(isNormal:Boolean){
        if (isNormal){
            view.setImageResource(normalResId)
        }else{
            view.setImageResource(errorResId)
        }
    }
}