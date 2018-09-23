package com.thedeveloperworldisyours.championsaffinity.add

import com.google.firebase.database.FirebaseDatabase
import com.lumbralessoftware.voterussia2018.NewPlayer
import com.thedeveloperworldisyours.championsaffinity.Constantss

/**
 * Created by javiergonzalezcabezas on 17/9/18.
 */
class AddDialogPresenter () {
    fun savePlayer(champions:NewPlayer) {
        val databaseReference = FirebaseDatabase.getInstance().reference
        val player = databaseReference.child(Constantss.PLAYERS)
        val builderString = StringBuilder()
        builderString.append(champions.team)
        builderString.append("-")
        builderString.append(champions.number)
        val idPlayer = player.child("1")
        /*champions.club = "Barcelona"
        champions.goalsFavor = "4"
        champions.id = 1
        champions.image = "https://firebasestorage.googleapis.com/v0/b/voterussia2018.appspot.com/o/1-1b.jpeg?alt=media&token=36a034f5-1c69-460f-857a-bf2b6f4d0589"
        champions.imageURL = "https://firebasestorage.googleapis.com/v0/b/voterussia2018.appspot.com/o/1-1b.jpeg?alt=media&token=36a034f5-1c69-460f-857a-bf2b6f4d0589"
        champions.name = "Javier"
        champions.nationality = 1
        champions.number = "10"
        champions.position =  3
        champions.team = 1
        champions.vote = "3.5"*/
        idPlayer.setValue(champions)
    }
}