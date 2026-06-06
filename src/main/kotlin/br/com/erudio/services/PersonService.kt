package br.com.erudio.services

import br.com.erudio.exceptions.ResourceNotFoundException
import br.com.erudio.model.Person
import br.com.erudio.repository.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.logging.Logger

@Service
class PersonService {

    @Autowired
    private lateinit var repository: PersonRepository
    private val logger = Logger.getLogger(PersonService::class.java.name)

    fun findById(id: Long): Person {
        logger.info("Finding one person!")

        return repository.findById(id)
            .orElseThrow { ResourceNotFoundException("No records found for this ID") }
    }

    fun findAll(): List<Person> {
        logger.info("Finding all person!")

        return repository.findAll()

    }

    fun create(person: Person): Person {
        logger.info("Creating one person with name ${person.firstname}!")

        return respository.save(person)
    }

    fun update(person: Person): Person {
        logger.info("Updating one person with name ${person.firstname}!")

        var entity = repository.findById(person.id)
            .orElseThrow { ResourceNotFoundException("No records found for this ID") }

        entity.firstName = person.firstName
        entity.lastName = person.lastName
        entity.address = person.address
        entity.gender = person.gender

        return respository.save(person)
    }

    fun delete(id: Long){
        logger.info("Deleting one person with name ${person.firstname}!")

        var entity = repository.findById(id)
            .orElseThrow { ResourceNotFoundException("No records found for this ID") }

        repository.delete(entity)
    }

}