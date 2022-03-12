package br.com.projetoSamiavet.Samiavet.PROJETO.bean;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import br.com.projetoSamiavet.Samiavet.PROJETO.domain.ArquivosCT;
import br.com.projetoSamiavet.Samiavet.PROJETO.domain.ArquivosES;
import br.com.projetoSamiavet.Samiavet.PROJETO.domain.ArquivosFU;
import br.com.projetoSamiavet.Samiavet.PROJETO.domain.ArquivosGeral;
import br.com.projetoSamiavet.Samiavet.PROJETO.domain.ArquivosImagens;
import br.com.projetoSamiavet.Samiavet.PROJETO.domain.ArquivosRX;
import br.com.projetoSamiavet.Samiavet.PROJETO.domain.ArquivosSV;
import br.com.projetoSamiavet.Samiavet.PROJETO.domain.ArquivosUS;
import br.com.projetoSamiavet.Samiavet.PROJETO.domain.FichaClinica;
import br.com.projetoSamiavet.Samiavet.PROJETO.service.ArquivoGeralService;
import br.com.projetoSamiavet.Samiavet.PROJETO.service.ArquivosImagensService;
import br.com.projetoSamiavet.Samiavet.PROJETO.service.CTService;
import br.com.projetoSamiavet.Samiavet.PROJETO.service.ESService;
import br.com.projetoSamiavet.Samiavet.PROJETO.service.FUService;
import br.com.projetoSamiavet.Samiavet.PROJETO.service.RXService;
import br.com.projetoSamiavet.Samiavet.PROJETO.service.SVService;
import br.com.projetoSamiavet.Samiavet.PROJETO.service.USService;
import br.com.projetoSamiavet.Samiavet.PROJETO.util.JsfUtil;

@Named(value="arquivosBean")
@ViewScoped
@RestController
public class ArquivosBean {

	
	private ArquivosGeral arquivosGeral;
	
	private ArquivosES arquivosES;
	
	private ArquivosSV arquivosSV;
	
	private ArquivosUS arquivosUS;
	
	private ArquivosFU arquivosFU;
	
	private ArquivosRX arquivosRX;
	
	private ArquivosCT arquivosCT;
	
	private ArquivosImagens arquivoImagem;
	
	private StreamedContent fileArquivosGeral;
	
	private StreamedContent fileArquivosES;

	private StreamedContent fileArquivosSV;
	
	private StreamedContent fileArquivosUS;

	private StreamedContent fileArquivosFU;

	private StreamedContent fileArquivosRX;

	private StreamedContent fileArquivosCT;
	
	private StreamedContent fileArquivosImagens;

	private List<ArquivosES> listaES;
	
	private List<ArquivosSV> listaSV;
	
	private List<ArquivosUS> listaUS;
	
	private List<ArquivosFU> listaFU;
	
	private List<ArquivosRX> listaRX;
	
	private List<ArquivosCT> listaCT;
	
	private List<ArquivosGeral> listaArquivosGeral;
	
	private List<ArquivosImagens> listaArquivoImagens;
	
	
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
	private ArquivosImagensService imagensService;
	
	
	private String nomeArquivoES;
	
	private String nomeArquivoSV;

	private String nomeArquivoUS;

	private String nomeArquivoRX;

	private String nomeArquivoCT;

	private String nomeArquivoFU;
	
	private String nomeImagem;

	
	private List<ArquivosES> listaESView;
	
	private List<ArquivosSV> listaSVView;
	
	private List<ArquivosUS> listaUSView;
	
	private List<ArquivosFU> listaFUView;
	
	private List<ArquivosRX> listaRXView;
	
	private List<ArquivosCT> listaCTView;
	
	private List<ArquivosImagens> listaArquivoImagensView;

	public ArquivosBean() {
		this.arquivosGeral = new ArquivosGeral();
		this.arquivosCT = new ArquivosCT();
		this.arquivosES = new ArquivosES();
		this.arquivosFU = new ArquivosFU();
		this.arquivosRX = new ArquivosRX();
		this.arquivosUS = new ArquivosUS();
		this.arquivosSV = new ArquivosSV();
		this.arquivoImagem = new ArquivosImagens();
		
	}

	
	public ArquivosGeral getArquivosGeral() {
		return arquivosGeral;
	}


