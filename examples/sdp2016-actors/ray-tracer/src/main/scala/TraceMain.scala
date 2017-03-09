import akka.actor.{Props, ActorSystem}
import com.mildlyskilled._
import com.mildlyskilled.actor.CoordinatorActor

object TraceMain extends App {

  val (infile, outfile) = ("src/main/resources/input.dat", "output.png")
  val scene = FileReader.parse(infile)

  render(scene, outfile, Trace.Width, Trace.Height)

  def render(scene: Scene, outfile: String, width: Int, height: Int) = {
    val image = new Image(width, height)
    scene.traceImage(width, height)
  }
}
