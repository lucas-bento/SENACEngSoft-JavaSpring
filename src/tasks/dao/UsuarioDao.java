package tasks.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import tasks.model.Usuario;

@Repository
public class UsuarioDao {

	@PersistenceContext
	private EntityManager entityManager;


	public boolean existeUsuario(Usuario usuario) {
		
		if(usuario == null) {
			throw new IllegalArgumentException("Usuario nao pode ser nulo");
		}
		
		try {
			Query query = entityManager.createQuery("from Usuario u where u.login = :login and u.senha = :senha");
			query.setParameter("login", usuario.getLogin());
			query.setParameter("senha", usuario.getSenha());
			
			Object result = query.getSingleResult();
			
			return result != null;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
}