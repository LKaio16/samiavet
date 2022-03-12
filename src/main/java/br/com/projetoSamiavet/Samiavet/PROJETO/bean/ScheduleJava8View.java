package br.com.projetoSamiavet.Samiavet.PROJETO.bean;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.LazyScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.projetoSamiavet.Samiavet.PROJETO.domain.Agendamento;
import br.com.projetoSamiavet.Samiavet.PROJETO.domain.FichaClinica;
import br.com.projetoSamiavet.Samiavet.PROJETO.service.AgendamentoService;
import br.com.projetoSamiavet.Samiavet.PROJETO.util.JsfUtil;
@Named(value="scheduleJava8View")
@ViewScoped
public class ScheduleJava8View implements Serializable {
	 
    private ScheduleModel eventModel;
     
    private ScheduleModel lazyEventModel;
 
    private ScheduleEvent event = new DefaultScheduleEvent();
 
    private boolean showWeekends = true;
    private boolean tooltip = true;
    private boolean allDaySlot = true;
 
    private String timeFormat;
    private String slotDuration="00:30:00";
    private String slotLabelInterval;
    private String scrollTime="06:00:00";
    private String minTime="04:00:00";
    private String maxTime="20:00:00";
    private String locale="pt";
    private String timeZone="";
    private String clientTimeZone="local";
    private String columnHeaderFormat="";
 
    
    private Agendamento agendamento;
    
    @Autowired
   	private AgendamentoService agendamentoService;
    
    private ArrayList<Agendamento> itens;
    
    private String pesquisarNome;
    
    
    public ScheduleJava8View() {
    	this.agendamento = new Agendamento();

    }
    @PostConstruct
    public void init() {
    	
    	JsfUtil.adicionarMensagemDeSucesso("Eventos atualizados!", null);
        eventModel = new DefaultScheduleModel();
        
        
        List<Agendamento> agendamentos = this.agendamentoService.listarAgendamentos();
        itens = new ArrayList<Agendamento>(agendamentos);
        
        for(int cont = 0; cont<agendamentos.size(); cont++) {
        	
        
        
	        
	        String dataInicio = agendamentos.get(cont).getDataInicio();
	        
	        String dataTermino = agendamentos.get(cont).getDataTermino();
	        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_DATE_TIME;
	        
	        if(LocalDateTime.now().equals(dataTermino)) {
	        	System.out.println("EVENTO ENCERRADO");
	        }
	       
	        
	        
	        LocalDateTime dateInicio = LocalDateTime.parse(dataInicio, dateTimeFormatter);
	        LocalDateTime dateTermino = LocalDateTime.parse(dataTermino, dateTimeFormatter);
	
	        String titulo = agendamentos.get(cont).getTitulo();
	        String observacao = agendamentos.get(cont).getObservacao();
	        
	        DefaultScheduleEvent event = DefaultScheduleEvent.builder()
	                .title(titulo)
	                .startDate(dateInicio)
	                .endDate(dateTermino)
	                .description(observacao)
	                .build();
	        eventModel.addEvent(event);
 
        
      
        }
        lazyEventModel = new LazyScheduleModel() {
             
            @Override
            public void loadEvents(LocalDateTime start, LocalDateTime end) {
                for(int cont = 0; cont<agendamentos.size(); cont++) {
                    LocalDateTime random = getRandomDateTime(start);
                    addEvent(DefaultScheduleEvent.builder().title("Lazy Event " + cont).startDate(random).endDate(random.plusHours(0)).build());
                }
            }
        };
    }
     
    
    public String getPesquisarNome() {
		return pesquisarNome;
	}
	public void setPesquisarNome(String pesquisarNome) {
		this.pesquisarNome = pesquisarNome;
	}
	public LocalDateTime getRandomDateTime(LocalDateTime base) {
        LocalDateTime dateTime = base.withMinute(0).withSecond(0).withNano(0);
        return dateTime.plusDays(((int) (Math.random()*30)));
    }
     
 
    public ScheduleModel getEventModel() {
        return eventModel;
    }
     
