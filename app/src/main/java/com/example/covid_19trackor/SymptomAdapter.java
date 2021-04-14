package com.example.covid_19trackor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.text.BreakIterator;
import java.util.List;

class SymptomAdapter extends RecyclerView.Adapter<ViewHolder>{
    private Context mContext;
    private List<RecyclerViewData> myRecyclerViewData;

    public SymptomAdapter(Context mContext, List<RecyclerViewData> myRecyclerViewData) {
        this.mContext = mContext;
        this.myRecyclerViewData = myRecyclerViewData;
    }

    @Override
    public ViewHolder onCreateViewHolder( ViewGroup viewGroup, int i) {

        // Initialize View
        View mView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_item,viewGroup,false);

        // Return View
        return new ViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int i) {
        holder.imgView.setImageResource(myRecyclerViewData.get(i).getItemImage());
        holder.mTitle.setText(myRecyclerViewData.get(i).getItemName());

    }

    @Override
    public int getItemCount() {
        return myRecyclerViewData.size();
    }
}
class ViewHolder extends RecyclerView.ViewHolder{


    // Initialize Variable
    ImageView imgView;
    TextView mTitle;
    CardView mcardView;


    public ViewHolder(View itemView) {
        super(itemView);

        // Assign Variable
        imgView = itemView.findViewById(R.id.imageView);
        mTitle = itemView.findViewById(R.id.tvTitle);
        mcardView = itemView.findViewById(R.id.cardView);
    }
}

