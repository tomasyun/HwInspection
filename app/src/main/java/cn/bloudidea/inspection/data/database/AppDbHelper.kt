package cn.bloudidea.inspection.data.database

import io.reactivex.Observable
import javax.inject.Inject

class AppDbHelper @Inject constructor(private val appDatabase: AppDatabase) : DbHelper {
    override fun getAllUsers(): Observable<ArrayList<User>> =
        Observable.fromCallable { appDatabase.userDao()?.loadAll() as ArrayList<User>? }

    override fun insertUser(user: User): Observable<Boolean> =
        Observable.fromCallable {
            appDatabase.userDao()?.insert(user)
            true
        }
}