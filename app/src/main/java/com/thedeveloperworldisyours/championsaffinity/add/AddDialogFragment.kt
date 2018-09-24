package com.thedeveloperworldisyours.championsaffinity.add

import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.thedeveloperworldisyours.championsaffinity.R
import android.content.DialogInterface
import android.support.v7.app.AlertDialog
import android.widget.ArrayAdapter
import com.google.firebase.database.FirebaseDatabase
import com.lumbralessoftware.voterussia2018.NewPlayer
import com.thedeveloperworldisyours.championsaffinity.App
import com.thedeveloperworldisyours.championsaffinity.Constantss.Companion.PLAYERS
import kotlinx.android.synthetic.main.add_dialog_fragment.*


/**
 * Created by javiergonzalezcabezas on 5/8/18.
 */
class AddDialogFragment: DialogFragment() {

    //lateinit var addDialogPresenter: AddDialogPresenter
    var res: android.content.res.Resources? = null

    val champions = NewPlayer()

    companion object {
        fun newInstance(name: String): AddDialogFragment {
            val fragment = AddDialogFragment()
            val args = Bundle()
            //args.putString(EXTRA_NAME, name)
            fragment.setArguments(args)
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view : View = inflater?.inflate(R.layout.add_dialog_fragment, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //detail_fragment_description_title_textView.setText(namePlayer)

        //App.scoreComponent.inject(this)
        add_button.setOnClickListener {
            addPlayer()
            dismiss()
        }
        add_show_nationality.setOnClickListener {
            showNationality()
        }
        add_show_club.setOnClickListener {
            showClubs()
        }
    }

    fun addPlayer() {

        val databaseReference = FirebaseDatabase.getInstance().reference
        val player = databaseReference.child(PLAYERS)
        val optionMenu = arrayOf<String>(
                resources.getString(R.string.club_at_madrid),
                resources.getString(R.string.club_barcelona),
                resources.getString(R.string.club_bayern),
                resources.getString(R.string.club_club_brugge),

                resources.getString(R.string.club_cska),
                resources.getString(R.string.club_dortmund),
                resources.getString(R.string.club_galatasaray),
                resources.getString(R.string.club_Hoffenshim),

                resources.getString(R.string.club_inter),
                resources.getString(R.string.club_juventus),
                resources.getString(R.string.club_liverpool),
                resources.getString(R.string.club_lokonmotive),

                resources.getString(R.string.club_lyon),
                resources.getString(R.string.club_city),
                resources.getString(R.string.club_united),
                resources.getString(R.string.club_monaco),

                resources.getString(R.string.club_napoli),
                resources.getString(R.string.club_paris),
                resources.getString(R.string.club_plzen),
                resources.getString(R.string.club_porto),

                resources.getString(R.string.club_real),
                resources.getString(R.string.club_roma),
                resources.getString(R.string.club_skakhtar),
                resources.getString(R.string.club_schalke),

                resources.getString(R.string.club_tottenham),
                resources.getString(R.string.club_valencia),
                resources.getString(R.string.country_tunisia),
                resources.getString(R.string.country_england),

                resources.getString(R.string.country_poland),
                resources.getString(R.string.country_senegal),
                resources.getString(R.string.country_colombia),
                resources.getString(R.string.country_japan))
        champions.goalsFavor = "4"
        champions.id = 1
        champions.image = "https://firebasestorage.googleapis.com/v0/b/voterussia2018.appspot.com/o/1-1b.jpeg?alt=media&token=36a034f5-1c69-460f-857a-bf2b6f4d0589"
        champions.imageURL = "https://firebasestorage.googleapis.com/v0/b/voterussia2018.appspot.com/o/1-1b.jpeg?alt=media&token=36a034f5-1c69-460f-857a-bf2b6f4d0589"
        champions.name =add_title_name_editText.text.toString()
        champions.nationality = 1
        champions.number = "10"
        champions.position =  3
        champions.vote = "3.5"
        val builderString = StringBuilder()
        builderString.append(champions.team)
        builderString.append("-")
        builderString.append(champions.number)
        val club:Int = champions.team!!.toInt()
        champions.club = optionMenu[club]
        val idPlayer = player.child(builderString.toString())

        //addDialogPresenter.savePlayer(champions)
        idPlayer.setValue(champions)
    }

    fun showNationality() {
        val builderNationality = AlertDialog.Builder(activity)
        builderNationality.setTitle(getString(R.string.add_nationality))
        val arrayAdapter = ArrayAdapter<String>(activity, android.R.layout.select_dialog_singlechoice)
        arrayAdapter.add(getString(R.string.nationality_russia))
        arrayAdapter.add(getString(R.string.nationality_saudi))
        arrayAdapter.add(getString(R.string.nationality_egypt))
        arrayAdapter.add(getString(R.string.nationality_uruguay))

        arrayAdapter.add(getString(R.string.nationality_portugal))
        arrayAdapter.add(getString(R.string.nationality_spain))
        arrayAdapter.add(getString(R.string.nationality_morocco))
        arrayAdapter.add(getString(R.string.nationality_iran))

        arrayAdapter.add(getString(R.string.nationality_france))
        arrayAdapter.add(getString(R.string.nationality_australia))
        arrayAdapter.add(getString(R.string.nationality_peru))
        arrayAdapter.add(getString(R.string.nationality_denmark))

        arrayAdapter.add(getString(R.string.nationality_argentina))
        arrayAdapter.add(getString(R.string.nationality_iceland))
        arrayAdapter.add(getString(R.string.nationality_croatia))
        arrayAdapter.add(getString(R.string.nationality_nigeria))

        arrayAdapter.add(getString(R.string.nationality_brazil))
        arrayAdapter.add(getString(R.string.nationality_switzerland))
        arrayAdapter.add(getString(R.string.nationality_costa_rica))
        arrayAdapter.add(getString(R.string.nationality_serbia))

        arrayAdapter.add(getString(R.string.nationality_germany))
        arrayAdapter.add(getString(R.string.nationality_mexico))
        arrayAdapter.add(getString(R.string.nationality_sweden))
        arrayAdapter.add(getString(R.string.nationality_south_korea))

        arrayAdapter.add(getString(R.string.nationality_belgium))
        arrayAdapter.add(getString(R.string.nationality_panama))
        arrayAdapter.add(getString(R.string.nationality_tunisia))
        arrayAdapter.add(getString(R.string.nationality_england))

        arrayAdapter.add(getString(R.string.nationality_poland))
        arrayAdapter.add(getString(R.string.nationality_senegal))
        arrayAdapter.add(getString(R.string.nationality_colombia))
        arrayAdapter.add(getString(R.string.nationality_japan))

        builderNationality.setNegativeButton(android.R.string.cancel, DialogInterface.OnClickListener { dialog, which -> dialog.dismiss() })

        builderNationality.setAdapter(arrayAdapter, DialogInterface.OnClickListener() { dialog, which ->
            champions.nationality =  which.toLong()
            dialog.dismiss()
            //add_show_nationality.text = arrayAdapter.getItem(which)
        })
        builderNationality.show()

    }

    fun showClubs() {
        val builderSingle = AlertDialog.Builder(activity)
        builderSingle.setTitle(getString(R.string.add_team))

        val arrayAdapter = ArrayAdapter<String>(activity, android.R.layout.select_dialog_singlechoice)
        arrayAdapter.add(getString(R.string.club_at_madrid))
        arrayAdapter.add(getString(R.string.club_barcelona))
        arrayAdapter.add(getString(R.string.club_bayern))
        arrayAdapter.add(getString(R.string.club_club_brugge))
        arrayAdapter.add(getString(R.string.club_cska))
        arrayAdapter.add(getString(R.string.club_dortmund))
        arrayAdapter.add(getString(R.string.club_galatasaray))
        arrayAdapter.add(getString(R.string.club_Hoffenshim))
        arrayAdapter.add(getString(R.string.club_inter))
        arrayAdapter.add(getString(R.string.club_juventus))
        arrayAdapter.add(getString(R.string.club_liverpool))
        arrayAdapter.add(getString(R.string.club_lokonmotive))
        arrayAdapter.add(getString(R.string.club_lyon))
        arrayAdapter.add(getString(R.string.club_city))
        arrayAdapter.add(getString(R.string.club_united))
        arrayAdapter.add(getString(R.string.club_monaco))
        arrayAdapter.add(getString(R.string.club_napoli))
        arrayAdapter.add(getString(R.string.club_paris))
        arrayAdapter.add(getString(R.string.club_plzen))
        arrayAdapter.add(getString(R.string.club_porto))
        arrayAdapter.add(getString(R.string.club_real))
        arrayAdapter.add(getString(R.string.club_roma))
        arrayAdapter.add(getString(R.string.club_skakhtar))
        arrayAdapter.add(getString(R.string.club_schalke))
        arrayAdapter.add(getString(R.string.club_tottenham))
        arrayAdapter.add(getString(R.string.club_valencia))

        builderSingle.setNegativeButton(getString(android.R.string.cancel), DialogInterface.OnClickListener { dialog, which -> dialog.dismiss() })

        builderSingle.setAdapter(arrayAdapter, DialogInterface.OnClickListener { dialog, which ->
            champions.team =  which.toLong()
            dialog.dismiss()
            //val strName = arrayAdapter.getItem(which)
            //add_show_club.text = strName
        })
        builderSingle.show()
    }

}