package com.dicoding.githubuser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_PERSON = "extra_person"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val imgAvatar: ImageView = findViewById(R.id.img_avatar)
        val tvUsername: TextView = findViewById(R.id.tv_username)
        val tvName: TextView = findViewById(R.id.tv_name)
        val tvLocation: TextView = findViewById(R.id.tv_location)
        val tvRepository: TextView = findViewById(R.id.tv_repository)
        val tvCompany: TextView = findViewById(R.id.tv_company)
        val tvFollowers: TextView = findViewById(R.id.tv_followers)
        val tvFollowing: TextView = findViewById(R.id.tv_following)

        val person = intent.getParcelableExtra<User>(EXTRA_PERSON) as User
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