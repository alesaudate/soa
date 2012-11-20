package br.com.casadocodigo.soaaplicado.cap06;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Base64;

public class HashSenhas {

   private static String SENHA = "admin";

   public static void main(String[] args) throws NoSuchAlgorithmException {
      MessageDigest digest = MessageDigest.getInstance("SHA-256");
      byte[] senhaBytes = digest.digest(SENHA.getBytes());
      System.out.println(Base64.encodeBase64String(senhaBytes));
   }

}
