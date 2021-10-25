package com.library.dannet.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;

import org.apache.commons.math3.util.MultidimensionalCounter.Iterator;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.dannet.dao.BooksRepo;
import com.library.dannet.pojo.Books;
import com.library.dannet.pojo.FileBeans;



@Service
public class uploadservice implements Importserinceintf {

	
	@Autowired
	BooksRepo br;
	
	
	@Override
	public void importfile(FileBeans fileBean) {
		DataFormatter dataFormatter = new DataFormatter();
		ByteArrayInputStream bis = new ByteArrayInputStream(fileBean.getFileData().getBytes());
		String filename=fileBean.getFileData().getOriginalFilename();
        Workbook workbook;
        try {
            if (fileBean.getFileData().getOriginalFilename().endsWith("xls")) {
                workbook = new HSSFWorkbook(bis);
            } else if (fileBean.getFileData().getOriginalFilename().endsWith("xlsx")) {
                workbook = new XSSFWorkbook(bis);
            } else {
                throw new IllegalArgumentException("Received file does not have a standard excel extension.");
            }
            Sheet sheet=workbook.getSheetAt(0);
           /* for (Row row : sheet) {
               if (row.getRowNum() == 0) {
                  java.util.Iterator<Cell> cellIterator = row.cellIterator();
                  while (cellIterator.hasNext()) {
                      Cell cell = cellIterator.next();
                      System.out.println(cell);
                  }
               }
            }
			*/
            
           
            	
            List<String> booklist= new ArrayList<String>();
            List<Books> booklistC= new ArrayList<Books>();
            int noOfColumns = sheet.getRow(0).getLastCellNum();
            for (Row row : sheet) {
            	Books book=new Books();
            	Random rm=new Random();
            	int p;
            	p=0;
            	
    			for (Cell cell : row) {
    				String cellValue = dataFormatter.formatCellValue(cell);
    				Random ran=new Random();
    				booklist.add(cellValue);
    				
    				
    			}
            }
            booklist.forEach(p -> System.out.println(p));
            
            
            System.out.println(booklist.size());
            System.out.println(noOfColumns);
            Random ran=new Random();
           
           int i=noOfColumns;
            do {
            	Books iv=new Books();
            	iv.setBookid(Integer.parseInt(booklist.get(i)));
            	iv.setBooks(booklist.get(i+1));
            	iv.setBookname(booklist.get(i+2));
            	iv.setAuthor(booklist.get(i+3));
            	iv.setContry(booklist.get(i+4));
            	iv.setLanguage(booklist.get(i+5));
            	i=i+noOfColumns;
            	System.out.println(iv);
            	booklistC.add(iv);
        		//System.out.println(i);
        		
            }while (i < booklist.size());
            
            booklistC.forEach(new Consumer<Books>() {

				@Override
				public void accept(Books t) {
					System.out.println(t);
					br.save(t);
					
				}
            	
			});
			
            
           
            
            
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

}
