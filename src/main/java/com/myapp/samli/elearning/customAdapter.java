package com.myapp.samli.elearning;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class customAdapter extends RecyclerView.Adapter<customAdapter.ViewHolder> {

    private LayoutInflater layoutInflater;
    private List<String> data, dataDescrip;

    customAdapter(Context context, List<String> data, List<String> dataDescrip){
        this.layoutInflater = LayoutInflater.from(context);
        this.data = data;
        this.dataDescrip = dataDescrip;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.customcardview, parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        //set title for each card
        String title = data.get(position);
        //String descrip = dataDescrip.get(position);
        //holder.descriptionTextView.setText(dataDescrip.get(position));
        holder.titleTextView.setText(title);

        //set description for each card and image for each thing



    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView titleTextView, descriptionTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            descriptionTextView = itemView.findViewById(R.id.descriptionTextView);
        }
    }
}
