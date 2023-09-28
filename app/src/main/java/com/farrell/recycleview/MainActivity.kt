package com.farrell.recycleview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.farrell.recycleview.adaptor.heroAdapter
import com.farrell.recycleview.databinding.ActivityMainBinding
import com.farrell.recycleview.model.dataHeroes

class MainActivity : AppCompatActivity() {

    private var list = ArrayList<dataHeroes>()
    private lateinit var rvHeroes: RecyclerView

    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        rvHeroes = binding.rvMain
        rvHeroes.setHasFixedSize(true)
        
        list.addAll(getListHeroes())

        showRecyclerView()


    }

    private fun showRecyclerView() {
        rvHeroes.layoutManager = LinearLayoutManager(this)

        val listHeroAdapter = heroAdapter(list)

        rvHeroes.adapter = listHeroAdapter
    }

    private fun getListHeroes(): ArrayList<dataHeroes> {
        val name = resources.getStringArray(R.array.data_name)
        val desc = resources.getStringArray(R.array.data_description)
        val imgs = resources.obtainTypedArray(R.array.data_photo)
        val role  = resources.getStringArray(R.array.data_role)
        val gender = resources.getStringArray(R.array.data_gender)

        val heroes = ArrayList<dataHeroes>()

        for (i in name.indices ) {
            var hero = dataHeroes(
                name[i],
                desc[i],
                imgs.getResourceId(i,-1),
                role[i],
                gender[i],

            )
            heroes.addAll(listOf(hero))

        }

        return heroes



    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId){
            R.id.about_page -> {
                val intent = Intent(this,AboutActivity::class.java)
                startActivity(intent)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}