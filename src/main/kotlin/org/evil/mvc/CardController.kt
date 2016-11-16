package org.evil.mvc

import mu.KLogging
import org.evil.data.Card
import org.evil.data.CardRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
open class CardController(@Autowired repo : CardRepository) {
    companion object : KLogging()

    val repository : CardRepository = repo

    @RequestMapping(path = arrayOf("/listAll"), method = arrayOf(RequestMethod.GET))
    fun listAllCards(): List<Card> {
        return repository.findAll().toList()
    }

    @RequestMapping(path = arrayOf("/save"), method = arrayOf(RequestMethod.POST))
    fun addCard(@RequestBody card :Card) : Unit {
        logger.info { "saving card : ${card.toString()} id : ${repository.save(card).id}"}
    }

}
