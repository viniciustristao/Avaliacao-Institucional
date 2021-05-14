package spa.cb.segacademico;

public class Academico {
	private String seguimento, campus, curso;

	public Academico(String seguimento, String campus) {
		this.seguimento = seguimento;
		this.campus = campus;
	}
	
	public Academico(String seguimento, String campus, String curso) {
		super();
		this.seguimento = seguimento;
		this.campus = campus;
		this.curso = curso;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getSeguimento() {
		return seguimento;
	}
	
	public void setSeguimento(String seguimento) {
		this.seguimento = seguimento;
	}
	
	
	public String getCampus() {
		return campus;
	}

	public void setCampus(String campus) {
		this.campus = campus;
	}

	@Override
	public String toString() {
		return (curso!=null)? String.format("Seguimento Academico: %s, Campus: %s, Curso: %s", seguimento, campus, curso):
				String.format("Seguimento Academico: %s, Campus: %s", seguimento, campus);
	}
}
