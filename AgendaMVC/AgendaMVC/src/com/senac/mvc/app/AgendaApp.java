package com.senac.mvc.app;

import com.senac.mvc.controller.AgendaController;

public class AgendaApp {
	
	  public static void main (String[]args ){
		  AgendaController agendacontroller;
		  agendacontroller = new AgendaController();
		  agendacontroller.gerarDadosAleatorios();  
	  }

}
