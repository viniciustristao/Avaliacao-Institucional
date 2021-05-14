package spa.cb.relatorios;

import java.util.ArrayList;

import spa.cb.pesquisa.Pesquisa;
import spa.cb.pesquisa.Resposta;
import spa.cb.pesquisa.Tema;

public class ParticipacaoSeguimento {
	
	public int[] getNPartSeguimento(ArrayList<Resposta> respostas, String... seguimentos) {
		
		int participacao[] = new int[3];
		int part;
		for (int i = 0; i < seguimentos.length; i++) {
			part = 0;
			for (int j = 0; j < respostas.size(); j++) {
				if(seguimentos[i].compareToIgnoreCase(respostas.get(j).getSegAcademico().getSeguimento())==0) {
					part++;
				}
			}
			participacao[i] = part;
		}
		return participacao;
	}
}