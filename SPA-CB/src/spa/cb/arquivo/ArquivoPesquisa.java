package spa.cb.arquivo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class ArquivoPesquisa{
	private String path,name,content = new String();
	private BufferedReader myBuffer;

	public ArquivoPesquisa() {
		
	}

	public ArquivoPesquisa(String path, String name) {
		super();
		this.path = path;
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	/*
	 * public void readContent() { try { content = ler(); } catch (IOException e) {
	 * e.printStackTrace(); } }
	 */
	
	public void abrir(String nomeArquivo) throws FileNotFoundException {
		// Abre um arquivo de bytes para realizar a entrada de dados. 
		try {
			myBuffer = new BufferedReader(new InputStreamReader(
					new FileInputStream(nomeArquivo), "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	public void ler() throws IOException {
		String linha = myBuffer.readLine();
		  
		try { // Lê o conteúdo completo do arquivo.
			while (linha!=null) {
				content += linha + "\n";
		    	linha = myBuffer.readLine();
		    }
		} catch (Exception e) {
			throw new IOException();
		}
	} 

	@Override
	public String toString() {
		return String.format("Arquivo Path: %s, Name: %s,\n\tcontent=[%s]", path, name, content);
	}
	
	
	
	
}