	public void setArquivosGeral(ArquivosGeral arquivosGeral) {
		this.arquivosGeral = arquivosGeral;
	}

	
	public ArquivosES getArquivosES() {
		return arquivosES;
	}


	public void setArquivosES(ArquivosES arquivosES) {
		this.arquivosES = arquivosES;
	}


	public ArquivosSV getArquivosSV() {
		return arquivosSV;
	}


	public void setArquivosSV(ArquivosSV arquivosSV) {
		this.arquivosSV = arquivosSV;
	}


	public ArquivosUS getArquivosUS() {
		return arquivosUS;
	}


	public void setArquivosUS(ArquivosUS arquivosUS) {
		this.arquivosUS = arquivosUS;
	}


	public ArquivosFU getArquivosFU() {
		return arquivosFU;
	}


	public void setArquivosFU(ArquivosFU arquivosFU) {
		this.arquivosFU = arquivosFU;
	}


	public ArquivosRX getArquivosRX() {
		return arquivosRX;
	}


	public void setArquivosRX(ArquivosRX arquivosRX) {
		this.arquivosRX = arquivosRX;
	}


	public ArquivosCT getArquivosCT() {
		return arquivosCT;
	}


	public void setArquivosCT(ArquivosCT arquivosCT) {
		this.arquivosCT = arquivosCT;
	}


	public List<ArquivosES> getListaES() {
		return listaES;
	}


	public void setListaES(List<ArquivosES> listaES) {
		this.listaES = listaES;
	}


	public List<ArquivosSV> getListaSV() {
		return listaSV;
	}


	public void setListaSV(List<ArquivosSV> listaSV) {
		this.listaSV = listaSV;
	}


	public List<ArquivosUS> getListaUS() {
		return listaUS;
	}


	public void setListaUS(List<ArquivosUS> listaUS) {
		this.listaUS = listaUS;
	}


	public List<ArquivosFU> getListaFU() {
		return listaFU;
	}


	public void setListaFU(List<ArquivosFU> listaFU) {
		this.listaFU = listaFU;
	}


	public List<ArquivosRX> getListaRX() {
		return listaRX;
	}


	public void setListaRX(List<ArquivosRX> listaRX) {
		this.listaRX = listaRX;
	}


	public List<ArquivosCT> getListaCT() {
		return listaCT;
	}


	public void setListaCT(List<ArquivosCT> listaCT) {
		this.listaCT = listaCT;
	}


	public ArquivoGeralService getArquivoService() {
		return arquivoService;
	}


	public void setArquivoService(ArquivoGeralService arquivoService) {
		this.arquivoService = arquivoService;
	}


	public ESService getEsService() {
		return esService;
	}


	public void setEsService(ESService esService) {
		this.esService = esService;
	}


	public SVService getSvService() {
		return svService;
	}


	public void setSvService(SVService svService) {
		this.svService = svService;
	}


	public USService getUsService() {
		return usService;
	}


	public void setUsService(USService usService) {
		this.usService = usService;
	}


	public FUService getFuService() {
		return fuService;
	}


	public void setFuService(FUService fuService) {
		this.fuService = fuService;
	}


	public RXService getRxService() {
		return rxService;
	}


	public void setRxService(RXService rxService) {
		this.rxService = rxService;
	}


	public CTService getCtService() {
		return ctService;
	}


	public void setCtService(CTService ctService) {
		this.ctService = ctService;
	}


	public List<ArquivosGeral> getListaArquivosGeral() {
		return listaArquivosGeral;
	}


	public void setListaArquivosGeral(List<ArquivosGeral> listaArquivosGeral) {
		this.listaArquivosGeral = listaArquivosGeral;
	}

	
	public StreamedContent getFile() {
		return fileArquivosGeral;
	}


