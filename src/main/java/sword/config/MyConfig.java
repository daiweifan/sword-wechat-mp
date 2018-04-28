package sword.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;  
   
/**
 * 静态资源拦截
* @ClassName: MyConfig 
* @Description: TODO
* @author daiwei
* @date 2018年4月23日 下午4:21:36 
* 
* @version V2.0
 */
@Configuration  
public class MyConfig extends WebMvcConfigurerAdapter{

	    @Override
	    public void addResourceHandlers(ResourceHandlerRegistry registry) {
	    	registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
	    	registry.addResourceHandler("/images/**").addResourceLocations("classpath:/static/images/");
	    	registry.addResourceHandler("/css/**").addResourceLocations("classpath:/static/css/");
	    	registry.addResourceHandler("/js/**").addResourceLocations("classpath:/static/js/");
	    }
	}