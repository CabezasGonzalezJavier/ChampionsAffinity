package com.thedeveloperworldisyours.championsaffinity.player;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.lumbralessoftware.voterussia2018.NewPlayer;
import com.lumbralessoftware.voterussia2018.Utils;
import com.lumbralessoftware.voterussia2018.player.PlayerListContract;
import com.thedeveloperworldisyours.championsaffinity.add.AddDialogFragment;
import com.thedeveloperworldisyours.championsaffinity.detail.DetailActivity;
import com.thedeveloperworldisyours.championsaffinity.rating.RatingDialogFragment;
import com.thedeveloperworldisyours.championsaffinity.rating.RatingPresenter;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import static com.thedeveloperworldisyours.championsaffinity.Constantss.EXTRA_BIG_IMAGE;
import static com.thedeveloperworldisyours.championsaffinity.Constantss.EXTRA_NAME;
import static com.thedeveloperworldisyours.championsaffinity.Constantss.FIREBASE_POSITION;
import static com.thedeveloperworldisyours.championsaffinity.Constantss.FIREBASE_TEAM;
import static com.thedeveloperworldisyours.championsaffinity.Constantss.PLAYERS;

/**
 * Created by javiergonzalezcabezas on 21/5/18.
 */

public class PlayerListPresenter implements PlayerListContract.Presenter {
    private PlayerListContract.View view;
    private AppCompatActivity activity;
    private List<NewPlayer> playerList;

    DatabaseReference databaseReference;
    DatabaseReference player;

    public PlayerListPresenter(PlayerListContract.View view, AppCompatActivity activity) {
        this.view = view;
        this.activity = activity;
        databaseReference = FirebaseDatabase.getInstance().getReference();
        player = databaseReference.child(PLAYERS);
        this.view.setPresenter(this);
        playerList = new ArrayList<>();
    }

    @Override
    public void fetch() {

        if (Utils.INSTANCE.isOnline(activity)) {
            player.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    playerList.clear();
                    for (DataSnapshot children : dataSnapshot.getChildren()) {
                        NewPlayer player = children.getValue(NewPlayer.class);
                        playerList.add(player);
                    }
                    view.showPlayer(playerList);
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    view.showError();
                }
            });
        } else {
            view.noInternet();
        }
    }



    @Override
    public void goToRating(int id, @NotNull String name, @NotNull String image) {

        RatingDialogFragment ratingDialogFragment = RatingDialogFragment.newInstance(id, name, image);
        ratingDialogFragment.show(activity.getSupportFragmentManager(), "dialog");
        new RatingPresenter(ratingDialogFragment, id, activity);
    }

    @Override
    public void fetchPlayerWithPosition(int position) {
        if (Utils.INSTANCE.isOnline(activity)) {
            player.orderByChild(FIREBASE_POSITION).equalTo(position).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    playerList.clear();
                    for (DataSnapshot children : dataSnapshot.getChildren()) {
                        NewPlayer player = children.getValue(NewPlayer.class);
                        playerList.add(player);
                    }
                    view.showPlayer(playerList);
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    view.showError();
                }
            });
        } else {
            view.noInternet();
        }
    }

    @Override
    public void fetchPlayerWithTeam(int team) {
        if (Utils.INSTANCE.isOnline(activity)) {
            player.orderByChild(FIREBASE_TEAM).equalTo(team).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    playerList.clear();
                    for (DataSnapshot children : dataSnapshot.getChildren()) {
                        NewPlayer player = children.getValue(NewPlayer.class);
                        playerList.add(player);
                    }
                    view.showPlayer(playerList);
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    view.showError();
                }
            });
        } else {
            view.noInternet();
        }
    }

    @Override
    public void goToDetail(int id) {
        Intent intent = new Intent(activity, DetailActivity.class);
        intent.putExtra(EXTRA_NAME, playerList.get(id).getName());
        intent.putExtra(EXTRA_BIG_IMAGE, playerList.get(id).getImage());
        activity.startActivity(intent);

    }

    @Override
    public void goToAdd() {
        Utils.INSTANCE.addFragmentToActivity(activity.getSupportFragmentManager(),new AddDialogFragment(), 0);
    }
}
