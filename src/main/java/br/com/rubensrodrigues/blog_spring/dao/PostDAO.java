package br.com.rubensrodrigues.blog_spring.dao;

import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.rubensrodrigues.blog_spring.models.Post;

@Repository
@Transactional
public class PostDAO {

	@PersistenceContext
	private EntityManager manager;
	
	
	public void gravar(Post post) {
		post.setDataCriacao(new GregorianCalendar(TimeZone.getTimeZone("BRT")));
		manager.persist(post);
	}
	
	public void alterar(Post post) {
		post.setDataModificacao(new GregorianCalendar(TimeZone.getTimeZone("BRT")));
		manager.merge(post);
	}
	
	public List<Post> listar(){
		return manager.createQuery("select p from Post p", Post.class).getResultList();
	}
	
	public Post find(int id) {
		return manager.find(Post.class, id);
	}

	public void remove(int id) {
		Post post = find(id);
		manager.remove(post);
	}
	
}
