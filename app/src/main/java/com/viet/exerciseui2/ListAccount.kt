package com.viet.exerciseui2

import android.provider.ContactsContract

var acc = Account("email", "password")
const val REQUEST_CODE_SING_UP = 0x9345

fun addAccount(account: Account) {
    acc = account
}

fun checkAccount(account: Account): Boolean {
    if (acc == account)
        return true
    return false
}

fun updatePassword() {
    acc.password = "123"
}
