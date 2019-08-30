package stepDef;

import org.json.simple.JSONObject;
import org.testng.ITestContext;

import com.google.gson.Gson;

import API_CALLS.SCRIPTS.RegistrationSuccessResponse;
import API_CALLS.SCRIPTS.Root_Class_GET;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class API_Step_def {
	
	@Given("call GET method")
    public void call_GET_method() {
		
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET, "/Hyderabad");
		String r1 = response.getBody().asString();
		Root_Class_GET rp = new Gson().fromJson(r1, Root_Class_GET.class);
		String city = rp.getCity();
		String temp = rp.getTemperature();
		System.out.println(city);
		System.out.println(response.getContentType() + response.getStatusCode());		
    }

    @SuppressWarnings("unchecked")
	@Given("call POST method")
    public void call_POST_method() {
    	
    	RestAssured.baseURI = "http://restapi.demoqa.com/customer";
		RequestSpecification httpRequest = RestAssured.given().contentType("application/json");

		JSONObject requestParams = new JSONObject();
		requestParams.put("FirstName", "Viraenad");
		requestParams.put("LastName", "Siana");
		requestParams.put("UserName", "63uaasaerf2");
		requestParams.put("Password", "passwaao");
		requestParams.put("Email", "ed26df39@gmail.com");
		httpRequest.body(requestParams.toJSONString());
		Response response = httpRequest.post("/register");
		String body = response.getBody().asString();
		RegistrationSuccessResponse rp = new Gson().fromJson(body, RegistrationSuccessResponse.class);
		String StatusCode = rp.FaultId;
		System.out.println(StatusCode);
		System.out.println(response.getContentType() + response.getStatusCode());
    }

}
