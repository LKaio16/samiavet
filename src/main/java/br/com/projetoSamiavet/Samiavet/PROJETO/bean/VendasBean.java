package br.com.projetoSamiavet.Samiavet.PROJETO.bean;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.MultiPartEmail;
import org.primefaces.component.export.ExcelOptions;
import org.primefaces.component.export.PDFOptions;
import org.primefaces.component.export.PDFOrientationType;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.springframework.beans.factory.annotation.Autowired;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import br.com.projetoSamiavet.Samiavet.PROJETO.domain.Produtos;
import br.com.projetoSamiavet.Samiavet.PROJETO.domain.ProdutosSelecionados;
import br.com.projetoSamiavet.Samiavet.PROJETO.domain.Vendas;
import br.com.projetoSamiavet.Samiavet.PROJETO.service.ProdutosSelecionadosService;
import br.com.projetoSamiavet.Samiavet.PROJETO.service.ProdutosService;
import br.com.projetoSamiavet.Samiavet.PROJETO.service.VendasService;
import br.com.projetoSamiavet.Samiavet.PROJETO.util.JsfUtil;
@Named(value="MBVendas")
@ViewScoped
public class VendasBean {

	private Vendas vendas;
	private List<Vendas> itens;
	private List<ProdutosSelecionados> listaProdutosSelecionados;
	private String codigoBarrasConsulta;
	private String quantidadeEstoque;
	
	private Double totalVendas;
	
    private StreamedContent file;
 
	private String conversaoCodigoBarras;
	
	private String total;
	private ProdutosSelecionados produtosSelecionados;
	@Autowired
	private VendasService vendasService;
	
	@Autowired
	private ProdutosService produtosService;
	
	@Autowired
	private ProdutosSelecionadosService produtosSelecionadosService;
	
	@Autowired
	private ProdutosBean produtos;
	
	private Long nomeComprovante;
	
	private Boolean renderedMedia;
	
   private ExcelOptions excelOpt;

    private PDFOptions pdfOpt;

	private String email;
	public VendasBean() {
		this.vendas = new Vendas();
		this.produtosSelecionados = new ProdutosSelecionados();
		this.total = "00.00 R$";
		this.renderedMedia = false;
		 
		 
		 
	}

	
	

	public ExcelOptions getExcelOpt() {
		return excelOpt;
	}




	public void setExcelOpt(ExcelOptions excelOpt) {
		this.excelOpt = excelOpt;
	}




	public PDFOptions getPdfOpt() {
		return pdfOpt;
	}




	public void setPdfOpt(PDFOptions pdfOpt) {
		this.pdfOpt = pdfOpt;
	}




	public Double getTotalVendas() {
		return totalVendas;
	}




	public void setTotalVendas(Double totalVendas) {
		this.totalVendas = totalVendas;
	}




	public Vendas getVendas() {
		return vendas;
	}

	public String getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	
	public StreamedContent getFile() {
		return file;
	}


	public void setFile(StreamedContent file) {
		this.file = file;
	}


	public void setQuantidadeEstoque(String quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}


	public String getTotal() {
		return total;
	}


	public void setTotal(String total) {
		this.total = total;
	}


	public String getConversaoCodigoBarras() {
		return conversaoCodigoBarras;
	}


	public void setConversaoCodigoBarras(String conversaoCodigoBarras) {
		this.conversaoCodigoBarras = conversaoCodigoBarras;
	}


	public List<Vendas> getItens() {
		return itens;
	}


	public void setItens(List<Vendas> itens) {
		this.itens = itens;
	}


	public List<ProdutosSelecionados> getListaProdutosSelecionados() {
		return listaProdutosSelecionados;
	}


	public void setListaProdutosSelecionados(List<ProdutosSelecionados> listaProdutosSelecionados) {
		this.listaProdutosSelecionados = listaProdutosSelecionados;
	}


	public String getCodigoBarrasConsulta() {
		return codigoBarrasConsulta;
	}


	public void setCodigoBarrasConsulta(String codigoBarrasConsulta) {
		this.codigoBarrasConsulta = codigoBarrasConsulta;
	}


	public ProdutosSelecionados getProdutosSelecionados() {
		return produtosSelecionados;
	}


	public void setProdutosSelecionados(ProdutosSelecionados produtosSelecionados) {
		this.produtosSelecionados = produtosSelecionados;
	}


