package com.example.example_unlock

import android.widget.ImageView

class LockModel {
    //保存所有的模型对象
    private val modelArray = arrayListOf<Model>()

    fun addModel(array:ArrayList<ImageView>,normal:Int,error:Int){
        array.forEach {modelArray.add(Model(it, R.drawable.dot_normal, R.drawable.dot_selected)) }
    }

    fun getModels():ArrayList<Model> {return modelArray}
}