package com.example.example_unlock

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.MotionEvent
import android.view.View
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.example_unlock.databinding.ActivityMainBinding

//add gesture-unlock
class MainActivity : AppCompatActivity(),ILock {

    //创建presenter
    private val presenter:LockPresenter = LockPresenter(this)

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //创建绑定类对象
        val binding = ActivityMainBinding.inflate(layoutInflater)
        //将绑定类里面的view设置给activity
        setContentView(binding.root)
        presenter.initData(binding);
        //找到容器
        val container = findViewById<ConstraintLayout>(R.id.container)
        //获取九个点的视图
        container.findViewWithTag<ImageView>("1")
        //给容器添加触摸事件
        binding.container.setOnTouchListener { v, event ->
            event.x
            event.y
            when (event.action) {
                MotionEvent.ACTION_DOWN -> presenter.touchdown(event.x,event.y)
                MotionEvent.ACTION_MOVE ->  presenter.touchmove(event.x,event.y)
                MotionEvent.ACTION_UP -> presenter.touchup(event.x,event.y)
            }
            true
        }
    }



}
