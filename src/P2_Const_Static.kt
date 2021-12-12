/*1. final
    1.1. 자바
       var
         =>  Java 10 이상 타입 추론 지원
       final
         => 값 지정후 값 변경 불가
            메소드에 붙이면 오버라이딩 불가
            클래스에 붙이면 상속불가
       static final
         => 객체에 선언과 동시 값 지정해야됨(컴파일시 메모리에 잡힐 수 있음)
            값 지정후 값 변경 불가
    1.2.코틀린
        var - 변수
        val - 상수, 자바 final 과 동일
        const val - 컴파일 시 결정되는 상수, 자바 static final 과 동일
*/
class Class1{
    val C1 = 1 //일반상수 = 런타임시 결정

    //companion object내에서 static처럼 정의가능
    companion object{
        //const val선언은 static과 동일하게 컴파일시 결정
        const val C2 = 2 // = 자바 static final int c2 = 3
    }
}
fun main(args: Array<String>){

    //static 상수
    println(Class1.C2) // static처럼 바로 접근(컴파일시 이미 할당돼있음)

    //일반 상수
    var cls1 = Class1() //해당 인스턴스로 상수값 할당
    println(cls1.C1)  //상수 조회


}