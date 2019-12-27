package io.edelivery.mock.accesspoint;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.io.IOUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@SpringBootApplication
public class MockAccessPointApplication {

	public static void main(String[] args) {
		SpringApplication.run(MockAccessPointApplication.class, args);
	}
	
	@GetMapping(value="/{id}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public byte[] getSubscriptionDetails(@PathVariable(name="id") String id) throws IOException {
		InputStream in = getClass()
			      .getResourceAsStream("/transactions/subscription.xml");
		return IOUtils.toByteArray(in);
	}
}