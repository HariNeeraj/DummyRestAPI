package DRA.api.endpoints;

public class DRAroutes {
	
	
	public static String baseurl= "http://restapi.adequateshop.com/api";
	
	
	public static String Registration_url	= baseurl+"/AuthAccount/Registration";
	public static String Login_url			= baseurl+"/AuthAccount/Login";
	public static String getuser			= baseurl+"/Users";
	public static String Createuser_url		= baseurl+"/Users";
	public static String userurl			= baseurl+"/Users/{ID}";
	
}
