package solution

trait Renderer {
  def renderTrigger(sensor: Sensor)

  def renderPolled(sensor: Sensor)
}
