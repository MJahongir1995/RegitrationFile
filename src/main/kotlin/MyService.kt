import java.io.File
import java.io.FileWriter
import java.util.Scanner

class MyService:MyServiceInterface {
    val scan = Scanner(System.`in`)
    val file = File("registration.txt")

    override fun addUser() {
        println("Enter username: ")
        val userName = scan.next()

        println("Enter password: ")
        val passWord = scan.next()

        val user = User(userName, passWord)

        val list = readFile()
        list.add(user)
        fileWriter(list)

        println("Saved")
    }

    override fun showUser() {
        val list = readFile()
        for (user in list) {
            println(user)
        }
    }

    override fun fileWriter(list: List<User>) {
        val fileWriter = FileWriter(file)
        for (u in list) {
            fileWriter.write("${u.userName}|${u.passWord}\n")
        }
        fileWriter.close()
    }

    override fun readFile(): ArrayList<User> {
        val list = ArrayList<User>()
        val listString = file.readLines()

        for (v in listString) {
            val userName = v.substring(0,v.indexOf('|'))
            val passWord = v.substring(v.indexOf('|')+1, v.length)

            val user = User(userName, passWord)
            list.add(user)
        }
        return list
    }

    override fun search() {
        println("Enter username: ")
        val word = scan.next()

        val list = readFile()

        for (s in list) {
            if (word.equals(s.userName)){
                println(s)
            }
        }
    }

    override fun delete() {
        val list = readFile()
        val fileWriter = FileWriter(file)
       // val listString = file.readLines()

        var count = 0
        for ((i, s) in list.withIndex()) {
            println("$count) ${list[count]}")
            count++
        }

        println("Choose user to delete: ")
        val del = scan.nextInt()
        list.removeAt(del)
        println("Removed")

        fileWriter(list)
        fileWriter.close()
    }
}