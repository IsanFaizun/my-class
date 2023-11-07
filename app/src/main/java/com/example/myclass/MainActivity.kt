package com.example.myclass

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lat10.StudentAdapter
import com.example.myclass.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapterStudent = StudentAdapter(generateStudents()){
            student ->  Toast.makeText(this@MainActivity, "You clicked on ${student.nama}", Toast.LENGTH_SHORT).show()
        }

        with(binding){
            rvMyClass.apply {
                adapter = adapterStudent
                layoutManager = LinearLayoutManager(this@MainActivity)
            }
        }
    }
    fun generateStudents():List<Student> {
        return listOf(
            Student(image = "ana", nama = "Ana", nim = "22/111111/SV/00001", ipk = 3.6),
            Student(image = "budi", nama = "Budi", nim = "22/222222/SV/00002", ipk = 2.5),
            Student(image = "caca", nama = "Caca", nim = "22/333333/SV/00003", ipk = 3.1),
            Student(image = "dani", nama = "Dani", nim = "22/444444/SV/00004", ipk = 2.2),
            Student(image = "emi", nama = "Emi", nim = "22/555555/SV/00005", ipk = 2.4),
            Student(image = "fahmi", nama = "Fahmi", nim = "22/666666/SV/00006", ipk = 3.7),
        )
    }
}