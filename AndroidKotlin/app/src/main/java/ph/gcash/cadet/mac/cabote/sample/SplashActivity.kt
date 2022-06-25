package ph.gcash.cadet.mac.cabote.sample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ph.gcash.cadet.mac.cabote.sample.databinding.ActivityMainBinding
import ph.gcash.cadet.mac.cabote.sample.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate((layoutInflater))
        setContentView(binding.root)

        binding.appcompatbuttonProceed.setOnClickListener{
            var goToPokemonActivity = Intent(this, PokemonActivity::class.java)
            //an intent can identify an action

            goToPokemonActivity.putExtra("username", "Extra Data")

            //passing data from one activity to another
            var bundle = Bundle()
            bundle.putString("bundle_string", "bundle string")
            goToPokemonActivity.putExtras(bundle)

            startActivity(goToPokemonActivity)
            finish()
        }
    }
}