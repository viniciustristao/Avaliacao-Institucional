package spa.cb.relatorios;

import java.util.ArrayList;

import spa.cb.pesquisa.Conceito;
import spa.cb.pesquisa.Pesquisa;
import spa.cb.pesquisa.Resposta;
import spa.cb.pesquisa.Tema;

public class ConceitoMedioAcademicos {
	
	public void conceitoMedioAcamedicos(Pesquisa pesquisa) {
		double media=0, ppc=0;
		ArrayList<Tema> temas = pesquisa.getTemas();
		ArrayList<String> temasStr = new ConceitoMedioDiscentes().getTemas(pesquisa);
		double conceitoMedioAcademico[] = new double [temasStr.size()];
				
		for (int i = 3; i<temasStr.size(); i++) {
			String temaStr = temasStr.get(i);
			System.out.println("TEMASTR"+temaStr);
			media=0;
			ppc=0;
			for (Tema tema: temas) {
				if(temaStr.compareToIgnoreCase(tema.getTema())==0) {
					ArrayList<Resposta>respostas = tema.getRespostas();
					for (Resposta resposta : respostas) {
		 				Conceito conceito = resposta.getConceito();
						media += conceito.getPeso();
						ppc++;
		 				/*System.out.println("\t\t'Conceito: "+conceito.getConceito());
						System.out.println("\t\tPESO: "+conceito.getPeso());*/
					}
				}
			}
			System.out.printf("\t\tMedia: %.1f\n",media/ppc);
			conceitoMedioAcademico[i-3] = media/ppc;
		}
	}//conceitomediogeral
}
