package com.thymeleaf.view.resolver;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

@Component
public class MyPropertiesComponent {

	@Bean
	public ClassLoaderTemplateResolver templateResolver2() {
		ClassLoaderTemplateResolver templateResolver2 = new ClassLoaderTemplateResolver();
		templateResolver2.setPrefix("templates-2/");
		templateResolver2.setSuffix(".html");
		templateResolver2.setTemplateMode(TemplateMode.HTML);
		templateResolver2.setCharacterEncoding("UTF-8");
		templateResolver2.setOrder(1);
		templateResolver2.setCheckExistence(true);
		return templateResolver2;
	}

	@Bean
	public ClassLoaderTemplateResolver templateResolver3() {
		ClassLoaderTemplateResolver templateResolver3 = new ClassLoaderTemplateResolver();
		templateResolver3.setPrefix("another-template-folder/");
		templateResolver3.setSuffix(".html");
		templateResolver3.setTemplateMode(TemplateMode.HTML);
		templateResolver3.setCharacterEncoding("UTF-8");
		templateResolver3.setOrder(1);
		templateResolver3.setCheckExistence(true);

		return templateResolver3;
	}
}
