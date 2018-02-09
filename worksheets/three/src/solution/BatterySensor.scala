package solution

import scala.collection.immutable.List
import scala.util.Random

abstract class BatterySensor extends Sensor {

  val notifiers: List[Notifier] = Nil

  /**
    *
    * @return the remaining charge in the battery
    */
  def getBatteryPercentage: Double

  protected var battery: Double = 100
  val r = new Random

  /**
    * handles draining the battery by a specified value
    *
    * @param drainAmount
    */
  protected def drainBattery(drainAmount: Double) = {
    if (battery - drainAmount < 0)
      battery = 0
    else
      battery -= drainAmount
  }

  override def executeNotifications = {
    notifiers.foreach(n => n.notify(this))
  }

}
