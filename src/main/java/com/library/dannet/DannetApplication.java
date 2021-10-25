package com.library.dannet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jms.core.JmsTemplate;

import com.library.dannet.pojo.Books;
import com.library.dannet.service.Dueimplementationservice;
import com.library.dannet.service.Dueservices;
import com.library.dannet.service.ReadFiles;
@SpringBootApplication
public class DannetApplication {

	public static void main(String[] args) throws IOException {
		ConfigurableApplicationContext context=SpringApplication.run(DannetApplication.class, args);
		JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);
		
		Dueservices ds=context.getBean(Dueimplementationservice.class);
		ds.createdue();
		
		File file = new File("D:\\library.txt");
		/*Books bk=new Books();
		bk.setBookid(100001);
		jmsTemplate.convertAndSend("java",bk);
		System.out.println("welcome arshin");*/
		BufferedReader br = new BufferedReader(new FileReader(file));
		if(br==null)
		{
			System.out.println("do nothingf ");
			System.out.println("testing git");
		}
		else
		{
		ReadFiles rf=new ReadFiles();
	
		Books bf=rf.readbooks(br);
		if(bf==null)
		{
			System.out.println("do nothing");
		}
		else
		{
		System.out.println(bf);
		jmsTemplate.convertAndSend("java",bf);
		}
		}
		  //System.out.println(bf);
		
	}

	 
}
