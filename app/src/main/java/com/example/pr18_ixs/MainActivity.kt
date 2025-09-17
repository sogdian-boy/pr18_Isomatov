package com.example.pr18_ixs

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.content.SharedPreferences
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import com.example.pr18_ixs.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var pref: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor
    private lateinit var binding: ActivityMainBinding //sdfaf

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pref = getSharedPreferences("my", Context.MODE_PRIVATE)
        editor = pref.edit()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        binding.fab?.setOnClickListener { view ->
            Snackbar.make(view, "Вы нажали на левитирующую кнопку", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        binding.txt2?.text = pref.getInt("count",0).toString()

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }



    fun defaultSnackbar(view: View) {
        Snackbar.make(view,"Вы нажали кнопку", Snackbar.LENGTH_LONG).show()


      }
    fun ButtonSnackbar(view: View) {

        val  snackbar = Snackbar.make(view, "C кнопкой",
            Snackbar.LENGTH_LONG);
        snackbar.setAction("ОК", View.OnClickListener{ Snackbar.make(view,"Вы нажали ок", Snackbar.LENGTH_SHORT).show()})
        snackbar.show()
    }
    fun CustomSnackbar(view: View) {

        val  snackbar = Snackbar.make(view, "Нажмите зеленую кнопку чтобы увеличить счетчик", Snackbar.LENGTH_LONG);
        snackbar.setActionTextColor(Color.GREEN)
        snackbar.setAction("Кнопка", View.OnClickListener{
            binding.txt2?.text   = (1 + pref.getInt("count",0)).toString()
            editor.putInt("count",pref.getInt("count",0)+1)
            editor.apply()
            Snackbar.make(view,"Вы увеличили счетчик", Snackbar.LENGTH_SHORT).show()})
        snackbar.show()
}
}