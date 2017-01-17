package example1;

public class CreateObject extends A {
	
	public int c = staticCall("이것은 5번 문장입니다.");
	
	public static int d = staticCall("이것은 6번 문장입니다.");
	
	public CreateObject() {
		// TODO Auto-generated constructor stub
		super(100);
		staticCall("이것은 7번 문장입니다.");
	}
	
	public static void main(String args[]){
		System.out.println("이것은 8번 문장입니다.");
		CreateObject k = new CreateObject();
	}
}
