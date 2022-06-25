package ph.gcash.cadet.mac.cabote.sample.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import ph.gcash.cadet.mac.cabote.sample.databinding.ItemNameBinding

class NameAdapter(
    private val context: Context,
    private var names: ArrayList<String>
) : RecyclerView.Adapter<NameAdapter.NameViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NameViewHolder {
        val itemBinding = ItemNameBinding
            .inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        return NameViewHolder(itemBinding)
    }

    override fun getItemCount() = names.size

    override fun onBindViewHolder(holder: NameAdapter.NameViewHolder, position: Int) {
        holder.bindItems(names[position])
    }

    inner class NameViewHolder(private val itemBinding: ItemNameBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bindItems(data: String) {
            if(adapterPosition % 2 == 0){
                itemBinding.root.setBackgroundColor(Color.LTGRAY)
            }
            itemBinding.textviewName.text = data

            itemBinding.root.setOnClickListener{
                Snackbar.make(itemBinding.root, "clicked : $data", Snackbar.LENGTH_SHORT).show()
            }

            itemBinding.buttonName.setOnClickListener{
                Snackbar.make(itemBinding.root, "CALLING: $data", Snackbar.LENGTH_SHORT).show()
            }
        }
    }

}