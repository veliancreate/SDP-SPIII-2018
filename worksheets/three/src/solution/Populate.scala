package solution

object Populate {
  def getHazardSensors: List[Sensor] = {
    return (1 to 5)
      .flatMap(i => (new FireSensor("Unknown") :: new SmokeSensor("Unknown") :: Nil))
      .toList
  }

  def getSecuritySensors: List[Sensor] = {
    return (1 to 5)
      .flatMap(i => (getSecuritySensor :: getSecuritySensor :: Nil))
      .toList
  }

  def getSecuritySensor: Sensor = {
    val sensor = new MotionSensor("Unknown")
    sensor.notifiers = new PoliceNotifier :: new SmsNotifier("0123 456 789") :: Nil
    sensor
  }


}
