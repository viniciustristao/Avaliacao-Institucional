package spa.cb.relatorios;

import java.util.ArrayList;

import spa.cb.pesquisa.Conceito;
import spa.cb.pesquisa.Pesquisa;
import spa.cb.pesquisa.Resposta;
import spa.cb.pesquisa.Tema;

public class ConceitoMedioDiscentes {
	
	public void conceitoMedioDiscentes(Pesquisa pesquisa, String tipo, ArrayList<String>cursos) {
		double media=0, ppc=0;
		ArrayList<Tema> temas = pesquisa.getTemas();
		double conceitoMedio[][] = new double [getTemas(pesquisa).size()][cursos.size()];
		ArrayList<String> temasStr = getTemas(pesquisa);
		//ArrayList<Integer> nPart = new ParticipacaoCurso().getNPartCurso(cursos, pesquisa.getTemas().get(0).getRespostas());		
		for (int i = 3; i<temasStr.size(); i++) {
			String temaStr = temasStr.get(i);
			System.out.println("TEMASTR"+temaStr);
			for ( int j = 0; j <cursos.size(); j++) {
				media = 0;
				ppc = 0;
				String curso = cursos.get(j);
				if(curso.substring(0, 3).compareToIgnoreCase(tipo.subSequence(0, 3).toString())==0) {
					System.out.println("\t"+curso);
					for (Tema tema: temas) {
						if(temaStr.compareToIgnoreCase(tema.getTema())==0) {
							ArrayList<Resposta>respostas = tema.getRespostas();
							for (Resposta resposta : respostas) {
								if(curso.compareTo(resposta.getSegAcademico().getCurso())==0) {
					 				Conceito conceito = resposta.getConceito();
									media += conceito.getPeso();
									ppc++;
					 				/*System.out.println("\t\t'Conceito: "+conceito.getConceito());
									System.out.println("\t\tPESO: "+conceito.getPeso());*/
								}
							}
						}
					}
					System.out.printf("\t\tMedia: %.1f\t",media/ppc);
					conceitoMedio[i-3][j] = media/ppc;
				}
			}
		}
		
		
	}//conceitomediodiscentes
	
	public ArrayList<String> getTemas(Pesquisa pesquisa) {
		ArrayList<String> temas = new ArrayList<String>();
		String temaStr;
			
			for (Tema tema : pesquisa.getTemas()) {
				temaStr = tema.getTema();
				if(!temas.contains(temaStr)) {
					temas.add(temaStr);
				}
			}
		return temas;
	}
	
}

