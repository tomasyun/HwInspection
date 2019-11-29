package cn.bloudidea.inspection.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import cn.bloudidea.inspection.R
import cn.bloudidea.inspection.base.BaseFragment
import cn.bloudidea.inspection.ui.AcceptanceActivity
import cn.bloudidea.inspection.ui.InspectListActivity
import cn.bloudidea.inspection.ui.StatisticsActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : BaseFragment() {
    private val vm by lazy { getViewModel(HomeViewModel::class.java) }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvHomeTitle.text = "首页"
        bannerHome.setAdapter { _, itemView, model, _ ->
            if (model is Int && itemView is ImageView) {
                Picasso.get().load(model).placeholder(R.mipmap.ic_image_pick_no_media)
                    .error(R.mipmap.ic_image_pick_no_media).centerCrop().fit().into(itemView)
            }
        }
        val urls: MutableList<Int> = ArrayList()
        urls.add(R.mipmap.ic_bn_first)
        urls.add(R.mipmap.ic_bn_second)
        urls.add(R.mipmap.ic_bn_third)
        urls.add(R.mipmap.ic_bn_forth)
        urls.add(R.mipmap.ic_bn_fifth)
        urls.add(R.mipmap.ic_bn_sixth)
        urls.add(R.mipmap.ic_bn_seventh)
        urls.add(R.mipmap.ic_bn_eighth)
        val tips: MutableList<String> = ArrayList()
        tips.add("")
        tips.add("")
        tips.add("")
        tips.add("")
        tips.add("")
        tips.add("")
        tips.add("")
        tips.add("")
        bannerHome.setData(urls.toList(), tips.toList())

        dailyInspect.setOnClickListener {
            startActivity(
                Intent(
                    activity,
                    InspectListActivity::class.java
                ).putExtra("skip", 0)
            )
        }
        expertInspect.setOnClickListener {
            startActivity(
                Intent(
                    activity,
                    InspectListActivity::class.java
                ).putExtra("skip", 1)
            )
        }
        selfInspect.setOnClickListener {
            startActivity(
                Intent(
                    activity,
                    InspectListActivity::class.java
                ).putExtra("skip", 2)
            )
        }
        acceptanceInspect.setOnClickListener {
            startActivity(
                Intent(
                    activity,
                    AcceptanceActivity::class.java
                )
            )
        }
        statisticsInspect.setOnClickListener {
            startActivity(
                Intent(
                    activity,
                    StatisticsActivity::class.java
                )
            )
        }
    }
}
