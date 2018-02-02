fun main(args: Array<String>) {
    if (args.isEmpty()) {
        println("Incorrect number of parameters: requires class name + args")
        System.exit(-1)
    }

    try {
        val cl = Class.forName(args[0])
        val arguments = args.drop(1)
        println(cl)
        println(arguments)
    } catch (ex: ClassNotFoundException) {
        println(ex)
    }
}