package br.com.itinerario.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Sanderson Soares
 */
public class PaginationUtil {

    private int quantidadePorPagina;
    private List<Object> lista;
    private List<Object> listaPaginada;
    private List<Integer> listaPaginas;
    private Map<Integer, List<Object>> listaMap;

    public PaginationUtil(List<Object> lista, int quantidadePorPagina) {
        this.lista = lista;
        this.quantidadePorPagina = quantidadePorPagina;
        listaMap = new HashMap<Integer, List<Object>>();
        gerarPaginas();
    }

    public int getQuantidadePaginas() {
        int qntPagesFinal = 0;
        int total = lista.size();
        double qntPaginas = ((double)total / (double)quantidadePorPagina);
        qntPagesFinal = (int) qntPaginas;
        if (!(total % quantidadePorPagina == 0)) {
            qntPagesFinal++;
        } 

        return qntPagesFinal;
    }

    public void gerarPaginas() {
        this.listaPaginas = new ArrayList<>();
        List<Object> temp = new ArrayList<>();

        int aux = 0;
        for (int i = 1; i <= getQuantidadePaginas(); i++) {

            for (int j = 0; j < quantidadePorPagina; j++) {
                temp.add(lista.get(aux));
                aux++;

                if (aux >= lista.size()) {
                    break;
                }
            }

            listaMap.put(i, temp);
            listaPaginas.add(i);
            temp = new ArrayList<>();
        }
        listaPaginada = listaMap.get(1);
    }

    public List<Object> getListaPaginada() {
        return listaPaginada;
    }
    
    public void getPagina(int numeroPagina) {
        this.listaPaginada = listaMap.get(numeroPagina);
    }

    public int getQuantidadePorPagina() {
        return quantidadePorPagina;
    }

    public void setQuantidadePorPagina(int quantidadePorPagina) {
        this.quantidadePorPagina = quantidadePorPagina;
    }

    public List<Object> getLista() {
        return lista;
    }

    public void setLista(List<Object> lista) {
        this.lista = lista;
    }

    public List<Integer> getListaPaginas() {
        return listaPaginas;
    }

    public void setListaPaginas(List<Integer> listaPaginas) {
        this.listaPaginas = listaPaginas;
    }

    public Map<Integer, List<Object>> getListaMap() {
        return listaMap;
    }

    public void setListaMap(Map<Integer, List<Object>> listaMap) {
        this.listaMap = listaMap;
    }

}
