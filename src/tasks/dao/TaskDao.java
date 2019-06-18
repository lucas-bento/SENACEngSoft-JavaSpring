package tasks.dao;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tasks.model.Task;

@Repository
public class TaskDao {
	
	@PersistenceContext
	private EntityManager entityManager;


	@Transactional
	public void inserir(Task task) {
		entityManager.persist(task);
	}


	@SuppressWarnings("unchecked")
	public List<Task> getTasks() {
		return entityManager.createQuery("from Task").getResultList();
	}

	@Transactional
	public void exclui(Task task) {
		Task found = entityManager.find(Task.class, task.getId());
		entityManager.remove(found);
	}


	public Task getById(Long id) {
		return entityManager.find(Task.class, id);
	}

	@Transactional
	public void edita(Task task) {
		entityManager.merge(task);
	}

	@Transactional
	public void finaliza(Long id) {
		Task found = entityManager.find(Task.class, id);
		found.setDataFinalizacao(Calendar.getInstance());
		found.setFinalizada(true);
		
		entityManager.merge(found);
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
}