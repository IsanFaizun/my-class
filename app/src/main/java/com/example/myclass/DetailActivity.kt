package com.example.myclass

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myclass.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val studentImage = intent.getStringExtra(Student.EXTRA_STUDENT_IMAGE)
        val studentName = intent.getStringExtra(Student.EXTRA_STUDENT_NAMA)
        val studentNim = intent.getStringExtra(Student.EXTRA_STUDENT_NIM)
        val studentIPK = intent.getDoubleExtra(Student.EXTRA_STUDENT_IPK, 0.0)

        with(binding){
            val fotoDetail = resources.getIdentifier(studentImage, "drawable", packageName)
            detailFoto.setImageResource(fotoDetail)
            detailNama.text = studentName
            detailNim.text = studentNim
            detailIpk.text = studentIPK.toString()

            btnBack.setOnClickListener {
                finish()
            }
        }
    }
}