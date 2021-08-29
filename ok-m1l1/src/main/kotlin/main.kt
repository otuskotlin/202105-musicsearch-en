fun printLine() {
    println("------------------")
}


fun main() {
    println("Hello World!")

    printLine()

    val x = 5 / 2
    println(x)

    printLine()

    val someType: Any = 10

    val typeString = when (someType) {
        1 -> "This is one"
        is Double, Float -> "This is Double or Float"
        in 11..15 -> "In range from 11 to 15"
        !is Long -> "Not a Long"
        is String -> "This is String. Checking if it's starts with s: ${someType.startsWith("s")}"
        else -> "Unknown"
    }

    println(typeString)

    printLine()

    val number = 11
    val test = when (val multiply = number * 10) {
        in 10..100 -> "$multiply <= 10"
        in 100..1000 -> "$multiply > 10"
        else -> "Multiply is too much for me"
    }
    println(test)

    printLine()

    val helloOtus = "hello, otus!"

    for (ch in helloOtus) {
        print(ch)
    }

    println()

    printLine()

    val array = arrayOf(1, 2, 3)
    for ((index, element) in array.withIndex()) {
        println("element at index $index is $element")
    }

    printLine()

    for (i in 1..10) {
        print("$i ")
    }

    println()
    printLine()

    for (boomCounter in 10 downTo 1 step 1) {
        print("$boomCounter ")
        if (boomCounter == 1) {
            print("...BOOM")
        }
    }

    println()
    printLine()

    countNewSteps(currentStepCounter = 5, from = 10, to = 10)
    println()
    countNewSteps(currentStepCounter = 5, to = 10)
    println()
//    countNewSteps(5, 10) // compilation error

    printLine()

    functionWithArg("1", "20", "30", otherArg = 10)

    printLine()

//    calculateWithMultiplication(10, 20) // raise NotImplementationError

    printLine()

    // lambda functions
    fun function() = print("Hello Otus!") // simple function
    val iAmLambda = { println("hello") } // simple Lambda
    iAmLambda()

    val giveName = { str: String -> "My name is $str" } // with argument
    println(giveName("John")) // -> My name is John

    // with type and multiple args
    val multiplication: (Int, Int) -> String = { first: Int, second: Int -> "Multiplication = ${first * second}" }
    println(multiplication(1, 4))

    // High order functions
    fun strengthCalculator(strength: Int, calculator: (Int) -> Int): Int {
        return calculator(strength) / 100
    }

    val myNewStrength = strengthCalculator(1000) {
        it * it
    }

    strengthCalculator(50) { oldStrength -> oldStrength / 10 }

    fun echo(sayIt: (toPerson: String, withAge: Int) -> String, name: String, age: Int) {
        sayIt(name, age)
    }

    echo({ toPerson, _ ->
        "Hello, $toPerson"
    }, "Alice", 33)

    fun lambda(func: () -> Unit) {
        func()
    }

    lambda(fun() = println("Hello"))

    printLine()

    // Extensions
    fun Int.toCustomString() = "This is integer $this"
    fun Any?.toCustomString(): String {
        return if (this == null) {
            "Nothing to return"
        } else {
            "$this this is custom string"
        }
    }

    fun Int.toLong(): String = "Convert int to Long"

    var integer: Int? = null
    val newNumber = 10
    println(10.toCustomString()) // This is integer 10
    println(newNumber.toLong()) // 10
    println(integer.toCustomString()) // Nothing to return

    printLine()

    // Receiver
    val greet: String.() -> Unit = { println("Hello, $this") }
    greet("Dee") // Hello, Dee
    "CoolGuy".greet() // Hello, CoolGuy
    val greetWithSurname: String.(String) -> Unit = { surname: String -> println("Hello, $this $surname") }
    greetWithSurname("Ivan", "Gorky") // Hello, Ivan Gorky
    "Ivan".greetWithSurname("Gorky") // Hello, Ivan Gorky
}

// Functions

fun countNewSteps(currentStepCounter: Int, from: Int = 10, to: Int): Int {
    var tempStepCounter = currentStepCounter

    for (i in from..to) {
        tempStepCounter += i
    }

    println("I made $tempStepCounter steps")
    return tempStepCounter
}

fun functionWithArg(vararg args: String, otherArg: Int) {
    println("otherArg: $otherArg")
    println(args[0])
    println(args.joinToString())
}

fun TODO(): Nothing = throw NotImplementedError()

fun calculateWithMultiplication(first: Int, second: Int): Int = TODO()



