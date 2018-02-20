package altreflect


object SpyMain {
    @JvmStatic
    fun main(args: Array<String>) {
        try {
            val thisClassPrinter = Spy.getSpy("Spy")
            thisClassPrinter.printAll(args)
        } catch (ex: ClassNotFoundException) {
            System.err.println("It broke!")
        }

    }
}
