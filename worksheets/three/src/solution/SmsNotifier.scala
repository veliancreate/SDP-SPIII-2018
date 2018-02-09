package solution

class SmsNotifier(number: String) extends Notifier {
  override def notify(sensor: Sensor): Unit = {
    println("Sending SMS to " + number + "...")
  }
}
