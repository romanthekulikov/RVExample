package com.example.rv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rv.databinding.ItemFirstBinding
import com.example.rv.databinding.ItemSecondBinding

class ExampleRecyclerView(private val data: List<ViewData>) : RecyclerView.Adapter<ExampleRecyclerView.ExampleSealedHolder>() {
    sealed class ExampleSealedHolder(view: View) : RecyclerView.ViewHolder(view) {
        abstract fun bind(data: ViewData)
        class FirstHolder(private val binding: ItemFirstBinding) : ExampleSealedHolder(binding.root) {
            override fun bind(data: ViewData) {
                if (data !is FirstData) throw RuntimeException("Invalid data type for FirstHolder")
                binding.textView.text = data.text
            }
        }

        class SecondHolder(private val binding: ItemSecondBinding) : ExampleSealedHolder(binding.root) {
            override fun bind(data: ViewData) {
                if (data !is SecondData) throw RuntimeException("Invalid data type for SecondHolder")
                binding.textView.text = data.text
                binding.switchCompat.isChecked = data.switched
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleSealedHolder {
        return when (viewType) {
            ExampleRVItems.FIRST.viewType ->
                ExampleSealedHolder.FirstHolder(ItemFirstBinding.inflate(LayoutInflater.from(parent.context), parent, false))

            ExampleRVItems.SECOND.viewType ->
                ExampleSealedHolder.SecondHolder(ItemSecondBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            else -> throw RuntimeException("Invalid holder type")
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ExampleSealedHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemViewType(position: Int): Int {
        return data[position].viewType.viewType
    }
}