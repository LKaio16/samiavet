package br.com.projetoSamiavet.Samiavet.PROJETO.bean;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
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
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import br.com.projetoSamiavet.Samiavet.PROJETO.domain.ServicosPrestados;
import br.com.projetoSamiavet.Samiavet.PROJETO.domain.ServicosPrestadosTemp;
import br.com.projetoSamiavet.Samiavet.PROJETO.service.ServicosPrestadosService;
import br.com.projetoSamiavet.Samiavet.PROJETO.service.ServicosPrestadosTempService;
import br.com.projetoSamiavet.Samiavet.PROJETO.util.JsfUtil;

@Named(value = "MBServicos")
@ViewScoped
public class ServicosPrestadosBean {

	private ServicosPrestados servico;

	private ServicosPrestadosTemp servicoTemp;

	private List<ServicosPrestados> servicos;

	private List<ServicosPrestadosTemp> listaServicoTemp;

	@Autowired
	private ServicosPrestadosService servicosService;

	@Autowired
	private ServicosPrestadosTempService servicosPrestadosTempService;

	private Long nomeComprovante;

	private Double total;

	private String guardarNomeAnimal;

	private ExcelOptions excelOpt;

	private PDFOptions pdfOpt;

	private String formaPag;

	private Double taxa;

	private String nomeCliente;

	private String cpf;

	private Integer parcelas;

	private Double valorDesconto;

	private Double valorTotalDesconto;

	private String nomeAnimal;

	private String email;

	private StreamedContent file;
	private StreamedContent fileRelatorioServicos;
	private Double totalServicos;

	public ServicosPrestadosBean() {
		this.servico = new ServicosPrestados();
		this.servicoTemp = new ServicosPrestadosTemp();
	}

	public ServicosPrestados getServico() {
		return servico;
	}

	public void setServico(ServicosPrestados servico) {
		this.servico = servico;
	}

	public List<ServicosPrestados> getServicos() {
		return servicos;
	}

	public void setServicos(List<ServicosPrestados> servicos) {
		this.servicos = servicos;
	}

	public List<ServicosPrestadosTemp> getListaServicoTemp() {
		return listaServicoTemp;
	}

	public void setListaServicoTemp(List<ServicosPrestadosTemp> listaServicoTemp) {
		this.listaServicoTemp = listaServicoTemp;
	}

	public Long getNomeComprovante() {
		return nomeComprovante;
	}

