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
            Student(image = "ic_person", nama = "Ana", nim = "22/111111/SV/00001", ipk = 3.6),
            Student(image = "ic_person", nama = "Ana", nim = "22/111111/SV/00001", ipk = 3.6),
            Student(image = "ic_person", nama = "Ana", nim = "22/111111/SV/00001", ipk = 3.6),
            Student(image = "ic_person", nama = "Ana", nim = "22/111111/SV/00001", ipk = 3.6),
            Student(image = "ic_person", nama = "Ana", nim = "22/111111/SV/00001", ipk = 3.6),
        )
    }
}