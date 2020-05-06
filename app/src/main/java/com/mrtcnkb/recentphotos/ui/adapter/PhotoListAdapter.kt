package com.mrtcnkb.recentphotos.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.mrtcnkb.recentphotos.R
import com.mrtcnkb.recentphotos.databinding.RowPhotoBinding
import com.mrtcnkb.recentphotos.util.ItemClickListener
import com.muratcan.model.remote.Photo
import hari.bounceview.BounceView

/**
 * Created by MuratCan on 6.05.2020.
 */
class PhotoListAdapter(private val listener: ItemClickListener): RecyclerView.Adapter<PhotoListAdapter.PhotoListViewHolder>() {
    private var photos: MutableList<Photo> = mutableListOf()
    private var lastPosition = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoListViewHolder {
        parent.inflate<RowPhotoBinding>(R.layout.row_photo, false).run { return PhotoListViewHolder(this) }
    }

    override fun getItemCount(): Int = photos.size

    override fun onBindViewHolder(holder: PhotoListViewHolder, position: Int) {
        holder.bind(position)
        BounceView.addAnimTo(holder.itemView).setScaleForPopOutAnim(1f, 0f)
        setAnimation(holder.itemView, position)
    }

    private fun setAnimation(viewToAnimate: View, position: Int) {
        if (position > lastPosition) {
            val animation = AnimationUtils.loadAnimation(viewToAnimate.context, android.R.anim.slide_in_left)
            animation.duration = 300
            viewToAnimate.startAnimation(animation)
            lastPosition = position
        }
    }

    fun clearList() {
        photos.clear()
        notifyDataSetChanged()
    }

    fun setPostItemList(list: List<Photo>) {
        val beforeSize = photos.size
        photos.addAll(list)
        notifyItemRangeInserted(beforeSize, list.size)
    }

    inner class PhotoListViewHolder(private val binding: RowPhotoBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(position: Int) {
            binding.apply {
                photo = photos[position]
                root.setOnClickListener {
                    listener.onItemClick(it, photos[position])
                }
            }
        }
    }

    private fun <T : ViewDataBinding> ViewGroup?.inflate(@LayoutRes layoutId: Int, attachToParent: Boolean = true): T {
        return DataBindingUtil.inflate(LayoutInflater.from(this!!.context), layoutId, this, attachToParent)
    }


}