package cn.bloudidea.inspection.backend.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MeiziPic(
    @SerializedName("_id") override val id: String,
    @SerializedName("type") val type: String,
    @SerializedName("url") val url: String,
    @SerializedName("who") val who: String
) : WithId, Parcelable
