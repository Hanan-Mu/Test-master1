package com.example.hanan.test;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hanan on 05/09/16.
 */
public class Adaptar extends RecyclerView.Adapter<ViewHolderItem> {

    ArrayList<OpportunityCard> card ;
    Context context;

    public Adaptar(ArrayList<OpportunityCard> card , Context context){
        this.card = card ;
        this.context=context;
    }

    @Override
    public ViewHolderItem onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_opportunities, parent,false);
        return new ViewHolderItem(v ,context ,card);
    }

    @Override
    public void onBindViewHolder(ViewHolderItem holder, int position){
        holder.title.setText(card.get(position).tilte);
        holder.description.setText(card.get(position).description);
        holder.numNeeded.setText(card.get(position).numNeeded);
        holder.people.setImageResource(card.get(position).people);
        holder.state.setImageResource(card.get(position).state);
    }

    @Override
    public int getItemCount() {
        return card.size();
    }


}



