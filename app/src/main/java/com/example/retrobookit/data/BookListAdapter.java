package com.example.retrobookit.data;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import com.example.retrobookit.R;
import com.example.retrobookit.model.Book;

public class BookListAdapter extends RecyclerView.Adapter<BookListAdapter.ViewHolder> {

    private BookData bookData=new BookData();
    private OnItemClickListener itemClickListener;


    @NonNull
    @Override
    public BookListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View bookRowList= LayoutInflater.from(parent.getContext()).inflate(
         R.layout.book_list_row,parent,false
       );

        return new ViewHolder(bookRowList);
    }

    @Override
    public void onBindViewHolder(@NonNull BookListAdapter.ViewHolder holder, int position) {
        Book book= bookData.bookList().get(position);
        holder.bookListNameView.setText(book.getBookName());
        holder.bookListAuthorView.setText(book.getBookAuthorName());
        holder.bookListPriceView.setText(book.getBookPrice());
        holder.bookListImageView.setImageResource(book.getBookImageId());
    }

    @Override
    public int getItemCount() {
        return bookData.bookList().size() ;
    }

    //Set up own clickListener
    public void setOnClickListener(OnItemClickListener itemClickListener){
        this.itemClickListener=itemClickListener;
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        //Finding text view of list row
        private ImageView bookListImageView;
        private TextView bookListNameView;
        private TextView bookListAuthorView;
        private TextView bookListPriceView;
        private TextView bookListDescriptionView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            //Registering itemView with onclcik
            itemView.setOnClickListener(this);

            bookListImageView=itemView.findViewById(R.id.bookListImage);
            bookListNameView=itemView.findViewById(R.id.bookNameList);
            bookListAuthorView=itemView.findViewById(R.id.bookAuthorList);
            bookListPriceView=itemView.findViewById(R.id.bookPriceList);
        }

        @Override
        public void onClick(View v) {
            itemClickListener.onItemClick(v,getAdapterPosition());
        }
    }

    //To simplify things make an interface
    public interface OnItemClickListener{
        void onItemClick(View view,int position);
    }
}
