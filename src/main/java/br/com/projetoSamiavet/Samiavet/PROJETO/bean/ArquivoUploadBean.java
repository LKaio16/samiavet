package br.com.projetoSamiavet.Samiavet.PROJETO.bean;

import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;
import org.primefaces.model.file.UploadedFiles;


@Named(value="fileUploadView")
@RequestScoped
public class ArquivoUploadBean {
	
	 private UploadedFile file;
	    private UploadedFiles files;
	 
	    public UploadedFile getFile() {
	        return file;
	    }
	 
	    public void setFile(UploadedFile file) {
	        this.file = file;
	    }
	 
	    public UploadedFiles getFiles() {
	        return files;
	    }
	 
	    public void setFiles(UploadedFiles files) {
	        this.files = files;
	    }
	    
	 
	 
	    public void upload() {
	        if (file != null) {
	            FacesMessage message = new FacesMessage("Successful", file.getFileName() + " is uploaded.");
	            FacesContext.getCurrentInstance().addMessage(null, message);
	        }
	    }
	     
	    public void uploadMultiple() {
	        if (files != null) {
	            for (UploadedFile f : files.getFiles()) {
	                FacesMessage message = new FacesMessage("Successful", f.getFileName() + " is uploaded.");
	                FacesContext.getCurrentInstance().addMessage(null, message);
	            }
	        }
	    }
	     
	    public void handleFileUpload() {
	    	
	    	
	    	String path = "C:\\Users\\kauaf\\Downloads\\" +
					"teste";
	    	
	    	
			  int cont = 1;
						  File termo = new File(path, this.file.getFileName());
				  if(cont==1) {
					  termo.renameTo(new File("teste" + ".pdf"));
					  
					  try {
							  OutputStream out = new FileOutputStream(termo);
							  out.write(this.file.getContent());
							  out.close();
							  System.out.println(termo.getName());
							  cont++;
							  
					  } catch (IOException e) {
						  FacesContext.getCurrentInstance().addMessage(
					            null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro", e.getMessage()));
						  
					  }
					  
				  }
				  else {
						  termo.renameTo(new File("teste" + cont + ".pdf"));
						  try {
							  OutputStream out = new FileOutputStream(termo);
							  out.write(this.file.getContent());
							  out.close();
							  System.out.println(termo.getName());
							  cont++;
							  
						  } catch (IOException e) {
							  FacesContext.getCurrentInstance().addMessage(
						            null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro", e.getMessage()));
							  
						  }
					 
				  }
			  
				 

	    }
	    
	    public void testar() {
	    
	    	System.out.println(this.file.getFileName());
	    }
}
	  
