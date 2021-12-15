
/*
    1. Late initialization
       lateinit로 변수선언
       null이 불가능한 타입 이지만, 선언에서 값 지정을 하지 않을떄 사용


    2. Lazy initialization
       변수 사용시 최초로 한번만 호출 되어 초기화 값 설정

 */

class Cls1 {
    lateinit var str1: String   //late init 없으면 컴파일 오류(null 허용안됨)
    fun init(iStr : String) {
        str1 =  iStr
    }
}

class Cls2 {
     val str2 : String by lazy {
         println("2.1 : 변수사용시 최초 호출")
         "init"
     }
}

fun main() {
    // 1.1. late init 변수는 반드시 값 설정 필요
    val inc1 = Cls1()
    inc1.init("inc1")
    println("1.1 : " + inc1.str1)

    // 1.2. late init를 사용한 변수를 호출할 때 런타입 오류 발생
    val inc2 = Cls1()
    //println("1.2 : " + inc2.str1) // 주석풀면 오류

    // 2.1. 값
    val inc3 = Cls2()
    println("2.1 : 값 호출 " + inc3.str2)
    println("2.1 : 값 호출 " + inc3.str2)
}