package com.example.travelexperts.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.travelexperts.R;
import com.example.travelexperts.activities.PackageInformation;
import com.example.travelexperts.models.Packages;
import java.util.List;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContext ;
    private List<Packages> mData ;
    RequestOptions option;


    public RecyclerViewAdapter(Context mContext, List<Packages> mData) {
        this.mContext = mContext;
        this.mData = mData;

        System.out.println(mData);
        // Request option for Glide
       // option = new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view ;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        view = inflater.inflate(R.layout.package_row_item, parent,false) ;
        final MyViewHolder viewHolder = new MyViewHolder(view) ;

        viewHolder.view_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(mContext, PackageInformation.class);
                i.putExtra("package_name", mData.get(viewHolder.getAdapterPosition()).getPkgName());
                i.putExtra("package_description", mData.get(viewHolder.getAdapterPosition()).getPkgDesc());
                i.putExtra("package_price", mData.get(viewHolder.getAdapterPosition()).getBasePrice());
                i.putExtra("package_start_date", mData.get(viewHolder.getAdapterPosition()).getPkgStartDate());
                i.putExtra("package_end_date", mData.get(viewHolder.getAdapterPosition()).getPkgEnddate());
                //i.putExtra("anime_rating",mData.get(viewHolder.getAdapterPosition()).getRating());
                //i.putExtra("anime_img",mData.get(viewHolder.getAdapterPosition()).getImage_url());

                mContext.startActivity(i);

            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.tv_package_name.setText(mData.get(position).getPkgName());
        //holder.tv_rating.setText(mData.get(position).getRating());
        holder.tv_price.setText(mData.get(position).getBasePrice());
        holder.tv_start_date.setText(mData.get(position).getPkgStartDate().substring(0, 12));
        holder.tv_end_date.setText(mData.get(position).getPkgEnddate().substring(0, 12));

        // Load Image from the internet and set it into Imageview using Glide

        //Glide.with(mContext).load(mData.get(position).getImage_url()).apply(option).into(holder.img_thumbnail);

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_package_name ;
      // TextView tv_rating ;
        TextView tv_price ;
        TextView tv_start_date;
        TextView tv_end_date;
        ImageView img_thumbnail;
        LinearLayout view_container;





        public MyViewHolder(View itemView) {
            super(itemView);

            view_container = itemView.findViewById(R.id.container);
            tv_package_name = itemView.findViewById(R.id.package_name);
            tv_start_date = itemView.findViewById(R.id.package_start_date);
            tv_end_date= itemView.findViewById(R.id.package_end_date);
            //tv_rating = itemView.findViewById(R.id.rating);
            tv_price = itemView.findViewById(R.id.package_price);

            img_thumbnail = itemView.findViewById(R.id.thumbnail);

        }
    }

}