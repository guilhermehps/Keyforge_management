package com.KeyforgeManagement.application.ui.decklist;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.KeyforgeManagement.application.R;
import com.KeyforgeManagement.application.data.model.Deck;
import com.KeyforgeManagement.application.data.model.House;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DeckListAdapter extends RecyclerView.Adapter<DeckListAdapter.DeckViewHolder> {

    private final List<Deck> decks;
    private final DeckListInteractionListener listener;
    private final List<Deck> bufferList;


    public DeckListAdapter(DeckListInteractionListener listener) {
        this.listener = listener;
        this.decks = new ArrayList<>();
        this.bufferList = new ArrayList<>();
    }

    @NonNull
    @Override
    public DeckViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.deck_displayer, parent, false);
        return new DeckViewHolder(v, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull DeckViewHolder holder, int position) {
        holder.display(decks.get(position));
    }

    @Override
    public int getItemCount() {
        return decks.size();
    }

    public void onNewDecks(List<Deck> decks) {

        this.decks.clear();
        this.decks.addAll(decks);
        this.bufferList.clear();
        this.bufferList.addAll(decks);
        notifyDataSetChanged();

    }

    public Deck getDeckAt(int position) {
        if (position >= decks.size())
            return null;
        return decks.get(position);
    }

    public void sort(int parameter) {
        switch (parameter) {
            case 0:
                this.decks.sort(Comparator.comparing(Deck::getSasRating)
                        .thenComparing(Deck::getRawAmber)
                        .reversed());
                break;
            case 1:
                this.decks.sort(Comparator.comparing(Deck::getRawAmber)
                        .thenComparing(Deck::getSasRating)
                        .reversed());
                break;
            case 2:
                this.decks.sort(Comparator.comparing(Deck::getLocalWins)
                        .thenComparing(Deck::getSasRating)
                        .reversed());
                break;
            case 3:
                this.decks.sort(Comparator.comparing(Deck::getActionCount)
                        .thenComparing(Deck::getSasRating)
                        .reversed());
                break;
            case 4:
                this.decks.sort(Comparator.comparing(Deck::getArtifactCount)
                        .thenComparing(Deck::getSasRating)
                        .reversed());
                break;
            default:
                break;

        }
        notifyDataSetChanged();
    }

    public void filter(String tofilter, int sortingParameter) {
        List<Deck> newList = new ArrayList<>();
        this.bufferList.forEach(item -> {
            if (item.getName().toLowerCase().contains(tofilter.toLowerCase()))
                newList.add(item);
        });

        this.decks.clear();
        this.decks.addAll(newList);

        notifyDataSetChanged();
    }

    static class DeckViewHolder extends RecyclerView.ViewHolder {

        private final ImageView[] houseArr;
        private final TextView deckName;
        private final TextView expansion;
        private final TextView sasScore;
        private final TextView rawAember;
        private final DeckListInteractionListener listener;

        DeckViewHolder(@NonNull View itemView, DeckListInteractionListener listener) {
            super(itemView);
            this.listener = listener;
            houseArr = new ImageView[]{
                    itemView.findViewById(R.id.img_house1),
                    itemView.findViewById(R.id.img_house2),
                    itemView.findViewById(R.id.img_house3)
            };
            deckName = itemView.findViewById(R.id.deck_name);
            expansion = itemView.findViewById(R.id.expansion_name);
            sasScore = itemView.findViewById(R.id.sas_rating);
            rawAember = itemView.findViewById(R.id.raw_amber);
        }

        @SuppressLint("SetTextI18n")
        void display(Deck currentItem) {
            House[] houses = currentItem.getHouses();
            houseArr[0].setImageResource(houses[0].getImageId());
            houseArr[1].setImageResource(houses[1].getImageId());
            houseArr[2].setImageResource(houses[2].getImageId());
            deckName.setText(currentItem.getName());
            expansion.setText(currentItem.getExpansion().toString());
            sasScore.setText(Integer.toString(currentItem.getSasRating()));
            rawAember.setText(Integer.toString(currentItem.getRawAmber()));

            itemView.setOnClickListener(v -> listener.onDeckClicked(currentItem));
            itemView.setOnLongClickListener(v -> {
                listener.onLongDeckClicked(currentItem);
                return true;
            });
        }


    }
}
