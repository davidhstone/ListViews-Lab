package ly.generalassemb.drewmahrt.bookshelf;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    BaseAdapter mBookAdapter;

    //TODO: Define your ListView
    ListView mlistView;

    //TODO: Define your Book List

    List<Book> mBookList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Use helper method to add books to the list
        mlistView = (ListView)findViewById(R.id.bookslistview);


        mBookList = generateBooks();


        //TODO: Instantiate BaseAdapter
        //Below is a partially complete example for one Adapter
        mBookAdapter = new BaseAdapter() {
            @Override
            public int getCount() {
                return mBookList.size();
            }

            @Override
            public Object getItem(int position) {
                return mBookList.get(position);
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                //TODO: Update the view
                View v = convertView;

                if (convertView == null) {
                    LayoutInflater li = (LayoutInflater) MainActivity.this
                            .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    v = li.inflate(android.R.layout.simple_list_item_2, null);
                }

                TextView title = (TextView)v.findViewById(android.R.id.text1);
                title.setText(mBookList.get(position).getTitle());
//                title.setTextColor(Color.parseColor("#000"));
                //TextView textView = (TextView)v.findViewById(android.R.id.text1);
                //textView.setText(mNameList.get(position));
                TextView author = (TextView)v.findViewById(android.R.id.text2);
                author.setText(mBookList.get(position).getAuthor());
                return v;
            }
        };


        //TODO: Set the ListView's adapter
        
        mlistView.setAdapter(mBookAdapter);
        mlistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView title = (TextView)view.findViewById(android.R.id.text1);
                TextView author = (TextView)view.findViewById(android.R.id.text2);
                title.setTextColor(Color.parseColor("#ff0000"));
                author.setTextColor(Color.parseColor("#ff0000"));

            }
        });

    }

    //Method to generate a list of Books
    private List<Book> generateBooks(){
        List<Book> books = new ArrayList<>();

        books.add(new Book("Apples Book","Brad"));
        books.add(new Book("Cats Book","Ryan"));
        books.add(new Book("Eagles Book","Kate"));
        books.add(new Book("Strawberries Cathy","Brad"));
        books.add(new Book("Dogs Book","Tom"));
        books.add(new Book("Ants Book","Zane"));

        return books;
    }

}
