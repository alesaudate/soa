package com.knight.estoque.modelos;

import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.httpclient.HttpConnection;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpState;
import org.apache.commons.httpclient.methods.GetMethod;

@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
public class Autor {

   private String nome;
   private Date dataNascimento;

   public Autor() {
   }

   public Autor(String nome, Date dataNascimento) {
      super();
      this.nome = nome;
      this.dataNascimento = dataNascimento;
   }

   public List<URL> refs() throws HttpException, IOException {

      String autor = URLEncoder.encode(nome, "UTF-8");
      String searchString = new StringBuilder(
            "/ajax/services/search/web?v=1.0&q=%22").append(autor)
            .append("%22").toString();

      GetMethod getMethod = new GetMethod(searchString);
      HttpState httpState = new HttpState();
      HttpConnection httpConnection = new HttpConnection("ajax.googleapis.com",
            80);
      httpConnection.open();
      getMethod.setFollowRedirects(true);
      int result = getMethod.execute(httpState, httpConnection);

      if (result == 200) {
         List<URL> responseList = new ArrayList<>();
         JSONObject jsonObject = JSONObject.fromObject(getMethod
               .getResponseBodyAsString());
         JSONArray results = jsonObject.getJSONObject("responseData")
               .getJSONArray("results");
         for (int i = 0; i < results.size(); i++) {
            String urlCrua = results.getJSONObject(i).getString("unescapedUrl");
            URL url = new URL(urlCrua);
            responseList.add(url);
         }
         return responseList;
      }

      return Collections.emptyList();

   }

   public String getNome() {
      return nome;
   }

   public void setNome(String nome) {
      this.nome = nome;
   }

   public Date getDataNascimento() {
      return dataNascimento;
   }

   public void setDataNascimento(Date dataNascimento) {
      this.dataNascimento = dataNascimento;
   }

}
