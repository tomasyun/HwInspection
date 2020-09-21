package com.yinghuo.highway.util

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import java.util.concurrent.TimeUnit

class RxTimerUtils {
    companion object {
        var mDisposable: Disposable? = null

        /**
         * 执行定时任务
         */
        fun timer(block: (t: Long) -> Unit,complete: () -> Unit, interval: Long,total:Int) {
            Observable.interval(interval, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<Long> {
                    override fun onError(e: Throwable) {}
                    override fun onComplete() {
                        complete()
                        cancel()
                    }

                    override fun onNext(t: Long) {
                        val count:Int=total-t.toInt();
                        block(count.toLong());
                        if (count==0){
                            complete()
                            cancel()
                        }
                    }

                    override fun onSubscribe(d: Disposable) {
                        mDisposable = d
                    }
                })
        }

        /**
         * 取消定时器
         */
        fun cancel() {
            if (mDisposable != null && !mDisposable!!.isDisposed) {
                mDisposable!!.dispose()
            }
        }
    }
}