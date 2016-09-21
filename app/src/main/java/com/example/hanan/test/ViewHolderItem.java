package com.example.hanan.test;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hanan on 05/09/16.
 */
public class ViewHolderItem extends RecyclerView.ViewHolder implements View.OnClickListener{

    TextView title;
    TextView description;
    TextView numNeeded;
    ImageView people;
    ImageView state;
    Context context;
    ArrayList<OpportunityCard> card = new ArrayList<OpportunityCard>();

    public ViewHolderItem(View itemView , Context context , ArrayList<OpportunityCard> card) {
        super(itemView);
        this.card = card;
        this.context = context ;
        itemView.setOnClickListener(this);
        title = (TextView) itemView.findViewById(R.id.opp_title);
        description = (TextView) itemView.findViewById(R.id.opp_text);
        numNeeded = (TextView) itemView.findViewById(R.id.six);
        people = (ImageView) itemView.findViewById(R.id.ppl);
        state = (ImageView) itemView.findViewById(R.id.available);
    }

    @Override
    public void onClick(View v) {
        int position  = getAdapterPosition();
        OpportunityCard opportunityCard = this.card.get(position);
        Intent intent = new Intent(this.context ,OpportunityCard.class);
    }
}
