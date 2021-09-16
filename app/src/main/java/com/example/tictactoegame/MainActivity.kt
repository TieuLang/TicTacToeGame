package com.example.tictactoegame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.ViewGroup
import android.widget.*


class MainActivity : AppCompatActivity() {

    private var arr: Array<Array<Button?>> =Array(3) { Array(3) { null } }
    private var tb:Array<TableRow?> = Array(3) { null }
    private var kt:Array<Array<Int?>> =Array(3) { Array(3) { null } }
    private var stt:Int=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val ll:TableLayout=findViewById(R.id.tb_screen)
        for (i in 0..2 step 1)
        {
            tb[i]=TableRow(this)
            ll.addView(tb[i])
            tb[i]?.layoutParams?.width=ViewGroup.LayoutParams.MATCH_PARENT
            tb[i]?.layoutParams?.height=ViewGroup.LayoutParams.MATCH_PARENT
            tb[i]?.gravity=Gravity.CENTER
        }
        for (i in 0..2 step 1)
            for (j in 0..2 step 1)
            {
                kt[i][j]=0

                arr[i][j]=Button(this)
                arr[i][j]?.gravity=Gravity.CENTER
                Log.d("Size4 ",arr[i][j]?.layoutParams?.width.toString()+" "+arr[i][j]?.layoutParams?.height.toString())
                arr[i][j]?.layoutParams?.width=50
                arr[i][j]?.layoutParams?.height=50
                Log.d("Size5 ",arr[i][j]?.layoutParams?.width.toString()+" "+arr[i][j]?.layoutParams?.height.toString())
                tb[i]?.addView(arr[i][j])

                arr[i][j]?.setBackgroundResource(R.color.black)

                arr[i][j]?.id=i*3+j
//                Log.d("Size2 ",arr[i][j]?.layoutParams?.width.toString()+" "+arr[i][j]?.layoutParams?.height.toString())
//                Log.d("Size1 ",arr[i][j]?.width.toString()+" "+arr[i][j]?.height.toString())
                arr[i][j]?.setOnClickListener{btnclick(i*3+j,i,j)}
            }
    }

    private fun btnclick(d:Int,i:Int,j:Int) {
        val btn:Button=findViewById(d)
        if (this.kt[i][j]==0) {
            if (stt==0)
            {
                kt[i][j]=1
                btn.setBackgroundResource(R.color.red)
            } else {
                kt[i][j]=2
                btn.setBackgroundResource(R.color.cyan)
            }
            stt=(stt+1)%2
        }
        Log.d("click",i.toString()+" "+j.toString()+" "+kt[i][j].toString())
        Log.d("Size",arr[i][j]?.width.toString()+" "+arr[i][j]?.height.toString())
        Log.d("Size3 ",arr[i][j]?.layoutParams?.width.toString()+" "+arr[i][j]?.layoutParams?.height.toString())

    }

}