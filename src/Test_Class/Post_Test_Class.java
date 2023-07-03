package Test_Class;

import java.io.IOException;
import java.time.LocalDateTime;

import org.testng.Assert;

import Common_Method.Post_Common_Method;
import Request_Repositry.Post_Request;
import io.restassured.path.json.JsonPath;

public class Post_Test_Class {
	public static void Extractor() throws IOException {
		int statuscode =Post_Common_Method.ResponsestatusCode(Post_Request.BaseURI(),Post_Request.Resource(),Post_Request.RequestBody());
		System.out.println( statuscode);
		String ResponseBody=Post_Common_Method.ResponseBody(Post_Request.BaseURI(),Post_Request.Resource(),Post_Request.RequestBody());
		System.out.println( ResponseBody);
		
		JsonPath JspRequest = new JsonPath(Post_Request.RequestBody());
		String req_name=JspRequest.getString("name");
		String req_job=JspRequest.getString("job");
		JsonPath JspResponse =new JsonPath(ResponseBody);
		String res_name=JspResponse.getString("name");
		String res_job=JspResponse.getString("job");
		System.out.println(res_name);
		System.out.println(res_job);
		//validate status body parameter
		Assert.assertEquals(res_name,req_name);
		Assert.assertEquals(res_job,req_job);
		
	}
}
