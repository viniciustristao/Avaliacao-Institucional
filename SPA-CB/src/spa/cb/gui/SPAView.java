package spa.cb.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import spa.cb.arquivo.ArquivoPesquisa;
import spa.cb.arquivo.ParserFile;
import spa.cb.bd.RespostaDAO;
import spa.cb.pesquisa.Pesquisa;
import spa.cb.relatorios.ConceitoMedioAcademicos;
import spa.cb.relatorios.ConceitoMedioDiscentes;
import spa.cb.relatorios.ParticipacaoCurso;
import spa.cb.relatorios.ParticipacaoSeguimento;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JTextField;

public class SPAView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Pesquisa pesquisa;
	private JTextField tfNomeCarregar;
	private JTextField tfNomeImportar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		iniciar();
	}

	private static void iniciar() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SPAView frame = new SPAView();
					frame.setTitle("Search Report");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SPAView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 239);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 120, 5, 120));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(8, 4, 0, 0));
		
		tfNomeImportar = new JTextField();
		tfNomeImportar.setToolTipText("Insira a pesquisa que deseja importar.");
		contentPane.add(tfNomeImportar);
		tfNomeImportar.setColumns(10);
		
		JButton btnImportar = new JButton("Importar");
		btnImportar.setToolTipText("Importar pesquisa");
		contentPane.add(btnImportar);
		importFile(btnImportar);
		
		tfNomeCarregar = new JTextField();
		tfNomeCarregar.setToolTipText("Insira a pesquisa que deseja carregar.");
		contentPane.add(tfNomeCarregar);
		tfNomeCarregar.setColumns(10);
		
		
		JButton btnLoadSearch = new JButton("Carregar Pesquisa");
		btnLoadSearch.setToolTipText("Carregar Pesquisa");
		contentPane.add(btnLoadSearch);
		loadShearch(btnLoadSearch);
	}
	
	/**
	 * carrega para a memoria uma pesquisa do banco de dados
	 * @param btnLoadSearch
	 */
	private void loadShearch(JButton btnLoadSearch) {
		btnLoadSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String nomePesq = tfNomeCarregar.getText();
				if(nomePesq!=null) {
					pesquisa = new Pesquisa(nomePesq);
	
					ParserFile.parserQuestions(2,pesquisa, RespostaDAO.getTemasPesquisaDAO(pesquisa.getNome()));
					
					ParserFile.parserAnswers(2,pesquisa, RespostaDAO.getRespostasPesquisaDAO("asd").split("\n"));
					
					ArrayList<String> cursos = new ParticipacaoCurso().getCursos(pesquisa);
					ArrayList<Integer> part = new ParticipacaoCurso().getNPartCurso(cursos, pesquisa.getTemas().get(0).getRespostas());
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								PesquisaView frame = new PesquisaView(cursos, part);
								frame.setTitle("Pesquisa:"+nomePesq);
								frame.setExtendedState(MAXIMIZED_BOTH);
								frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
	
					//int pos = 0;
					
					//new ConceitoMedioDiscentes().conceitoMedioDiscentes(pesquisa, "Bacharelado", cursos);
					//new ConceitoMedioDiscentes().conceitoMedioDiscentes(pesquisa, "Licenciatura", cursos);
					//new ConceitoMedioDiscentes().conceitoMedioDiscentes(pesquisa, "Tec", cursos);
					//new ConceitoMedioAcademicos().conceitoMedioAcamedicos(pesquisa);
					
					/*
					String seguimentos[] = {"discente", "docente", "técnico administrativo"};
					int parti[] = new ParticipacaoSeguimento().getNPartSeguimento(pesquisa.getTemas().get(0).getRespostas(), seguimentos);
					for (int i = 0; i < seguimentos.length; i++) {
						System.out.printf("%s: %d\n", seguimentos[i], parti[i]);
					}*/
					
					/*
					for (String curso : cursos) {
						System.out.printf("Curso: %s -- Participação: %d\n\n",curso,part.get(pos));
						pos++;
					}*/
					
					/*
					for (Tema tema : pesquisa.getTemas()) {
						System.out.println(tema.getTema());
						//for (int i = 0; i < tema.getRespostas().size(); i++) {
						for (int i = 0; i < 5; i++) {
							System.out.println(tema.getRespostas().get(i));
						}
					}*/
					tfNomeCarregar.setText("");
				}else
					JOptionPane.showMessageDialog(null, "Você deve inserir um nome para a pesquisa", "Carregar Pesquisa", JOptionPane.ERROR_MESSAGE);
			}
		});  
	}

	/**
	 * Importa um arquivo texto para o programa
	 * @param btnImportar
	 */
	private void importFile(JButton btnImportar) {
		btnImportar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String nomePesq = tfNomeImportar.getText();
				if(nomePesq!=null) {
					ArquivoPesquisa arquivoPesquisa = getArquivoPesquisa();
					if(arquivoPesquisa!=null) {	
						try {
							arquivoPesquisa.abrir(arquivoPesquisa.getPath()+arquivoPesquisa.getName());
							arquivoPesquisa.ler();
							pesquisa = new Pesquisa(nomePesq);
							
							///mudar de lugar
							ParserFile.parserQuestions(1,pesquisa, arquivoPesquisa.getContent().split("\n")[0]);
							ParserFile.parserAnswers(1,pesquisa, arquivoPesquisa.getContent().substring(arquivoPesquisa.getContent().indexOf("\n")).split("\n"));
							
							
						} catch (FileNotFoundException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}//trycatch
					}//if
					tfNomeImportar.setText("");
				}else
					JOptionPane.showMessageDialog(null, "Você deve inserir um nome para a pesquisa", "Importar Pesquisa", JOptionPane.ERROR_MESSAGE);
			}//action performed
		});//action listener
		
	}

	
	/**
	 * Abre um jfilechooser e caso aruivo valido seja selecionado
	 * retorna uma arquivo pesquisa caso contrario retorna null 
	 * @return
	 */
	public ArquivoPesquisa getArquivoPesquisa() {
		String name,path;
		int optFile;
		JFileChooser fileChooser = new JFileChooser();
		optFile = fileChooser.showOpenDialog(null);
		if(optFile == JFileChooser.APPROVE_OPTION) {
			int posSeparador;
			File file = fileChooser.getSelectedFile();
			posSeparador = file.getAbsolutePath().lastIndexOf(File.separatorChar)+1;
			
			path = file.getAbsolutePath().substring(0, posSeparador);
			name = file.getAbsolutePath().substring(posSeparador);
			return new ArquivoPesquisa(path, name);
		}
		
		return null;
	}//getArquivoPesqusa

}
