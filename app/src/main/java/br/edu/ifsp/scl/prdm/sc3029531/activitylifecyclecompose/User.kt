package br.edu.ifsp.scl.prdm.sc3029531.activitylifecyclecompose

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    var name: String = "",
    var age: Int = 0
): Parcelable
