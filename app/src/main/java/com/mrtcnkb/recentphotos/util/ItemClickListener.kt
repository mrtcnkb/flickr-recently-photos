package com.mrtcnkb.recentphotos.util

import android.view.View
import com.muratcan.model.remote.Photo

/**
 * Created by MuratCan on 6.05.2020.
 */
interface ItemClickListener {
    fun onItemClick(view: View, photo: Photo)
}