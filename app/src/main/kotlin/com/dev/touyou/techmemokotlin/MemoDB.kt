package com.dev.touyou.techmemokotlin

/**
 * Created by touyou on 16/07/21.
 */

import com.activeandroid.Model
import com.activeandroid.annotation.Column
import com.activeandroid.annotation.Table


@Table(name = "memo_table")
class MemoDB : Model() {

    @Column(name = "title")
    var title: String = ""

    @Column(name = "memo")
    var memo: String = ""

    @Column(name = "date")
    var date: String = ""

    override fun toString(): String {
        return title
    }
}