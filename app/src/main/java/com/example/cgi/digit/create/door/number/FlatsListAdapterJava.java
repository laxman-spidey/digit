package com.example.cgi.digit.create.door.number;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cgi.digit.R;

import java.util.List;

/**
 * Created by Saikrupa on 1/21/2018.
 */

public class FlatsListAdapterJava extends RecyclerView.Adapter<FlatsListAdapterJava.ViewHolder> {


    List<HouseDetailsModel> list;
    Context context;

    public FlatsListAdapterJava(List<HouseDetailsModel> mList,Context mContext){
            list=mList;
            context=mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(context).inflate(R.layout.flats_list_item,parent,false);


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        HouseDetailsModel singleData=list.get(position);
        holder.tvDoorNumber.setText(singleData.getHouseNumber());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvDoorNumber;
        public ViewHolder(View itemView) {
            super(itemView);
            tvDoorNumber=(TextView)itemView.findViewById(R.id.tvDoorNumber);
        }
    }
}
