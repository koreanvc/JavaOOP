package example1;

class A {
	static int staticCall(String message){
		System.out.println(message);
		return (0);
	}
	
	static int a = staticCall("이것은 1번 문장입니다.");
	
	int b = staticCall("이것은 2번 문장입니다.");
	
	public A(){
		staticCall("이것은 3번 문장입니다.");
	}
	
	public A(int a){
		this();
		staticCall("이것은 4번 문장입니다.");
	}
}
