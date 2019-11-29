package cn.bloudidea.inspection.ui.pic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import cn.bloudidea.inspection.R
import cn.bloudidea.inspection.base.BaseFragment
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_pic.*

class PicFragment : BaseFragment() {
    private val vm by lazy {
        getViewModel(PicViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_pic, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        vm.liveDataPic.observe(this, Observer {
            Picasso.get().load(it.url).centerCrop().fit().into(imageView)
        })
    }
}
