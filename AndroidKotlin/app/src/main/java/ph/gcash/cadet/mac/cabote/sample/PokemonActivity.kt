package ph.gcash.cadet.mac.cabote.sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import ph.gcash.cadet.mac.cabote.sample.adapter.NameAdapter
import ph.gcash.cadet.mac.cabote.sample.api.PokemonAPI
import ph.gcash.cadet.mac.cabote.sample.api.PokemonAPIClient
import ph.gcash.cadet.mac.cabote.sample.databinding.ActivityPokemonBinding
import ph.gcash.cadet.mac.cabote.sample.model.PokemonListResponse
import ph.gcash.cadet.mac.cabote.sample.model.PokemonURL
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PokemonActivity : AppCompatActivity() {
    private val LOG = "PokemonActivity"
    private var names = ArrayList<PokemonURL>()
    private lateinit var binding: ActivityPokemonBinding
    private lateinit var itemTouchHelper: ItemTouchHelper
    private lateinit var recyclerViewAdapter: NameAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPokemonBinding.inflate((layoutInflater))
        setContentView(binding.root)

        init()
        recyclerViewAdapter = NameAdapter(applicationContext, names)
        binding.recyclerviewList.adapter = recyclerViewAdapter

        //Linear Layout
        binding.recyclerviewList.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)

        var swipeCallback = SwipeCallback(0,ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT)
        swipeCallback.nameAdapter = recyclerViewAdapter
        itemTouchHelper = ItemTouchHelper(swipeCallback)
        itemTouchHelper.attachToRecyclerView(binding.recyclerviewList)


        /*
            var username = intent.getStringExtra("username")
            var bundle = intent.extras
            var bundleData = bundle?.getString("bundle_string")


            Log.d(LOG,"username: $username")
            Log.i(LOG,"Bundle Data : $bundleData")
            Log.w(LOG,"Bundle Data : $bundleData")
            Log.e(LOG,"Bundle Data : $bundleData")
        */

    }

    fun init() {
        /*
        names.add("Bernabe")
        names.add("Louie")
        names.add("Densel")
        names.add("Enzo")
        names.add("Francis")
        names.add("Arthur")
        names.add("Angela")
        names.add("Regina")
        names.add("Renz J")
        names.add("Celso")
         */

        val call: Call<PokemonListResponse> =
            PokemonAPIClient.getPokemonData.getList(0,100)

        call.enqueue(object : Callback<PokemonListResponse> {
            override fun onFailure(call: Call<PokemonListResponse>, t: Throwable) {
                Log.d("API CALL", "Failed API Call")
            }

            override fun onResponse(
                call: Call<PokemonListResponse>,
                response: Response<PokemonListResponse>
            ) {
                var response: PokemonListResponse = response!!.body()!!

                recyclerViewAdapter.setNames(response.pokemonList)

//                var pokelist = response.pokemonList
//                for(pokemon in pokelist) {
//                    Log.d("API CALL", pokemon.name)
//                }
            }
        })
    }
}