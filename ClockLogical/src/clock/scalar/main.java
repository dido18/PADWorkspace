package clock.scalar;

public class main {

	public static void main( String[] args) {
		Entity n1 = new Entity(1);
		Entity n2 = new Entity(2);
		Entity n3 = new Entity(3);
		
		VersionedEntity<Entity> wn1 = new VersionedEntity<Entity>(n1);
		VersionedEntity<Entity> wn2 = new VersionedEntity<Entity>(n2);
		VersionedEntity<Entity> wn3 = new VersionedEntity<Entity>(n3);
		
		wn1.compute();// 1:1
		wn2.compute();// 2:1
		wn3.compute();// 3:1
		//System.out.print(wn3);
		
		wn1.send(wn2);// 1:2 , 2:3

		wn1.compute();// 1:3
		wn2.send(wn3);// 2:4, 3:5
		
		wn3.compute(); // 3:6
		
		System.out.print(wn1);
		System.out.print(wn2);
		System.out.print(wn3);
		
		
		
	}

}
