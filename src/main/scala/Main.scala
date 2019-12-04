import database.MongoDb
import model.Block

object Main {
  val user: String = "myUserAdmin"
  val password: String = "abc123"
  val role: String = "admin"

  def main(args: Array[String]): Unit = {
    //val dao = new MongoDbDao("myUserAdmin", "abc123", "admin")

    MongoDb.insert(Block("test"))

    Thread.sleep(1000)

    val document = MongoDb.read(1)
    document match {
      case Some(value) => prettyPrintBlock(value)
      case None => println("No document found")
    }

    Thread.sleep(1000)

    println("Documents: " + MongoDb.count)

    val documents = MongoDb.show
    for(document <- documents) {
      prettyPrintBlock(document)
    }

    Thread.sleep(1000)
  }

  def prettyPrintBlock(block: Block): Unit = {
    println("_id: " + block._id)
    println("timestamp: " + block.timestamp)
    println("previousHash: " + block.previousHash)
    println("hash: " + block.hash)
    println("data: " + block.data)
    println("")
  }
}
