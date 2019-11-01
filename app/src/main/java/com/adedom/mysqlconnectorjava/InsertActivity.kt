package com.adedom.mysqlconnectorjava

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.adedom.library.Dru
import com.adedom.library.ExecuteUpdate
import kotlinx.android.synthetic.main.activity_insert.*

class InsertActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insert)

        mBtnInsert.setOnClickListener {
            when {
                Dru.isEmpty(mEdtName, "abc") -> return@setOnClickListener
                Dru.isEmpty(mEdtPrice, "456") -> return@setOnClickListener
                Dru.isEmpty(mEdtType, "123") -> return@setOnClickListener
            }

            Dru.with(MainActivity().conn)
                .call("sp_insert_product")
                .parameter(mEdtName.text.toString().trim())
                .parameter(mEdtPrice.text.toString().trim())
                .parameter(mEdtType.text.toString().trim())
                .commit(ExecuteUpdate {
                    mEdtName.text.clear()
                    mEdtPrice.text.clear()
                    mEdtType.text.clear()
                    Dru.completed(baseContext)
                })
        }
    }
}