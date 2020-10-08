package com.example.retrobookit.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.retrobookit.R;
import com.example.retrobookit.data.BookData;
import com.example.retrobookit.model.Book;

public class UploadBookActivity extends AppCompatActivity {
        private Bundle extras;
        private Bitmap imageBitmap;
        private Button uploadPhotoButton;
        private ImageView imageView;
        private EditText uploadName;
        private EditText uploadAuthor;
        private EditText uploadPrice;
        private EditText uploadDescription;
        private Button postButton;
        private BookData bookData=new BookData();
    static final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_book);

        uploadPhotoButton=findViewById(R.id.uploadButton);
        imageView=findViewById(R.id.bookPostImage);
        uploadPhotoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dispatchTakePictureIntent();
            }
        });

        //fetching rest of the views
        uploadName=findViewById(R.id.nameEditTextAddress);
        uploadAuthor=findViewById(R.id.authorEditTextAddress);
        uploadPrice=findViewById(R.id.priceEditTextAddress);
        uploadDescription=findViewById(R.id.descriptionEditTextAddress);
        postButton=findViewById(R.id.postButton);

        postButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book book= new Book(""+uploadName.getText(),""+uploadAuthor.getText(),"Price= Rs"+uploadPrice.getText(),
                            ""+uploadDescription.getText(),imageView.getId()
                        );
                    bookData.addBook(book);
                    startActivity(new Intent(UploadBookActivity.this,BookListActivity.class));
            }
        });

    }
    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        try {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        } catch (ActivityNotFoundException e) {
            // display error state to the user
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
             imageBitmap = (Bitmap) extras.get("data");
            imageView.setImageBitmap(imageBitmap);
        }
    }
    
}