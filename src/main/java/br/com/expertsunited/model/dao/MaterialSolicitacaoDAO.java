package br.com.expertsunited.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.expertsunited.model.JPAUtil.UtilJPA;
import br.com.expertsunited.model.entity.MaterialSolicitacao;

public class MaterialSolicitacaoDAO implements IMaterialSolicitacaoDAO {
	EntityManager eManager = UtilJPA.getEntityManager();

	/**
	 * M�todo para persistir um novo objeto MaterialSolicitacao
	 * @param materialsolicitacao 
	 */
	
	public void create(MaterialSolicitacao materialsolicitacao) {
		try {
			eManager.getTransaction().begin();
			eManager.persist(materialsolicitacao);
			eManager.getTransaction().commit();
		}catch(Exception exp) {
			eManager.getTransaction().rollback();			
		}finally {
			eManager.close();
		}
		
	}
	
	/**
	 * M�todo para atualizar um objeto Grafica j� persistido
	 * @param grafica
	 */

	public void update(MaterialSolicitacao materialsolicitacao) {
		try {
			eManager.getTransaction().begin();
			eManager.merge(materialsolicitacao);
			eManager.getTransaction().commit();			
		}catch(Exception exp) {
			eManager.getTransaction().rollback();
		}finally {
			eManager.close();
		}
		
	}
	
	/**
	 * M�todo para excluir um objeto MaterialSolicitacao j� persistido
	 * @param materialsolicitacao
	 */

	public void remove(MaterialSolicitacao materialsolicitacao) {
		try {
			eManager.getTransaction().begin();
			eManager.remove(materialsolicitacao);
			eManager.getTransaction().commit();
		}catch(Exception exp) {
			eManager.getTransaction().rollback();
		}finally {
			eManager.close();
		}
		
	}
	
	/**
	 * M�todo para listar todas os objetos MaterialSolicitacao persistidos
	 */

	public List<MaterialSolicitacao> getlist() {
		List<MaterialSolicitacao> materialsolicitacao = null;
		try {
			Query consulta = eManager.createQuery("SELECT ms FROM MaterialSolicitacao ms");
			materialsolicitacao = consulta.getResultList();
		}catch(Exception exp) {
			eManager.getTransaction().rollback();
		}finally {
			eManager.close();
		}
		return materialsolicitacao;
	}
	
	/**
	 * M�todo para buscar um objeto MaterialSolicitacao informando seu ID
	 * @param id
	 */

	public MaterialSolicitacao getByID(int id) {
		MaterialSolicitacao materialsolicitacao = null;
		try {
			materialsolicitacao = eManager.find(MaterialSolicitacao.class, id);
		}catch(Exception exp) {
			eManager.getTransaction().rollback();
		}finally {
			eManager.close();
		}
		return materialsolicitacao;
	}
	

}
