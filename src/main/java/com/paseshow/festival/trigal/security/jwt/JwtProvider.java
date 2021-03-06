package com.paseshow.festival.trigal.security.jwt;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.paseshow.festival.trigal.dto.LoginUser;
import com.paseshow.festival.trigal.entity.User;
import com.paseshow.festival.trigal.entity.UsersFirst;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;


@Component
public class JwtProvider {
	//genera los token y que valide que no este expirados

	private final static Logger logger = LoggerFactory.getLogger(JwtProvider.class);
	
	//variables para las de application.properties
	@Value("${jwt.secret}")
	private String secret;
	
	@Value("${jwt.expiration}")
	private int expiration;

	
	public String generateToken(Authentication auth, LoginUser user) {
		
		UsersFirst userfirst = (UsersFirst) auth.getPrincipal();
		
		return Jwts.builder().setSubject(user.getNameUser())
				.setIssuedAt(new Date())
				.setExpiration(new Date(new Date().getTime() + expiration *1000))
				.signWith(SignatureAlgorithm.HS512, secret)
				.compact();
		
	}
	
	public String getNameUserFromToken(String token) {
		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
	}
	
	public boolean validToken(String token) {
		try {
			
			Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
			return true;
			
			
		} catch (MalformedJwtException e) {
			logger.error("Token mal formado");
		} catch (UnsupportedJwtException e) {
			logger.error("Token no soportado");
		} catch (ExpiredJwtException e) {
			logger.error("Token expirado");
		} catch (IllegalArgumentException e) {
			logger.error("Token vacio");
		} catch (SignatureException e) {
			logger.error("Error en la firma" + e.getMessage());
		}
		
		return false;
	}
}
