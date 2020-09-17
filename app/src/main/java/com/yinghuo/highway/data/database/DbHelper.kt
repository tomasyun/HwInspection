package com.yinghuo.highway.data.database

import io.reactivex.Observable
interface DbHelper {
    fun getAllUsers(): Observable<ArrayList<User>>
    fun insertUser(user: User): Observable<Boolean>
}