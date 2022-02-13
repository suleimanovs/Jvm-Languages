package otherUsefulThing;

public class SwitchCase{
	
	public static void main(String[] args){
		
		String name = "Ivan";
		int age = 19;
		
		String result = String.format("%s you %d year's old",name,age);
		
		String[] namesOfMonth = {
		"January",
		"Febryary",
		"Mart",
		"April",
		"May",
		"June",
		"Jule",
		"August",
		"September",
		"October",
		"November",
		"December"
		};
		
		int searchMonth = 2;
		String resultName;
		/**
		 * Если не указать break, то следующие проверки не будут проверены,
		 * но будет выведено все дейтсвия в во всех других кэйсах
		 */
		switch(searchMonth){
			case 1:resultName=namesOfMonth[0];break;
			case 2:resultName=namesOfMonth[1];break;
			case 3:resultName=namesOfMonth[2];break;
			case 4:resultName=namesOfMonth[3];break;
			case 5:resultName=namesOfMonth[4];break;
			case 6:resultName=namesOfMonth[5];break;
			case 7:resultName=namesOfMonth[6];break;
			case 8:resultName=namesOfMonth[7];break;
			case 9:resultName=namesOfMonth[8];break;
			case 10:resultName=namesOfMonth[9];break;
			case 11:resultName=namesOfMonth[10];break;
			case 12:resultName=namesOfMonth[11];break;
			default: resultName="Month from this index not found";
		}
		
		System.out.println(resultName);
		
	}
	
	
	
}