package com.example.myclass

data class Student(
    val image: String = "",
    val nama: String = "",
    val nim: String = "",
    val ipk: Double = 0.0
)
{
    companion object {
        const val EXTRA_STUDENT_IMAGE = "student_img"
        const val EXTRA_STUDENT_NAMA = "student_name"
        const val EXTRA_STUDENT_NIM = "student_nim"
        const val EXTRA_STUDENT_IPK = "student_ipk"
    }
}
