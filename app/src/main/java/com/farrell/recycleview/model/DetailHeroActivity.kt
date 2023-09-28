package com.farrell.recycleview.model

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.farrell.recycleview.R
import com.farrell.recycleview.databinding.ActivityDetailHeroBinding

class DetailHeroActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDetailHeroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailHeroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = intent.getParcelableExtra<dataHeroes>("DATA")

        Glide.with(this)
            .load(data?.image)
            .into(binding.imgProfile)

        binding.tvName.text     = data?.name
        binding.tvDesc.text     = data?.description
        binding.tvRole.text     = data?.role
        binding.tvGender.text   = data?.gender

//        if (data != null){
//            Log.d("DATA" ,data.name)
//        }


    }

}