	public void setFile(StreamedContent file) {
		this.fileArquivosGeral = file;
	}

	
	public StreamedContent getFileArquivosGeral() {
		return fileArquivosGeral;
	}


	public void setFileArquivosGeral(StreamedContent fileArquivosGeral) {
		this.fileArquivosGeral = fileArquivosGeral;
	}


	public StreamedContent getFileArquivosES() {
		return fileArquivosES;
	}


	public void setFileArquivosES(StreamedContent fileArquivosES) {
		this.fileArquivosES = fileArquivosES;
	}


	public StreamedContent getFileArquivosSV() {
		return fileArquivosSV;
	}


	public void setFileArquivosSV(StreamedContent fileArquivosSV) {
		this.fileArquivosSV = fileArquivosSV;
	}


	public StreamedContent getFileArquivosUS() {
		return fileArquivosUS;
	}


	public void setFileArquivosUS(StreamedContent fileArquivosUS) {
		this.fileArquivosUS = fileArquivosUS;
	}


	public StreamedContent getFileArquivosFU() {
		return fileArquivosFU;
	}


	public void setFileArquivosFU(StreamedContent fileArquivosFU) {
		this.fileArquivosFU = fileArquivosFU;
	}


	public StreamedContent getFileArquivosRX() {
		return fileArquivosRX;
	}


	public void setFileArquivosRX(StreamedContent fileArquivosRX) {
		this.fileArquivosRX = fileArquivosRX;
	}


	public StreamedContent getFileArquivosCT() {
		return fileArquivosCT;
	}


	public void setFileArquivosCT(StreamedContent fileArquivosCT) {
		this.fileArquivosCT = fileArquivosCT;
	}

	
	
	public ArquivosImagens getArquivoImagem() {
		return arquivoImagem;
	}


	public void setArquivoImagem(ArquivosImagens arquivoImagem) {
		this.arquivoImagem = arquivoImagem;
	}


	public StreamedContent getFileArquivosImagens() {
		return fileArquivosImagens;
	}


	public void setFileArquivosImagens(StreamedContent fileArquivosImagens) {
		this.fileArquivosImagens = fileArquivosImagens;
	}


	public List<ArquivosImagens> getListaArquivoImagens() {
		return listaArquivoImagens;
	}


	public void setListaArquivoImagens(List<ArquivosImagens> listaArquivoImagens) {
		this.listaArquivoImagens = listaArquivoImagens;
	}


	public ArquivosImagensService getImagensService() {
		return imagensService;
	}


	public void setImagensService(ArquivosImagensService imagensService) {
		this.imagensService = imagensService;
	}

	

	public String getNomeArquivoES() {
		return nomeArquivoES;
	}


	public void setNomeArquivoES(String nomeArquivoES) {
		this.nomeArquivoES = nomeArquivoES;
	}


	public String getNomeArquivoSV() {
		return nomeArquivoSV;
	}


	public void setNomeArquivoSV(String nomeArquivoSV) {
		this.nomeArquivoSV = nomeArquivoSV;
	}


	public String getNomeArquivoUS() {
		return nomeArquivoUS;
	}


	public void setNomeArquivoUS(String nomeArquivoUS) {
		this.nomeArquivoUS = nomeArquivoUS;
	}


	public String getNomeArquivoRX() {
		return nomeArquivoRX;
	}


	public void setNomeArquivoRX(String nomeArquivoRX) {
		this.nomeArquivoRX = nomeArquivoRX;
	}


	public String getNomeArquivoCT() {
		return nomeArquivoCT;
	}


	public void setNomeArquivoCT(String nomeArquivoCT) {
		this.nomeArquivoCT = nomeArquivoCT;
	}


	public String getNomeArquivoFU() {
		return nomeArquivoFU;
	}


	public void setNomeArquivoFU(String nomeArquivoFU) {
		this.nomeArquivoFU = nomeArquivoFU;
	}


	public String getNomeImagem() {
		return nomeImagem;
	}


