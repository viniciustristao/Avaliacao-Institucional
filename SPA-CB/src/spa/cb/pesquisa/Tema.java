package spa.cb.pesquisa;

import java.util.ArrayList;

public class Tema {
	private String tema, aspecto;
	private ArrayList<Resposta> respostas;
	
	public Tema() {
		super();
		respostas = new ArrayList<Resposta>();
	}

	public Tema(String tema, String aspecto) {
		super();
		this.tema = tema;
		this.aspecto = aspecto;
		respostas = new ArrayList<Resposta>();
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public String getAspecto() {
		return aspecto;
	}

	public void setAspecto(String aspecto) {
		this.aspecto = aspecto;
	}

	public ArrayList<Resposta> getRespostas() {
		return respostas;
	}
	
	public void addResposta(Resposta resposta) {
		respostas.add(resposta);
	}
	
	public String strRespostas() {
		StringBuilder respostas = new StringBuilder();
		for (Resposta resposta : this.respostas) {
			respostas.append(resposta.toString()).append("\n");
		}
		return respostas.toString();
	}

	@Override
	public String toString() {
		return String.format("Tema :%s %s\n", tema, aspecto);
	}
	
}
