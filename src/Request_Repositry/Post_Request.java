package Request_Repositry;

import java.io.IOException;
import java.util.ArrayList;

import Common_Method.Common_Utility_Method;

public class Post_Request {
	public static String BaseURI() {
		String BaseURI="https://reqres.in/";
		return BaseURI;
	}
	public static String Resource() {
		String Resource="api/users";
		return Resource;
	}
	public static String RequestBody() throws IOException {
		ArrayList<String>Req_Data=Common_Utility_Method.ReadExcelData("Post","TC4");
		String Req_Name=Req_Data.get(1);
		String Req_job=Req_Data.get(2);
		String RequestBody="{\r\n"
				+ "    \"name\": \""+Req_Name+"\",\r\n"
				+ "    \"job\": \""+Req_job+"\"\r\n"
				+ "}";
		return RequestBody;
	}

}
