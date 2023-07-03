package Test_Class;

import java.io.IOException;

import org.testng.Assert;

import Common_Method.Put_Common_Method;
import Request_Repositry.Post_Request;
import Request_Repositry.Put_Request;
import io.restassured.path.json.JsonPath;

public class Put_TC1 {
	public static  void Extractor() throws IOException {
		int statuscode=Put_Common_Method.ResponsestatusCode1(Put_Request.BaseURI(),Put_Request.Resource(),Put_Request.RequestBody());
		System.out.println( statuscode);
		String ResponseBody=Put_Common_Method.ResponseBody(Put_Request.BaseURI(),Put_Request.Resource(),Put_Request.RequestBody());
		System.out.println(ResponseBody);
		JsonPath JspRequest = new JsonPath(ResponseBody);
		String res_name=JspRequest.getString("name");
		String res_job=JspRequest.getString("job");
		JsonPath JspResponse = new JsonPath(ResponseBody);
		String req_name=JspResponse.getString("name");
		String req_job=JspResponse.getString("job");
		String res_updatedAt=JspResponse.getString("updatedAt");
		System.out.println(res_name);
		System.out.println(res_job);
		res_updatedAt=res_updatedAt.substring(0,11);
		System.out.println(res_updatedAt);
		//validate the responseBody parameters
		Assert.assertEquals(res_name,req_name);
		Assert.assertEquals(res_job,req_job);
	}

}
