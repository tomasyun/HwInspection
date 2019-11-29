package cn.bloudidea.inspection.backend.model.wrapper

import com.google.gson.annotations.SerializedName

data class GankIoResponse<T>(
    @SerializedName("error") val error: Boolean,
    @SerializedName("results") val results: List<T>
)
