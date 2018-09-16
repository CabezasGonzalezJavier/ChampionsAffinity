package com.thedeveloperworldisyours.championsaffinity.player;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.lumbralessoftware.voterussia2018.NewPlayer;
import com.thedeveloperworldisyours.championsaffinity.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.thedeveloperworldisyours.championsaffinity.Constantss.ARGENTINA;
import static com.thedeveloperworldisyours.championsaffinity.Constantss.AUSTRALIA;
import static com.thedeveloperworldisyours.championsaffinity.Constantss.BELGIUM;
import static com.thedeveloperworldisyours.championsaffinity.Constantss.BRAZIL;
import static com.thedeveloperworldisyours.championsaffinity.Constantss.COLOMBIA;
import static com.thedeveloperworldisyours.championsaffinity.Constantss.COSTA_RICA;
import static com.thedeveloperworldisyours.championsaffinity.Constantss.CROATIA;
import static com.thedeveloperworldisyours.championsaffinity.Constantss.DEFAULT_IMAGE;
import static com.thedeveloperworldisyours.championsaffinity.Constantss.DEFENDER;
import static com.thedeveloperworldisyours.championsaffinity.Constantss.DENAMARK;
import static com.thedeveloperworldisyours.championsaffinity.Constantss.EGYPT;
import static com.thedeveloperworldisyours.championsaffinity.Constantss.ENGLAND;
import static com.thedeveloperworldisyours.championsaffinity.Constantss.FORWARD;
import static com.thedeveloperworldisyours.championsaffinity.Constantss.FRANCE;
import static com.thedeveloperworldisyours.championsaffinity.Constantss.GERMANY;
import static com.thedeveloperworldisyours.championsaffinity.Constantss.GOALKEEPER;
import static com.thedeveloperworldisyours.championsaffinity.Constantss.ICELAND;
import static com.thedeveloperworldisyours.championsaffinity.Constantss.IRAN;
import static com.thedeveloperworldisyours.championsaffinity.Constantss.JAPAN;
import static com.thedeveloperworldisyours.championsaffinity.Constantss.MEXICO;
import static com.thedeveloperworldisyours.championsaffinity.Constantss.MIDFIELD;
import static com.thedeveloperworldisyours.championsaffinity.Constantss.MOROCCO;
import static com.thedeveloperworldisyours.championsaffinity.Constantss.NIGERIA;
import static com.thedeveloperworldisyours.championsaffinity.Constantss.PANAMA;
import static com.thedeveloperworldisyours.championsaffinity.Constantss.PERU;
import static com.thedeveloperworldisyours.championsaffinity.Constantss.POLAND;
import static com.thedeveloperworldisyours.championsaffinity.Constantss.PORTUGAL;
import static com.thedeveloperworldisyours.championsaffinity.Constantss.RUSSIA;
import static com.thedeveloperworldisyours.championsaffinity.Constantss.SAUDI_ARABIA;
import static com.thedeveloperworldisyours.championsaffinity.Constantss.SENEGAL;
import static com.thedeveloperworldisyours.championsaffinity.Constantss.SERBIA;
import static com.thedeveloperworldisyours.championsaffinity.Constantss.SOUTH_KOREA;
import static com.thedeveloperworldisyours.championsaffinity.Constantss.SPAIN;
import static com.thedeveloperworldisyours.championsaffinity.Constantss.SWEDEN;
import static com.thedeveloperworldisyours.championsaffinity.Constantss.SWITZERLAND;
import static com.thedeveloperworldisyours.championsaffinity.Constantss.TUNISIA;
import static com.thedeveloperworldisyours.championsaffinity.Constantss.URUGUAY;

/**
 * Created by javiergonzalezcabezas on 5/6/18.
 */

