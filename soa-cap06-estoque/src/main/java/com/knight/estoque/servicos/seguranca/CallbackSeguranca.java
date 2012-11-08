package com.knight.estoque.servicos.seguranca;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.ws.security.WSPasswordCallback;

public class CallbackSeguranca
      implements
      CallbackHandler {

   @PersistenceContext
   private EntityManager em;

   private Map<String, String> passwords = new HashMap<String, String>();

   public CallbackSeguranca() {
      passwords
            .put("alice", "password");
      passwords
            .put("bob", "password");
   }

   @Override
   public void handle(
         Callback[] callbacks) throws IOException, UnsupportedCallbackException {
      for (int i = 0; i < callbacks.length; i++) {
         if (callbacks[i] instanceof WSPasswordCallback) {
            WSPasswordCallback pc = (WSPasswordCallback) callbacks[i];
            String pass = passwords
                  .get(pc
                        .getIdentifier());
            if (pass != null) {
               pc.setPassword(pass);
               return;
            }
         }
      }

   }

}
