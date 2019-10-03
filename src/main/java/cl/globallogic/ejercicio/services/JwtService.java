package cl.globallogic.ejercicio.services;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.JwtParser;

@Service
public class JwtService {

	private static final Logger logger = LoggerFactory.getLogger(JwtService.class);

	@Autowired
	private JwtBuilder jwtBuilder;
	@Autowired
	private JwtParser jwtParser;

	public String emitToken(Map<String, Object> claims) {
		Calendar date = Calendar.getInstance();
		Date fechaCreacion = new Date(date.getTimeInMillis());		
		return jwtBuilder.setIssuedAt(fechaCreacion).addClaims(claims).compact();
	}

//	public Claims getJwtClaims(String jwt) {
//		Object body = jwtParser.parse(jwt).getBody();
//		if (body instanceof Claims) {
//			return (Claims) body;
//		}
//		return null;
//	}
//
//	public boolean isSignedJwt(String jwt) {
//		try {
//			jwtParser.parse(jwt.substring(7));
//			return true;
//		} catch (JwtException ex) {
//			logger.warn("No fue posible validar el JWT", ex);
//			return false;
//		}
//	}
//	
//	public boolean validaToken(String headerAuthorization) {
//		if (headerAuthorization.length() < 8 || !headerAuthorization.startsWith("Bearer ")) {
//			throw new JwtException("El token no tiene el formato correcto.");
//		}
//		if (!isSignedJwt(headerAuthorization)) {
//			throw new JwtException("El token no esta firmado.");
//		}
//		return true;
//	}
//
//	public Object getClaim(String headerAuthorization, String key) {
//		try {
//			String jwt = headerAuthorization.substring(7);
//			Map<String, Object> claims = getJwtClaims(jwt);
//			return claims.get(key);
//		} catch (Exception e) {
//			throw new JwtException("La información del token es ilegible", e.getCause());
//		}
//	}	
}
