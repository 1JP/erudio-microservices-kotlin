package br.com.erudio.services

import br.com.erudio.model.Person
import org.springframework.stereotype.Service
import java.util.concurrent.atomic.AtomicLong
import java.util.logging.Logger

@Service
class PersonService {

    private val counter: AtomicLong = AtomicLong()
    private val logger = Logger.getLogger(PersonService::class.java.name)

    fun findById(id: Long): Person {
        logger.info("Finding one person!")

        val person = Person();
        person.id = counter.incrementAndGet()
        person.firstName = "Joao Pedro"
        person.lastName = "Saturnino"
        person.address = "Matozinhos"
        person.gender = "Male"

        return person
    }

    fun findAll(): List<Person> {
        logger.info("Finding all person!")

        val persons: MutableList<Person> = ArrayList()

        for (i in 0 <= 7){
            val person = mockPerson();
            persons.add(person)
        }

        return persons;

    }

    fun create(person: Person): person

    fun update(person: Person): person

    fun delete(id: Long){}

    private fun mockPerson(i: Int): Person {
        val person = Person();
        person.id = counter.incrementAndGet()
        person.firstName = "Person name $i"
        person.lastName = "Last Name $i"
        person.address = "Matozinhos"
        person.gender = "Male"

        return person
    }
}