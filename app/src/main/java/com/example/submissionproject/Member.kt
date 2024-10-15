package com.example.submissionproject

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Member(
    val name: String,
    val description: String,
    val photo: String
):Parcelable