package br.com.rubensrodrigues.blog_spring.conf;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//Classe inicial do spring. Usada para iniciar classes de configuração
public class ServletSpringMVC extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	//Metodo usado para indicar que as classes de configuração serão usadas quando a o servlet for chamado
	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {AppWebConfiguration.class, JPAConfiguration.class};
	}

	//Indica a partir de qual URL a configuração deve agir
	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] {"/"};
	}

	//Serve para salvar os dados em UTF-8
	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
        encodingFilter.setEncoding("UTF-8");
        return new Filter[] {encodingFilter};
	}
	
	//Serve para carregar os arquivos nas JSP usando o a tag <link>, como os CSS e JS
	@Override
	protected void customizeRegistration(Dynamic registration) {
			registration.setMultipartConfig(new MultipartConfigElement(""));
	}
}