	public VendasService getVendasService() {
		return vendasService;
	}


	public void setVendasService(VendasService vendasService) {
		this.vendasService = vendasService;
	}


	public ProdutosService getProdutosService() {
		return produtosService;
	}


	public void setProdutosService(ProdutosService produtosService) {
		this.produtosService = produtosService;
	}


	public ProdutosSelecionadosService getProdutosSelecionadosService() {
		return produtosSelecionadosService;
	}


	public void setProdutosSelecionadosService(ProdutosSelecionadosService produtosSelecionadosService) {
		this.produtosSelecionadosService = produtosSelecionadosService;
	}


	public void setVendas(Vendas vendas) {
		this.vendas = vendas;
	}

	public void listarProdutosEscolhidos() {
		this.listaProdutosSelecionados = new ArrayList<ProdutosSelecionados>(this.produtosSelecionadosService.listar());
		
	}
	
	public void converter() {
		this.conversaoCodigoBarras = String.valueOf(this.produtosSelecionados.getCodigoBarras());

	}
	
	
	
	
	public Long getNomeComprovante() {
		return nomeComprovante;
	}


	public void setNomeComprovante(Long nomeComprovante) {
		this.nomeComprovante = nomeComprovante;
	}


	


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
	@PostConstruct
	public void carregar() {
		this.itens = new ArrayList<Vendas>(this.vendasService.listar());
		
		this.totalVendas = 0.0;
		
		
		
		for(int cont =0; cont <  this.vendasService.listar().size(); cont++ ) {
			 this.totalVendas += this.vendasService.listar().get(cont).getValor();
			 
		}
		
		customizationOptions();
	}
	
	
	 public void customizationOptions() {
	        excelOpt = new ExcelOptions();
	        excelOpt.setFacetFontSize("10");
	        excelOpt.setFacetFontStyle("BOLD");
	        excelOpt.setCellFontSize("8");
	        excelOpt.setFontName("Verdana");

	        pdfOpt = new PDFOptions();
	        
	        pdfOpt.setFacetFontStyle("BOLD");
	        pdfOpt.setCellFontSize("12");
	        pdfOpt.setFontName("Courier");
	        pdfOpt.setOrientation(PDFOrientationType.LANDSCAPE);
	    }
	
	public void listarProdutosSelecionados() {
		
		if(this.codigoBarrasConsulta.isEmpty()) {
			JsfUtil.adicionarMensagemDeErro("INSIRA UM CÓDIGO DE BARRAS", null);
		}else {
			List<Produtos> listarProdutos = this.produtosService.listarProdutosPorId(codigoBarrasConsulta);
			Double soma = 0.0;

			for(int cont = 0; cont < listarProdutos.size() ; cont++) {
				ProdutosSelecionados produtosSelecionados = new ProdutosSelecionados();
				
				produtosSelecionados.setCodigo_barras(listarProdutos.get(cont).getCodigoBarras());
				produtosSelecionados.setNome(listarProdutos.get(cont).getNome());
				produtosSelecionados.setPreco_compra(listarProdutos.get(cont).getPreco_compra());
				produtosSelecionados.setPreco_venda(listarProdutos.get(cont).getPreco_venda());
				produtosSelecionados.setDistribuidora(listarProdutos.get(cont).getDistribuidora());
				produtosSelecionados.setEmpresa(listarProdutos.get(cont).getEmpresa());
				produtosSelecionados.setData_registro(listarProdutos.get(cont).getData_registro());
				produtosSelecionados.setData_validade(listarProdutos.get(cont).getData_validade());
				produtosSelecionados.setQuantidade_estoque(listarProdutos.get(cont).getQuantidade_estoque());
				produtosSelecionados.setQuantidade_estoque_subtracao(0);
				
				this.produtosSelecionadosService.salvar(produtosSelecionados);
			
			}
			

			
			this.listaProdutosSelecionados = new ArrayList<ProdutosSelecionados>(this.produtosSelecionadosService.listar());
			
			
			System.out.println(soma);
			String converter = String.valueOf(soma);
			
			
			JsfUtil.adicionarMensagemDeSucesso("PRODUTO ADICIONADO", null);
			setCodigoBarrasConsulta(null);
		}
		
	}
	
