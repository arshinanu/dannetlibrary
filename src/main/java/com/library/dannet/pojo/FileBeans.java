package com.library.dannet.pojo;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Component
public class FileBeans {

	
	private CommonsMultipartFile fileData;

	  public CommonsMultipartFile getFileData()
	  {
	    return fileData;
	  }

	  public void setfileData(CommonsMultipartFile file)
	  {
	    this.fileData = file;
	  }
	
}
