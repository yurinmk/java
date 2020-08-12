package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Programa {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Calendar cal = Calendar.getInstance();
		
		Date x = sdf.parse("12/08/2020");
		
		cal.setTime(x);
		
		cal.add(Calendar.MONTH, 1);
		
		System.out.println(sdf.format(cal.getTime()));

	}

}
