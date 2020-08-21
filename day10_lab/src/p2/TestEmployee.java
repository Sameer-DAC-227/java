package p2;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TestEmployee {

	public static void main(String[] args) {
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		
		try {
			Employee e1 = new Employee (101,"abc","rnd",12345,sdf.parse("1-5-2020"));
			Employee e2=new Employee (101,"abc","rnd",12345,sdf.parse("1-5-2020"));
			Employee e3=e1;
			System.out.println(e1.equals(e2));
			System.out.println(e1.equals(e3));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