	public void setNomeComprovante(Long nomeComprovante) {
		this.nomeComprovante = nomeComprovante;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
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

	public ServicosPrestadosTemp getServicoTemp() {
		return servicoTemp;
	}

	public void setServicoTemp(ServicosPrestadosTemp servicoTemp) {
		this.servicoTemp = servicoTemp;
	}

	public String getFormaPag() {
		return formaPag;
	}

	public void setFormaPag(String formaPag) {
		this.formaPag = formaPag;
	}

	public Double getTaxa() {
		return taxa;
	}

	public void setTaxa(Double taxa) {
		this.taxa = taxa;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Integer getParcelas() {
		return parcelas;
	}

	public void setParcelas(Integer parcelas) {
		this.parcelas = parcelas;
	}

	public Double getValorDesconto() {
		return valorDesconto;
	}

	public void setValorDesconto(Double valorDesconto) {
		this.valorDesconto = valorDesconto;
	}

	public Double getValorTotalDesconto() {
		return valorTotalDesconto;
	}

	public void setValorTotalDesconto(Double valorTotalDesconto) {
		this.valorTotalDesconto = valorTotalDesconto;
	}

	public String getNomeAnimal() {
		return nomeAnimal;
	}

	public void setNomeAnimal(String nomeAnimal) {
		this.nomeAnimal = nomeAnimal;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public StreamedContent getFile() {
		return file;
	}

	public void setFile(StreamedContent file) {
		this.file = file;
	}

	public Double getTotalServicos() {
		return totalServicos;
	}

	public void setTotalServicos(Double totalServicos) {
		this.totalServicos = totalServicos;
	}

	public String getGuardarNomeAnimal() {
		return guardarNomeAnimal;
	}

	public void setGuardarNomeAnimal(String guardarNomeAnimal) {
		this.guardarNomeAnimal = guardarNomeAnimal;
	}

	public StreamedContent getFileRelatorioServicos() {
		return fileRelatorioServicos;
	}

	public void setFileRelatorioServicos(StreamedContent fileRelatorioServicos) {
		this.fileRelatorioServicos = fileRelatorioServicos;
	}

	@PostConstruct
	public void carregar() {
		this.servicos = new ArrayList<ServicosPrestados>(this.servicosService.listar());
		this.listaServicoTemp = new ArrayList<ServicosPrestadosTemp>(this.servicosPrestadosTempService.listar());
		customizationOptions();

		this.totalServicos = 0.0;

		for (int cont = 0; cont < this.servicosService.listar().size(); cont++) {
			this.totalServicos += this.servicosService.listar().get(cont).getValor();

		}

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

	public void adicionarServicoLista() {

		this.servicosPrestadosTempService.cadastrar(this.servicoTemp);

		this.servicoTemp = new ServicosPrestadosTemp();

		JsfUtil.adicionarMensagemDeSucesso("Serviço adicionado a lista", null);

		carregar();
	}

	public void calcularTotal() {

		this.total = 0.0;

		for (int cont = 0; cont < this.servicosPrestadosTempService.listar().size(); cont++) {
			this.total += this.servicosPrestadosTempService.listar().get(cont).getValor();

		}

	}

	public void cadastrar() {

		try {

			for (int cont = 0; cont < this.servicosPrestadosTempService.listar().size(); cont++) {

				ServicosPrestados servicos = new ServicosPrestados();

				servicos.setNome_cliente(this.nomeCliente);
				servicos.setForma_pagamento(formaPag);
				servicos.setParcelas(this.parcelas);
				servicos.setNomeAnimal(this.nomeAnimal);
				servicos.setTipo(this.servicosPrestadosTempService.listar().get(cont).getTipo());
				servicos.setTitulo(this.servicosPrestadosTempService.listar().get(cont).getTitulo());
				servicos.setData(String.valueOf(LocalDate.now()));
				servicos.setValor(this.servicosPrestadosTempService.listar().get(cont).getValor());

				this.servicosService.salvar(servicos);

			}

			Document document = new Document();

			try {
				PdfWriter.getInstance(document, new FileOutputStream(
						"C:\\Users\\User\\Downloads\\Apache-tomcat\\webapps\\br.com.projetoSamiavet-0.0.1-SNAPSHOT\\resources\\comprovantes\\"
								+ this.nomeAnimal + ".pdf"));

				document.open();
				document.add(new Paragraph(
						"----------------------------------------------------------------------------------------------------------------------"));
				String filename = "C:\\Users\\User\\Downloads\\Apache-tomcat\\webapps\\br.com.projetoSamiavet-0.0.1-SNAPSHOT\\resources\\imagens\\samiavet-copia.png";
				Font fonteTexto = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.NORMAL);

				Font fonteNegrito = FontFactory.getFont(FontFactory.COURIER, 17, Font.BOLD);
				Font fonteNegrito2 = FontFactory.getFont(FontFactory.COURIER, 15, Font.BOLD);

				Image image;
				try {
					image = Image.getInstance(filename);
					document.add(image);
					document.add(new Paragraph(
							"----------------------------------------------------------------------------------------------------------------------"));
					document.add(new Paragraph(
							"PAGAMENTO: " + this.formaPag + "                   " + "TOTAL: " + this.total + "R$",
							fonteNegrito2));
					document.add(new Paragraph("N° PARCELAS: " + this.parcelas, fonteNegrito2));
					document.add(new Paragraph("DATA: " + LocalDate.now().getDayOfMonth() + "/"
							+ LocalDate.now().getMonthValue() + "/" + LocalDate.now().getYear() + "        " + "HORA: "
							+ LocalDateTime.now().getHour() + ":" + LocalDateTime.now().getMinute(), fonteNegrito2));

					document.add(new Paragraph("CLIENTE: " + this.nomeCliente, fonteNegrito2));
					document.add(new Paragraph("NOME ANIMAL: " + this.nomeAnimal, fonteNegrito2));
					document.add(new Paragraph("-"));
					document.add(new Paragraph("-"));
					document.add(new Paragraph("-"));
					document.add(new Paragraph("-"));
					document.add(new Paragraph("-"));

					for (int cont = 0; cont < this.servicosPrestadosTempService.listar().size(); cont++) {
						document.add(new Paragraph(
								"----------------------------------------------------------------------------------------------------------------------"));

						document.add(new Paragraph(
								"ATENDIMENTO: " + this.servicosPrestadosTempService.listar().get(cont).getTipo(),
								fonteNegrito2));
						document.add(new Paragraph(
								"DESCRIÇÃO: " + this.servicosPrestadosTempService.listar().get(cont).getDescricao(),
								fonteNegrito2));
						document.add(new Paragraph(
								"VALOR: " + this.servicosPrestadosTempService.listar().get(cont).getValor(),
								fonteNegrito2));
						document.add(new Paragraph(
								"----------------------------------------------------------------------------------------------------------------------"));

					}
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (DocumentException ex) {
				System.out.println("Error:" + ex);
			} catch (FileNotFoundException ex) {
				System.out.println("Error:" + ex);
			} finally {
				document.close();
			}

			this.servicosPrestadosTempService.deletarTodos();

			JsfUtil.adicionarMensagemDeSucesso("Serviço salvo com sucesso!", null);
			carregar();

			setNomeCliente(null);

			this.servico = new ServicosPrestados();

			this.servicoTemp = new ServicosPrestadosTemp();

			this.guardarNomeAnimal = this.nomeAnimal;

			this.setNomeAnimal(null);

		} catch (Exception erro) {
			JsfUtil.adicionarMensagemDeSucesso("Serviços salvos com sucesso", null);
		}

	}

	public void calcularDesconto() {

		this.valorTotalDesconto = 0.0;

		Double calcularTaxa = (this.taxa / 100) * this.valorDesconto;

		this.valorTotalDesconto = this.valorDesconto - calcularTaxa;

		setValorDesconto(null);

		setTaxa(null);
	}

	public void excluir() {
		this.servicosPrestadosTempService.deletar(this.servicoTemp.getIdServico());
		carregar();
		JsfUtil.adicionarMensagemDeSucesso("Serviço deletado com sucesso!", null);

		this.total = 0.0;

		for (int cont = 0; cont < this.servicosPrestadosTempService.listar().size(); cont++) {
			this.total += this.servicosPrestadosTempService.listar().get(cont).getValor();

		}
	}

	public void cancelarServicos() {
		this.servicosPrestadosTempService.deletarTodos();
		carregar();
		JsfUtil.adicionarMensagemDeSucesso("Serviços excluídos com sucesso!", null);

		this.total = 0.0;

		for (int cont = 0; cont < this.servicosPrestadosTempService.listar().size(); cont++) {
			this.total += this.servicosPrestadosTempService.listar().get(cont).getValor();

		}

	}

	public void enviarEmail() {
		String meuEmail = "tirsopottim04@gmail.com";
		String minhaSenha = "191991tirso";

		MultiPartEmail email = new MultiPartEmail();
		email.setHostName("smtp.gmail.com");
		// email.setSmtpPort(587);
		email.setAuthenticator(new DefaultAuthenticator(meuEmail, minhaSenha));
		email.setSSLOnConnect(true);

		try {

			email.setFrom(meuEmail);
			email.setSubject("_COMPROVANTE_SAMIAVET(ATENDIMENTO)");
			email.setMsg("Comprovante de atendimento realizado. DATA: " + LocalDate.now().getDayOfMonth() + "/"
					+ LocalDate.now().getMonthValue() + "/" + LocalDate.now().getYear() + " HORA: "
					+ LocalDateTime.now().getHour() + ":" + LocalDateTime.now().getMinute());
			email.addTo(this.email);
			EmailAttachment anexo = new EmailAttachment();
			anexo.setPath(
					"C:\\Users\\User\\Downloads\\Apache-tomcat\\webapps\\br.com.projetoSamiavet-0.0.1-SNAPSHOT\\resources\\comprovantes\\"
							+ this.guardarNomeAnimal + ".pdf");
			anexo.setName(this.guardarNomeAnimal + ".pdf");
			email.attach(anexo);

			email.send();

			System.out.println("email enviado com sucesso!!");
			JsfUtil.adicionarMensagemDeSucesso(
					"EMAIL ENVIADO PARA O EMAIL: " + this.email + " CONFIRA NA CAIXA DE ENTRADA!!", null);
		} catch (Exception erro) {
			erro.printStackTrace();
			JsfUtil.adicionarMensagemDeErro("Ocorreu um erro inesperado", null);

		}

		setEmail(null);

	}

	public void gerarRelatorioServicos() throws DocumentException, IOException {
		Document document = new Document(PageSize.A4.rotate());

		try {
			PdfWriter.getInstance(document, new FileOutputStream(
					"C:\\Users\\User\\Downloads\\Apache-tomcat\\webapps\\br.com.projetoSamiavet-0.0.1-SNAPSHOT\\resources\\arquivos\\" + "Servicos" + ".pdf"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}

		document.open();
		String filename = "C:\\Users\\User\\Downloads\\Apache-tomcat\\webapps\\br.com.projetoSamiavet-0.0.1-SNAPSHOT\\resources\\imagens\\SamiaVetLogoComprovanteHorizontal2.png";
		Font fonteTexto = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.NORMAL);
		Font fonteTexto2 = FontFactory.getFont(FontFactory.COURIER, 9, Font.NORMAL);
		Font fonteTexto3 = FontFactory.getFont(FontFactory.COURIER_BOLD, 10, Font.NORMAL);

		Font fonteNegrito = FontFactory.getFont(FontFactory.COURIER, 17, Font.BOLD);
		Font fonteNegrito2 = FontFactory.getFont(FontFactory.COURIER, 15, Font.BOLD);
		Font fonteNegrito3 = FontFactory.getFont(FontFactory.COURIER, 10, Font.BOLD);

		Image image = null;

		try {
			image = Image.getInstance(filename);

			image.scaleToFit(PageSize.A4.getWidth(), PageSize.A4.getHeight());

		} catch (BadElementException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			document.add(image);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		document.add(new Paragraph(" "));
		document.add(new Paragraph(" "));

		float[] pointColumnWidths = { 40F, 40F, 60F, 40F, 40F, 40F, 40F, 60F, 40F };
		PdfPTable table = new PdfPTable(pointColumnWidths);
		PdfPCell cell;

		cell = new PdfPCell(new Phrase("ID", new Font(fonteNegrito3)));
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("TIPO", new Font(fonteNegrito3)));
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("DESCRIÇÃO", new Font(fonteNegrito3)));
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("ANIMAL", new Font(fonteNegrito3)));
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("CLIENTE", new Font(fonteNegrito3)));
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("PAG.", new Font(fonteNegrito3)));
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("PARCELAS", new Font(fonteNegrito3)));
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("DATA", new Font(fonteNegrito3)));
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("VALOR", new Font(fonteNegrito3)));
		table.addCell(cell);

