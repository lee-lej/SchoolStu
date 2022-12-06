package com.example.schoolstu.Modules;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.schoolstu.R;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<Person> {

    List<Person> list;
    Context context;
    public CustomAdapter( Context context, List<Person> list) {
        super(context, R.layout.newactivity_new, list);

        this.context=context;
        this.list=list;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView=inflater.inflate(R.layout.newactivity_new,null,true);

        TextView textView1 = rowView.findViewById(R.id.txtView1);
        TextView textView2 = rowView.findViewById(R.id.txtView2);
        TextView textView3 = rowView.findViewById(R.id.txtView3);
        TextView textView4 = rowView.findViewById(R.id.txtView4);
        textView1.setText(list.get(position).getName());
        textView2.setText(list.get(position).getSurname());
        textView3.setText(list.get(position).getAge());
        textView4.setText(list.get(position).getEmail());
        return rowView;

    }
}
