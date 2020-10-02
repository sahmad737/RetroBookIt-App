package com.example.retrobookit.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.retrobookit.R;
import com.example.retrobookit.data.BookData;
import com.example.retrobookit.data.BookListAdapter;
import com.example.retrobookit.model.Book;

public class BookListActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private StaggeredGridLayoutManager staggeredGridLayoutManager;
    private BookListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list);

        recyclerView=findViewById(R.id.listRecyclerView);
        adapter=new BookListAdapter();

        //1 will make List 2 will make Grid
        staggeredGridLayoutManager=new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        recyclerView.setAdapter(adapter);

        //uusing setOnClick
        adapter.setOnClickListener(new BookListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                //Getting the book clicked
                Book book= new BookData().bookList().get(position);
                String name=book.getBookName();
                String author=book.getBookAuthorName();
                String price=book.getBookPrice();
                String description=book.getBookDescription();
                int image=book.getBookImageId();

                Intent intent=new Intent(BookListActivity.this,BooksDetailConfirmActivity.class);
                intent.putExtra("name",name);
                intent.putExtra("author",author);
                intent.putExtra("price",price);
                intent.putExtra("description",description);
                intent.putExtra("image",image);

                startActivity(intent);


            }
        });

    }
}