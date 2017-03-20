package br.com.heiderlopes.stickyheaders.model;

import java.util.Comparator;

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

	public static Comparator<Person> PersonNameComparator = new Comparator<Person>() {

		public int compare(Person person1, Person person2) {

			String name1 = person1.getNome().toUpperCase();
			String name2 = person2.getNome().toUpperCase();

			return name1.compareTo(name2);

		}

	};
}
