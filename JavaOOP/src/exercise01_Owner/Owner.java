package exercise01_Owner;

public class Owner {
	private String name;
	private String cellPhone;
	
	public Owner() {
		// TODO Auto-generated constructor stub
	}
	
	public Owner(String name, String cellPhone){
		this.name = name;
		this.cellPhone = cellPhone;		
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCellPhone() {
		return cellPhone;
	}
	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	@Override
	public boolean equals(Object obj) {
		boolean result;
		
		if( obj instanceof Owner ){			
			Owner temp = (Owner)obj;	// 형변환
			if(this.name.equals(temp.name)){
				result = true;
			} else{
				result = false;
			}
		} else{
			result = false;
		}
		
		return result;		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String temp;
		temp = "이름은 " + this.name + ", " + "전화번호는 " + this.cellPhone + "입니다."; 
		return temp;
	}

}
