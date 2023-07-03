package Common_Method;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
public class Put_Common_Method {
	public static int ResponsestatusCode1(String BaseURI,String Resource,String RequestBody) {
		RestAssured.baseURI=BaseURI;
		int statuscode=given().header("Content-Type","application/json").body(RequestBody).
				when().put("api/users/2").
				then().extract().statusCode();
		return statuscode;
	}
	public static String ResponseBody(String BaseURI,String Resource,String RequestBody) {
		RestAssured.baseURI=BaseURI;
		String ResponseBody=given().header("Content-Type","application/json").body(RequestBody).
				when().put("api/users/2").
				then().extract().response().asString();
		return ResponseBody;
	}
}
