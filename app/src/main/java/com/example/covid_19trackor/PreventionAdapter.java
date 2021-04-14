package com.example.covid_19trackor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

class PreventionAdapter extends RecyclerView.Adapter<ViewHolderPrevent> {
    private Context nContext;
    private List<ScreenItem> nRecyclerViewData;

    public PreventionAdapter(Context nContext, List<ScreenItem> nRecyclerViewData) {
        this.nContext = nContext;
        this.nRecyclerViewData = nRecyclerViewData;
    }

    @Override
    public ViewHolderPrevent onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        // Initialize View
        View nview = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.prevention_item,viewGroup,false);

        // Return View
        return new ViewHolderPrevent(nview);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderPrevent holder, int i) {
        holder.img2.setImageResource(nRecyclerViewData.get(i).getScreenImg());
        holder.title2.setText(nRecyclerViewData.get(i).getTitle());
        holder.description2.setText(nRecyclerViewData.get(i).getDescription());

    }

    @Override
    public int getItemCount() {
        return nRecyclerViewData.size();
    }
}
class ViewHolderPrevent extends RecyclerView.ViewHolder{

    // Initialize Variable
    ImageView img2;
    TextView title2,description2;
    CardView cardView2;

    public ViewHolderPrevent(@NonNull View itemView) {
        super(itemView);

        // Assign Variable
        img2 = itemView.findViewById(R.id.img2);
        title2 = itemView.findViewById(R.id.title2);
        description2 = itemView.findViewById(R.id.description2);
        cardView2 = itemView.findViewById(R.id.cardView2);
    }
}
