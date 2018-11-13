package br.com.expertsunited.controler.regra;

import java.util.List;

import br.com.expertsunited.model.dao.GraficaDAO;
import br.com.expertsunited.model.dao.IGraficaDAO;
import br.com.expertsunited.model.entity.Grafica;

public class GraficaNegocio {

	private final IGraficaDAO daoGrafica;
	
	public GraficaNegocio() {
		daoGrafica = new GraficaDAO();
	}
	
	public void validaGrafica(Grafica grafica) throws Exception{
		if(grafica == null) {
			throw new Exception("Gr�fica n�o instanciada");
		}
		if(grafica.getNome().equals("") == true || grafica.getNome() == null) {
			throw new Exception("Informe o nome da Gr�fica");
		}
		if(grafica.getEmail().equals("") ||grafica.getEmail() == null) {
			throw new Exception("Informe o email da Gr�fica");
		}
		if(grafica.getTelefone().equals("") ||grafica.getTelefone() == null) {
			throw new Exception("Informe o telefone da Gr�fica");
		}
		if(grafica.getCnpj().equals("") ||grafica.getCnpj() == null) {
			throw new Exception("Informe o CNPJ da Gr�fica");
		}
		if(grafica.getLogin().equals("") || grafica.getLogin() == null) {
			throw new Exception("Informe um login para a Gr�fica");
		}
		if(grafica.getSenha().equals("") || grafica.getSenha() == null) {
			throw new Exception("Informe uma senha para a Gr�fica");
		}	
	}
	
	public void inserirGrafica(Grafica grafica) throws Exception{
		try {
			daoGrafica.create(grafica);
		}
		catch(Exception ex) {			
			throw new Exception("Erro:" + ex.getMessage());
		}
	}
	
	public void alterarGrafica(Grafica grafica) throws Exception{
		try {
			daoGrafica.update(grafica);
		}
		catch(Exception ex) {
			throw new Exception("Erro:" + ex.getMessage());
		}
	}
	
	public void removerGrafica(Grafica grafica) throws Exception{
		try {
			daoGrafica.remove(grafica);
		}
		catch(Exception ex){
			throw new Exception("Erro:" + ex.getMessage());
		}
	}
	
	public Grafica buscarPorIdGrafica(int id) throws Exception{
		try {
			Grafica consultaGrafica = daoGrafica.getByID(id);
			return(consultaGrafica);
		}
		catch(Exception ex) {
			throw new Exception("Erro:" + ex.getMessage());
		}
	}
	
	public List<Grafica> listaGrafica() throws Exception{
		try {
			List<Grafica> lista = daoGrafica.getList();
			return(lista);
		}
		catch(Exception ex){
			throw new Exception("Erro:" + ex.getMessage() );
		}
	}
	
}
