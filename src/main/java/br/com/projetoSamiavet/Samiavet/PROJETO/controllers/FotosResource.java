package br.com.projetoSamiavet.Samiavet.PROJETO.controllers;

import java.io.IOException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import br.com.projetoSamiavet.Samiavet.PROJETO.bean.ArquivosBean;
import br.com.projetoSamiavet.Samiavet.PROJETO.domain.ArquivosCT;
import br.com.projetoSamiavet.Samiavet.PROJETO.domain.ArquivosES;
import br.com.projetoSamiavet.Samiavet.PROJETO.domain.ArquivosFU;
import br.com.projetoSamiavet.Samiavet.PROJETO.domain.ArquivosGeral;
import br.com.projetoSamiavet.Samiavet.PROJETO.domain.ArquivosImagens;
import br.com.projetoSamiavet.Samiavet.PROJETO.domain.ArquivosRX;
import br.com.projetoSamiavet.Samiavet.PROJETO.domain.ArquivosSV;
import br.com.projetoSamiavet.Samiavet.PROJETO.domain.ArquivosUS;
import br.com.projetoSamiavet.Samiavet.PROJETO.service.ArquivoGeralService;
import br.com.projetoSamiavet.Samiavet.PROJETO.service.ArquivosImagensService;
import br.com.projetoSamiavet.Samiavet.PROJETO.service.CTService;
import br.com.projetoSamiavet.Samiavet.PROJETO.service.ESService;
import br.com.projetoSamiavet.Samiavet.PROJETO.service.FUService;
import br.com.projetoSamiavet.Samiavet.PROJETO.service.RXService;
import br.com.projetoSamiavet.Samiavet.PROJETO.service.SVService;
import br.com.projetoSamiavet.Samiavet.PROJETO.service.USService;

@RestController
public class FotosResource {
	
	@Autowired
	private Disco disco;
	
	
	@Autowired
	private ArquivoGeralService arquivoService;
	
	@Autowired
	private ESService esService;
	
	@Autowired
	private SVService svService;
	
	@Autowired
	private USService usService;
	
	@Autowired
	private FUService fuService;

	@Autowired
	private RXService rxService;
	
	@Autowired
	private CTService ctService;

	@Autowired
	private ArquivosBean arquivosBean;
	
