import java.io.File

val path = "C:\\Users\\Damir\\Desktop\\test.txt"
val obfName = "Il"
val lenght = 15

var count : Int = 20

var namesObf : ArrayList<String> = arrayListOf()

fun main(args: Array<String>) {
    createFileWrite(path)
}

fun createFileWrite(path : String) {
    var file = File(path)
    if(!file.exists()) {
        println("Create file text: $path")
        file.createNewFile()
    }
    while(count != 0) {
        namesObf.add(generateObfName())
        count--
    }

    File(path).bufferedWriter().use { out ->
              val obfResult = namesObf.distinct().toList()
              for(result in obfResult){
                  println("Obf generated: $result")
                  out.write("$result")
                  out.newLine()
              }
    }
}

fun generateObfName() : String {
    return (1..lenght).map { obfName.random() }.joinToString("")
}
