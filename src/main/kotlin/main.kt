import java.util.Scanner

fun main(){

    val myService = MyService()

    while (true){
        println("Choose option:" +
                "\n1-> Add user" +
                "\n2-> Show user" +
                "\n3-> Search user" +
                "\n4-> Delete user")

        when(Scanner(System.`in`).nextInt()){
            1-> myService.addUser()
            2-> myService.showUser()
            3-> myService.search()
            4-> myService.delete()
        }
    }
}