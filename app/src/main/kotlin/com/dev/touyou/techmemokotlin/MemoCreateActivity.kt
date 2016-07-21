package com.dev.touyou.techmemokotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import java.text.SimpleDateFormat
import java.util.*

class MemoCreateActivity : AppCompatActivity() {

    var mMemoDB: MemoDB? = null
    var mTitle: EditText? = null
    var mMemo: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_memo_create)

        mTitle = findViewById(R.id.create_title) as EditText
        mMemo = findViewById(R.id.create_memo) as EditText
        mMemoDB = MemoDB()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_memo_create, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item?.itemId

        if (R.id.create_save == id) {
            saveMemo()
            finish()

            return true
        }

        return super.onOptionsItemSelected(item)
    }

    fun saveMemo() {
        mMemoDB?.title = mTitle?.text as String
        mMemoDB?.memo = mMemo?.text as String
        val date = Date()
        val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.JAPANESE)
        mMemoDB?.date = sdf.format(date)
        mMemoDB?.save()
    }
}
