package com.senac.agenda;

public class Telefone {

	 private int ddd;
	 private String numero;
	 private int tipoTelefone;
	 
	 
	public Telefone(int ddd, String numero, int tipoTelefone) {

		this.ddd = ddd;
		this.numero = numero;
		this.tipoTelefone = tipoTelefone;
	}


	public int getDdd() {
		return ddd;
	}
	public void setDdd(int ddd) {
		this.ddd = ddd;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public int getTipoTelefone() {
		return tipoTelefone;
	}
	public void setTipoTelefone(int tipoTelefone) {
		this.tipoTelefone = tipoTelefone;
	}
	 
	 

	}
