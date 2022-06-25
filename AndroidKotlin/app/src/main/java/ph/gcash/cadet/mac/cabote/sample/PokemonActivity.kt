package ph.gcash.cadet.mac.cabote.sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import ph.gcash.cadet.mac.cabote.sample.adapter.NameAdapter
import ph.gcash.cadet.mac.cabote.sample.databinding.ActivityPokemonBinding

class PokemonActivity : AppCompatActivity() {
    private val LOG = "PokemonActivity"
    private var names = ArrayList<String>()
    private lateinit var binding: ActivityPokemonBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPokemonBinding.inflate((layoutInflater))
        setContentView(binding.root)

        init()
        var recyclerViewAdapter = NameAdapter(applicationContext, names)
        binding.recyclerviewList.adapter = recyclerViewAdapter

        //Linear Layout
        binding.recyclerviewList.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)

        //GridLayout
        //binding.recyclerView.layoutManager = GridLayoutManager(applicationContext, 3)


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

    fun init(){
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
    }
}