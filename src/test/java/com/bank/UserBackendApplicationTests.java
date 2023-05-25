package com.bank;

import java.text.ParseException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
@Import(UserBackendApplication.class)
public class UserBackendApplicationTests {

	@Test
	public void main() throws ParseException {
		UserBackendApplication.main(new String[0]);
	}

}