	public void excluir() {
		String cod = this.produtosSelecionados.getCodigoBarras();
		this.produtosSelecionadosService.excluir(cod);
		JsfUtil.adicionarMensagemDeSucesso("PRODUTO RETIRADO", null);
		listarProdutosEscolhidos();
		this.produtosSelecionados = new ProdutosSelecionados();
		
		Double soma = 0.0;

		

		for(int cont = 0; cont < this.listaProdutosSelecionados.size() ; cont++) {

			
			soma += this.listaProdutosSelecionados.get(cont).getPreco_venda();
		}
		
		System.out.println(soma);
		String converter = String.valueOf(soma);
		this.total = converter + " R$";
	}
	
	public void salvar() {
		
		List<ProdutosSelecionados> listarProdutos = this.produtosSelecionadosService.listar();
		List<Produtos> listaProdutosVendas = new ArrayList<Produtos>();
		Double soma = 0.0;
		Integer validaEstoque = null;
		List<ProdutosSelecionados> listarProdutos2 = new ArrayList<ProdutosSelecionados>();;

		for(int cont = 0; cont < this.listaProdutosSelecionados.size() ; cont++) {
			
			
			
			this.produtosSelecionadosService.getProdutosSelecionadosRepository().saveAll( this.listaProdutosSelecionados);
			
			
			if(listaProdutosSelecionados.get(cont).getQuantidade_estoque() < listaProdutosSelecionados.get(cont).getQuantidade_estoque_subtracao()) {
				validaEstoque = 1;
				JsfUtil.adicionarMensagemDeErro("ESTOQUE INSUFICIENTE", "O Produto: " + listaProdutosSelecionados.get(cont).getNome() + " não possui estoque suficiente para realizar a venda" );

				System.out.println("ENTROU");
			}else if(listaProdutosSelecionados.get(cont).getQuantidade_estoque() >= listaProdutosSelecionados.get(cont).getQuantidade_estoque_subtracao() && listaProdutosSelecionados.get(cont).getQuantidade_estoque_subtracao() != 0){
				listarProdutos2.add(listaProdutosSelecionados.get(cont));
				
			}else if(listaProdutosSelecionados.get(cont).getQuantidade_estoque_subtracao() == 0) {
				validaEstoque = 2;
			}
			


			
		}
	
		
	if(listarProdutos2.size() == this.listaProdutosSelecionados.size() ) {
		validaEstoque = 0;

		for(int cont = 0; cont < this.listaProdutosSelecionados.size() ; cont++) {

		Produtos produtos = new Produtos();
		produtos.setCodigoBarras(this.listaProdutosSelecionados.get(cont).getCodigoBarras());
        produtos.setNome(this.listaProdutosSelecionados.get(cont).getNome());
        produtos.setPreco_compra(this.listaProdutosSelecionados.get(cont).getPreco_compra());
        produtos.setPreco_venda(this.listaProdutosSelecionados.get(cont).getPreco_venda());
        produtos.setDistribuidora(this.listaProdutosSelecionados.get(cont).getDistribuidora());
        produtos.setEmpresa(this.listaProdutosSelecionados.get(cont).getEmpresa());
        produtos.setData_registro(this.listaProdutosSelecionados.get(cont).getData_registro());
        produtos.setData_validade(this.listaProdutosSelecionados.get(cont).getData_validade());
        produtos.setQuantidade_estoque(this.listaProdutosSelecionados.get(cont).getQuantidade_estoque() - this.listaProdutosSelecionados.get(cont).getQuantidade_estoque_subtracao() );

        System.out.println("APROVADO");

        this.produtosService.salvar(produtos);


        listaProdutosVendas.add(produtos);
		}

	}
		
		
	
	try {

	if(validaEstoque == 0) {
		for(int cont = 0; cont < this.listaProdutosSelecionados.size() ; cont++) {
			String Quantidade_estoque_subtracao = String.valueOf(this.listaProdutosSelecionados.get(cont).getQuantidade_estoque_subtracao());
			Double conversaoQuantidadesDouble = Double.valueOf(Quantidade_estoque_subtracao);
			
			soma += this.listaProdutosSelecionados.get(cont).getPreco_venda() *  conversaoQuantidadesDouble;
		}
		if(this.vendas.getTaxa() != 0 ) {
			Double calcularTaxa = (this.vendas.getTaxa() / 100)  * soma;
			Double calcularSomaAtualizada = soma - calcularTaxa;
			String converter = String.valueOf(calcularTaxa);
			
			this.total = converter + " R$";
			this.vendas.setValor(calcularSomaAtualizada);
			System.out.println(calcularSomaAtualizada);


		}else {
			String converter = String.valueOf(soma);
			this.total = converter + " R$";

			this.vendas.setValor(soma);
			System.out.println(soma);


			
		}

		this.vendas.setProdutos(listaProdutosVendas);
		this.vendas.setData_venda(String.valueOf(LocalDate.now()));
		this.vendasService.cadastrar(this.vendas);

		setTotal("0.0 R$");
		Document document = new Document();

		 try {
	            PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\User\\Downloads\\Apache-tomcat\\webapps\\br.com.projetoSamiavet-0.0.1-SNAPSHOT\\resources\\comprovantes\\" + this.vendas.getId_venda() + ".pdf"));
	            
	            document.open();
	            document.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------"));
	            String filename = "C:\\Users\\User\\Downloads\\Apache-tomcat\\webapps\\br.com.projetoSamiavet-0.0.1-SNAPSHOT\\resources\\imagens\\samiavet-copia.png";
	            Font fonteTexto = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12,Font.NORMAL);

	            Font fonteNegrito = FontFactory.getFont(FontFactory.COURIER, 17,Font.BOLD );
	            Font fonteNegrito2 = FontFactory.getFont(FontFactory.COURIER, 15,Font.BOLD );


	            Image image;
				try {
					image = Image.getInstance(filename);
		            document.add(image);
		            document.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------"));
		            document.add(new Paragraph("N°: " + this.vendas.getId_venda(), fonteNegrito2 ));
		            document.add(new Paragraph("PAGAMENTO: " + this.vendas.getForma_pagamento() + "                   "  + "VALOR: " + this.vendas.getValor() + "R$",fonteNegrito2));
		            document.add(new Paragraph("N° PARCELAS: " + this.vendas.getParcelas(), fonteNegrito2 ));
		            document.add(new Paragraph("DATA: " + LocalDate.now().getDayOfMonth() + "/" + LocalDate.now().getMonthValue() + "/" + LocalDate.now().getYear() 
		            		+ "        " + "HORA: "  + LocalDateTime.now().getHour() + ":" + LocalDateTime.now().getMinute()
		            		,fonteNegrito2));
		            
		            document.add(new Paragraph("CLIENTE: " + this.vendas.getNome_cliente() ,fonteNegrito2));
		            document.add(new Paragraph("CPF: " + this.vendas.getCpf() ,fonteNegrito2));
		            document.add(new Paragraph("-"));
		            document.add(new Paragraph("-"));
		            document.add(new Paragraph("-"));
		            document.add(new Paragraph("-"));
		            document.add(new Paragraph("-"));


		            for(int cont = 0; cont < this.listaProdutosSelecionados.size()  ; cont++) {
				          document.add(new Paragraph( this.vendas.getProdutos().get(cont).getNome() +  "  -----------------------------  QTD: " + this.listaProdutosSelecionados.get(cont).getQuantidade_estoque_subtracao() ,fonteNegrito2));
		            }
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        } catch (DocumentException ex) {
	            System.out.println("Error:"+ex);
	        } catch (FileNotFoundException ex) {
	            System.out.println("Error:"+ex);
	        }finally{
	            document.close();
	        }
		this.nomeComprovante = this.vendas.getId_venda();
		this.vendas = new Vendas();
		produtos.carregar();
		JsfUtil.adicionarMensagemDeSucesso("VENDA REGISTRADA COM SUCESSO", null);
		this.produtosSelecionadosService.getProdutosSelecionadosRepository().deleteAll();
		listarProdutosEscolhidos();
		carregar();
		}else if(validaEstoque == 1){

		}else if(validaEstoque == 2){
			JsfUtil.adicionarMensagemDeErro("A QUANTIDADE DE PRODUTOS NÃO PODE SER ZERADA", null);

		}
	}catch(Exception erro) {
			erro.printStackTrace();
		}
		
		
		
	} 
	
	
	public void cancelar() {
		
		this.vendas = new Vendas();
		this.produtosSelecionadosService.getProdutosSelecionadosRepository().deleteAll();
		listarProdutosEscolhidos();
		setTotal("0.0 R$");
		JsfUtil.adicionarMensagemDeAtencao("VENDA CANCELADA", null);

	}
	
