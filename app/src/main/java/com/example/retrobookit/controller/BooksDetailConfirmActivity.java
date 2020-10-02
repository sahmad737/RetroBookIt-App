package com.example.retrobookit.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.retrobookit.R;

public class BooksDetailConfirmActivity extends AppCompatActivity {
        private Bundle extras;
        private TextView bookName;
        private TextView bookAuthor;
        private TextView bookPrice;
        private TextView bookDescription;
        private ImageView bookImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books_detail_confirm);

        //Fetching the views
        bookName=findViewById(R.id.bookNameDetails);
        bookAuthor=findViewById(R.id.authorBookDetails);
        bookPrice=findViewById(R.id.priceBookDetails);
        bookDescription=findViewById(R.id.descriptionBookDetails);
        bookImage=findViewById(R.id.imageBookDetails);

        //getting bundle for values from Intent
        extras=getIntent().getExtras();
        if(extras!=null){
            bookName.setText(extras.getString("name"));
            bookAuthor.setText(extras.getString("author"));
            bookPrice.setText(extras.getString("price"));
            bookDescription.setText(extras.getString("description"));
            bookImage.setImageResource(extras.getInt("image"));

        }
    }
}