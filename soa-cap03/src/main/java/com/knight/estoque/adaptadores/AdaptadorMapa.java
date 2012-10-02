package com.knight.estoque.adaptadores;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import com.knight.estoque.modelos.TipoPreco;
import com.knight.estoque.servicos.EntradaMapa;
import com.knight.estoque.servicos.Mapa;

public class AdaptadorMapa extends
      XmlAdapter<Mapa, Map<TipoPreco, Double>> {

   @Override
   public Mapa marshal(Map<TipoPreco, Double> v) throws Exception {
      Mapa mapa = new Mapa();
      List<EntradaMapa> entradas = new ArrayList<>();
      for (Entry<TipoPreco, Double> entry : v.entrySet()) {
         EntradaMapa entradaMapa = new EntradaMapa();
         entradaMapa.setTipoPreco(entry.getKey());
         entradaMapa.setPreco(entry.getValue());
         entradas.add(entradaMapa);
      }
      mapa.setEntradas(entradas);
      return mapa;
   }

   @Override
   public Map<TipoPreco, Double> unmarshal(Mapa v) throws Exception {

      Map<TipoPreco, Double> mapa = new HashMap<>();
      for (EntradaMapa entrada : v.getEntradas()) {
         mapa.put(entrada.getTipoPreco(), entrada.getPreco());
      }
      return mapa;
   }

}
