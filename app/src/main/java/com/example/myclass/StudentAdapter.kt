package com.example.lat10

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
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

                itemView.setOnClickListener{
                    onClickStudent(data)
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