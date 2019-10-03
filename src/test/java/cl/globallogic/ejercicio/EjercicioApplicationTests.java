package cl.globallogic.ejercicio;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import cl.globallogic.ejercicio.forms.PhoneForm;
import cl.globallogic.ejercicio.forms.UserForm;
import cl.globallogic.ejercicio.modelo.User;
import cl.globallogic.ejercicio.services.UserService;

@Test
@SpringBootTest(classes = {EjercicioApplication.class})
public class EjercicioApplicationTests extends AbstractTestNGSpringContextTests{

	@Autowired
	private UserService userService;
	
	@Test
	public void testServices() {
		UserForm newUser = new UserForm();
		newUser.setEmail("jgarciamgmail.com");
		newUser.setName("Jorge");
		newUser.setPassword("hola");
		
		List<PhoneForm> phones = new ArrayList<>();
		PhoneForm newPhone =  new PhoneForm();
		newPhone.setNumber("82236987");
		newPhone.setCountrycode("+56");
		newPhone.setCitycode("9");
		phones.add(newPhone);
		newUser.setPhones(phones);
		
		User user = userService.save(newUser);
		assertNotNull(user.getId());
		assertTrue(user.getPhones().size()>0);
		
		
	}

}
