package com.example.coeus.adapter

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.coeus.R
import com.example.coeus.model.Book

class BookAdapter : RecyclerView.Adapter<BookAdapter.BookViewHolder>() {
    var booksList = mutableListOf<Book>()

    fun setBooks(books: List<Book>) {
        this.booksList = books.toMutableList()
        notifyDataSetChanged()
    }

    class BookViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val bookName = view.findViewById<TextView>(R.id.bookTitle)
        val price = view.findViewById<TextView>(R.id.bookPrice)
        val isbn = view.findViewById<TextView>(R.id.bookId)
        val bookImg = view.findViewById<ImageView>(R.id.bookImg)
        val viewBook = view.findViewById<Button>(R.id.viewBook)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val adapterLayout =
            LayoutInflater.from(parent.context).inflate(R.layout.book_card, parent, false)
        return BookViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val item = booksList[position]
        holder.bookName.text = item.title
        holder.price.text = item.price
        holder.isbn.text = "ISBN: ${item.isbn13}"
        Glide.with(holder.itemView.context).load(item.image).into(holder.bookImg)

        holder.viewBook.setOnClickListener{
            holder.itemView.context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(item.url)))
        }
    }

    override fun getItemCount(): Int {
        return booksList.size
    }


}