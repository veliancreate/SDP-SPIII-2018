package observer

import java.text.DecimalFormat

class GetTheStock(
        // Will hold reference to the StockGrabber object
        private val stockGrabber: Subject, newStartTime: Int,
        // Could be used to set how many seconds to wait in Thread.sleep() below

        private val stock: String, private var price: Double)
// Store the reference to the stockGrabber object so
// I can make calls to its methods
// startTime = newStartTime;  Not used to have variable sleep time
    : Runnable {

    override fun run() {
        for (i in 1..20) {

            try {
                // Sleep for 2 seconds
                Thread.sleep(2000)

                // Use Thread.sleep(startTime * 1000); to
                // make sleep time variable
            } catch (e: InterruptedException) {
            }

            // Generates a random number between -.03 and .03
            val randNum = Math.random() * .06 - .03

            // Formats decimals to 2 places
            val df = DecimalFormat("#.##")

            // Change the price and then convert it back into a double
            price = java.lang.Double.valueOf(df.format(price + randNum))
            when (stock) {
                "IBM" -> (stockGrabber as StockGrabber).ibmPrice = price
                "AAPL" -> (stockGrabber as StockGrabber).aaplPrice = price
                "GOOG" -> (stockGrabber as StockGrabber).googPrice = price
            }

            println("${stock}: ${df.format(price + randNum)} ${df.format(randNum)}")
            println()
        }
    }
}