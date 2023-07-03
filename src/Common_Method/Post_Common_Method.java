package Common_Method;
import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
public class Post_Common_Method {
	public static int ResponsestatusCode(String BaseURI,String Resource,String RequestBody) {
		RestAssured.baseURI=BaseURI;
		int statuscode=given().header("Content-Type","application/json").body(RequestBody).
				when().post("api/users").
				then().extract().statusCode();
		return statuscode;
	}
	public static String ResponseBody(String BaseURI,String Resource,String RequestBody) {
		RestAssured.baseURI=BaseURI;
	String ResponseBody=given().header("Content-Type","application/json").body(RequestBody).
				when().post("api/users").
				then().extract().response().asString();
		return  ResponseBody;
	}
}