	public void resetarTotal() {
		Double soma = 0.0;
		

		for(int cont = 0; cont < this.listaProdutosSelecionados.size() ; cont++) {
			String Quantidade_estoque_subtracao = String.valueOf(this.listaProdutosSelecionados.get(cont).getQuantidade_estoque_subtracao());
			Double conversaoQuantidadesDouble = Double.valueOf(Quantidade_estoque_subtracao);
			
			soma += this.listaProdutosSelecionados.get(cont).getPreco_venda() *  conversaoQuantidadesDouble;
			
			
		}
		if(this.vendas.getTaxa() != 0 ) {
			Double calcularTaxa = (this.vendas.getTaxa() / 100)  * soma;
			Double calcularSomaAtualizada = soma - calcularTaxa;
			String converter = String.valueOf(calcularSomaAtualizada);
			
			this.total = converter + " R$";
			this.vendas.setValor(calcularSomaAtualizada);


		}else {
			String converter = String.valueOf(soma);
			this.total = converter + " R$";

			this.vendas.setValor(soma);


			
		}
		
		
	}
	
	public List<String> completarCodigoBarras(String query) {
        String queryLowerCase = query.toLowerCase();
        List<String> countryList = new ArrayList<>();
        List<Produtos> produtos = this.produtosService.listarProdutos();
        for (Produtos produto : produtos) {
            countryList.add(produto.getCodigoBarras());
        }

        return countryList.stream().filter(t -> t.toLowerCase().startsWith(queryLowerCase)).collect(Collectors.toList());
    
	}
	
