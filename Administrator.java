public class Administrator extends User
{
	String adminId;
	String pass;
	Administrator()
	{
		adminId	=super.adminId;
		pass = super.adminPass;
	}
	boolean adminLogin(String userName, String pass)
	{

		if(userName.equals(adminId) && pass.equals(adminPass))
		{
			//System.out.println("Successfully Logged in!!!");
		    return true;
		}
		else 
		{
			//System.out.println("Enter valid credentials!!!");
			return false;
		}
	}
}