		Double soma = 0.0;
		for (int cont = 0; cont < this.servicosService.listar().size(); cont++) {

			cell = new PdfPCell(new Phrase(String.valueOf(this.servicosService.listar().get(cont).getIdServico()),
					new Font(fonteTexto2)));
			table.addCell(cell);

			cell = new PdfPCell(new Phrase(String.valueOf(this.servicosService.listar().get(cont).getTipo()),
					new Font(fonteTexto2)));
			table.addCell(cell);

			cell = new PdfPCell(new Phrase(String.valueOf(this.servicosService.listar().get(cont).getDescricao()),
					new Font(fonteTexto2)));
			table.addCell(cell);

			cell = new PdfPCell(new Phrase(String.valueOf(this.servicosService.listar().get(cont).getNomeAnimal()),
					new Font(fonteTexto2)));
			table.addCell(cell);

			cell = new PdfPCell(new Phrase(String.valueOf(this.servicosService.listar().get(cont).getNome_cliente()),
					new Font(fonteTexto2)));
			table.addCell(cell);

			cell = new PdfPCell(new Phrase(String.valueOf(this.servicosService.listar().get(cont).getForma_pagamento()),
					new Font(fonteTexto2)));
			table.addCell(cell);

			cell = new PdfPCell(new Phrase(String.valueOf(this.servicosService.listar().get(cont).getParcelas()),
					new Font(fonteTexto2)));
			table.addCell(cell);

			cell = new PdfPCell(new Phrase(String.valueOf(this.servicosService.listar().get(cont).getData()),
					new Font(fonteTexto2)));
			table.addCell(cell);

			cell = new PdfPCell(new Phrase(String.valueOf(this.servicosService.listar().get(cont).getValor()),
					new Font(fonteTexto2)));
			table.addCell(cell);

			soma += this.servicosService.listar().get(cont).getValor();

		}

