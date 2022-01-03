package com.example.coeus

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.coeus.adapter.BookAdapter
import com.example.coeus.api.BookApiInterface
import com.example.coeus.model.Book
import com.example.coeus.repos.BooksRepo
import com.example.coeus.viewmodels.BookViewModelFactory
import com.example.coeus.viewmodels.BooksViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.awaitResponse
import retrofit2.converter.gson.GsonConverterFactory

class BooksFragment : Fragment() {
    private val adapter = BookAdapter()
    lateinit var mViewModel:BooksViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_books, container, false)
        val retrofitService = BookApiInterface.getInstance()
        val bookRepo = BooksRepo(retrofitService)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewBooks)
        recyclerView.adapter = adapter
        mViewModel = ViewModelProvider(this,BookViewModelFactory(bookRepo))[BooksViewModel::class.java]
        mViewModel.books.observe(viewLifecycleOwner, {books -> adapter.setBooks(books)})
        mViewModel.getAllBooks()

        view.findViewById<TextView>(R.id.bookBtn).setOnClickListener {
            view.findNavController().navigate(R.id.action_booksFragment_to_homePageFragment)
        }
        view.findViewById<TextView>(R.id.bookBtn).setOnClickListener {
            view.findNavController().navigate(R.id.action_booksFragment_to_homePageFragment)
        }
        return view
    }
}