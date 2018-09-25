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
        add_show_date.setOnClickListener {
            addDate()
        }
        add_show_number.setOnClickListener{
            addNumber()
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

    fun addDate() {
        val builderDate = AlertDialog.Builder(activity)
        builderDate.setTitle(getString(R.string.add_number_date))
        builderDate.setView(R.layout.add_dialog_date)
        builderDate.setNegativeButton(android.R.string.cancel,  { dialog, which -> dialog.dismiss() })
        builderDate.setPositiveButton(android.R.string.ok, {dialogInterface, which->  })
        builderDate.show()
    }
    fun addNumber() {

        val builderNumber = AlertDialog.Builder(activity)
        builderNumber.setTitle(getString(R.string.add_number))
        val arrayAdapter = ArrayAdapter<String>(activity, android.R.layout.select_dialog_singlechoice)
        arrayAdapter.add(getString(R.string.number_1))
        arrayAdapter.add(getString(R.string.number_2))
        arrayAdapter.add(getString(R.string.number_3))
        arrayAdapter.add(getString(R.string.number_4))
        arrayAdapter.add(getString(R.string.number_5))
        arrayAdapter.add(getString(R.string.number_6))
        arrayAdapter.add(getString(R.string.number_7))
        arrayAdapter.add(getString(R.string.number_8))
        arrayAdapter.add(getString(R.string.number_9))

        arrayAdapter.add(getString(R.string.number_10))
        arrayAdapter.add(getString(R.string.number_11))
        arrayAdapter.add(getString(R.string.number_12))
        arrayAdapter.add(getString(R.string.number_13))
        arrayAdapter.add(getString(R.string.number_14))
        arrayAdapter.add(getString(R.string.number_15))
        arrayAdapter.add(getString(R.string.number_16))
        arrayAdapter.add(getString(R.string.number_17))
        arrayAdapter.add(getString(R.string.number_18))
        arrayAdapter.add(getString(R.string.number_19))

        arrayAdapter.add(getString(R.string.number_21))
        arrayAdapter.add(getString(R.string.number_22))
        arrayAdapter.add(getString(R.string.number_23))
        arrayAdapter.add(getString(R.string.number_24))
        arrayAdapter.add(getString(R.string.number_25))
        arrayAdapter.add(getString(R.string.number_26))
        arrayAdapter.add(getString(R.string.number_27))
        arrayAdapter.add(getString(R.string.number_28))
        arrayAdapter.add(getString(R.string.number_29))
        arrayAdapter.add(getString(R.string.number_30))
        builderNumber.setNegativeButton(android.R.string.cancel, { dialog, which -> dialog.dismiss() })

        builderNumber.setAdapter(arrayAdapter, { dialog, which ->
            val another = which + 1
            champions.number =  another.toString()
            dialog.dismiss()
            //add_show_nationality.text = arrayAdapter.getItem(which)
        })
        builderNumber.show()
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

        builderNationality.setNegativeButton(android.R.string.cancel, { dialog, which -> dialog.dismiss() })

        builderNationality.setAdapter(arrayAdapter, { dialog, which ->
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

        builderSingle.setNegativeButton(getString(android.R.string.cancel), { dialog, which -> dialog.dismiss() })

        builderSingle.setAdapter(arrayAdapter, { dialog, which ->
            champions.team =  which.toLong()
            dialog.dismiss()
            //val strName = arrayAdapter.getItem(which)
            //add_show_club.text = strName
        })
        builderSingle.show()
    }

}