		document.add(table);

		float[] pointColumnWidths2 = { 350F, 90F };
		PdfPTable table2 = new PdfPTable(pointColumnWidths2);
		PdfPCell cell2;

		cell2 = new PdfPCell(new Phrase("Total Vendas: ", new Font(fonteNegrito3)));
		table2.addCell(cell2);

		cell2 = new PdfPCell(new Phrase(soma + "R$", new Font(fonteNegrito3)));
		table2.addCell(cell2);
		document.add(table2);

		document.close();

		JsfUtil.adicionarMensagemDeSucesso("Relatório gerado com sucesso", null);
		String path = "C:\\Users\\User\\Downloads\\Apache-tomcat\\webapps\\br.com.projetoSamiavet-0.0.1-SNAPSHOT\\resources\\arquivos\\Servicos.pdf";
		File file = new File(path);
		try {
			if (file.exists()) {
				Process pro = Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + path);
				pro.waitFor();
			} else {
				System.out.println("file does not exist");
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void gerarComprovante() {
		this.file = DefaultStreamedContent.builder().contentType("application/pdf")
				.name(this.guardarNomeAnimal + ".pdf")
				.stream(() -> FacesContext.getCurrentInstance().getExternalContext()
						.getResourceAsStream("/resources/comprovantes/" + this.guardarNomeAnimal + ".pdf"))
				.build();
	}

	public void gerarComprovanteServicos() {
		this.fileRelatorioServicos = DefaultStreamedContent.builder().contentType("application/pdf")
				.name("Servicos" + ".pdf").stream(() -> FacesContext.getCurrentInstance().getExternalContext()
						.getResourceAsStream("/resources/arquivos/" + "Servicos" + ".pdf"))
				.build();
	}

	public void deletar() {
		this.servicosService.deletarTodos();
		carregar();
		JsfUtil.adicionarMensagemDeSucesso("Serviços deletados com sucesso ", null);

	}
}