    public ScheduleModel getLazyEventModel() {
        return lazyEventModel;
    }
 
    private LocalDateTime previousDay8Pm() {
        return LocalDateTime.now().minusDays(1).withHour(20).withMinute(0).withSecond(0).withNano(0);
    }
     
    private LocalDateTime previousDay11Pm() {
        return LocalDateTime.now().minusDays(1).withHour(23).withMinute(0).withSecond(0).withNano(0);
    }
     
    private LocalDateTime today1Pm() {
        return LocalDateTime.now().withHour(13).withMinute(0).withSecond(0).withNano(0);
    }
     
    private LocalDateTime theDayAfter3Pm() {
        return LocalDateTime.now().plusDays(1).withHour(15).withMinute(0).withSecond(0).withNano(0);
    }
 
    private LocalDateTime today6Pm() {
        return LocalDateTime.now().withHour(18).withMinute(0).withSecond(0).withNano(0);
    }
     
    private LocalDateTime nextDay9Am() {
        return LocalDateTime.now().plusDays(1).withHour(9).withMinute(0).withSecond(0).withNano(0);
    }
     
    private LocalDateTime nextDay11Am() {
        return LocalDateTime.now().plusDays(1).withHour(11).withMinute(0).withSecond(0).withNano(0);
    }
     
    private LocalDateTime fourDaysLater3pm() {
        return LocalDateTime.now().plusDays(4).withHour(15).withMinute(0).withSecond(0).withNano(0);
    }
 
    private LocalDateTime sevenDaysLater0am() {
        return LocalDateTime.now().plusDays(7).withHour(0).withMinute(0).withSecond(0).withNano(0);
    }
 
    private LocalDateTime eightDaysLater0am() {
        return LocalDateTime.now().plusDays(7).withHour(0).withMinute(0).withSecond(0).withNano(0);
    }
     
    public LocalDate getInitialDate() {
        return LocalDate.now().plusDays(1);
    }
 
    public ScheduleEvent getEvent() {
        return event;
    }
 
    public void setEvent(ScheduleEvent event) {
        this.event = event;
    }
     
    public void addEvent() {
        if (event.isAllDay()) {
            //see https://github.com/primefaces/primefaces/issues/1164
            if (event.getStartDate().toLocalDate().equals(event.getEndDate().toLocalDate())) {
                event.setEndDate(event.getEndDate().plusDays(1));
            }
        }
 
        if(event.getId() == null) {
            eventModel.addEvent(event);
            
            
        }
        else {
            eventModel.updateEvent(event);
         
        event = new DefaultScheduleEvent();
        }
        
        System.out.println(event.getStartDate());
        
    }
     
    public void onEventSelect(SelectEvent<ScheduleEvent> selectEvent) {
        event = selectEvent.getObject();
    }
     
