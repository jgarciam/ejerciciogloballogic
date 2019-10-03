package cl.globallogic.ejercicio.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import cl.globallogic.ejercicio.forms.PhoneForm;
import cl.globallogic.ejercicio.forms.UserForm;
import cl.globallogic.ejercicio.modelo.Phone;
import cl.globallogic.ejercicio.modelo.User;
import cl.globallogic.ejercicio.repositories.UserRespository;

@Service
public class UserService {

	@Autowired
	private UserRespository userRespository;

	@Autowired
	private JwtService jwtService;

	public User save(UserForm newUser) {
		User user = new User();
		BeanUtils.copyProperties(newUser, user, "phones");
		List<Phone> phones = new ArrayList<>();
		for (PhoneForm phoneForm : newUser.getPhones()) {
			Phone phone = new Phone();
			BeanUtils.copyProperties(phoneForm, phone);
			phones.add(phone);
		}
		if(!CollectionUtils.isEmpty(phones)) {
			user.setPhones(phones);
		}
		user.setIsactive(true);
		obtieneToken(user);
		return userRespository.save(user);
	}

	private void obtieneToken(User user) {
		Map<String, Object> claims = new HashMap<>();
		claims.put("email", user.getEmail());
		user.setToken(jwtService.emitToken(claims));
	}
}
