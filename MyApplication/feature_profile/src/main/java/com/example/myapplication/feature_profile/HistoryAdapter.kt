package com.example.myapplication.feature_profile

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.feature_profile.databinding.ItemHistoryBinding


// 1. Inherits from ListAdapter, which is efficient and uses DiffUtil automatically.
class HistoryAdapter : ListAdapter<String, HistoryAdapter.HistoryViewHolder>(HistoryDiffCallback()) {

    // 2. Called when the RecyclerView needs a brand-new row view.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        // 3. Inflate the item_history.xml layout file.
        val binding = ItemHistoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        // 4. Create a ViewHolder to hold onto the new row's views.
        return HistoryViewHolder(binding)
    }

    // 5. Called to display data in a specific row. This is called as you scroll.
    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        // 6. Get the data for this position.
        val item = getItem(position)
        // 7. Tell the ViewHolder to update its views with this data.
        holder.bind(item)
    }

    // 8. Holds the views for one row, avoiding expensive lookups.
    class HistoryViewHolder(private val binding: ItemHistoryBinding) : RecyclerView.ViewHolder(binding.root) {
        // 9. A helper function to set the text on the view.
        fun bind(historyItem: String) {
            binding.historyTextView.text = historyItem
        }
    }
}

// 10. The "brain" that tells ListAdapter how to calculate changes.
class HistoryDiffCallback : DiffUtil.ItemCallback<String>() {
    // 11. Are these the same item? (e.g., do they have the same ID?)
    override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }

    // 12. If they are the same item, has the content changed?
    override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }
}