public class PlayerListAdapter extends RecyclerView
        .Adapter<PlayerListAdapter.DataObjectHolder> {

    private List<NewPlayer> list;
    private Context context;
    private static ListenerPlayer listenerPlayer;

    interface ListenerPlayer {
        void rating(int id);

        void detail(int id);
    }

    public PlayerListAdapter(ListenerPlayer listener, List<NewPlayer> list, Context context) {
        this.listenerPlayer = listener;
        this.list = list;
        this.context = context;
    }

    static class DataObjectHolder extends RecyclerView.ViewHolder
            implements View
            .OnClickListener {

        @BindView(R.id.player_list_item_profile_imageView)
        ImageView profileImageView;

        @BindView(R.id.player_list_item_flag_imageView)
        ImageView flag;

        @BindView(R.id.player_list_item_name_textView)
        TextView name;

        @BindView(R.id.player_list_item_club_textView)
        TextView club;

        @BindView(R.id.player_list_item_number_textView)
        TextView number;

        @BindView(R.id.player_list_item_position_imageView)
        ImageView positon;

        @BindView(R.id.player_list_item_goal_imageView)
        ImageView goalFavorImage;

        @BindView(R.id.player_list_item_goal_textView)
        TextView goalsFavor;

        @BindView(R.id.player_list_item_goal_against_imageView)
        ImageView goalAgainstImage;

        @BindView(R.id.player_list_item_goal_against_textView)
        TextView goalsAgainst;


        @BindView(R.id.player_list_item_rate_textView)
        Button rate;

        DataObjectHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);

            itemView.setOnClickListener(this);
            rate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listenerPlayer.rating(getLayoutPosition());

                }
            });
        }

        @Override
        public void onClick(View view) {
            listenerPlayer.detail(getLayoutPosition());
        }

    }

    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.player_list_item, parent, false);

        DataObjectHolder dataObjectHolder = new DataObjectHolder(view);
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(DataObjectHolder holder, int position) {
        holder.name.setText(list.get(position).getName());
        holder.club.setText(list.get(position).getClub());
        /*holder.number.setText(list.get(position).getNumber());
        holder.rate.setText(String.valueOf(list.get(position).getVote()));
        setImagePosition(list.get(position).getPosition(), holder.positon);
        if (list.get(position).getImageURL().equals("")) {
            Glide.with(context)
                    .load(DEFAULT_IMAGE)
                    .apply(RequestOptions.circleCropTransform())
                    .into(holder.profileImageView);
        } else {
            Glide.with(context)
                    .load(list.get(position).getImageURL())
                    .apply(RequestOptions.circleCropTransform())
                    .into(holder.profileImageView);
        }
        setFlag(list.get(position).getNationality(), holder.flag);*/
        if (Integer.valueOf(list.get(position).getGoalsFavor()) > 0) {
            holder.goalFavorImage.setImageResource(R.drawable.goal);
            holder.goalsFavor.setText(String.valueOf(list.get(position).getGoalsFavor()));
        } else {
            holder.goalFavorImage.setImageResource(R.drawable.circle_white_background);
            holder.goalsFavor.setText("");
        }

        //if(list.get(position).getGoalsAgainst()>0) {
        //  holder.goalAgainstImage.setImageResource(R.drawable.goal_agaist);
        //holder.goalsAgainst.setText(String.valueOf(list.get(position).getGoalsAgainst()));
        //} else {
        //  holder.goalAgainstImage.setImageResource(R.drawable.circle_white_background);
        //holder.goalsAgainst.setText("");
        //}
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    private void setImagePosition(int position, ImageView imageView) {
        switch (position) {
            case GOALKEEPER:
                imageView.setImageResource(R.drawable.goalkeeper);
                imageView.setBackground(ContextCompat.getDrawable(context, R.drawable.circle_goalkeeper));
                break;
            case DEFENDER:
                imageView.setImageResource(R.drawable.defender);
                imageView.setBackground(ContextCompat.getDrawable(context, R.drawable.circle_defender));
                break;
            case MIDFIELD:
                imageView.setImageResource(R.drawable.midfield);
                imageView.setBackground(ContextCompat.getDrawable(context, R.drawable.circle_midfield));
                break;
            case FORWARD:
                imageView.setImageResource(R.drawable.forward);
                imageView.setBackground(ContextCompat.getDrawable(context, R.drawable.circle_forward));
                break;
        }
    }

    public void setFlag(int flag, ImageView imageView) {
        switch (flag) {
            //A
            case RUSSIA:
                imageView.setImageResource(R.drawable.flag0);
                break;
            case SAUDI_ARABIA:
                imageView.setImageResource(R.drawable.flag1);
                break;
            case EGYPT:
                imageView.setImageResource(R.drawable.flag2);
                break;
            case URUGUAY:
                imageView.setImageResource(R.drawable.flag3);
                break;
            //B
            case PORTUGAL:
                imageView.setImageResource(R.drawable.flag4);
                break;
            case SPAIN:
                imageView.setImageResource(R.drawable.flag5);
                break;
            case MOROCCO:
                imageView.setImageResource(R.drawable.flag6);
                break;
            case IRAN:
                imageView.setImageResource(R.drawable.flag7);
                break;
            //C
            case FRANCE:
                imageView.setImageResource(R.drawable.flag8);
                break;
            case AUSTRALIA:
                imageView.setImageResource(R.drawable.flag9);
                break;
            case PERU:
                imageView.setImageResource(R.drawable.flag10);
                break;
            case DENAMARK:
                imageView.setImageResource(R.drawable.flag11);
                break;
            //D
            case ARGENTINA:
                imageView.setImageResource(R.drawable.flag12);
                break;
            case ICELAND:
                imageView.setImageResource(R.drawable.flag13);
                break;
            case CROATIA:
                imageView.setImageResource(R.drawable.flag14);
                break;
            case NIGERIA:
                imageView.setImageResource(R.drawable.flag15);
                break;
            //E
            case BRAZIL:
                imageView.setImageResource(R.drawable.flag16);
                break;
            case SWITZERLAND:
                imageView.setImageResource(R.drawable.flag17);
                break;
            case COSTA_RICA:
                imageView.setImageResource(R.drawable.flag18);
                break;
            case SERBIA:
                imageView.setImageResource(R.drawable.flag19);
                break;
            //F
            case GERMANY:
                imageView.setImageResource(R.drawable.flag20);
                break;
            case MEXICO:
                imageView.setImageResource(R.drawable.flag21);
                break;
            case SWEDEN:
                imageView.setImageResource(R.drawable.flag22);
                break;
            case SOUTH_KOREA:
                imageView.setImageResource(R.drawable.flag23);
                break;
            //G
            case BELGIUM:
                imageView.setImageResource(R.drawable.flag24);
                break;
            case PANAMA:
                imageView.setImageResource(R.drawable.flag25);
                break;
            case TUNISIA:
                imageView.setImageResource(R.drawable.flag26);
                break;
            case ENGLAND:
                imageView.setImageResource(R.drawable.flag27);
                break;
            //H
            case POLAND:
                imageView.setImageResource(R.drawable.flag28);
                break;
            case SENEGAL:
                imageView.setImageResource(R.drawable.flag29);
                break;
            case COLOMBIA:
                imageView.setImageResource(R.drawable.flag30);
                break;
            case JAPAN:
                imageView.setImageResource(R.drawable.flag31);
                break;
            default:
                imageView.setImageResource(R.drawable.flag31);

        }

    }

}
