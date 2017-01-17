package booksearch_MVCpattern.dto;

public class BookDTO {

	// 3. DTO의 목적은 우리 프로그램에서 Data에 대한 단위로 쓰인다.  (단위에 대한 객체)
	// 여기에는 책 한권에 대한 Data가 들어가면 좋을 것 같다. (제목, 저자, 출판사 등)
	
	// DTO를 만들 때에는 Database Table을 보고 만든다. (table의 명세를 보고 이걸 쓴다.)
	// table의 column 이름을 대소문자 똑같이해서 class의 field로 만든다.
	// 모자라는 것은 곤란해... 추가적으로 내가 더 넣고 싶으면 더 넣어도 된다. (여기서는 구현을 위해 2개만 쓴다.)
		
	private String btitle;
	private String bauthor;
	
	public BookDTO() {
		// TODO Auto-generated constructor stub
	}
	
	
	// Getter & Setter
	public String getBtitle() {
		return btitle;
	}
	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}
	public String getBauthor() {
		return bauthor;
	}
	public void setBauthor(String bauthor) {
		this.bauthor = bauthor;
	}
	
	
	
	
}
