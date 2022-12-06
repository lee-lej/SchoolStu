package com.example.schoolstu.Modules;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.schoolstu.R;

import java.util.List;

public class SchoolCustomAdapter extends ArrayAdapter<School> {
    List<School> listS;
    Context contextS;

    public SchoolCustomAdapter(Context contextS, List<School> listS) {
        super(contextS, R.layout.schoolactivity, listS);

        this.contextS = contextS;
        this.listS = listS;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) contextS.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.schoolactivity, null, true);
        TextView textView1 = rowView.findViewById(R.id.txtView1);
        TextView textView2 = rowView.findViewById(R.id.txtView2);
        TextView textView3 = rowView.findViewById(R.id.txtView3);
        TextView textView4 = rowView.findViewById(R.id.txtView4);
        textView1.setText(listS.get(position).getSchoolName());
        textView2.setText(listS.get(position).getYearOfStudies());
        textView3.setText(listS.get(position).getDegree());
        textView4.setText(listS.get(position).getGroup());

        return rowView;
    }
}
