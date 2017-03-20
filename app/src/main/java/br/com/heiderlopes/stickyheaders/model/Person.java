package br.com.heiderlopes.stickyheaders.model;

/**
 * Simplified take on the model vended by http://api.randomuser.me/
 */
public class Person {

	private String nome;
	private String sobrenome;

	public Person(String nome) {
		this.nome = nome;

	}
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
}
