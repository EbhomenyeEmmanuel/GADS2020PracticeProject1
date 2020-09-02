package com.esq.gads2020practiceproject1.data

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.esq.gads2020practiceproject1.R
import com.esq.gads2020practiceproject1.domain.SkillDataModel
import kotlinx.android.synthetic.main.content_skill_item_list.view.*

class SkillAdapter(private val context: Context, private val items: List<SkillDataModel>) : RecyclerView.Adapter<SkillAdapter.ItemViewHolder>() {

    companion object {
        private val TAG = this::class.java.simpleName
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder =
        ItemViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.content_skill_item_list, parent,
                false
            )
        )

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(items[position])
    }

    inner class ItemViewHolder(private val view: View) :
        RecyclerView.ViewHolder(view) {
        fun bind(skillDataModel: SkillDataModel) {
            Log.d(TAG, "Item is $skillDataModel")
            with(skillDataModel) {
                view.tvName.text = name
                view.tvIq.text = iq
            }
        }
    }

}