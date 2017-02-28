package builder

object TestRobotBuilder extends App {
    // Get a RobotBuilder of type OldRobotBuilder
    val oldStyleRobot: RobotBuilder = OldRobotBuilder()
    // Pass the OldRobotBuilder specification to the engineer
    val robotEngineer: RobotEngineer = RobotEngineer(oldStyleRobot)
    // Tell the engineer to make the Robot using the specifications
    // of the OldRobotBuilder class
    robotEngineer.makeRobot()
    // The engineer returns the right robot based off of the spec
    // sent to it on line 11
    val firstRobot: Robot = robotEngineer.getRobot
    println("Robot Built")
    println("Robot Head Type: " + firstRobot.getRobotHead)
    println("Robot Torso Type: " + firstRobot.getRobotTorso)
    println("Robot Arm Type: " + firstRobot.getRobotArms)
    println("Robot Leg Type: " + firstRobot.getRobotLegs)
}
