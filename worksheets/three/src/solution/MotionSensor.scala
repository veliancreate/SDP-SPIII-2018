package solution

import scala.collection.immutable.List

class MotionSensor(location: String) extends SecuritySensor {

  var notifiers: List[Notifier] = Nil

  override def isTriggered: Boolean = {
    r.nextInt(100) < 3
  }

  override def getLocation: String = location

  override def getSensorType: String = "Motion"

  override def executeNotifications = {
    if (notifiers != null) notifiers.foreach(n => n.notify(this))
  }
}
