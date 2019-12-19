package com.myapp.samli.elearning;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
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

        final ViewHolder vHolder = new ViewHolder(view);

        vHolder.descriptionTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(String.valueOf(vHolder.getAdapterPosition())!=null) {
                    if(vHolder.getAdapterPosition()==0) {
                        Intent intent2 = new Intent(view.getContext(), CPPActivity.class);
                        intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        view.getContext().startActivity(intent2);
                   } else if(vHolder.getAdapterPosition()==1){
                        Intent intent2 = new Intent(view.getContext(), JavaActivity.class);
                        intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        view.getContext().startActivity(intent2);
                    }else if(vHolder.getAdapterPosition()==2){
                        Intent intent2 = new Intent(view.getContext(), DataStructureActivity.class);
                        intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        view.getContext().startActivity(intent2);
                    }else if(vHolder.getAdapterPosition()==3){
                        Intent intent2 = new Intent(view.getContext(), UIDesignActivity.class);
                        intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        view.getContext().startActivity(intent2);
                    }else if(vHolder.getAdapterPosition()==4){
                        Intent intent2 = new Intent(view.getContext(), AlgorithmsActivity.class);
                        intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        view.getContext().startActivity(intent2);
                    }else if(vHolder.getAdapterPosition()==5){
                        Intent intent2 = new Intent(view.getContext(), DatabaseSystemsActivity.class);
                        intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        view.getContext().startActivity(intent2);
                    }else if(vHolder.getAdapterPosition()==6){
                        Intent intent2 = new Intent(view.getContext(), DiscreteMathematicsActivity.class);
                        intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        view.getContext().startActivity(intent2);
                    }else if(vHolder.getAdapterPosition()==7){
                        Intent intent2 = new Intent(view.getContext(), SpokenChineseActivity.class);
                        intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        view.getContext().startActivity(intent2);
                    }else if(vHolder.getAdapterPosition()==8){
                        Intent intent2 = new Intent(view.getContext(), ComputerOrganizationActivity.class);
                        intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        view.getContext().startActivity(intent2);
                    }else if(vHolder.getAdapterPosition()==9){
                        Intent intent2 = new Intent(view.getContext(), MobileApplicationDevelopmentActivity.class);
                        intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        view.getContext().startActivity(intent2);
                    }else if(vHolder.getAdapterPosition()==10){
                    Intent intent2 = new Intent(view.getContext(), ComputerNetworksActivity.class);
                    intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    view.getContext().startActivity(intent2);
                }


                }
            }
        });
        return vHolder;
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
