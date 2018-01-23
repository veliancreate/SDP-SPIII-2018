import java.util.*

fun main(args: Array<String>) {
    val controlUnit = ControlUnit()

    val scanner = Scanner(System.`in`)
    var input = ""
    do {
        print("Type \"poll\" to poll all sensors once or \"exit\" to exit: ")
        input = scanner.nextLine()
        if (input == "poll") {
            controlUnit.pollSensors()
        }
    } while (input != "exit")
}