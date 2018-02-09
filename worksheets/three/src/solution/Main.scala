package solution

import java.util.Scanner

object Main extends App {
  private val EXIT: String = "exit"
  private val POLL: String = "poll"

  val hazardControlUnit: ControlUnit = new ControlUnit(Populate.getHazardSensors, new SensorPollerGeneric(new RendererConsole))
  val securityControlUnit: SecurityControlUnit = new SecurityControlUnit(Populate.getSecuritySensors, new SensorPollerGeneric(new RendererConsole))
  val scanner: Scanner = new Scanner(System.in)
  var input: String = ""
  while ((input != EXIT)) {
    {
      System.out.println("Type \"poll\" to poll all sensors once or \"exit\" to exit")
      input = scanner.nextLine
      if (input == POLL) {
        hazardControlUnit.pollSensors
        securityControlUnit.pollSensors
      }
    }
  }
}