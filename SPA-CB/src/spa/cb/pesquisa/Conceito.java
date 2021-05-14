package spa.cb.pesquisa;

public enum Conceito {
	OTIMO("Ótimo", 5), BOM("Bom", 4), SATISFATORIO("Satisfatório", 3),
	RUIM("Ruim", 2), PESSIMO("Péssimo", 1), INEXISTENTE("Inexistente", 0),
	NAOCONHECO("Não conheço", 0);
	
	private String conceito;
	private int peso;
	private Conceito(String conceito, int peso) {
		this.conceito = conceito;
		this.peso = peso;
	}
	public String getConceito() {
		return this.conceito;
	}
	public int getPeso() {
		return this.peso;
	}
	
	public static Conceito parserTipoConceito(String conceito) {
		//System.out.println(conceito +" = ");
		if(OTIMO.getConceito().compareTo(conceito)==0) {
			//System.out.println(OTIMO.getConceito());
			return OTIMO;
		}
		
		if(BOM.getConceito().compareTo(conceito)==0) {
			//System.out.println(BOM.getConceito());
			return BOM;
		}
		
		if(SATISFATORIO.getConceito().compareTo(conceito)==0) {
			//System.out.println(SATISFATORIO.getConceito());
			return SATISFATORIO;
		}
		
		if(RUIM.getConceito().compareTo(conceito)==0) {
			//System.out.println(RUIM.getConceito());
			return RUIM;
		}
		
		if(PESSIMO.getConceito().compareTo(conceito)==0) {
			//System.out.println(PESSIMO.getConceito());
			return PESSIMO;
		}
		
		if(INEXISTENTE.getConceito().compareTo(conceito)==0) {
			//System.out.println(INEXISTENTE.getConceito());
			return INEXISTENTE;
		}
		
		if(NAOCONHECO.getConceito().compareTo(conceito)==0) {
			//System.out.println(NAOCONHECO.getConceito());
			return NAOCONHECO;
		}
		return null;	
	}
	
}