package com.senac.mvc.model;

public class Agenda {
	
	private String nome;
	private String endereco;
	private String telefone;
	private char tipotelefone;
	
	
	public void setNome(String nome){
		this.nome = nome;
	}
	
	public String getNome(){
		return nome;
	}
	
	public void setEndereco(String endereco){
		this.endereco = endereco;
	}
	
	public String getEndereco(){
		return endereco;
	}
	
	public void setTelefone(String telefone){
		this.telefone = telefone;
	}
	
	public String getTelefone(){
		return telefone;
	}
	
    public void setPhoneType(char phonetype) {
        this.tipotelefone = phonetype;
    }

	public String getPhoneType(){
		String type = "";
		
        switch(this.tipotelefone) {
        case 'C': type = "Cellular";
        	break;
        case 'H': type = "Home";
        	break;
        case 'W': type = "Work";
        	break;
        }
        
    return type;
		
		
	}


}
