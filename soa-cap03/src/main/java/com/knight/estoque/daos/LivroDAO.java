package com.knight.estoque.daos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.knight.estoque.modelos.Livro;
import com.knight.estoque.modelos.TipoPreco;

public class LivroDAO {

   private static List<Livro> livros;

   static {
      livros = new ArrayList<>();
      Map<TipoPreco, Double> precosLivroPauloSilveira = new HashMap<>();
      precosLivroPauloSilveira.put(TipoPreco.NORMAL, 69.9);
      precosLivroPauloSilveira.put(TipoPreco.CAPA_DURA, 89.9);
      precosLivroPauloSilveira.put(TipoPreco.EBOOK, 29.9);
      livros.add(new Livro(2012, new ArrayList<>(Arrays.asList(
            "Paulo Silveira", "Adriano Almeida")), "Casa do Código",
            "Guia do Programador", "Vá do \"nunca programei\" ...",
            precosLivroPauloSilveira));

      Map<TipoPreco, Double> precosLivroViniBaggio = new HashMap<>();
      precosLivroViniBaggio.put(TipoPreco.NORMAL, 69.9);
      livros.add(new Livro(2012, new ArrayList<>(Arrays
            .asList("Vinícius Baggio Fuentes")), "Casa do Código",
            "Ruby on Rails", "Crie rapidamente aplicações web",
            precosLivroViniBaggio));
   }

   public List<Livro> listarLivros() {
      return livros;
   }

   public List<Livro> listarLivros(Integer numeroDaPagina,
         Integer tamanhoDaPagina) {
      List<Livro> livros = listarLivros();

      int indiceInicial = numeroDaPagina * tamanhoDaPagina;
      int indiceFinal = indiceInicial + tamanhoDaPagina;

      indiceFinal = indiceFinal > livros.size() ? livros.size()
            : indiceFinal;
      indiceInicial = indiceInicial > indiceFinal ? indiceFinal
            : indiceInicial;

      return livros.subList(indiceInicial, indiceFinal);

   }

   public void criarLivro(Livro livro) {
      livros.add(livro);
   }

}
