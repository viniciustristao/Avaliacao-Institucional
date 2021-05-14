package spa.cb.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import spa.cb.chart.FabricaDeGraficos;

public class PesquisaView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 *
	public static void main(String[] args) {
		
	}*/
	/**
	 * Create the frame.
	 */
	public PesquisaView(List<String> cursos, List<Integer> part) {
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 2, 0, 0));

		
		JPanel panel_chart = new JPanel();
		contentPane.add(panel_chart);
		panel_chart.setLayout(new BorderLayout(0, 0));
		
		JLayeredPane panelBtn = new JLayeredPane();
		panelBtn.setSize(new Dimension(200,200));
		panelBtn.setBorder(new EmptyBorder(50, 80, 50, 80));
		contentPane.add(panelBtn);
		panelBtn.setLayout(new GridLayout(4, 1, 0, 0));
		
		JButton btnchartPC = new JButton("Relatorio de Participa\u00E7\u00E3o por curso");
		btnchartPC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FabricaDeGraficos fabricaDeGraficos = new FabricaDeGraficos();
				panel_chart.add(fabricaDeGraficos.creatChatPanelParticipacaoCurso(cursos, part));
				
				
			}
		});
		panelBtn.add(btnchartPC);
		
		JButton btnNewButton = new JButton("Relatorio Participa\u00E7\u00E3o Seguimento");
		panelBtn.add(btnNewButton);
		
		JButton btnNewButton_3 = new JButton("Relatorio Curso");
		panelBtn.add(btnNewButton_3);
		
		JButton btnNewButton_2 = new JButton("Relatorio Media Temas");
		panelBtn.add(btnNewButton_2);
	}

}
