package Request_Repositry;


public class Put_Request {
	public static String BaseURI() {
		String BaseURI="https://reqres.in/";
		return BaseURI;
	}
	public static String Resource() {
		String Resource ="api/users/2";
		return Resource;
	}
	public static String RequestBody() {
		String RequestBody="{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"leader\"\r\n"
				+ "}";
		return RequestBody;
	}

}
