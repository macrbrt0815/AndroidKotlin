package ph.gcash.cadet.mac.cabote.sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import ph.gcash.cadet.mac.cabote.sample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //binding removes the need to declare and find elements by ID
        //can directly access and manipulate elemets
        binding = ActivityMainBinding.inflate((layoutInflater))
        setContentView(binding.root)

        /*
        setContentView(R.layout.activity_main)

        var text_message = findViewById<TextView>(R.id.text_message)
        text_message.text = "GCASH"
        */

        //binding.textMessage.text = "View Binding"

        //static assignment
        binding.buttonSubmit.setOnClickListener{
            Toast.makeText(applicationContext, "message", Toast.LENGTH_SHORT).show()
        }

        //dynamic assignment
        binding.appcompatbuttonSubmit.setOnClickListener(this)
        binding.appcompatbuttonCancel.setOnClickListener(this)
        binding.appcompatbuttonClose.setOnClickListener(this)
    }

    //call by function
    fun closeClick(v: View?){
        Snackbar.make(binding.root, "click close message", Snackbar.LENGTH_SHORT).show()
    }
    /*
    override fun onClick(v : View?){
        Snackbar.make(binding.root, "message", Snackbar.LENGTH_SHORT).show()
    }*/

    override fun onClick(v : View?){
        var message = ""
        v?.let{
            when(it.id){
                R.id.appcompatbutton_submit -> message ="submit is clicked"
                R.id.appcompatbutton_cancel -> message ="cancel is clicked"
                R.id.appcompatbutton_close -> message ="close is clicked"
            }
        }
        var username = binding.edittextUsername.text.toString()
        //same with text input edit text
        var spinner = binding.spinner.selectedItem
        Snackbar.make(binding.root,
            "$message \n $username -> $spinner",
            Snackbar.LENGTH_SHORT).show()
    }
}