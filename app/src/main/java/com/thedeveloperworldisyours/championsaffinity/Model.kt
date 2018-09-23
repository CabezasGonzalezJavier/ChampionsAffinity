package com.lumbralessoftware.voterussia2018

/**
 * Created by javiergonzalezcabezas on 7/6/18.
 */
class Vote {

    var sum: Int? = null
    var id: Int? = null
    var one: Int? = null
    var two: Int? = null
    var three: Int? = null
    var four: Int? = null
    var five: Int? = null
    var total: Int? = null

}


class ElementList {

    private var name: String? = null
    private var section: Boolean? = null
    private var nextSection: Boolean? = null

    constructor(name: String, section: Boolean, nextSection: Boolean) {
        this.name = name
        this.section = section
        this.nextSection = nextSection
    }

    fun isSection(): Boolean? {
        return section
    }

    fun setSection(mSection: Boolean) {
        this.section = mSection
    }

    fun getName(): String? {
        return name
    }

    fun setName(name: String) {
        this.name = name
    }

    fun ismNextSection(): Boolean? {
        return nextSection
    }

    fun setmNextSection(mNextSection: Boolean) {
        this.nextSection = mNextSection
    }

}

class NewPlayer {

    var club: String? = null
    var goalsFavor: String? = null
    var id: Int? = null
    var image : String? = null
    var imageURL: String? = null
    var name: String? = null
    var nationality: Long? = null
    var number: String? = null
    var position: Long? = null
    var team: Long? = null
    var vote: String? = null

}