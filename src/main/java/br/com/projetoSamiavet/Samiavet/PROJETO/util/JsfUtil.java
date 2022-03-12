package br.com.projetoSamiavet.Samiavet.PROJETO.util;

import javax.faces.application.FacesMessage;

import javax.faces.context.FacesContext;

public class JsfUtil {

    public static void adicionarMensagemDeSucesso(String mensagem , String detalhe) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, mensagem, detalhe);

        FacesContext contexto = FacesContext.getCurrentInstance();
        contexto.addMessage(null, msg);
    }

    public static void adicionarMensagemDeErro(String mensagem , String detalhe) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagem, detalhe);
        FacesContext contexto = FacesContext.getCurrentInstance();
        contexto.addMessage(null, msg);
    }
    public static void adicionarMensagemDeAtencao(String mensagem , String detalhe) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN, mensagem, detalhe);
        FacesContext contexto = FacesContext.getCurrentInstance();
        contexto.addMessage(null, msg);
    }
}
