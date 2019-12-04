package ma.ac.emi.Schooltest;

import com.sun.xml.internal.ws.client.sei.ResponseBuilder;

import ma.ac.emi.School.entities.Account;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@SpringBootTest
public class DemoApplicationTests {


	@Test
	public void test_Login_Correct_Pass_Correct() throws URISyntaxException
	{
		RestTemplate restTemplate = new RestTemplate();

		final String baseUrl = "http://localhost:8080/login";
		URI uri = new URI(baseUrl);

		HttpHeaders head = new HttpHeaders();
		Account acc = new Account("test","test");
		HttpEntity<Account> request = new HttpEntity<>(acc,head);
		ResponseEntity<String> result = restTemplate.postForEntity(uri, request, String.class);
		//Verify request succeed
		Assert.assertEquals("Login Success", result.getBody());



	}
	@Test
	public void test_Login_Correct_Pass_Faux() throws URISyntaxException
	{
		RestTemplate restTemplate = new RestTemplate();

		final String baseUrl = "http://localhost:8080/login";
		URI uri = new URI(baseUrl);

		HttpHeaders head = new HttpHeaders();
		Account acc = new Account("test","t");
		HttpEntity<Account> request = new HttpEntity<>(acc,head);
		ResponseEntity<String> result = restTemplate.postForEntity(uri, request, String.class);
		//Verify request succeed
		Assert.assertEquals("Login Failed", result.getBody());



	}
	@Test
	public void test_Login_Faux_Pass_Correct() throws URISyntaxException
	{
		RestTemplate restTemplate = new RestTemplate();

		final String baseUrl = "http://localhost:8080/login";
		URI uri = new URI(baseUrl);

		HttpHeaders head = new HttpHeaders();
		Account acc = new Account("t","test");
		HttpEntity<Account> request = new HttpEntity<>(acc,head);
		ResponseEntity<String> result = restTemplate.postForEntity(uri, request, String.class);
		//Verify request succeed
		Assert.assertEquals("this account doesnt exist", result.getBody());



	}
	@Test
	public void test_Login_Faux_Pass_Faux() throws URISyntaxException
	{
		RestTemplate restTemplate = new RestTemplate();

		final String baseUrl = "http://localhost:8080/login";
		URI uri = new URI(baseUrl);

		HttpHeaders head = new HttpHeaders();
		Account acc = new Account("t","t");
		HttpEntity<Account> request = new HttpEntity<>(acc,head);
		ResponseEntity<String> result = restTemplate.postForEntity(uri, request, String.class);
		//Verify request succeed
		Assert.assertEquals("this account doesnt exist", result.getBody());



	}

}
