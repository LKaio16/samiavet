package br.com.projetoSamiavet.Samiavet.PROJETO;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import br.com.projetoSamiavet.Samiavet.PROJETO.filtros.appAuth;
import br.com.projetoSamiavet.Samiavet.PROJETO.filtros.loginAuth;
import br.com.projetoSamiavet.Samiavet.PROJETO.filtros.mudarSenhaAuth;


/**
 *
 * Spring Boot application starter class
 */
@SpringBootApplication
public class Application extends SpringBootServletInitializer{
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        
        
        
    }
 
    @Bean
    public FilterRegistrationBean<loginAuth> loggingFilter(){
        FilterRegistrationBean<loginAuth> registrationBean 
          = new FilterRegistrationBean<>();
            
        registrationBean.setFilter(new loginAuth());
        registrationBean.addUrlPatterns("/seguranca/login.xhtml");
        registrationBean.setOrder(2);
            
        return registrationBean;    
    }
    
    @Bean
    public FilterRegistrationBean<appAuth> loggingFilter2(){
        FilterRegistrationBean<appAuth> registrationBean 
          = new FilterRegistrationBean<>();
            
        registrationBean.setFilter(new appAuth());
        registrationBean.addUrlPatterns("/pages/*");
        registrationBean.setOrder(2);
            
        return registrationBean;    
    }
    
    @Bean
    public FilterRegistrationBean<mudarSenhaAuth> recuperarSenhaFiltro(){
        FilterRegistrationBean<mudarSenhaAuth> registrationBean 
          = new FilterRegistrationBean<>();
            
        registrationBean.setFilter(new mudarSenhaAuth());
        registrationBean.addUrlPatterns("/seguranca/mudar.xhtml");
        registrationBean.setOrder(2);
            
        return registrationBean;    
    }
 
    
}
