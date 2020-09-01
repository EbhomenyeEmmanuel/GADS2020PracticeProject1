package com.esq.gads2020practiceproject1.data

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.esq.gads2020practiceproject1.ui.LearningLeaderFragment
import com.esq.gads2020practiceproject1.ui.SkillFragment

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class SectionsPagerAdapter(fm: FragmentManager)
    : FragmentPagerAdapter(fm) {
    lateinit var fragment: Fragment
    private val title = arrayOf("Learning Leaders", "Skill IQ Leaders")
    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> fragment = LearningLeaderFragment.newInstance()
            1 -> fragment = SkillFragment.newInstance()
        }
        return fragment
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return title[position]
    }

    override fun getCount(): Int {
        return title.size
    }
}