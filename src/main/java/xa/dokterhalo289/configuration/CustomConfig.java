package xa.dokterhalo289.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CustomConfig implements WebMvcConfigurer{
    String mypath = "file:\\C:\\Users\\user\\Documents\\GitHub\\dokterhalo\\dokterhalo289\\assets\\photos\\";
    
    @Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/images/**").addResourceLocations(mypath);
	}
}
