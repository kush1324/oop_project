import java.util.*;
import java.lang.*;

public class User
{
	private String uName = "user@123";
	private String pass = "pass@123";
	
	protected final String adminId = "admin@123";
	protected final String adminPass = "pass@123";

	boolean userLogin(String userName, String pass)
	{

		if(userName.equals(uName) && pass.equals(pass))
		{
		    return true;
		}
		else 
		{
			return false;
		}
	}
}