package com.example.lat10

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myclass.DetailActivity
import com.example.myclass.R
import com.example.myclass.Student
import com.example.myclass.databinding.ItemMyclassBinding

typealias OnClickStudent = (Student) -> Unit
class StudentAdapter(private val listStudent: List<Student>,
                        private val onClickStudent: OnClickStudent) :
    RecyclerView.Adapter<StudentAdapter.ItemStudentViewHolder>() {

    inner class ItemStudentViewHolder (private val
                                          binding: ItemMyclassBinding
    ):
        RecyclerView.ViewHolder(binding.root){
        fun bind(data : Student) {
            with(binding){
                val imageData = itemView.context.resources.getIdentifier(data.image, "drawable", itemView.context.packageName)
                fotoMhs.setImageResource(imageData)
                namaMhsTxt.text = data.nama
                nimMhsTxt.text = data.nim
                ipkTxt.text = data.ipk.toString()

                if(data.ipk < 3.0) {
                    ipkTxt.setBackgroundColor(itemView.context.getColor(R.color.red))
                } else {
                    ipkTxt.setBackgroundColor(itemView.context.getColor(R.color.green))
                }

                itemView.setOnClickListener{
                    onClickStudent(data)
                    val intentToDetail = Intent(itemView.context, DetailActivity::class.java).apply {
                        putExtra(Student.EXTRA_STUDENT_IMAGE, data.image)
                        putExtra(Student.EXTRA_STUDENT_NAMA, data.nama)
                        putExtra(Student.EXTRA_STUDENT_NIM, data.nim)
                        putExtra(Student.EXTRA_STUDENT_IPK, data.ipk)
                    }
                    itemView.context.startActivity(intentToDetail)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemStudentViewHolder {
        val binding = ItemMyclassBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemStudentViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listStudent.size
    }

    override fun onBindViewHolder(holder: ItemStudentViewHolder, position: Int) {
        holder.bind(listStudent[position])
    }

}