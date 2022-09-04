package com.dicoding.githubuser

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.githubuser.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

//    private lateinit var binding: ActivityMainBinding

    private lateinit var rvUser: RecyclerView
    private val list = ArrayList<User>()

    // Menandakan item mana yang dipilih
    private fun showSelectedHero(user: User) {
        Toast.makeText(this, "Kamu Memilih" + user.name, Toast.LENGTH_SHORT).show()

        val moveWithObjectIntent = Intent(this@MainActivity, DetailActivity::class.java)
        moveWithObjectIntent.putExtra(DetailActivity.EXTRA_PERSON, user)
        startActivity(moveWithObjectIntent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        rvUser = findViewById(R.id.rv_user)
        rvUser.setHasFixedSize(true)

        list.addAll(listUser)
        showRecyclerList()
    }

    private val listUser: ArrayList<User>
        @SuppressLint("Recycle")
        get() {
            val dataPhoto = resources.obtainTypedArray(R.array.avatar)
            val dataUsername = resources.getStringArray(R.array.username)
            val dataName = resources.getStringArray(R.array.name)
            val dataLocation = resources.getStringArray(R.array.location)
            val dataRepository = resources.getStringArray(R.array.repository)
            val dataCompany = resources.getStringArray(R.array.company)
            val dataFollowers = resources.getStringArray(R.array.followers)
            val dataFollowing = resources.getStringArray(R.array.following)
            val listHero = ArrayList<User>()

            for (i in dataName.indices) {
                val hero = User(dataPhoto.getResourceId(i, -1), dataUsername[i], dataName[i], dataLocation[i], dataRepository[i], dataCompany[i], dataFollowers[i], dataFollowing[i] )
                listHero.add(hero)
            }

            return listHero
        }

    private fun showRecyclerList() {
        rvUser.layoutManager = LinearLayoutManager(this)
        val listUserAdapter = ListUserAdapter(list)
        rvUser.adapter = listUserAdapter

        listUserAdapter.setOnItemClickCallback(object : ListUserAdapter.OnItemClickCallback {
            override fun onItemClicked(data: User) {
                showSelectedHero(data)
            }
        })

    }


}