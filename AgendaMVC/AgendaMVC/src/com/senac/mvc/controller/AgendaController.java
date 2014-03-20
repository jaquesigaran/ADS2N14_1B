package com.senac.mvc.controller;

import com.senac.mvc.model.*;
import com.senac.mvc.view.AgendaView;
import java.util.Random;

public class AgendaController {

  private Agenda pessoa = new Agenda();
  private Random random = new Random();
  private AgendaView pessoaview = new AgendaView();

  public String gerarNumeroTelefoneAleatorio() {
      return (random.nextInt(1000-100)+100) + "-" + (random.nextInt(10000-1000)+1000);
  }
  
  private String gerarNomeAleatorio() {
      String vetorNomeAleatorio[] = 
    	  	{
    		  "Sandro","Amanda","Karen","Paula", "Carla", 
    		  "Marcelo","Roberto","Inês","Lisiane", "Guilherme",
    		  "Marcos","Marcela","Mirta","Namur", "Robson",
    		  "Pedro","João","Jaqueline","Janete", "Antoônio"
    		};
      int nomeAleatorio = random.nextInt(vetorNomeAleatorio.length);
      return vetorNomeAleatorio[nomeAleatorio]; 
  }

  private String gerarSobrenomeAleatorio() {
      String vetorSobrenomeAleatorio[] = 
    	  {
    		  "Pereira","Figueira","Silva","Ribeiro","Irigaray",
    		  "Bertoletti","Vivian","Rodrigues","Lima","Petrickz",
    		  "Nascimento","Pacheco","Kouri","Machado","Helmounth",
    		  "Borba","Veríssimo","Sigaran","Costa","Oliveira"
    	  };
      int sobrenomeAleatorio = random.nextInt(vetorSobrenomeAleatorio.length);
      return vetorSobrenomeAleatorio[sobrenomeAleatorio];
  }
  
  private String gerarEnderecoAleatorio() {
      String vetorEnderecoAleatorio[] = {"Av...","Rua...","Avenida...","Loteamento...","Bairro...", "Cidade..."};
      int enderecoAleatorio = random.nextInt(vetorEnderecoAleatorio.length);
      return vetorEnderecoAleatorio[enderecoAleatorio];
  }
  
  
  public void gerarDadosAleatorios() {
      for(int i = 0; i < 50; i++) {
    	  String resultadoNomeAleatorio = gerarNomeAleatorio() + " " + gerarSobrenomeAleatorio();
          gerarPessoa(resultadoNomeAleatorio, gerarNumeroTelefoneAleatorio(), gerarEnderecoAleatorio());
          this.pessoaview.imprimeDados(pessoa.getNome(), pessoa.getTelefone(), pessoa.getEndereco());
      }
  }
 
  public void gerarPessoa(String nome, String telefone, String endereco) {
      pessoa.setNome(nome);
      pessoa.setTelefone(telefone);
      pessoa.setEndereco(endereco);
  }

}
