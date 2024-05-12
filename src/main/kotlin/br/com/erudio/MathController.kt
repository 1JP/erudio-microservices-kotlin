package br.com.erudio

import br.com.erudio.exceptions.UnsupportedMathOperationException
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

@RestController
class MathController {

    var counter: AtomicLong = AtomicLong()

    @RequestMapping(value = ["/sum/{numberOne}/{numberTwo}"])
    fun sum(@PathVariable(value="numberOne") numberOne: String?,
            @PathVariable(value="numberTwo") numberTwo: String?
    ): Double {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw UnsupportedMathOperationException("Please set a numeric value!")
        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }

    @RequestMapping(value = ["/sub/{numberOne}/{numberTwo}"])
    fun sub(@PathVariable(value="numberOne") numberOne: String?,
            @PathVariable(value="numberTwo") numberTwo: String?
    ): Double {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw UnsupportedMathOperationException("Please set a numeric value!")
        return convertToDouble(numberOne) - convertToDouble(numberTwo);
    }

    @RequestMapping(value = ["/mult/{numberOne}/{numberTwo}"])
    fun mult(@PathVariable(value="numberOne") numberOne: String?,
            @PathVariable(value="numberTwo") numberTwo: String?
    ): Double {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw UnsupportedMathOperationException("Please set a numeric value!")
        return convertToDouble(numberOne) * convertToDouble(numberTwo);
    }

    @RequestMapping(value = ["/division/{numberOne}/{numberTwo}"])
        fun division(@PathVariable(value="numberOne") numberOne: String?,
                     @PathVariable(value="numberTwo") numberTwo: String?
        ): Double {
            if(!isNumeric(numberOne) || !isNumeric(numberTwo))
                throw UnsupportedMathOperationException("Please set a numeric value!")
            return convertToDouble(numberOne) / convertToDouble(numberTwo);
    }

    @RequestMapping(value = ["/min/{numberOne}/{numberTwo}"])
    fun min(@PathVariable(value="numberOne") numberOne: String?,
            @PathVariable(value="numberTwo") numberTwo: String?
    ): Double {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw UnsupportedMathOperationException("Please set a numeric value!")
        return (convertToDouble(numberOne) + convertToDouble(numberTwo)) / 2;
    }

    @RequestMapping(value = ["/square/{numberOne}"])
    fun square(@PathVariable(value="numberOne") numberOne: String?
    ): Double {
        if(!isNumeric(numberOne))
            throw UnsupportedMathOperationException("Please set a numeric value!")
        return Math.sqrt(convertToDouble(numberOne));
    }

    private fun convertToDouble(strNumber: String?): Double {
        if(strNumber.isNullOrBlank()) return 0.0
        val number = strNumber.replace(",".toRegex(), ".")
        return if(isNumeric(number)) number.toDouble() else 0.0
    }

    private fun isNumeric(strNumber: String?): Boolean {
        if(strNumber.isNullOrBlank()) return false
        val number = strNumber.replace(",".toRegex(), ".")
        return number.matches("""[-+]?[0-9]*\.?[0-9]+""".toRegex())
    }

}