	public void enviarEmail() {
		String meuEmail = "tirsopottim04@gmail.com";
		String minhaSenha = "191991tirso";
		
		MultiPartEmail email = new MultiPartEmail();
		email.setHostName("smtp.gmail.com");
		//email.setSmtpPort(587);
		email.setAuthenticator(new DefaultAuthenticator(meuEmail,minhaSenha));
		email.setSSLOnConnect(true);
		
		
		
		try {
			
			
			email.setFrom(meuEmail);
			email.setSubject("_COMPROVANTE_SAMIAVET");
			email.setMsg("Comprovante de compra realizada. DATA: " + LocalDate.now().getDayOfMonth() + "/" + LocalDate.now().getMonthValue() + "/" + LocalDate.now().getYear() + " HORA: " + LocalDateTime.now().getHour() + ":" + LocalDateTime.now().getMinute());
			email.addTo(this.email);
			EmailAttachment anexo = new EmailAttachment();
			anexo.setPath("C:\\Users\\User\\Downloads\\Apache-tomcat\\webapps\\br.com.projetoSamiavet-0.0.1-SNAPSHOT\\resources\\comprovantes\\" + this.nomeComprovante + ".pdf");
			anexo.setName(this.nomeComprovante + ".pdf");
			email.attach(anexo);
			
			
			email.send();
			
			System.out.println("email enviado com sucesso!!");
			JsfUtil.adicionarMensagemDeSucesso("EMAIL ENVIADO PARA O EMAIL: " + this.email + " CONFIRA NA CAIXA DE ENTRADA!!", null);
		}catch(Exception erro) {
			erro.printStackTrace();
			JsfUtil.adicionarMensagemDeErro("Ocorreu um erro inesperado", null);

		}
		
		setEmail(null);
	
	}
	
	public void gerarComprovante() {
		this.file = DefaultStreamedContent.builder()
                .contentType("application/pdf")
                .name(this.nomeComprovante + ".pdf")
                .stream(() -> FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/resources/comprovantes/" + this.nomeComprovante + ".pdf"))
                .build();
	}
	

	
	 public void preProcessPDF(Object document) throws IOException, BadElementException, DocumentException {
	        Document pdf = (Document) document;
	        pdf.open();
	        pdf.setPageSize(PageSize.A4);

	        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();

	        String separator = File.separator;
	        String logo = externalContext.getRealPath("") + separator
	                + "resources" + separator + "showcase" + separator + "images" + separator + "primefaces-logo.png";

	        pdf.add(Image.getInstance(logo));
	    }

	public void deletar() {
		this.vendasService.deletarTudo();
		
		JsfUtil.adicionarMensagemDeSucesso("Vendas deletadas com sucesso!!", null);
		
		carregar();
	}
}
