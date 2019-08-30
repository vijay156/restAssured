package API_CALLS.SCRIPTS;

import org.json.simple.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class testCASE {

	@Test
	public void GetWeatherDetails(ITestContext context) {
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET, "/Hyderabad");
		String r1 = response.getBody().asString();
		Root_Class_GET rp = new Gson().fromJson(r1, Root_Class_GET.class);
		String city = rp.getCity();
		String temp = rp.getTemperature();
		System.out.println(city);
		System.out.println(response.getContentType() + response.getStatusCode());
		context.setAttribute("Temperature", temp); 
	}

	@SuppressWarnings("unchecked")
	@Test
	public void RegistrationSuccessful(ITestContext context) {
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
		System.out.println(context.getAttribute("Temperature"));
		Assert.assertEquals("27.46 Degree celsius", context.getAttribute("Temperature"));
	}

}
