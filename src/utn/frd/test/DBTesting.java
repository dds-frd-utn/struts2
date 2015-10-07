package utn.frd.test;

import utn.frd.bean.Person;
import utn.frd.db.DBPersonManager;

public class DBTesting {

	public static void main(String[] args) {
		Person person = new Person(2, "Mariano Martinez", "Mitre 123, Campana");
		
		try{
			DBPersonManager.add(person);

			DBPersonManager.getAll();

			person.setName("Mario Martinez");
			DBPersonManager.update(person);
			DBPersonManager.getAll();
			
			person.setId(3);
			DBPersonManager.update(person);
			DBPersonManager.getAll();

			DBPersonManager.deleteAll();

		}catch(Exception e){
			System.err.println( "ERROR: "+e.getLocalizedMessage() );
		}
	}

}
