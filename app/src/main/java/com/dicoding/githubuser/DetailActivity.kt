package com.dicoding.githubuser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dicoding.githubuser.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    companion object {
        const val EXTRA_PERSON = "extra_person"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val person = intent.getParcelableExtra<User>(EXTRA_PERSON) as User
        binding.imgAvatar.setImageResource(person.photo)
        binding.tvUsername.text = person.username
        binding.tvName.text = person.name
        binding.tvLocation.text = person.location
        binding.tvRepository.text = person.repository
        binding.tvCompany.text = person.company
        binding.tvFollowers.text = person.followers
        binding.tvFollowing.text = person.following


    }
}