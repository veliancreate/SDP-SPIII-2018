package solution

class RendererConsole extends Renderer {
  override def renderTrigger(sensor: Sensor) = println("A " + sensor.getSensorType + " sensor was triggered at " + sensor.getLocation)

  override def renderPolled(sensor: Sensor) = println("Polled " + sensor.getSensorType + " at " + sensor.getLocation + " successfully")
}