	public void setNomeImagem(String nomeImagem) {
		this.nomeImagem = nomeImagem;
	}


	
	public List<ArquivosES> getListaESView() {
		return listaESView;
	}


	public void setListaESView(List<ArquivosES> listaESView) {
		this.listaESView = listaESView;
	}


	public List<ArquivosSV> getListaSVView() {
		return listaSVView;
	}


	public void setListaSVView(List<ArquivosSV> listaSVView) {
		this.listaSVView = listaSVView;
	}


	public List<ArquivosUS> getListaUSView() {
		return listaUSView;
	}


	public void setListaUSView(List<ArquivosUS> listaUSView) {
		this.listaUSView = listaUSView;
	}


	public List<ArquivosFU> getListaFUView() {
		return listaFUView;
	}


	public void setListaFUView(List<ArquivosFU> listaFUView) {
		this.listaFUView = listaFUView;
	}


	public List<ArquivosRX> getListaRXView() {
		return listaRXView;
	}


	public void setListaRXView(List<ArquivosRX> listaRXView) {
		this.listaRXView = listaRXView;
	}


	public List<ArquivosCT> getListaCTView() {
		return listaCTView;
	}


	public void setListaCTView(List<ArquivosCT> listaCTView) {
		this.listaCTView = listaCTView;
	}


	public List<ArquivosImagens> getListaArquivoImagensView() {
		return listaArquivoImagensView;
	}


	public void setListaArquivoImagensView(List<ArquivosImagens> listaArquivoImagensView) {
		this.listaArquivoImagensView = listaArquivoImagensView;
	}


	@PostConstruct
	public void carregar() {
	
		this.listaCT = new ArrayList<ArquivosCT>(this.ctService.listar());
		this.listaES = new ArrayList<ArquivosES>(this.esService.listar());
		this.listaFU = new ArrayList<ArquivosFU>(this.fuService.listar());
		this.listaRX = new ArrayList<ArquivosRX>(this.rxService.listar());
		this.listaSV = new ArrayList<ArquivosSV>(this.svService.listar());
		this.listaUS = new ArrayList<ArquivosUS>(this.usService.listar());
		this.listaArquivosGeral = new ArrayList<ArquivosGeral>(this.arquivoService.listar());
		this.listaArquivoImagens = new ArrayList<ArquivosImagens>(this.imagensService.listar());
		
		
	
		this.listaCTView = new ArrayList<ArquivosCT>(this.ctService.listar());
		this.listaESView = new ArrayList<ArquivosES>(this.esService.listar());
		this.listaFUView = new ArrayList<ArquivosFU>(this.fuService.listar());
		this.listaRXView = new ArrayList<ArquivosRX>(this.rxService.listar());
		this.listaSVView = new ArrayList<ArquivosSV>(this.svService.listar());
		this.listaUSView = new ArrayList<ArquivosUS>(this.usService.listar());
		this.listaArquivoImagensView = new ArrayList<ArquivosImagens>(this.imagensService.listar());

		
	}

