package com.library.dannet.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;

import com.library.dannet.pojo.Books;

public class ReadFiles implements Serializable {
	@Autowired
	JmsTemplate jms;

	public Books readbooks(BufferedReader br) throws IOException
	{
		System.out.println("inside readbooks ");
		char[] st=new char[100];
		String stt,stt2 = null;
		StringBuffer stb=new StringBuffer();
		int i=0,j=0,k=0;
		i=k;
		while ((stt = br.readLine()) != null)
		{
			System.out.println(stt);
			
			stb.append(stt);
		  }
		
		System.out.println(" val is "+stb);
		System.out.println(st);
		String ps=stb.toString().trim();
		if(ps.isEmpty())
		{
			return null;
		}
		else
		{
		Books bb=new Books();
		
		List<String> sts=new ArrayList<String>();
		
		while (i<ps.length())
		{
			if(ps.charAt(i)==' ' || i==ps.length()-1 )
			{
				if(i==ps.length()-1)
				{
					i++;
				}
				sts.add(ps.substring(k,i).trim());
				k=i;
				j++;
			}
			i++;
		}
		j=0;
	String[] stt1=new String[sts.size()];
	for (int c=0;c<sts.size();c++)
	{
		stt1[j]=sts.get(c);
		j++;
	}
	for (int c=0;c<stt1.length;c++)
	{
		bb.setBookid(Integer.parseInt(stt1[0]));
		bb.setBookname(stt1[1]);
		bb.setBooks(stt1[2]);
		bb.setAuthor(stt1[3]);
		bb.setContry(stt1[4]);
		bb.setLanguage(stt1[5]);
		
	}
		
		return bb;
	}
	}
}