	@Autowired
	private ArquivosImagensService imagensService;
	
	

	
	@RequestMapping(value= "/upload", method = RequestMethod.POST)
	public ModelAndView upload(@RequestParam(name="upload") MultipartFile arquivo) throws IOException {
		
		String nomeArquivo = arquivo.getOriginalFilename();
		
		String[] characters = nomeArquivo.split("");
		
		int ultimaPosicao = (characters.length - 5);
		
		int penultimaPosicao = (characters.length - 6);

		
		
		try {
		
		if(characters[penultimaPosicao].equals("E")&&characters[ultimaPosicao].equals("S")&&arquivo.getOriginalFilename().contains(".pdf")) {
			
			String nomeValida = this.esService.listarPorNome(arquivo.getOriginalFilename());
			
			if(nomeValida == null) {
				
				ArquivosES arquivoES = new ArquivosES();
				arquivoES.setNomeArquivo(arquivo.getOriginalFilename());
				arquivoES.setTipoArquivo(arquivo.getContentType());
				this.esService.salvar(arquivoES);
				disco.salvarFoto(arquivo);
				arquivosBean.carregar();
				
			}else{
				
				return new ModelAndView("erroUpload2.xhtml");

			}
			
			
		}else if(characters[penultimaPosicao].equals("U")&&characters[ultimaPosicao].equals("S")&&arquivo.getOriginalFilename().contains(".pdf")) {
			
			String nomeValida = this.usService.listarPorNome(arquivo.getOriginalFilename());
			
			if(nomeValida == null) {
				
				ArquivosUS arquivoUS = new ArquivosUS();
				arquivoUS.setNomeArquivo(arquivo.getOriginalFilename());
				arquivoUS.setTipoArquivo(arquivo.getContentType());
				this.usService.salvar(arquivoUS);
				this.disco.salvarFoto(arquivo);
				arquivosBean.carregar();
				
			}else {
				
				return new ModelAndView("erroUpload2.xhtml");

			}
			
			
		}else if(characters[penultimaPosicao].equals("R")&&characters[ultimaPosicao].equals("X")&&arquivo.getOriginalFilename().contains(".pdf")) {
			
			String nomeValida = this.rxService.listarPorNome(arquivo.getOriginalFilename());

			if(nomeValida == null) {

				ArquivosRX arquivoRX = new ArquivosRX();
				arquivoRX.setNomeArquivo(arquivo.getOriginalFilename());
				arquivoRX.setTipoArquivo(arquivo.getContentType());
				this.rxService.salvar(arquivoRX);
				this.disco.salvarFoto(arquivo);
				arquivosBean.carregar();
				
			}else {
				return new ModelAndView("erroUpload2.xhtml");

			}
			
		}else if(arquivo.getOriginalFilename().contains(".png")||arquivo.getOriginalFilename().contains(".jpg")||arquivo.getOriginalFilename().contains(".jpeg")||
				arquivo.getOriginalFilename().contains(".gif")||arquivo.getOriginalFilename().contains(".svg")||arquivo.getOriginalFilename().contains(".bmp")||
				arquivo.getOriginalFilename().contains(".eps")) {
			
			String nomeValida = this.imagensService.listarPorNome(arquivo.getOriginalFilename());

			if(nomeValida == null) {

				ArquivosImagens arquivoImagem = new ArquivosImagens();
				arquivoImagem.setNomeImagem(arquivo.getOriginalFilename());
				arquivoImagem.setTipoImagem(arquivo.getContentType());
				this.imagensService.salvar(arquivoImagem);
				this.disco.salvarFoto(arquivo);
				arquivosBean.carregar();
				
			}else {
				return new ModelAndView("erroUpload2.xhtml");

			}
			}else if(characters[penultimaPosicao].equals("F")&&characters[ultimaPosicao].equals("U")&&arquivo.getOriginalFilename().contains(".pdf")) {
			String nomeValida = this.fuService.listarPorNome(arquivo.getOriginalFilename());

			if(nomeValida == null) {

			
			ArquivosFU arquivoFU = new ArquivosFU();
			arquivoFU.setNomeArquivo(arquivo.getOriginalFilename());
			arquivoFU.setTipoArquivo(arquivo.getContentType());
			this.fuService.salvar(arquivoFU);
			this.disco.salvarFoto(arquivo);
			arquivosBean.carregar();
			
			}else{
				return new ModelAndView("erroUpload2.xhtml");

			}
		}else if(characters[penultimaPosicao].equals("S")&&characters[ultimaPosicao].equals("V")&&arquivo.getOriginalFilename().contains(".pdf")) {
			
			
			String nomeValida = this.svService.listarPorNome(arquivo.getOriginalFilename());

			
			if(nomeValida == null) {

			ArquivosSV arquivoSV = new ArquivosSV();
			arquivoSV.setNomeArquivo(arquivo.getOriginalFilename());
			arquivoSV.setTipoArquivo(arquivo.getContentType());
			this.svService.salvar(arquivoSV);
			this.disco.salvarFoto(arquivo);
			arquivosBean.carregar();
			}else {
				return new ModelAndView("erroUpload2.xhtml");

			}
		}else if(characters[penultimaPosicao].equals("C")&&characters[ultimaPosicao].equals("T")&&arquivo.getOriginalFilename().contains(".pdf")) {
			String nomeValida = this.ctService.listarPorNome(arquivo.getOriginalFilename());

			if(nomeValida == null) {

			ArquivosCT arquivoCT = new ArquivosCT();
			arquivoCT.setNomeArquivo(arquivo.getOriginalFilename());
			arquivoCT.setTipoArquivo(arquivo.getContentType());
			this.ctService.salvar(arquivoCT);
			this.disco.salvarFoto(arquivo);
			arquivosBean.carregar();
			}else {
				return new ModelAndView("erroUpload2.xhtml");

			}
		}else if(arquivo.getOriginalFilename()  == "") {

			return new ModelAndView("erroUpload.xhtml");
			
		}else {
			String nomeValida = this.arquivoService.listarPorNome(arquivo.getOriginalFilename());

			System.out.println(nomeValida);
			if(nomeValida == null) {

			ArquivosGeral arquivoGeral = new ArquivosGeral();
			arquivoGeral.setNomeArquivo(arquivo.getOriginalFilename());
			arquivoGeral.setTipoArquivo(arquivo.getContentType());
			this.arquivoService.salvar(arquivoGeral);
			this.disco.salvarFoto(arquivo);
			arquivosBean.carregar();
			}else{
				
				return new ModelAndView("erroUpload2.xhtml");

			}
		}
		}catch(Exception erro) {
			return new ModelAndView("erroUpload.xhtml");

		}
	
		
		return new ModelAndView("index.html");
	}
	
	@GetMapping("/pegar")
	public void pegar() {
		System.out.println("eaiiiii");
	}
}