    public void onDateSelect(SelectEvent<LocalDateTime> selectEvent) {
        event = DefaultScheduleEvent.builder().startDate(selectEvent.getObject()).endDate(selectEvent.getObject()).build();
    }
     
    
  
     
    private void addMessage(FacesMessage message) {
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
 
    public boolean isShowWeekends() {
        return showWeekends;
    }
 
    public void setShowWeekends(boolean showWeekends) {
        this.showWeekends = showWeekends;
    }
 
    public boolean isTooltip() {
        return tooltip;
    }
 
    public void setTooltip(boolean tooltip) {
        this.tooltip = tooltip;
    }
 
    public boolean isAllDaySlot() {
        return allDaySlot;
    }
 
    public void setAllDaySlot(boolean allDaySlot) {
        this.allDaySlot = allDaySlot;
    }
 
    public String getTimeFormat() {
        return timeFormat;
    }
 
    public void setTimeFormat(String timeFormat) {
        this.timeFormat = timeFormat;
    }
 
    public String getSlotDuration() {
        return slotDuration;
    }
 
    public void setSlotDuration(String slotDuration) {
        this.slotDuration = slotDuration;
    }
 
    public String getSlotLabelInterval() {
        return slotLabelInterval;
    }
 
    public void setSlotLabelInterval(String slotLabelInterval) {
        this.slotLabelInterval = slotLabelInterval;
    }
 
    public String getScrollTime() {
        return scrollTime;
    }
 
    public void setScrollTime(String scrollTime) {
        this.scrollTime = scrollTime;
    }
 
    public String getMinTime() {
        return minTime;
    }
 
    public void setMinTime(String minTime) {
        this.minTime = minTime;
    }
 
    public String getMaxTime() {
        return maxTime;
    }
 
    public void setMaxTime(String maxTime) {
        this.maxTime = maxTime;
    }
 
    public String getLocale() {
        return locale;
    }
 
    public void setLocale(String locale) {
        this.locale = locale;
    }
 
    public String getTimeZone() {
        return timeZone;
    }
 
    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }
 
    public String getClientTimeZone() {
        return clientTimeZone;
    }
 
    public void setClientTimeZone(String clientTimeZone) {
        this.clientTimeZone = clientTimeZone;
    }
 
    public String getColumnHeaderFormat() {
        return columnHeaderFormat;
    }
 
    public void setColumnHeaderFormat(String columnHeaderFormat) {
        this.columnHeaderFormat = columnHeaderFormat;
    }

	
	
	public Agendamento getAgendamento() {
		return agendamento;
	}
	public void setAgendamento(Agendamento agendamento) {
		this.agendamento = agendamento;
	}
	public AgendamentoService getAgendamentoService() {
		return agendamentoService;
	}
	public void setEventModel(ScheduleModel eventModel) {
		this.eventModel = eventModel;
	}
	public void setLazyEventModel(ScheduleModel lazyEventModel) {
		this.lazyEventModel = lazyEventModel;
	}
	public void cadastrar() {
		
		String converterDataInicio = String.valueOf(event.getStartDate());
		String converterDataTermino = String.valueOf(event.getEndDate());

		this.agendamento.setDataInicio(converterDataInicio);
		this.agendamento.setDataTermino(converterDataTermino);
		
		
		this.agendamentoService.salvar(this.agendamento);
		this.agendamento = new Agendamento();
        JsfUtil.adicionarMensagemDeSucesso("Evento agendado", null);
        init();
	}
	
	public void editar(){
		
		this.agendamentoService.salvar(this.agendamento);
		this.agendamento = new Agendamento();
		init();
		
	}
	public void deletar() {
		
		this.agendamentoService.deletar(this.agendamento.getId());
		JsfUtil.adicionarMensagemDeSucesso("Eventos atualizados", null);
		this.agendamento = new Agendamento();
		init();
	}
	public ArrayList<Agendamento> getItens() {
		return itens;
	}
	public void setItens(ArrayList<Agendamento> itens) {
		this.itens = itens;
	}
    

	public List<String> completarNomeAnimal(String query) {
        String queryLowerCase = query.toLowerCase();
        List<String> listaNomes = new ArrayList<>();
        List<Agendamento> nomes = this.agendamentoService.listarAgendamentos();
        for (Agendamento nomesAnimais : nomes) {
        	listaNomes.add(nomesAnimais.getNomeAnimal());
        }

        return listaNomes.stream().filter(t -> t.toLowerCase().startsWith(queryLowerCase)).collect(Collectors.toList());
    }
	
	public void pesquisarAgendamento() {
        this.itens= new ArrayList<Agendamento>(this.agendamentoService.retornaPeloNome(this.pesquisarNome));

	}
	
	public void resetar() {
        this.itens = new ArrayList<Agendamento>(this.agendamentoService.listarAgendamentos());

	}
}
