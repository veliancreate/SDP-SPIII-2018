import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

class FireSensorTest  {
    lateinit var sensor: Sensor

    @Before
    fun startup(){
        sensor = FireSensor()
    }

    @Test
    fun testThatIsTriggeredReturnsFalse() {
        val isTriggered = sensor.isTriggered()
        assertEquals(false, isTriggered)
    }

    @Test
    fun testThatGetLocationReturns() {
        val location = sensor.getLocation()
        assertEquals("", location)
    }

    @Test
    fun testThatGetSensorType() {
        val sensorType = sensor.getSensortype()
        assertEquals("Fire sensor", sensorType)
    }

    @Test
    fun testThatGetBatteryPercentageReturnsNegativeOne() {
        val batteryPercentage  = sensor.getBatteryPercentage()
        assertEquals(0.0, batteryPercentage)
    }
}