	public void downloadArquivos() {
		

		 this.fileArquivosGeral = DefaultStreamedContent.builder()
	                .name(this.arquivosGeral.getNomeArquivo())
	                .contentType(this.arquivosGeral.getTipoArquivo())
	                .stream(() -> FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/resources/arquivos/" + this.arquivosGeral.getNomeArquivo()))
	                .build();
		
		 this.fileArquivosES = DefaultStreamedContent.builder()
	                .name(this.arquivosES.getNomeArquivo())
	                .contentType(this.arquivosES.getTipoArquivo())
	                .stream(() -> FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/resources/arquivos/" + this.arquivosES.getNomeArquivo()))
	                .build();
		 
		 
			
		 this.fileArquivosSV = DefaultStreamedContent.builder()
	                .name(this.arquivosSV.getNomeArquivo())
	                .contentType(this.arquivosSV.getTipoArquivo())
	                .stream(() -> FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/resources/arquivos/" + this.arquivosSV.getNomeArquivo()))
	                .build();
		 
		 this.fileArquivosUS = DefaultStreamedContent.builder()
	                .name(this.arquivosUS.getNomeArquivo())
	                .contentType(this.arquivosUS.getTipoArquivo())
	                .stream(() -> FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/resources/arquivos/" + this.arquivosUS.getNomeArquivo()))
	                .build();
		 
		 
		 this.fileArquivosFU = DefaultStreamedContent.builder()
	                .name(this.arquivosFU.getNomeArquivo())
	                .contentType(this.arquivosFU.getTipoArquivo())
	                .stream(() -> FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/resources/arquivos/" + this.arquivosFU.getNomeArquivo()))
	                .build();
		 
		 this.fileArquivosRX = DefaultStreamedContent.builder()
	                .name(this.arquivosRX.getNomeArquivo())
	                .contentType(this.arquivosRX.getTipoArquivo())
	                .stream(() -> FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/resources/arquivos/" + this.arquivosRX.getNomeArquivo()))
	                .build();
		 
		 this.fileArquivosCT = DefaultStreamedContent.builder()
	                .name(this.arquivosCT.getNomeArquivo())
	                .contentType(this.arquivosCT.getTipoArquivo())
	                .stream(() -> FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/resources/arquivos/" + this.arquivosCT.getNomeArquivo()))
	                .build();
		 
		 this.fileArquivosImagens = DefaultStreamedContent.builder()
	                .name(this.arquivoImagem.getNomeImagem())
	                .contentType(this.arquivosCT.getTipoArquivo())
	                .stream(() -> FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/resources/arquivos/" + this.arquivoImagem.getNomeImagem()))
	                .build();
	}
	
	
	public void excluirArquivoES() {
			
			try {
				this.esService.deletar(this.arquivosES.getId());
				carregar();
				JsfUtil.adicionarMensagemDeSucesso("Arquivo excluído com sucesso. ", null);
	
			}catch(Exception erro) {
				JsfUtil.adicionarMensagemDeErro("Ocorreu um erro inesperado.", null);
	
			}
			
		}
	
	public void excluirArquivoCT() {
		
		try {
			this.ctService.deletar(this.arquivosCT.getId());
			carregar();
			JsfUtil.adicionarMensagemDeSucesso("Arquivo excluído com sucesso. ", null);
	
		}catch(Exception erro) {
			JsfUtil.adicionarMensagemDeErro("Ocorreu um erro inesperado.", null);
	
		}
		
		
		
	}
	public void excluirArquivoSV() {
		
		try {
			this.svService.deletar(this.arquivosSV.getId());
			carregar();
			JsfUtil.adicionarMensagemDeSucesso("Arquivo excluído com sucesso. ", null);
	
		}catch(Exception erro) {
			JsfUtil.adicionarMensagemDeErro("Ocorreu um erro inesperado.", null);
	
		}
		
		
		
	}
	public void excluirArquivoFU() {
		
		try {
			this.fuService.deletar(this.arquivosFU.getId());
			carregar();
			JsfUtil.adicionarMensagemDeSucesso("Arquivo excluído com sucesso. ", null);
	
		}catch(Exception erro) {
			JsfUtil.adicionarMensagemDeErro("Ocorreu um erro inesperado.", null);
	
		}
		
		
		
	}
	public void excluirArquivoUS() {
		
		try {
			this.usService.deletar(this.arquivosUS.getId());
			carregar();
			JsfUtil.adicionarMensagemDeSucesso("Arquivo excluído com sucesso. ", null);
	
		}catch(Exception erro) {
			JsfUtil.adicionarMensagemDeErro("Ocorreu um erro inesperado.", null);
	
		}
		
		
		
	}
	public void excluirArquivoRX() {
		
		try {
			this.rxService.deletar(this.arquivosRX.getId());
			carregar();
			JsfUtil.adicionarMensagemDeSucesso("Arquivo excluído com sucesso. ", null);
	
		}catch(Exception erro) {
			JsfUtil.adicionarMensagemDeErro("Ocorreu um erro inesperado.", null);
	
		}
		
		
		
	}
	public void excluirArquivosGeral() {
		
		try {
			this.arquivoService.deletar(this.arquivosGeral.getId());
			carregar();
			JsfUtil.adicionarMensagemDeSucesso("Arquivo excluído com sucesso. ", null);
	
		}catch(Exception erro) {
			JsfUtil.adicionarMensagemDeErro("Ocorreu um erro inesperado.", null);
	
		}
		
		
		
	}
	
	public void excluirImagens() {
		
		try {
			this.imagensService.deletar(this.arquivoImagem.getId());
			carregar();
			JsfUtil.adicionarMensagemDeSucesso("Arquivo excluído com sucesso. ", null);
	
		}catch(Exception erro) {
			JsfUtil.adicionarMensagemDeErro("Ocorreu um erro inesperado.", null);
	
		}
		
		
		
	}

	
	public List<String> listaNomesArquivosES(String query) {
	    String queryLowerCase = query.toLowerCase();
	    List<String> listaNomes = new ArrayList<>();
	    List<ArquivosES> nomes = this.esService.listar();
	    for (ArquivosES nomesArquivos : nomes) {
	    	listaNomes.add(nomesArquivos.getNomeArquivo());
	    }
	
	    return listaNomes.stream().filter(t -> t.toLowerCase().startsWith(queryLowerCase)).collect(Collectors.toList());
	}
	public List<String> listaNomesArquivosSV(String query) {
	    String queryLowerCase = query.toLowerCase();
	    List<String> listaNomes = new ArrayList<>();
	    List<ArquivosSV> nomes = this.svService.listar();
	    for (ArquivosSV nomesArquivos : nomes) {
	    	listaNomes.add(nomesArquivos.getNomeArquivo());
	    }
	
	    return listaNomes.stream().filter(t -> t.toLowerCase().startsWith(queryLowerCase)).collect(Collectors.toList());
	}
	
	public List<String> listaNomesArquivosUS(String query) {
	    String queryLowerCase = query.toLowerCase();
	    List<String> listaNomes = new ArrayList<>();
	    List<ArquivosUS> nomes = this.usService.listar();
	    for (ArquivosUS nomesArquivos : nomes) {
	    	listaNomes.add(nomesArquivos.getNomeArquivo());
	    }
	
	    return listaNomes.stream().filter(t -> t.toLowerCase().startsWith(queryLowerCase)).collect(Collectors.toList());
	}
	
	
	public List<String> listaNomesArquivosRX(String query) {
	    String queryLowerCase = query.toLowerCase();
	    List<String> listaNomes = new ArrayList<>();
	    List<ArquivosRX> nomes = this.rxService.listar();
	    for (ArquivosRX nomesArquivos : nomes) {
	    	listaNomes.add(nomesArquivos.getNomeArquivo());
	    }
	
	    return listaNomes.stream().filter(t -> t.toLowerCase().startsWith(queryLowerCase)).collect(Collectors.toList());
	}
	
	public List<String> listaNomesArquivosCT(String query) {
	    String queryLowerCase = query.toLowerCase();
	    List<String> listaNomes = new ArrayList<>();
	    List<ArquivosCT> nomes = this.ctService.listar();
	    for (ArquivosCT nomesArquivos : nomes) {
	    	listaNomes.add(nomesArquivos.getNomeArquivo());
	    }
	
	    return listaNomes.stream().filter(t -> t.toLowerCase().startsWith(queryLowerCase)).collect(Collectors.toList());
	}
	
	public List<String> listaNomesArquivosFU(String query) {
	    String queryLowerCase = query.toLowerCase();
	    List<String> listaNomes = new ArrayList<>();
	    List<ArquivosFU> nomes = this.fuService.listar();
	    for (ArquivosFU nomesArquivos : nomes) {
	    	listaNomes.add(nomesArquivos.getNomeArquivo());
	    }
	
	    return listaNomes.stream().filter(t -> t.toLowerCase().startsWith(queryLowerCase)).collect(Collectors.toList());
	}
	
	public List<String> listaNomesArquivosGeral(String query) {
	    String queryLowerCase = query.toLowerCase();
	    List<String> listaNomes = new ArrayList<>();
	    List<ArquivosGeral> nomes = this.arquivoService.listar();
	    for (ArquivosGeral nomesArquivos : nomes) {
	    	listaNomes.add(nomesArquivos.getNomeArquivo());
	    }
	
	    return listaNomes.stream().filter(t -> t.toLowerCase().startsWith(queryLowerCase)).collect(Collectors.toList());
	}
	
	public List<String> listaNomesImagens(String query) {
	    String queryLowerCase = query.toLowerCase();
	    List<String> listaNomes = new ArrayList<>();
	    List<ArquivosImagens> nomes = this.imagensService.listar();
	    for (ArquivosImagens nomesArquivos : nomes) {
	    	listaNomes.add(nomesArquivos.getNomeImagem());
	    }
	
	    return listaNomes.stream().filter(t -> t.toLowerCase().startsWith(queryLowerCase)).collect(Collectors.toList());
	}
	
	
	
	public void pesquisarES() {
		
		this.listaESView = new ArrayList<ArquivosES>(esService.buscarPorNome(nomeArquivoES));
		JsfUtil.adicionarMensagemDeSucesso("Resultados encontrados para: " + this.nomeArquivoES, null);
	}
	
	public void pesquisarSV() {
		
		this.listaSVView = new ArrayList<ArquivosSV>(svService.buscarPorNome(nomeArquivoSV));
		JsfUtil.adicionarMensagemDeSucesso("Resultados encontrados para: " + this.nomeArquivoSV, null);
	}
	
	public void pesquisarCT() {
		
		this.listaCTView = new ArrayList<ArquivosCT>(ctService.buscarPorNome(nomeArquivoCT));
		JsfUtil.adicionarMensagemDeSucesso("Resultados encontrados para: " + this.nomeArquivoCT, null);
	}
	
	public void pesquisarFU() {
		
		this.listaFUView = new ArrayList<ArquivosFU>(fuService.buscarPorNome(nomeArquivoFU));
		JsfUtil.adicionarMensagemDeSucesso("Resultados encontrados para: " + this.nomeArquivoFU, null);
	}
	
	public void pesquisarRX() {
		
		this.listaRXView = new ArrayList<ArquivosRX>(rxService.buscarPorNome(nomeArquivoRX));
		JsfUtil.adicionarMensagemDeSucesso("Resultados encontrados para: " + this.nomeArquivoRX, null);
	}
	
	public void pesquisarUS() {
		
		this.listaUSView = new ArrayList<ArquivosUS>(usService.buscarPorNome(nomeArquivoUS));
		JsfUtil.adicionarMensagemDeSucesso("Resultados encontrados para: " + this.nomeArquivoUS, null);
	}
	

	public void pesquisarImagens() {
		
		this.listaArquivoImagensView = new ArrayList<ArquivosImagens>(this.imagensService.buscarPorNome(nomeImagem));
		JsfUtil.adicionarMensagemDeSucesso("Resultados encontrados para: " + this.nomeImagem, null);
	}
	
	public void resetarArquivosES() {
		this.listaESView = new ArrayList<ArquivosES>(esService.listar());

	}
	
	public void resetarArquivosSV() {
		this.listaSVView = new ArrayList<ArquivosSV>(svService.listar());

	}
	
	public void resetarArquivosFU() {
		this.listaFUView = new ArrayList<ArquivosFU>(fuService.listar());

	}
	public void resetarArquivosRX() {
		this.listaRXView = new ArrayList<ArquivosRX>(rxService.listar());

	}
	
	public void resetarArquivosUS() {
		this.listaUSView = new ArrayList<ArquivosUS>(usService.listar());

	}
	public void resetarArquivosCT() {
		this.listaCTView = new ArrayList<ArquivosCT>(ctService.listar());

	}
	
	public void resetarArquivosImagens() {
		this.listaArquivoImagensView = new ArrayList<ArquivosImagens>(imagensService.listar());

	}
}
