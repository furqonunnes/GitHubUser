package com.dicoding.githubuser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dicoding.githubuser.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val person = intent.getParcelableExtra<User>(EXTRA_PERSON) as User
        binding.apply {
            imgAvatar.setImageResource(person.photo)
            tvUsername.text = person.username
            tvName.text = person.name
            tvLocation.text = person.location
            tvRepository.text = person.repository
            tvCompany.text = person.company
            tvFollowers.text = person.followers
            tvFollowing.text = person.following
        }

    }

    companion object {
        const val EXTRA_PERSON = "extra_person"
    }
}