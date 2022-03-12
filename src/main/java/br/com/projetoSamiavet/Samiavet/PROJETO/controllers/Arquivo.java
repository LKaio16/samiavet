package br.com.projetoSamiavet.Samiavet.PROJETO.controllers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.springframework.web.multipart.MultipartFile;

public class Arquivo {

	
	
	public void upload(String pasta, String nomeDoArquivo, MultipartFile arquivoCarregado) { 
		try {
		String caminhoArquivo = pasta + "/" + nomeDoArquivo; 
		File novoArquivo = new File(caminhoArquivo); 
		FileOutputStream saida = new FileOutputStream(novoArquivo); 
		copiar(arquivoCarregado, saida);
		}catch (IOException e) {
			e.printStackTrace();
		}
		}

private void copiar(MultipartFile arquivoCarregado, OutputStream destino) {
int bite = 0; byte[] 
tamanhoMaximo = new byte[1024 * 8]; // 8KB
try { 
// enquanto bytes forem sendo lidos 
   while((bite = ((InputStream) arquivoCarregado).read(tamanhoMaximo)) >= 0) { 
    // pegue o byte lido e escreva no destino 
     destino.write(tamanhoMaximo, 0, bite);
     } 
   } catch (IOException e) { 
     // TODO Auto-generated catch block e.printStackTrace();
      } 
  }
}
