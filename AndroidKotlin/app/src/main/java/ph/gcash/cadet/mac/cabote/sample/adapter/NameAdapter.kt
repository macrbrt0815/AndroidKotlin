package ph.gcash.cadet.mac.cabote.sample.adapter

import android.content.Context
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import ph.gcash.cadet.mac.cabote.sample.api.PokemonAPIClient
import ph.gcash.cadet.mac.cabote.sample.databinding.ItemNameBinding
import ph.gcash.cadet.mac.cabote.sample.model.PokemonInfoResponse
import ph.gcash.cadet.mac.cabote.sample.model.PokemonURL
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NameAdapter(
    private val context: Context,
    private var names: ArrayList<PokemonURL>
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

    fun removeName(position: Int){
        names.removeAt(position)
        notifyItemRemoved(position)
        notifyDataSetChanged()
    }

    fun setNames(newNames:ArrayList<PokemonURL>){
        names.clear()
        names.addAll(newNames)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: NameAdapter.NameViewHolder, position: Int) {
        holder.bindItems(names[position])
    }



    inner class NameViewHolder(private val itemBinding: ItemNameBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bindItems(data: PokemonURL) {
            if(adapterPosition % 2 == 0){
                itemBinding.root.setBackgroundColor(Color.LTGRAY)
            }
            itemBinding.textviewName.text = data.name

            itemBinding.root.setOnClickListener{
                Snackbar.make(itemBinding.root, "clicked : $data", Snackbar.LENGTH_SHORT).show()
            }

            itemBinding.buttonName.setOnClickListener{
                Snackbar.make(itemBinding.root, "CALLING: $data", Snackbar.LENGTH_SHORT).show()

                getData(data.url.getPokemonID())
            }
        }
    }

    private fun getData(id: Int){
        val call: Call<PokemonInfoResponse> = PokemonAPIClient.getPokemonData.getPokemonInfo(id)

        call.enqueue(object : Callback<PokemonInfoResponse> {
            override fun onFailure(call: Call<PokemonInfoResponse>, t: Throwable) {
            }

            override fun onResponse(
                call: Call<PokemonInfoResponse>,
                response: Response<PokemonInfoResponse>
            ) {
                val response: PokemonInfoResponse = response.body()!!
                Log.d("API Pokemon CALL", "${response.sprites.frontDefault}")
                Log.d("API PokemonCAll", response.name)
            }
        })
    }
}

fun String.getPokemonID() : Int{
    var value = this.toString()
    val id = value.substring(34, value.length-1)
    return id.toInt()
}