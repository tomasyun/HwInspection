package com.yinghuo.highway.ui.pic

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.yhsoft.highway.backend.api.PicApi
import com.yhsoft.highway.backend.model.MeiziPic
import com.yinghuo.highway.base.BaseViewModel
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class PicViewModel @Inject constructor(
    private val picApi: PicApi
) : BaseViewModel() {
    val liveDataPic: LiveData<MeiziPic> = MutableLiveData()

    init {
        fetchOnePic()
    }

    private fun fetchOnePic() {
        liveDataPic as MutableLiveData
        picApi.getMeiziPics(1, (1..10).random())
            .subscribeOn(Schedulers.io())
            .autoDisposable()
            .subscribe { response ->
                liveDataPic.postValue(response.results[0])
            }
    }
}
