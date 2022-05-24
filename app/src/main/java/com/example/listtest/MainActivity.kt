package com.example.listtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.example.listtest.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var mCustomAdapter: CustomAdapter
    lateinit var mMemoData: ArrayList<MemoData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val egg = MemoData("卵",R.drawable.ic_egg)
        val fish = MemoData("肉",R.drawable.ic_fish)
        val ai = MemoData("ひき肉",R.drawable.ic_meat)
        val a = MemoData("ひき肉",R.drawable.ic_meat)
        val aa = MemoData("ひき肉",R.drawable.ic_meat)
        val  b= MemoData("ひき肉",R.drawable.ic_meat)
        val  bb= MemoData("ひき肉",R.drawable.ic_meat)

        mMemoData = arrayListOf(egg,fish,ai,a,aa,b,bb)

        val listView = findViewById<ListView>(R.id.MemoList)

        //カスタムアダプターの生成と設定
        mCustomAdapter = CustomAdapter(this, mMemoData)
        listView.adapter = mCustomAdapter
    }
}
