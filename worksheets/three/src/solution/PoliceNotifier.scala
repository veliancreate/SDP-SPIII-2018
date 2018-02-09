package solution

class PoliceNotifier extends Notifier {
  override def notify(sensor: Sensor): Unit = {
    println("Calling Police...")
  }
}
