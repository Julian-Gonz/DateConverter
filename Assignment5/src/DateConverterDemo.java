import java.util.Scanner;

public class DateConverterDemo {
	
	public static int maximumDays(int month) {	//Finds maximum days for each month
		
		switch(month) {
			case 2:
				return 29;
			case 4:
			case 6:
			case 9:
			case 11:
				return 30;
			default:
				return 31;
		}
	}
	
	public static String monthName(int month) {	//Finds the name of the month
		
		switch(month){
			case 1:
				return "January";
			case 2:
				return "February";
			case 3:
				return "March";
			case 4: 
				return "April";
			case 5: 
				return "May";
			case 6:
				return "June";
			case 7:
				return "July";
			case 8: 
				return "August";
			case 9:
				return "September";
			case 10:
				return "October";
			case 11: 
				return "November";
			case 12:
				return "December";
			default:
				return "Error";
		}
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean done = false;
		boolean end = false;
		int month = 0;
		int day = 0;
		int year = 0;
		
		while(!end) {	//Makes sure the input is in correct format
			try {
				System.out.println("Enter date to parse (MM/DD/YYYY format): ");
				String date = scan.nextLine();
				String [] parse = date.split("/");
				month = Integer.parseInt(parse[0]);
				day = Integer.parseInt(parse[1]);
				year = Integer.parseInt(parse[2]);
				end = true;
			}
			catch(Exception e) {
				System.out.println("Invalid input!");
			}
		}
				
		while(!done) {	//Makes sure month, day, year are valid
			try {
				if(month<1 || month >12){
					throw new MonthException("Invalid month. Re-enter a valid month.");
				}
		
				if(day<1|| day > maximumDays(month)) {
					throw new DayException("Invalid day. Re-enter a valid day.");
				}
				
				if(year<1000 || year>3000) {
					throw new YearException("Invalid year. Re-enter a valid year.");
				}
				
				if(month == 2) {
					if(year % 4 != 0) {
						if(day == 29) {
							throw new DayException("Invalid day. Re-enter a valid day.");
						}
					}
				}
				
		System.out.println("Parsed date: " + monthName(month) + " " + day + ", " + year);
		done = true;
		}
			
		catch(MonthException e) {
			System.out.println(e.getMessage());
			month = scan.nextInt();	
		}
			
		catch(DayException e) {
			System.out.println(e.getMessage());
			day = scan.nextInt();
				
		}
			
		catch(YearException e) {
			System.out.println(e.getMessage());
			year = scan.nextInt();
				
			}
		}		
		
		scan.close();

		}
	}
