/*  코틀린은 null체크 필수, 또는 null이 아닌 타입만 허용하여 런타임 오류 방지

    1. 함수 파라미터 null 가능 여부에 따라 null체크 위치가 다름
    함수 null가능시 함수 내에서 null체크 필수
    함수 null불가능시 함수 호출부분에서 null파마미터 체크
*/
//1.1.null가능 파라미터
// "?" 를 표시하면 null이 가능함
// null가능한 경우 코틀린에서는 null체크 필수(체크 없으면 컴파일 오류 발생시킴)
fun f1(s: String?): Int
{
    if (s != null)  //필수 구문
        return s.length
    else
        return -1
}

//1.2.null불가능 파라미터
// 기본적으로 null이 불가능함
// null체크 없어도됨(대신 함수 호출 코드에서 null울 넣을때 컴파일 오류)
fun f2(s: String): Int
{
    return s.length
}


fun main(args: Array<String>){
    // 1.1. null가능 함수 (함수 내부에서 null체크)
    println("1.1 : " + f1(null))

    // 1.2. null불가능 함수 (해당 라인에서  null필수 변수를 넘겨주는지 체크)
    // 해당 주석풀면...  변수가 null 가능이므로 컴파일 오류
    // val x1: String? = "s"
    // print(f2(x1))

    // null불가능 변수를 넘겨주므로 해당 함수로 null이 아닌값만 들어갈 수 있음(정상실행)
    val x2: String = "aaaa"
    println("1.2 : " + f2(x2)) // 변수가 null 가능이므로 컴파일 오류

    //2. SAFE CALL
    // NULL이면 접근하지 않고, NULL리턴

    // 2.1  null 가능 타입의 접근
    val a : String ?=  null // null가능 타입이면
    println("2.1 : " + a?.length) // null이므로 접근하지않고 null출력

    //2.2  null 불가능 타입의 접근
    val b : String =  "not null" // null 불가능 타입이면
    println("2.2 : " + b.length) // null인 경우 고려하지 않아도됨


    //3. 엘비스 연산자(Elvis Operation)
    //null이면 ?: 의 우측 리턴
    val c : String ?= null
    println("3.1 : " + ( c  ?: "null" ) )





}