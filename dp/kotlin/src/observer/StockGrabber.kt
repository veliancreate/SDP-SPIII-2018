package observer

// Uses the Subject interface to update all Observers

class StockGrabber : Subject {
    private lateinit var observers: ArrayList<Observer>

    var ibmPrice: Double = 0.0
        set(value) {
            ibmPrice = value
            notifyObserver()
        }

    var aaplPrice: Double = 0.0
        set(value) {
            aaplPrice = value
            notifyObserver()
        }

    var googPrice: Double = 0.0
        set(value) {
            googPrice = value
            notifyObserver()
        }

    init {
        // Creates an ArrayList to hold all observers
        observers = ArrayList<Observer>()
    }

    override fun register(newObserver: Observer): ArrayList<Observer> {
        // Adds a new observer to the ArrayList
        observers.add(newObserver)
        return observers
    }

    override fun unregister(deleteObserver: Observer): ArrayList<Observer> {
        // Get the index of the observer to delete
        val observerIndex = observers.indexOf(deleteObserver)

        // Print out message (Have to increment index to match)
        println("Observer ${(observerIndex + 1)} deleted")

        // Removes observer from the ArrayList
        observers.removeAt(observerIndex)

        return observers
    }

    override fun notifyObserver() {
        // Cycle through all observers and notifies them of price changes
        for (observer in observers) {
            observer.update(ibmPrice, aaplPrice, googPrice)
        }
    }
}