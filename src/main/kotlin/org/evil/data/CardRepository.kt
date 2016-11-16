package org.evil.data

import org.springframework.data.repository.CrudRepository

interface CardRepository : CrudRepository<Card,Long> {

    fun findByWord(word: String)

}
