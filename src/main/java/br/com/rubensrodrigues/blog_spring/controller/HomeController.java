package br.com.rubensrodrigues.blog_spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.rubensrodrigues.blog_spring.dao.PostDAO;
import br.com.rubensrodrigues.blog_spring.models.Post;

@Controller
public class HomeController {

	@Autowired
	private PostDAO postDao;
	
	@RequestMapping("/")
	public ModelAndView index() {
		List<Post> lista = postDao.listar();
		ModelAndView modelAndView = new ModelAndView("home");
		modelAndView.addObject("lista", lista);
		return modelAndView;
	}
}
