package Test_Class;
import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.time.LocalDateTime;

import org.testng.Assert;

import io.restassured.path.json.JsonPath;
import Common_Method.Common_Utility_Method;
import Common_Method.Post_Common_Method;
import Request_Repositry.Post_Request;
public class Post_Retry_TestClass {
	public static void Extractor() throws IOException {
		for(int i =0; i<5; i++)
		{
			int statuscode =Post_Common_Method.ResponsestatusCode(Post_Request.BaseURI(),Post_Request.Resource(),Post_Request.RequestBody());
			System.out.println( statuscode);
			if(statuscode==201)
			{
				String ResponseBody=Post_Common_Method.ResponseBody(Post_Request.BaseURI(),Post_Request.Resource(),Post_Request.RequestBody());
				System.out.println( ResponseBody);
				//parse the RequestBody and ResponseBody
				String RequestBody=Post_Request.RequestBody();
				Common_Utility_Method.Evidencecreator("Post_Retry_TestClass", RequestBody, ResponseBody, statuscode);
				Validator(ResponseBody,RequestBody);
				break;
			}
			else
			{
				System.out.println("Incorrect StatusCode");
			}
			
		}
	}

	public static void Validator(String ResponseBody, String RequestBody) {
    JsonPath JspRequest= new JsonPath(RequestBody);
    String req_name=JspRequest.getString("name"); 
	String req_job=JspRequest.getString("job");
	LocalDateTime actualdate=LocalDateTime.now();
	String expecteddate= actualdate.toString().substring(0,13);
	JsonPath JspResponse= new JsonPath(ResponseBody);	
	String res_name=JspResponse.getString("name"); 
	String res_job=JspResponse.getString("job");
	String res_createdAt=JspResponse.getString("createdAt");
	res_createdAt=res_createdAt.substring(0,13);
	//validate ResponeBody Parameter
	Assert.assertEquals(res_name, req_name);
	Assert.assertEquals(res_job,req_job);
	Assert.assertEquals(res_createdAt, expecteddate);

	}

}
