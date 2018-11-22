package br.com.expertsunited.facade;

import java.util.List;

import br.com.expertsunited.controler.regra.GraficaNegocio;
import br.com.expertsunited.model.entity.Grafica;

public class GraficaFachada {
	
	private final GraficaNegocio graNeg;
	
	public GraficaFachada() {
		graNeg = new GraficaNegocio();
	}
	
	/**
   * Chama as regras de negocio para cadastro de uma Gr�fica
   * @param gr�fia todos os dados da gr�fica
   * @throws Exception
   */
	public void createGrafica(Grafica grafica) throws Exception{
		graNeg.validaGrafica(grafica);
		graNeg.inserirGrafica(grafica);
	}
	
	/**
   * Atualiza os dados de uma Gr�fica
   * @param gr�fica dados da gr�fica
   * @throws Exception
   */
	public void updateGrafica(Grafica grafica) throws Exception{
		graNeg.alterarGrafica(grafica);
	}
	
	/**
   * Remove um registro do banco de dados
   * @param gr�fica dados da gr�fica a ser exclu�da
   * @throws Exception
   */
	public void removeGrafica(Grafica grafica) throws Exception{
		graNeg.removerGrafica(grafica);
	}
	
	/**
   * Retorna uma Gr�fica baseado no dado passado
   * @param id ID da Gr�fica a ser consultado
   * @return A Gr�fica encontrada ou NULL
   * @throws Exception
   */
	public Grafica getByIdGrafica(int id) throws Exception{
		return graNeg.buscarPorIdGrafica(id);
	}
	
	/**
   * Retorna a lista de todos as Gr�ficas
   * @return Lista de Grafica
   * @throws Exception
   */
	public List<Grafica> getListGrafica() throws Exception{
		return graNeg.listaGrafica();
	}
	
	/**
   * Retorna uma Gr�fica baseado no dado passado
   * @param id ID da Gr�fica a ser consultado
   * @return A Gr�fica encontrada ou NULL
   * @throws Exception
   */
	public List<Grafica> getByNameGrafica(String nome) throws Exception{
		return graNeg.buscarPorNomeGrafica(nome);
	}
	
}
