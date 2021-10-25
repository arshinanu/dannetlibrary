package com.library.dannet.config;



import javax.jms.ConnectionFactory;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.library.dannet.dao.BooksRepo;
import com.library.dannet.pojo.Registration;
import com.library.dannet.service.Dueimplementationservice;
import com.library.dannet.service.Duesericechecker;
import com.library.dannet.service.Dueserricecheckerimp;
import com.library.dannet.service.Dueservices;



@Configuration
public class LibConfig {
	
	@Bean(name = "multipartResolver")
	public CommonsMultipartResolver getCommonsMultipartResolver() {
	    CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
	    multipartResolver.setMaxUploadSize(20971520);   // 20MB
	    multipartResolver.setMaxInMemorySize(1048576);  // 1MB
	    return multipartResolver;
	}
	@Bean(name = "registration")
	public Registration getRegistration() {
	    
	    return new Registration();
	}
	@Bean
	public DefaultJmsListenerContainerFactory containerFactory() {
		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
		factory.setSessionTransacted(true);
		factory.setMaxMessagesPerTask(1);
		factory.setConcurrency("1-5");
		return factory;
	}
	@Bean
	public MessageConverter  jacksonJmsMessageConverter() {
		MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
		converter.setTargetType(MessageType.TEXT);
		converter.setTypeIdPropertyName("_type");
		return converter;
	}
	
	@Bean
	public Dueservices dueserviceconfiguration()
	{
		return new Dueimplementationservice();
	}
	
	@Bean
	public Duesericechecker duesericecheckerconfig()
	{
		return new Dueserricecheckerimp();
	}

}
