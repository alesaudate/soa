package com.knight.usuarios.servicos.testes.integracao;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.knight.usuarios.servicos.UsuariosService;

public class UsuariosITCase {

   public static String SERVICES_CONTEXT = "http://localhost:8080/soa-cap05-0.0.1-SNAPSHOT/services";

   public static String USUARIOS_CONTEXT = SERVICES_CONTEXT + "/usuarios";

   private byte[] fotoSaudate;

   @Before
   public void setup() throws IOException {
      BufferedImage bufferedImage = ImageIO.read(UsuariosITCase.class
            .getResourceAsStream("/saudate.png"));
      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      ImageIO.write(bufferedImage, "png", baos);
      this.fotoSaudate = baos.toByteArray();
   }

   @Test
   public void testRecepcaoImagens() throws Exception {
      ClientResponse<byte[]> clientResponse = new ClientRequest(
            USUARIOS_CONTEXT + "/{id}").pathParameters(1).accept("image/*")
            .get(byte[].class);
      byte[] image = clientResponse.getEntity();
      int status = clientResponse.getStatus();

      Assert.assertEquals(200, status);
      Assert.assertArrayEquals(fotoSaudate, image);

      String descricao = clientResponse.getHeaders().getFirst(
            UsuariosService.CAMPO_DESCRICAO_IMAGEM);

      Assert.assertEquals("Alexandre Saudate - 2012", descricao);
   }

   @Test
   public void testCriacaoImagens() throws Exception {
      ClientResponse<?> clientResponse = new ClientRequest(USUARIOS_CONTEXT
            + "/{id}").pathParameters(1)
            .header(UsuariosService.CAMPO_DESCRICAO_IMAGEM, "Nova descricao")
            .body("image/png", fotoSaudate).put();

      Assert.assertEquals(204, clientResponse.getStatus());

      clientResponse = new ClientRequest(USUARIOS_CONTEXT + "/{id}")
            .pathParameters(1).accept("image/*").get(byte[].class);
      byte[] image = (byte[]) clientResponse.getEntity();
      int status = clientResponse.getStatus();

      Assert.assertEquals(200, status);
      Assert.assertArrayEquals(fotoSaudate, image);

      String descricao = clientResponse.getHeaders().getFirst(
            UsuariosService.CAMPO_DESCRICAO_IMAGEM);

      Assert.assertEquals("Nova descricao", descricao);

   }

}
