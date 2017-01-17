package exercise01_Owner;

public class VehicleTest {
	public static void main(String[] args) {
		Owner o1 = new Owner("LEE", "010-2676-6629");
		Owner o2 = new Owner("LEE", "010-1765-1228");
		
		Vehicle v1 = new Vehicle(o1, 50000);
		Vehicle v2 = new Vehicle(o2, 80000);
		
		System.out.println("소유주 정보 : " + v1.toString() + "\n");
		System.out.println("소유주 정보 : " + v2.toString() + "\n");
		
		if(v1.equals(v2)){
			System.out.println("동일한 소유주 여부 : true");
		} else{
			System.out.println("동일한 소유주 여부 : false");
		}
		
	
		
	}
}
