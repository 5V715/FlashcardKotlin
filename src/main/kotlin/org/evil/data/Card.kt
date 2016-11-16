package org.evil.data

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
open class Card() {

    constructor(word: String, meaning:String) : this(){
        this.word = word
        this.meaning = meaning
    }

    var word: String = ""

    var meaning:String = ""

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = -1L

}




