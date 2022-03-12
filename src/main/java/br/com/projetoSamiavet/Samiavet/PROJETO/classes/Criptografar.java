package br.com.projetoSamiavet.Samiavet.PROJETO.classes;

import java.math.BigInteger;
import java.security.MessageDigest;

public class Criptografar {

	
	public static String criptografarSenha(String senha) {
		String retorno = "";
		
		MessageDigest md;
		
		try {
			
			md= MessageDigest.getInstance("MD5");
			BigInteger hash = new BigInteger(1, md.digest(senha.getBytes()));
			retorno = hash.toString();
			
		}catch(Exception erro) {
			
		}
		return retorno;
	}
}
