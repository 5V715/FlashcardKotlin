package org.evil.mvc

import mu.KLogging
import org.evil.data.Card
import org.evil.data.CardRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.ModelAndView
import java.util.*

@RestController
open class CardController(@Autowired repo : CardRepository) {
    companion object : KLogging()

    val repository : CardRepository = repo

    @RequestMapping(path = arrayOf("/save"), method = arrayOf(RequestMethod.POST))
    fun addCard(@RequestBody card :Card) : Unit {
        logger.info { "saving card : ${card.toString()} id : ${repository.save(card).id}"}
    }

    @RequestMapping(path = arrayOf("/shuffle"), method = arrayOf(RequestMethod.GET))
    fun shuffle() : List<Card> {
        return shuffle(repository.findAll().toMutableList())
    }

    @RequestMapping(path = arrayOf("/play"), method = arrayOf(RequestMethod.GET))
    fun play() : ModelAndView {
        return ModelAndView("views/play",mapOf("cards" to shuffle()))
    }

    private fun <T:Comparable<T>>shuffle(items:MutableList<T>):List<T>{
        val rg : Random = Random()
        for (i in 0..items.size - 1) {
            val randomPosition = rg.nextInt(items.size)
            val tmp : T = items[i]
            items[i] = items[randomPosition]
            items[randomPosition] = tmp
        }
        return items
    }

}
