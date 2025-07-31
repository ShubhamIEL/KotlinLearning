package com.example.myapplication.feature_profile
//
//import android.view.LayoutInflater
//import android.view.ViewGroup
//import androidx.recyclerview.widget.DiffUtil
//import androidx.recyclerview.widget.ListAdapter
//import androidx.recyclerview.widget.RecyclerView
//import com.example.myapplication.feature_profile.databinding.ItemHistoryBinding
//
//class HistoryAdapter : ListAdapter<String, HistoryAdapter.HistoryViewHolder>(HistoryDiffCallback()) {
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
//        val binding = ItemHistoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//        return HistoryViewHolder(binding)
//    }
//
//    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
//        val item = getItem(position)
//        holder.bind(item)
//    }
//
//    class HistoryViewHolder(private val binding: ItemHistoryBinding) : RecyclerView.ViewHolder(binding.root) {
//        fun bind(historyItem: String) {
//            binding.historyTextView.text = historyItem
//        }
//    }
//}
//
//class HistoryDiffCallback : DiffUtil.ItemCallback<String>() {
//    override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
//        return oldItem == newItem
//    }
//
//    override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
//        return oldItem == newItem
//    }
//}