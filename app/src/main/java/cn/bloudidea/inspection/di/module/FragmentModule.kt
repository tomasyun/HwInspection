package cn.bloudidea.inspection.di.module

import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import cn.bloudidea.inspection.di.FragmentScope
import cn.bloudidea.inspection.ui.message.MessageListAdapter
import cn.bloudidea.inspection.ui.message.MsgViewPagerAdapter
import dagger.Module
import dagger.Provides

@Module
class FragmentModule(private val fragment: Fragment) {

    @Provides
    @FragmentScope
    fun provideFragment(): Fragment = fragment

    @Provides
    fun provideMsgViewPagerAdapter(): MsgViewPagerAdapter =
        MsgViewPagerAdapter(fragment.childFragmentManager)

    @Provides
    fun provideMessageListAdapter(): MessageListAdapter =
        MessageListAdapter(fragment.activity!!, ArrayList())

    @Provides
    fun provideLinearLayoutManager(): LinearLayoutManager = LinearLayoutManager(fragment.context)
}