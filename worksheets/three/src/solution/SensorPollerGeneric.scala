package solution

class SensorPollerGeneric(renderer: Renderer) extends SensorPoller {
  override def poll(sensors: List[Sensor]): Unit = {
    sensors.foreach(s => checkTriggered(s))
  }

  def checkTriggered(sensor: Sensor) = {
    if (sensor.isTriggered) {
      renderer.renderTrigger(sensor)
      sensor.executeNotifications
    }

    else
      renderer.renderPolled(sensor)
  }
}
