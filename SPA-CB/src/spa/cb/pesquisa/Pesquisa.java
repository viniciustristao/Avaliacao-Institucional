package spa.cb.pesquisa;

import java.util.ArrayList;

public class Pesquisa {
	private String nome;
	private ArrayList<Tema> temas;
	
	public Pesquisa() {
		super();
	}

	public Pesquisa(String nome) {
		super();
		this.nome = nome;
		this.temas = new ArrayList<Tema>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void addTema(Tema tema){
		temas.add(tema);
	}
	
	public Tema getTemaPos(int pos) {
		return temas.get(pos);
	}
	
	public ArrayList<Tema> getTemas() {
		return temas;
	}

	public String strTemas() {
		StringBuilder temas = new StringBuilder();
		for (Tema tema : this.temas) {
			temas.append(tema.toString()).append("\n");
		}
		return temas.toString();
	}

	@Override
	public String toString() {
		return String.format("Pesquisa %s\n\t%s", nome,strTemas());
	}
}
