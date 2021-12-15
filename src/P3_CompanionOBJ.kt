/*
    1.object expression
      익명클래스 사용(선언 동시 할당)
    2.object declaration
      object로 선언하면, 싱글톤 패턴으로 간단하게 사용가능
      Java에서 싱글톤클래스를 정의할때 getInstance() 메소드 정의 및 인스턴스 할당 코드를 내부적으로 포함함
      Thread 동시 접근시 인스턴스 한번 이상 할당하지 못하도록 내부적으로 체크
    3.companion object
      object declaration을 일반 클래스 내부에서 작성
      모든 인스턴스가 하나의 static companion 객체의 인스턴스 하나를 공유(싱글톤)
*/

//2.object declaration
//단 하나의 인스턴스로서 싱클톤과 같음
object ObjectDecl {
    var num = 1
    fun getIncNum() : Int {
        num+=1
        return num
    }
}

//3.companion object
class ClassComp {

    //클래스내 static클래스 companion을 정의하고 static 멤버로 할당받아 static으로 공유(싱글톤)
    //ClassComp로 여러 인스턴스가 접근할 경우, static으로 할당된 동일 companion 인스턴스를 접근하는것
    //static이 아니지만 companion이 static으로 할당되면서 인스턴스가 되면서 내부 변수 함수도 공유
    //자바에서 static과 동일한 사용은 같음
    companion object {
        var n1 = "n1" //static companion의 변수
        val C1 = "C1" //static companion의 final 상수
        const val C2 = "C2" //static final final 상수
        fun f1()  { //static companion의 함수
            println("call companion.f1()")
        }
    }
}

fun main(args: Array<String>){

    //3.companion object
    //내부 static class  Companion접근은 생략가능하다.
    println("** example3.companion object")
    println("String : " + ClassComp.Companion.n1)
    println("final String : " + ClassComp.Companion.C1)
    println("static final String : " + ClassComp.Companion.C2)
    ClassComp.Companion.f1()
    println()

    //1.object expression
    //자바 익명 클래스와 비슷
    println("** example1.object expression")
    val obj1 = object { // any클래스 상속받음(기본)
        val str = "object"
        fun fStr() = str
    }
    println("익명클래스 : " + obj1.fStr())
    println()


    //2.object declaration (싱글톤)
    println("** example2.object declaration")
    val obj2_1 = ObjectDecl
    println("SingleTon 공유1 : " +  obj2_1.getIncNum())
    val obj2_2 = ObjectDecl
    println("SingleTon 공유2 : " + obj2_2.getIncNum())


}