package observer

// Represents each Observer that is monitoring changes in the subject

class StockObserver(
        // Will hold reference to the StockGrabber object
        private val stockGrabber: Subject) : Observer {

    private var ibmPrice: Double = 0.toDouble()
    private var aaplPrice: Double = 0.toDouble()
    private var googPrice: Double = 0.toDouble()

    // Used to track the observers
    private val observerID: Int

    init {
        // Assign an observer ID and increment the static counter
        this.observerID = ++observerIDTracker

        // Message notifies user of new observer
        println("New Observer " + this.observerID)

        // Add the observer to the Subjects List
        stockGrabber.register(this)


    }
// Called to update all observers

    override fun update(ibmPrice: Double, aaplPrice: Double, googPrice: Double) {

        this.ibmPrice = ibmPrice
        this.aaplPrice = aaplPrice
        this.googPrice = googPrice

        println(observerID)
        println("IBM: $ibmPrice")
        println("AAPL: $aaplPrice")
        println("GOOG: $googPrice")
    }

    companion object {
        private var observerIDTracker = 0
    }
}