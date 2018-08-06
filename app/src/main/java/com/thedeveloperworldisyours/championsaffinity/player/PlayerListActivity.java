package com.thedeveloperworldisyours.championsaffinity.player;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

import com.lumbralessoftware.voterussia2018.ElementList;
import com.lumbralessoftware.voterussia2018.Utils;
import com.thedeveloperworldisyours.championsaffinity.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.thedeveloperworldisyours.championsaffinity.Constantss.ARGENTINA;
import static com.thedeveloperworldisyours.championsaffinity.Constantss.AUSTRALIA;
import static com.thedeveloperworldisyours.championsaffinity.Constantss.BELGIUM;
import static com.thedeveloperworldisyours.championsaffinity.Constantss.BRAZIL;
import static com.thedeveloperworldisyours.championsaffinity.Constantss.COLOMBIA;
import static com.thedeveloperworldisyours.championsaffinity.Constantss.COSTA_RICA;
import static com.thedeveloperworldisyours.championsaffinity.Constantss.CROATIA;
import static com.thedeveloperworldisyours.championsaffinity.Constantss.DENAMARK;
import static com.thedeveloperworldisyours.championsaffinity.Constantss.EGYPT;
import static com.thedeveloperworldisyours.championsaffinity.Constantss.ENGLAND;
import static com.thedeveloperworldisyours.championsaffinity.Constantss.FRANCE;
import static com.thedeveloperworldisyours.championsaffinity.Constantss.GERMANY;
import static com.thedeveloperworldisyours.championsaffinity.Constantss.ICELAND;
import static com.thedeveloperworldisyours.championsaffinity.Constantss.IRAN;
import static com.thedeveloperworldisyours.championsaffinity.Constantss.JAPAN;
import static com.thedeveloperworldisyours.championsaffinity.Constantss.MEXICO;
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
 * Created by javiergonzalezcabezas on 21/5/18.
 */

public class PlayerListActivity extends AppCompatActivity implements PlayerListMenuAdapter.MyClickListener {

    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    @BindView(R.id.left_drawer)
    RelativeLayout drawerRelativeLayout;

    @BindView(R.id.list_view_drawer)
    RecyclerView recyclerView;

    @BindView(R.id.player_activity_list_fab)
    FloatingActionButton floatingActionButton;

