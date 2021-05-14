package spa.cb.pesquisa;

import spa.cb.segacademico.Academico;

public class Resposta {
	private Conceito conceito;
	private Academico segAcademico;
	
	public Resposta() {
		super();
	}

	public Resposta(Conceito conceito, Academico segAcademico) {
		this.conceito = conceito;
		this.segAcademico = segAcademico;
	}

	public Conceito getConceito() {
		return conceito;
	}

	public void setConceito(Conceito conceito) {
		this.conceito = conceito;
	}

	public Academico getSegAcademico() {
		return segAcademico;
	}

	public void setSegAcademico(Academico segAcademico) {
		this.segAcademico = segAcademico;
	}

	@Override
	public String toString() {
		return String.format("%s, Conceito: %s", segAcademico, conceito);
	}
	
	
}
