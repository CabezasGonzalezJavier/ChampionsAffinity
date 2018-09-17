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
import com.thedeveloperworldisyours.championsaffinity.Constantss.Companion.PLAYERS
import kotlinx.android.synthetic.main.add_dialog_fragment.*


/**
 * Created by javiergonzalezcabezas on 5/8/18.
 */
class AddDialogFragment: DialogFragment() {
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

        add_button.setOnClickListener {
            addPlayer()
            dismiss()
        }
        add_show_club.setOnClickListener {
            showClubs()
        }
    }

    fun addPlayer() {

        val databaseReference = FirebaseDatabase.getInstance().reference
        val player = databaseReference.child(PLAYERS)
        val idPlayer = player.child("1")
        val champions = NewPlayer()
        champions.club = "Barcelona"
        champions.goalsFavor = "4"
        champions.id = 1
        champions.image = "https://firebasestorage.googleapis.com/v0/b/voterussia2018.appspot.com/o/1-1b.jpeg?alt=media&token=36a034f5-1c69-460f-857a-bf2b6f4d0589"
        champions.imageURL = "https://firebasestorage.googleapis.com/v0/b/voterussia2018.appspot.com/o/1-1b.jpeg?alt=media&token=36a034f5-1c69-460f-857a-bf2b6f4d0589"
        champions.name = "Javier"
        champions.nationality = "1"
        champions.number = "10"
        champions.position =  "3"
        champions.team = "1"
        champions.vote = "3.5"
        idPlayer.setValue(champions)
    }

    fun showClubs() {
        val builderSingle = AlertDialog.Builder(activity)
        builderSingle.setTitle("Select One Name:-")

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

        builderSingle.setNegativeButton("cancel", DialogInterface.OnClickListener { dialog, which -> dialog.dismiss() })

        builderSingle.setAdapter(arrayAdapter, DialogInterface.OnClickListener { dialog, which ->
            val strName = arrayAdapter.getItem(which)
            val builderInner = AlertDialog.Builder(activity)
            builderInner.setMessage(strName)
            builderInner.setTitle("Your Selected Item is")
            builderInner.setPositiveButton("Ok", DialogInterface.OnClickListener { dialog, which -> dialog.dismiss() })
            builderInner.show()
        })
        builderSingle.show()
    }

}