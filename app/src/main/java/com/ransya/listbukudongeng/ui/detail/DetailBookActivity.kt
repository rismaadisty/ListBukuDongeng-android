package com.ransya.listbukudongeng.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ransya.listbukudongeng.databinding.ActivityDetailBookBinding
import com.ransya.listbukudongeng.model.Book
import com.ransya.listbukudongeng.ui.listbuku.ListBukuActivity

class DetailBookActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBookBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBookBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()


    }

    private fun initView() {
        val data = intent.getParcelableExtra<Book>(ListBukuActivity.KEY_DATA) ?:Book()

        binding.run {
            ivBack.setOnClickListener { finish() }
            tvTitle.text = data.judulBuku
            tvJudulBuku.text = data.judulBuku
            tvTahun.text = data.tahun
            tvPenerbit.text = data.penerbit
            ivBook.setImageResource(data.image)
        }
    }
}