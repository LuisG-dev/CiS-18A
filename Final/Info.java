package Final;
// Create a package to contain the different files

//Class to hold user information
class Info {
	//Public variables to use throughout the class and other classes that use the variables
	public	String First_name;
	public String Last_name;
	public String email;
	public int age;

	//Define constructor
	public Info(String First_name, String Last_name,
			 String email, int age) {
	this.First_name = First_name;
	this.Last_name = Last_name;
	this.email = email;
	this.age = age;
	}

	//Define to toString to concatinate varibles together.
	public String toString() {
	return ("\nFirst name: " + First_name +"\nLast name: " + Last_name 
			+ "\nEmail: " + email + "\nAge: " + age);
	
	}
}

//Clas that extends Info class to incorporate tattoo information
class TattooInfo extends Info
{	
	//create a variable that holds the tattoo aspect of object
	public String Desc;
	
	//Define constructor with variables from Info class
	public TattooInfo(String First_name, String Last_name,
			 String email, int age,String Description)
	{
	     super(First_name,Last_name,email,age);
	     Desc = Description;
	}
	
	//Sets the description variable
	public void setDesc(String newInfo)
	{
	    Desc = newInfo;
	}

	//Creates another toString that overrides that previous stated in the other class
	public String toString()
	{
	    return(super.toString()+ "\nDescription: " + Desc);
	}
}