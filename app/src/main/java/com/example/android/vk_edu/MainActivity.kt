package com.example.android.vk_edu

import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: RectangleAdapter
    private val numbers = mutableListOf<Int>()
    private lateinit var fab: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        fab = findViewById(R.id.fab)

        setLayoutManager()

        fab.setOnClickListener {
            numbers.add(numbers.size + 1)
            adapter.notifyItemInserted(numbers.size - 1)
        }
    }

    private fun setLayoutManager() {
        val columns = if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) 4 else 3
        recyclerView.layoutManager = GridLayoutManager(this, columns)
        adapter = RectangleAdapter(this, numbers, columns)
        recyclerView.adapter = adapter
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        setLayoutManager()
    }
}