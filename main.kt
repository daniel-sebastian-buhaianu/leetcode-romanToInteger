fun main() {

    // Read and store user input
    val userInput = getUserInput("Roman numeral: ")

    // Ensure proper usage
    if (!isRomanNumeral(userInput)) {
        println("Error. You must enter a valid roman numeral")
        return 
    }

    // Print result
    println(romanNumeralToInt(userInput))
    
}

// Asks for user input and returns it
fun getUserInput(s: String): String {
    print(s)
    return readln()
}

// Checks if string is roman numeral
fun isRomanNumeral(s: String): Boolean {
    val romanLetters = setOf('I', 'V', 'X', 'L', 'C', 'D', 'M')

    for (i in 0..s.length - 1) {
        if (!romanLetters.contains(s[i])) {
            return false
        } else if (i + 1 == s.length) {
            return true
        } else if (i > 0) {
            if (s[i] == 'M') {
                if (s[i+1] == 'M')
                {
                    println("p1")
                    return false
                }
                
                if (s[i-1] == 'C' && romanLetters.indexOf(s[i+1]) > 3)
                {
                    println("p2")
                    return false
                }
            }

            if (s[i] == 'D') {
                if (s[i+1] == 'M' || s[i+1] == 'D') {
                    println("p3")
                    return false
                }
                
                if (s[i-1] == 'C' && romanLetters.indexOf(s[i+1]) > 3) {
                    println("p4")
                    return false
                }
            }

            if (s[i] == 'C') {
                if (s[i-1] == 'X' && romanLetters.indexOf(s[i+1]) > 1)
                {
                    println("p5")
                    return false
                }
                
                if (s[i+1] == 'D' || s[i+1] == 'M' && s[i-1] == 'C') {
                    println("p6")
                    return false
                }
            }

            if (s[i] == 'L') {
                if (romanLetters.indexOf(s[i+1]) > romanLetters.indexOf(s[i])) {
                    println("p7")
                    return false
                }
                
                if (s[i-1] == 'X' && romanLetters.indexOf(s[i+1]) > 1) {
                    println("p8")
                    return false
                }
            }

            if (s[i] == 'X') {
                if (s[i+1] == 'D' || s[i+1] == 'M') {
                    println("p9")
                    return false
                }
                
                if (s[i-1] == 'I' && romanLetters.indexOf(s[i+1]) >= 0) {
                    println("p10")
                    return false
                }

                if (s[i+1] == 'L' || s[i+1] == 'C' && s[i-1] == 'X') {
                    println("p11")
                    return false
                }
            }

            if (s[i] == 'V')
            {
                if (s[i+1] != 'I') {
                    println("p12")
                    return false
                }
                
                if (s[i-1] == 'I' && romanLetters.indexOf(s[i+1]) >= 0) {
                    println("p13")
                    return false
                }
            }
            
            if (s[i] == 'I') {
                if (romanLetters.indexOf(s[i+1]) > 2) {
                    println("p14")
                    return false
                }
                
                if (s[i+1] == 'V' || s[i+1] == 'X' && s[i-1] == 'I') {
                    println("p15")
                    return false
                }
            }
        }
    }

    return true
}

// Converts roman letter(s) to integer
fun romanLetterToInt(romanLetter: String): Int? {
    val romanLettersToInt = mapOf(
        "I" to 1,
        "IV" to 4,
        "V" to 5,
        "IX" to 9,
        "X" to 10,
        "XL" to 40,
        "L" to 50,
        "XC" to 90,
        "C" to 100,
        "CD" to 400,
        "D" to 500,
        "CM" to 900,
        "M" to 1000
    )
    return romanLettersToInt.get(romanLetter)    
}

// Converts roman numeral to integer
fun romanNumeralToInt(romanNumeral: String): Int {
    var result: Int = 0
    var i = 0
    while (i < romanNumeral.length) {
        var romanLetter: String = romanNumeral[i].toString()

        if (i + 1 != romanNumeral.length)
        {
            when (romanNumeral[i]) {
                'I' -> {
                    if (romanNumeral[i+1] == 'V' || romanNumeral[i+1] == 'X') {
                        romanLetter = romanNumeral[i].toString() + romanNumeral[i+1].toString()
                        i++
                    }
                }
                'X' -> {
                    if (romanNumeral[i+1] == 'L' || romanNumeral[i+1] == 'C') {
                        romanLetter = romanNumeral[i].toString() + romanNumeral[i+1].toString()
                        i++
                    }
                }
                'C' -> {
                    if (romanNumeral[i+1] == 'D' || romanNumeral[i+1] == 'M') {
                        romanLetter = romanNumeral[i].toString() + romanNumeral[i+1].toString()
                        i++
                    }
                }
            }
        }

        result += romanLetterToInt(romanLetter)?: 0
        i++
    }
    return result
}