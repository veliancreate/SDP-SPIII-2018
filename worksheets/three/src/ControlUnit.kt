class ControlUnit {

    fun pollSensors() {
        val sensors = ArrayList<Sensor>()
        sensors.add(FireSensor())
        sensors.add(SmokeSensor())

        for (sensor in sensors) {
            if (sensor.isTriggered()) {
                println("A ${sensor.getSensortype()}  sensor was triggered at  ${sensor.getLocation()}")
            } else {
                println("Polled ${sensor.getSensortype()} at ${sensor.getLocation()}  successfully")
            }
        }
    }
}