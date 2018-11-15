package br.com.expertsunited.model.dao;

import java.util.List;
import javax.persistence.EntityManager;
import br.com.expertsunited.model.JPAUtil.UtilJPA;
import br.com.expertsunited.model.entity.Usuario;

public class UsuarioDAO implements IUsuarioDAO {
	EntityManager eManager = UtilJPA.getEntityManager();
	
	/**
	 * M�todo para persistir um novo objeto Usuario
	 * @param usuario 
	 */
	public void create(Usuario usuario) {
		try {
			eManager.getTransaction().begin();
			eManager.persist(usuario);
			eManager.getTransaction().commit();
		} catch(Exception exp) {
			exp.printStackTrace();
			eManager.getTransaction().rollback();
		} finally {
			eManager.close();
		}
	}
	
	/**
	 * M�todo para atualizar um objeto Usuario j� persistido
	 * @param usuario
	 */
	public void update(Usuario usuario) {
		try {
			eManager.getTransaction().begin();
			eManager.merge(usuario);
			eManager.getTransaction().commit();
		} catch(Exception exp) {
			exp.printStackTrace();
			eManager.getTransaction().rollback();
		} finally {
			eManager.close();
		}
	}
	
	/**
	 * M�todo para excluir um objeto Usuario j� persistido
	 * @param usuario
	 */
	public void remove(Usuario usuario) {
		try {
			usuario = eManager.find(Usuario.class, usuario.getIdUsuario());
			eManager.getTransaction().begin();
			eManager.remove(usuario);
			eManager.getTransaction().commit();
		} catch(Exception exp) {
			exp.printStackTrace();
			eManager.getTransaction().rollback();
		} finally {
			eManager.close();
		}
	}
	
	/**
	 * M�todo para listar todos os objetos Usuarios persistidos
	 */
	@SuppressWarnings("unchecked")
	public List<Usuario> getList() {
		List<Usuario> usuarios = null;
		try {
			usuarios = eManager.createQuery("FROM Usuario").getResultList();
		} catch(Exception exp) {
			exp.printStackTrace();
			eManager.getTransaction().rollback();
		} finally {
			eManager.close();
		}
		return usuarios;
	}
	
	/**
	 * M�todo para buscar um objeto Usuario informando seu ID
	 * @param id
	 */
	public Usuario getByID(int id) {
		Usuario usuario = null;
		try {
			usuario = eManager.find(Usuario.class, id);
		} catch(Exception exp) {
			exp.printStackTrace();
			eManager.getTransaction().rollback();
		} finally {
			eManager.close();
		}
		return usuario;
	}
	
	/**
	 * M�todo para buscar um objeto Usuario informando seu login e senha
	 * @param login 
	 * @param senha
	 */
	public Usuario getUsuario(String login, String senha) {
		try {
			Usuario usuario = (Usuario) eManager.createQuery("SELECT u FROM Usuario u WHERE u.login = :login AND u.senha = :senha")
					.setParameter("login", login).setParameter("senha", senha).getSingleResult();
			return usuario;		
		} catch(Exception exp) {
			exp.printStackTrace();
			eManager.getTransaction().rollback();
			return null;
		} finally {
			eManager.close();
		}
	}
}
