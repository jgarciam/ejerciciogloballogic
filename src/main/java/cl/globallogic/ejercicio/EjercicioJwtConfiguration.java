package cl.globallogic.ejercicio;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Configuration
public class EjercicioJwtConfiguration {
	
	@Value("${cl.globallogic.ejercicio.jwt.algorithm}")
	private String algorithm;	
	@Value("${cl.globallogic.ejercicio.jwt.secret}")
	private String jwtSecret;
	@Value("${cl.globallogic.ejercicio.jwt.issuer}")
	private String jwtIssuer;
	
	@Bean
	public SignatureAlgorithm jwtAlgorithm(Environment env) {
		return SignatureAlgorithm.forName(algorithm);
	}

	@Bean
	public JwtBuilder jwtBuilder(Environment env) {		
		return Jwts.builder().setIssuer(jwtIssuer).signWith(jwtAlgorithm(env), jwtSecret.getBytes());
	}

	@Bean
	public JwtParser jwtParser(Environment env) {
		return Jwts.parser().requireIssuer(jwtIssuer) .setSigningKey(jwtSecret.getBytes());
	}
}
