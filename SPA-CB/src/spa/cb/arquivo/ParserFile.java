package spa.cb.arquivo;

import spa.cb.bd.RespostaDAO;
import spa.cb.pesquisa.Conceito;
import spa.cb.pesquisa.Pesquisa;
import spa.cb.pesquisa.Resposta;
import spa.cb.pesquisa.Tema;
import spa.cb.segacademico.Academico;

public class ParserFile {
	public static void parserQuestions(int op, Pesquisa pesquisa, String lineQuest) {
		Tema tema;
		String strTema,aspecto, quest[];
		
		if(op==1)
			RespostaDAO.insertQuest(pesquisa.getNome(), lineQuest);
		if(op==2) {
			quest = lineQuest.split(";");
			for (int i = 0; i < quest.length; i++) {
				if(quest[i].indexOf('[')!=-1) {
					strTema = quest[i].split(" \\[")[0];
					aspecto = quest[i].split(" \\[")[1];
				}else {
					strTema = quest[i];
					aspecto = "";
				}
				tema = new Tema(strTema, aspecto);
				pesquisa.addTema(tema);
			}
		}
	}//parserQuestions
	
	public static void parserAnswers(int op, Pesquisa pesquisa, String... linesAnswers) {
		Resposta resposta;
		Academico segAcademico;
		String respostas[];
		Conceito conceito;
		for (int i = 0; i < linesAnswers.length; i++) {
			respostas = linesAnswers[i].split(";");
			segAcademico = (respostas[2].compareTo("")!=0)?new Academico(respostas[0], respostas[1], respostas[2]):
									new Academico(respostas[0], respostas[1]);
			if(op==1)
				RespostaDAO.insertResposta(pesquisa.getNome(), segAcademico, linesAnswers[i].substring(indexAns(linesAnswers[i])));
			if(op==2) {
				for (int j = 0; j < pesquisa.getTemas().size(); j++) {
					resposta = new Resposta();
					resposta.setSegAcademico(segAcademico);
					if(j>2) {
						conceito = Conceito.parserTipoConceito(respostas[j]);
						resposta.setConceito(conceito);
					}
					pesquisa.getTemaPos(j).addResposta(resposta);
						
				}
			}
		}
		
		
	}//parseranswer
	
	
	public static int indexAns(String lineAns) {
		int  index=0;
		for (int i = 0; i < 3; i++){
			index = lineAns.indexOf(';', index)+1;
		}

		return index;
	}
	

}
