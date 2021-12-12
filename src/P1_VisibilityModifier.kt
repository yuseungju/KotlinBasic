/*1. 접근 제한자
    1.1. 자바&코틀린 동일
        public [클래스, 필드, 생성자, 메소드]
         => 어디서든 접근 가능함
        protected [필드, 생성자, 메소드]
         => 동일 또는 하위(상속받는)클래스만 접근 가능
        private [필드, 생성자, 메소드]
         => 동일 클래스 내에서만 접근 가능

    1.2. 자바
        default [클래스, 필드, 생성자, 메소드]
         => 동일 패키지 내에서 접근 가능

    1.3. 코틀린
        internal [클래스, 필드, 생성자, 메소드]
         => 동일 모듈이면 내에서 접근 가능(함께 컴파일되는 파일들, gradle프로젝트는 gradle 프로젝트 내 전체)

    ex) b패키지에서 a패키지 접근가능(자바와 defult와 다르게 접근 가능한게 차이)
        package a
        internal class C1 {
            val s = baz
        }

        package b
        import a.*
        class C2 {
            //다른 패키지인데, 멤버로 클래스 접근해서 할당
            //internal로 internal클래스를 받아야함
            internal val C1 = C1()
            //또는 private처럼 접근이 더 제한되는 방향으로
            private val C2 = C1()
        }

*/


/*
    2. 파일 & class수
    2.1.자바 public class한개 제한, 코틀린은 public class여러개 가능
    2.2.제한자 명시안하면 자바 default 기본, 코틀린은 public 기본
       다른 패키지 접근을 막는 defult가 자바에서 의미없기 떄문에 그냥 public으로 바뀐 것으로 보임
       (대부분 자바에서 puplic로 선언하고 사용하니깐.. )
*/
class PublicC1{ // :  public class Mclass1
    var classStr = "Mclass1"
}
class PublicC2{
    var classStr = "Mclass2"
}


//3. 기타
fun main(args: Array<String>){
    /*
      3.1.자료형 명시안함, 코를린은 new 키워드 없음
      자바는..
      PublicC1 person = new PublicC1()
    */
    //생략해도 new인걸 컴파일러가 알 수 있는 것 같음 타입추론처럼..(인스턴스() => new => heap)
    val c1 = PublicC1()
    print(c1.classStr)



}