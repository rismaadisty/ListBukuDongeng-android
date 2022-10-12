package com.ransya.listbukudongeng.ui.listbuku

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ransya.listbukudongeng.R
import com.ransya.listbukudongeng.data.listBook
import com.ransya.listbukudongeng.databinding.ActivityListBukuBinding
import com.ransya.listbukudongeng.model.Book
import com.ransya.listbukudongeng.ui.detail.DetailBookActivity
import com.ransya.listbukudongeng.ui.listbuku.adapter.ListBukuAdapter
import com.ransya.listbukudongeng.ui.listbuku.adapter.ListBukuNewAdapter
import com.ransya.listbukudongeng.ui.profile.ProfileActivity

class ListBukuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListBukuBinding
    private val adapter by lazy { ListBukuAdapter() }
    private val newAdapter by lazy { ListBukuNewAdapter().apply {
        onClickItem = { data ->
            handleOnClick(data)

        }
    } }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBukuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()

    }

    private fun initView() {
        binding.run {
            val layoutManager = LinearLayoutManager(this@ListBukuActivity, RecyclerView.VERTICAL,false)
            rvBook.layoutManager = layoutManager
            rvBook.adapter = newAdapter
//            adapter.setItemBook(listBook)
            newAdapter.submitList(listBook)

            swipeRefresh.setOnRefreshListener {
//                adapter.setItemBook(listBook)
//                adapter.notifyDataSetChanged()
                newAdapter.submitList(listBook)
                swipeRefresh.isRefreshing = false
            }

            siProfile.setOnClickListener {
                val intent = Intent(this@ListBukuActivity, ProfileActivity::class.java)
                startActivity(intent)
            }

        }
    }

    private fun handleOnClick(data: Book) {
        val intent = Intent(this@ListBukuActivity, DetailBookActivity::class.java)
        intent.putExtra(KEY_DATA, data)
        startActivity(intent)
    }

    companion object {
        const val KEY_DATA = "key_data"
    }

}