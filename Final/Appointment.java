/* All libraries used are imported and package name is same as
   Info.java for when compile it involves that same file
*/

package Final;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.text.SimpleDateFormat;
import java.util.*;



//Main class Appointment
class Appointment{
	public static void main(String args[]){
	
	//Start the program with message to user
	System.out.println("\nWelcome please choose what you would like.");

	//Scanner to take user input one used for string and the other for numbers.
	Scanner num = new Scanner(System.in);
	Scanner input = new Scanner(System.in);

	//Declare the variables being used
	String Fname = "";
	String Lname = "";
	String Descr = "";
	String Email = "";
	int age = 0;
	int choice;
	
	//Declare ArrayList to add and hold the Appointment and the other for the dates being used.
	ArrayList<String> date = new ArrayList<String>();
	
	ArrayList<String> app = new ArrayList<String>();

	//Date variables
	int MM = 0;
	int DD = 0;
	int YY = 2021;
	
	//Do-While loop to display menu once then allow the user to decide what happens next.
	do{
		//Menu	
		System.out.println("\nMenu");
		System.out.println("1. Schedule Appointmecdnt");
		System.out.println("2. Look up Appointment");
		System.out.println("3. Cancel Appointment");
		System.out.println("4. Quit"); 
		System.out.print("\nSelect a Menu Option: ");
		choice = num.nextInt();
	
	   if(choice == 1){
		
		//Get user information
		System.out.println("\nEnter your information & Description");
		System.out.print("First name: ");
		Fname = input.nextLine();
		System.out.print("Last name: ");
		Lname = input.nextLine();
		System.out.print("Email: ");
		Email = input.nextLine();
			//Simple validation for email checks if @ is in string
			if(!Email.contains("@")){
			   System.out.println("Invalid Email");
			   Email = input.nextLine();
			  }

		System.out.print("Age: ");
		age = num.nextInt();
		    //Check for the age being higher than 18 if not the programs end.
		    if(age < 18){
			System.out.println("Sorry must be 18 years of age to get a Tattoo");
			break;
			}

		System.out.println("Describe Tattoo idea.");
		System.out.print("Description: ");
		Descr = input.nextLine();

		//Creates a new object with user input
		TattooInfo client  = new TattooInfo(Fname,Lname,Email,age,Descr);
		System.out.println("Your information is saved");

		//Creates a new string using the toString method in Info.java
		String info = client.toString();
	
		//Gets the moneth and day from user	
		System.out.println("\nEnter desired date Appointment.");
		System.out.print("Month: ");
		MM = num.nextInt();

		    //Checks to see if month entered is valid
		    if(MM >12 || MM<1){
			System.out.println("Invalid Month entered.");
			MM = num.nextInt();
			}

		System.out.print("Day: ");
		DD = num.nextInt();
		
		//Switch case to determine if day entered is valid		
		switch (MM){
			//months that have 31 days. 
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				if(DD > 31){
					System.out.println("Invalid date.");
					DD = num.nextInt();
				}
				break;
			//Months that have 30 days
			case 4:
			case 6:
			case 9:
			case 11:
				if(DD > 30){
					System.out.println("Invalid date.");
					DD = num.nextInt();
				}
				break;
			//Month of February
			case 2:
				if(DD > 29){
					System.out.println("Invalid date.");
					DD = num.nextInt();
				}
				break;
			};
		   //creates a LocalDate variable that includes user Input
		   LocalDate Nd = LocalDate.of(YY,MM,DD);

		   //convert int for date into string values
		   String strDate = Nd.format(DateTimeFormatter.ofPattern("dd-MMM-yy"));

		   //Creates new string and concatinate both the user info and date.
		   String newapp = info + ("\nAppointment on :")+ strDate;
		  
		   //Compares the date entered with dates in the ArrayList
		   if(date.contains(strDate)){
			System.out.println("Date is not available");
		       }
		    else
			{
			//if date not found both the appointment and date are added to their respected ArrayList
			System.out.println("Appointment scheduled.");
			date.add(strDate);
			app.add(newapp);
		       }
	   }
	    //if choice is 2 the user inputs date to get their appointment
	    if(choice == 2){
			//Get user input
			System.out.println("Enter desired date Appointment.");
			System.out.print("Month: ");
			MM = num.nextInt();
		   	 if(MM >12 || MM<1){
				System.out.println("Invalid Month entered.");
				MM = num.nextInt();
				}
			System.out.print("Day: ");
				DD = num.nextInt();
			//Creates localDate and string to check with ArrayList	
		  	LocalDate CD = LocalDate.of(YY,MM,DD);
		   	String Check_Date = CD.format(DateTimeFormatter.ofPattern("dd-MMM-yy"));
			
			//For loop iterates and checks if a string contains the date entered
			for(String element : app){
			  if(element.contains(Check_Date)){
				System.out.println(element);
				}
			}
	   }
	 if(choice == 3){
		char ch;
		System.out.println("Enter your first name & last name.");
		System.out.print("Last name: ");
		Lname = input.nextLine();
		
		//for loop to check if appointment contains last name
		for(String emt : app){
		  if(emt.contains(Lname)){
			System.out.println("Found appointment");
			System.out.println("Are you sure you wish to cancel: (Y/N)");
			 ch = input.next().charAt(0);
			   //if loop checks on user answer being either Y or N
			   if(ch == 'Y' || ch == 'y'){
				app.remove(emt);
				System.out.println("Appointment cancelled");
        			break;
				}
			   else
				break;
			}
		}
	}

  }
   //if choice does not equal 4 the process continues until user inputs 4.
   while (choice != 4);
	System.out.println("Thank you!");
  }	 
}