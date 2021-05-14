package spa.cb.chart;
import java.awt.Dimension;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 * Classe com metodos responsaveis por gerar graficos
 * apartir de uma lista de exercios consumindo dados
 * gerados pela classe DataSetGraficos
 * @author tivin
 *
 */
public class FabricaDeGraficos {

	
	public static DefaultCategoryDataset datasetParticipacaoCurso(List<String> cursos, List<Integer>part){
		
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for (int i=0; i<cursos.size();i++) {
			dataset.addValue(part.get(i), cursos.get(i), "");
		}
		
		return dataset;
	}//fim graficoduração
	
	public JFreeChart createParticipacaoCursoChart(CategoryDataset dataset) {
	
		JFreeChart chartBarPC = ChartFactory.createBarChart("Participaçap discentes por Curso",
				"Teste",
				"Teste2",
				dataset,
				PlotOrientation.HORIZONTAL,
				true,
				false,
				false);
		
		return chartBarPC;
	}
	
	public ChartPanel creatChatPanelParticipacaoCurso(List<String> cursos, List<Integer>part) {
		CategoryDataset dataset = datasetParticipacaoCurso(cursos, part);
		JFreeChart chart = createParticipacaoCursoChart(dataset);
		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new Dimension(500,500));
		
		return chartPanel;
	}
	
}