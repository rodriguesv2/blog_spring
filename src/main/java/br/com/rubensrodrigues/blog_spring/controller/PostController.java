package br.com.rubensrodrigues.blog_spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.rubensrodrigues.blog_spring.dao.PostDAO;
import br.com.rubensrodrigues.blog_spring.models.Post;

@Controller
@RequestMapping("/post")
public class PostController {
	
	@Autowired
	private PostDAO postDao;

	@RequestMapping("/inserir")
	public ModelAndView form() {
		ModelAndView modelAndView = new ModelAndView("insere");
		return modelAndView;
	}
	
	@RequestMapping("/alterar/{id}")
	public ModelAndView formAlterar(@PathVariable("id") Integer id) {
		ModelAndView modelAndView = new ModelAndView("insere");
		Post post = postDao.find(id);
		modelAndView.addObject("post", post);
		return modelAndView;
	}
	
	@RequestMapping("/gravar")
	public ModelAndView gravar(Post post) {
		ModelAndView modelAndView = new ModelAndView("redirect:/");
		
		if(post.getId() == null) {
			postDao.gravar(post);
		}else {
			postDao.alterar(post);
		}
		
		return modelAndView;
	}
	
	@RequestMapping("/detalhe/{id}")
	public ModelAndView detalhe(@PathVariable("id") Integer id) {
		ModelAndView modelAndView = new ModelAndView("detalhe");
		Post post = postDao.find(id);
		
		if(post == null)
			modelAndView.setViewName("erroDetalhe");
			
		modelAndView.addObject("post", post);
		return modelAndView;
	}
	
	@RequestMapping("/remover/{id}")
	public ModelAndView remove(@PathVariable("id") Integer id) {
		ModelAndView modelAndView = new ModelAndView("redirect:/");
		postDao.remove(id);
		return modelAndView;
	}
}