    private String[] optionMenu;
    private ActionBarDrawerToggle mDrawerToggle;
    private PlayerListPresenter presenter;
    private CharSequence titleSection;
    private CharSequence mTitleApp;
    HashMap<Integer, String> mMapIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player_list_activity);

        ButterKnife.bind(this);
        initFloatingActionButton();
        initFragment();
        initDrawer();
    }

    private void initFloatingActionButton() {
        floatingActionButton.setOnClickListener((View view) -> presenter.goToAdd());
    }

    private void initFragment() {
        PlayerListFragment playerListFragment = (PlayerListFragment) getSupportFragmentManager().
                findFragmentById(R.id.player_list_activity_container);
        if (playerListFragment == null) {
            playerListFragment = playerListFragment.newInstance();
            Utils.INSTANCE.addFragmentToActivity(getSupportFragmentManager(),
                    playerListFragment, R.id.player_list_activity_container);
        }
        presenter = new PlayerListPresenter(playerListFragment, this);

    }

    private void initDrawer() {

        recyclerView.setScrollbarFadingEnabled(true);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        optionMenu = new String[]{getString(R.string.position_goalkeeper),
                getString(R.string.position_defender),
                getString(R.string.position_midfield),
                getString(R.string.position_forward),

                getString(R.string.club_at_madrid),
                getString(R.string.club_barcelona),
                getString(R.string.club_bayern),
                getString(R.string.club_club_brugge),

                getString(R.string.club_cska),
                getString(R.string.club_dortmund),
                getString(R.string.club_galatasaray),
                getString(R.string.club_Hoffenshim),

                getString(R.string.club_inter),
                getString(R.string.club_juventus),
                getString(R.string.club_liverpool),
                getString(R.string.club_lokonmotive),

                getString(R.string.club_lyon),
                getString(R.string.club_city),
                getString(R.string.club_united),
                getString(R.string.club_monaco),

                getString(R.string.club_napoli),
                getString(R.string.club_paris),
                getString(R.string.club_plzen),
                getString(R.string.club_porto),

                getString(R.string.club_real),
                getString(R.string.club_roma),
                getString(R.string.club_skakhtar),
                getString(R.string.club_schalke),

                getString(R.string.club_tottenham),
                getString(R.string.club_valencia),
                getString(R.string.country_tunisia),
                getString(R.string.country_england),

                getString(R.string.country_poland),
                getString(R.string.country_senegal),
                getString(R.string.country_colombia),
                getString(R.string.country_japan)};

        PlayerListMenuAdapter adapter = new PlayerListMenuAdapter(this, getDataSet());
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(this);

        titleSection = getString(R.string.position_goalkeeper);
        mTitleApp = getTitle();

        mDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.drawer_open,
                R.string.drawer_close) {

            public void onDrawerClosed(View view) {
                getSupportActionBar().setTitle(titleSection);
                ActivityCompat.invalidateOptionsMenu(PlayerListActivity.this);
            }

            public void onDrawerOpened(View drawerView) {
                getSupportActionBar().setTitle(R.string.app_name);
                ActivityCompat.invalidateOptionsMenu(PlayerListActivity.this);
            }
        };

        drawerLayout.addDrawerListener(mDrawerToggle);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_drawer);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Pass the event to ActionBarDrawerToggle, if it returns
        // true, then it has handled the app icon touch event
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        // Handle your other action bar items...

        return super.onOptionsItemSelected(item);
    }

    private ArrayList<ElementList> getDataSet() {

        getListIndexed();

        ArrayList results = new ArrayList<>();
        ElementList obj;
        int section = 0, normal = 0;
        int total = optionMenu.length + mMapIndex.size();

        for (int index = 0; index < total; index++) {
            switch (index) {
                case 0:
                case 5:
                case 10:
                case 15:
                case 20:
                case 25:
                case 30:
                case 35:
                case 40:
                    obj = new ElementList(mMapIndex.get(section).toString(), true, false);
                    section++;
                    break;
                case 4:
                case 9:
                case 14:
                case 19:
                case 24:
                case 29:
                case 34:
                case 39:
                    obj = new ElementList(optionMenu[normal], false, true);
                    normal++;
                    break;
                default:
                    obj = new ElementList(optionMenu[normal], false, false);
                    normal++;
                    break;
            }

            results.add(index, obj);
        }
        return results;
    }

    public void getListIndexed() {

        mMapIndex = new LinkedHashMap<>();
        mMapIndex.put(0, getString(R.string.position));
        mMapIndex.put(1, getString(R.string.group_a));
        mMapIndex.put(2, getString(R.string.group_b));
        mMapIndex.put(3, getString(R.string.group_c));
        mMapIndex.put(4, getString(R.string.group_d));
        mMapIndex.put(5, getString(R.string.group_e));
        mMapIndex.put(6, getString(R.string.group_f));
        mMapIndex.put(7, getString(R.string.group_g));
        mMapIndex.put(8, getString(R.string.group_h));
    }


    @Override
    public void onItemClick(int position, boolean addItem) {
        switch (position) {
            case 1:
                presenter.fetchPlayerWithPosition(0);
                titleSection = optionMenu[0];
                break;
            case 2:
                presenter.fetchPlayerWithPosition(1);
                titleSection = optionMenu[1];
                break;
            case 3:
                presenter.fetchPlayerWithPosition(2);
                titleSection = optionMenu[2];
                break;
            case 4:
                presenter.fetchPlayerWithPosition(3);
                titleSection = optionMenu[3];
                break;
            //A
            case 6:
                presenter.fetchPlayerWithTeam(RUSSIA);
                titleSection = optionMenu[4];
                break;
            case 7:
                presenter.fetchPlayerWithTeam(SAUDI_ARABIA);
                titleSection = optionMenu[5];
                break;
            case 8:
                presenter.fetchPlayerWithTeam(EGYPT);
                titleSection = optionMenu[6];
                break;
            case 9:
                presenter.fetchPlayerWithTeam(URUGUAY);
                titleSection = optionMenu[7];
                break;
            //B
            case 11:
                presenter.fetchPlayerWithTeam(PORTUGAL);
                titleSection = optionMenu[8];
                break;
            case 12:
                presenter.fetchPlayerWithTeam(SPAIN);
                titleSection = optionMenu[9];
                break;
            case 13:
                presenter.fetchPlayerWithTeam(MOROCCO);
                titleSection = optionMenu[10];
                break;
            case 14:
                presenter.fetchPlayerWithTeam(IRAN);
                titleSection = optionMenu[11];
                break;
            //C
            case 16:
                presenter.fetchPlayerWithTeam(FRANCE);
                titleSection = optionMenu[12];
                break;
            case 17:
                presenter.fetchPlayerWithTeam(AUSTRALIA);
                titleSection = optionMenu[13];
                break;
            case 18:
                presenter.fetchPlayerWithTeam(PERU);
                titleSection = optionMenu[14];
                break;
            case 19:
                presenter.fetchPlayerWithTeam(DENAMARK);
                titleSection = optionMenu[15];
                break;
            //D
            case 21:
                presenter.fetchPlayerWithTeam(ARGENTINA);
                titleSection = optionMenu[16];
                break;
            case 22:
                presenter.fetchPlayerWithTeam(ICELAND);
                titleSection = optionMenu[17];
                break;
            case 23:
                presenter.fetchPlayerWithTeam(CROATIA);
                titleSection = optionMenu[18];
                break;
            case 24:
                presenter.fetchPlayerWithTeam(NIGERIA);
                titleSection = optionMenu[19];
                break;
            //E
            case 26:
                presenter.fetchPlayerWithTeam(BRAZIL);
                titleSection = optionMenu[20];
                break;
            case 27:
                presenter.fetchPlayerWithTeam(SWITZERLAND);
                titleSection = optionMenu[21];
                break;
            case 28:
                presenter.fetchPlayerWithTeam(COSTA_RICA);
                titleSection = optionMenu[22];
                break;
            case 29:
                presenter.fetchPlayerWithTeam(SERBIA);
                titleSection = optionMenu[23];
                break;

            //F
            case 31:
                presenter.fetchPlayerWithTeam(GERMANY);
                titleSection = optionMenu[24];
                break;
            case 32:
                presenter.fetchPlayerWithTeam(MEXICO);
                titleSection = optionMenu[25];
                break;
            case 33:
                presenter.fetchPlayerWithTeam(SWEDEN);
                titleSection = optionMenu[26];
                break;
            case 34:
                presenter.fetchPlayerWithTeam(SOUTH_KOREA);
                titleSection = optionMenu[27];
                break;
            //G
            case 36:
                presenter.fetchPlayerWithTeam(BELGIUM);
                titleSection = optionMenu[28];
                break;
            case 37:
                presenter.fetchPlayerWithTeam(PANAMA);
                titleSection = optionMenu[29];
                break;
            case 38:
                presenter.fetchPlayerWithTeam(TUNISIA);
                titleSection = optionMenu[30];
                break;
            case 39:
                presenter.fetchPlayerWithTeam(ENGLAND);
                titleSection = optionMenu[31];
                break;
            //H
            case 41:
                presenter.fetchPlayerWithTeam(POLAND);
                titleSection = optionMenu[32];
                break;
            case 42:
                presenter.fetchPlayerWithTeam(SENEGAL);
                titleSection = optionMenu[33];
                break;
            case 43:
                presenter.fetchPlayerWithTeam(COLOMBIA);
                titleSection = optionMenu[34];
                break;
            case 44:
                presenter.fetchPlayerWithTeam(JAPAN);
                titleSection = optionMenu[35];
                break;
        }
        drawerLayout.closeDrawer(Gravity.LEFT);
    }
}
