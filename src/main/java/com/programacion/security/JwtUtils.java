package com.programacion.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;

@Component
public class JwtUtils {

	private static final Logger LOG = LoggerFactory.getLogger(JwtUtils.class);

	public boolean validateJwtToken(String token) {
		try {
			Jwts.parser().setSigningKey("semilla1").parseClaimsJws(token);
			return true;
		} catch (ExpiredJwtException e) {
			LOG.error("Token expirado {}", e.getMessage());
		}

		return false;
	}

	public String getUserNameFromJwtToken(String token) {
		return Jwts.parser().setSigningKey("semilla1").parseClaimsJws(token).getBody().getSubject();
	}

}
