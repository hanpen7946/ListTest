package com.example.listtest

import android.content.Context
import android.graphics.Color
import android.graphics.Paint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*


class CustomAdapter(context: Context, var Memolist: List<MemoData>) : ArrayAdapter<MemoData>(context, 0, Memolist) {
    private val layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        //タップされたアイテムを格納
        val memo = Memolist[position]

        //レイアウトの設定
        var view = convertView
        if(convertView == null) {
            view = layoutInflater.inflate(R.layout.custom_list, parent, false)
        }

        //各ビューの設定
        val title = view?.findViewById<TextView>(R.id.MemoTitle)
        title?.text = memo.title

        val checkBox = view?.findViewById<CheckBox>(R.id.CheckBox)
        checkBox?.setOnClickListener{
            if(checkBox.isChecked == true) {
                title?.paint?.flags = Paint.STRIKE_THRU_TEXT_FLAG
                title?.setTextColor(Color.GRAY)
            } else{
                title?.paint?.flags = Paint.ANTI_ALIAS_FLAG
                title?.setTextColor(Color.BLACK)
            }
            updateMemoList(Memolist)
        }

        val category = view?.findViewById<ImageButton>(R.id.Category)
        category?.setImageResource(memo.category)

        return view!!
    }

    //リスト更新用の関数を実装
    fun updateMemoList(memoList: List<MemoData>){
        Memolist = memoList
        //再描画
        notifyDataSetChanged()
    }
}