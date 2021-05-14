package spa.cb.relatorios;

import java.util.ArrayList;

import spa.cb.pesquisa.Pesquisa;
import spa.cb.pesquisa.Resposta;
import spa.cb.pesquisa.Tema;

public class ParticipacaoCurso {
	
	public ArrayList<String> getCursos(Pesquisa pesquisa) {
		ArrayList<String> cursos = new ArrayList<String>();
		String curso;
		
		for (int i = 0; i < pesquisa.getTemas().size(); i++) {
			ArrayList<Resposta> respostas = pesquisa.getTemas().get(i).getRespostas();
			for (Resposta resposta : respostas) {
				curso = resposta.getSegAcademico().getCurso();
				if(!cursos.contains(curso)) {
					cursos.add(curso);
				}
			}
		}
		return cursos;
	}
	
	public ArrayList<Integer> getNPartCurso(ArrayList<String> cursos, ArrayList<Resposta> respostas) {
		ArrayList<Integer> participacao = new ArrayList<Integer>();
		int part;
		for (String curso : cursos) {
			part = 0;
			for (int i = 0; i < respostas.size(); i++) {
				if(curso.compareTo(respostas.get(i).getSegAcademico().getCurso())==0) {
					part++;
				}
			}
			participacao.add(part);
		}
		return participacao;
	}
	
	
	
	
}
