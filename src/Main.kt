import java.util.*

/**
 * Created by james on 14/02/2017.
 */


fun  generateBigArray(): Array<Int> {
    var array = IntArray(Random().nextInt(10000), {i -> Random().nextInt(1000000)})
    return array.toTypedArray()
}

class ArrayManipulator {

    fun mean(array: Array<Int>): Double {
        val sum = array.sum()
        return (sum / array.size).toDouble()
    }

    fun mode(array: Array<Int>): Double {
        array.sort()
        var maxValue: Int = 0
        var maxCount: Int = 0

        for (i in 0..array.size - 1) {
            val count = (0..array.size - 1).count { array[it] === array[i] }
            if (count > maxCount) {
                maxCount = count
                maxValue = array[i]
            }
        }

        return maxValue.toDouble()
    }

    fun median(array: Array<Int>): Double {
        val middle = array.size / 2
        if (array.size % 2 === 1) {
            return array[middle].toDouble()
        } else {
            return (array[middle - 1] + array[middle]) / 2.0
        }
    }

    fun range(array: Array<Int>): Double {
        array.sort()
        return (array[array.size - 1] - array[0]).toDouble()
    }

    fun getAllStats(array: Any): Any? {
        val mean = mean(array as Array<Int>)
        val mode = mode(array)
        val median = median(array)
        val range = range(array)
        return "Mean: $mean Mode: $mode Median: $median Range: $range"
    }
}

class StringSearch {
    var stringList: List<String> = listOf("Architect", "Software engineer", "Quantity surveyor", "Accountant")

    fun processInput(arg: String): String {
        var split = arg.split(" ")
        var stringToUse = SplitStrings(split[0], split[1])
        if(!stringToUse.lastString.isBlank()) {
            if(split[1].equals(stringToUse.lastString)) {
                return stringToUse.firstString + " " + stringToUse.lastString
            } else {
              return stringToUse.firstString
            }
        }
        return "No match found"
    }

}

class SplitStrings {
    var firstString: String = ""
    var lastString: String = ""

    constructor(first: String, second: String = "") {
        firstString = first
        lastString = second
    }
}


fun main(args: Array<String>) {
    var bigArray = generateBigArray()
    println("Here are the stats: " + ArrayManipulator().getAllStats(bigArray))

    var search = StringSearch()
    println("Here is the search: " + search.processInput(args[0] + " " + args[1]))
}
