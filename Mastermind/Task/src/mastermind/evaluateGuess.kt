package mastermind


data class Evaluation(val rightPosition: Int, val wrongPosition: Int)

fun evaluateGuess(secret: String, guess: String): Evaluation {
    var rightPosition = 0
    var wrongPosition = 0
    val charList = ArrayList<Char>()
    val charList1 = ArrayList<Char>()
    charList1.addAll(secret.toList())
    charList.addAll(guess.toList())
    for (i in secret.indices) {
        if (secret[i] == guess[i]) {
            rightPosition++
            charList.remove(secret[i])
            charList1.remove(secret[i])
        }
    }
    for (i in charList1.indices) {
        if (charList.contains(charList1[i])) {
            wrongPosition++
            charList.remove(charList1[i])
        }
    }
    return Evaluation(rightPosition, wrongPosition)
}
