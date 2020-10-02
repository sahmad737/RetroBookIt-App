package com.example.retrobookit.data;

import android.content.Context;
import android.content.res.Resources;

import com.example.retrobookit.MainActivity;
import com.example.retrobookit.R;
import com.example.retrobookit.model.Book;

import java.util.ArrayList;

public class BookData {
    private String lorem= "lorem ipsumlorem ipsumlorem ipsumlorem ipsumlorem ipsumlorem ipsumlorem ipsumlorem ipsumlorem ipsumlorem ipsumlorem ipsumlorem ipsum";
    public ArrayList<Book> bookList(){
        ArrayList<Book> list=new ArrayList<>();
        for(int i=0;i<16;i++){
            Book book=new Book("Book"+(i+1),"Author Name",
                    "Price: Rs 420", lorem,R.drawable.book);
            list.add(book);
        }
        return list;
    }

}
