package com.vitu.single.thread;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SingleThreadApplicationTests {
	@Autowired
	TestRestTemplate testRestTemplate;

	@Test
	void test() {
		User user = new User(null, "user","123456", "vitorbrussolo@gmial.com");
		User postResponse = testRestTemplate.postForObject("/users", user, User.class);

		//verificar se foi gerado um id no usuario retornado
		assertNotNull(postResponse.id());

		//comparando os atributos
		assertEquals(user.username(), postResponse.username());
		//assertEquals(user.password(), postResponse.password());
		assertEquals(user.email(), postResponse.email());


		//verificando o get
		User[] getResponses = testRestTemplate.getForObject("/users", User[].class);
		//como é uma lista vamos pegar apenas o primeiro usuario
		User getResponse = getResponses[0];
		assertNotNull(getResponse.id());
		assertEquals(user.username(), getResponse.username());
		//assertEquals(user.password(), getResponse.password());
		assertEquals(user.email(), getResponse.email());
	}

}
