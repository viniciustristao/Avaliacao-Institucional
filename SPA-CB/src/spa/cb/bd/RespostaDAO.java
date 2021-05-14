package spa.cb.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import spa.cb.pesquisa.Pesquisa;
import spa.cb.segacademico.Academico;

public class RespostaDAO {
	public static void insertResposta(String pesquisa, Academico academico, String respostas) {
		
		Connection con = ConnectBd.getConexao();

		String sql = (academico.getCurso()!=null) ? "insert into respostas(pesquisa, seguimento, campus, curso, respostas) values (?,?,?,?,?)":
	 				"insert into respostas(pesquisa,seguimento, campus, respostas) values (?,?,?,?)";
		PreparedStatement statement;
		try {
			statement = con.prepareStatement(sql);
			statement.setString(1, pesquisa);
			statement.setString(2, academico.getSeguimento());
			statement.setString(3, academico.getCampus());
			if(academico.getCurso()!=null) {
				statement.setString(4, academico.getCurso());
				statement.setString(5, respostas);
			}else
				statement.setString(4, respostas);
			
			statement.execute();
			statement.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}// insertans
	
public static void insertQuest(String pesquisa, String quests) {
		
		Connection con = ConnectBd.getConexao();

		String sql ="insert into temas(pesquisa, temas) values (?,?)";
		PreparedStatement statement;
		try {
			statement = con.prepareStatement(sql);
			statement.setString(1, pesquisa);
			statement.setString(2, quests);
			
			statement.execute();
			statement.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//insertquest

	public static String getTemasPesquisaDAO(String nomePesquisa) {
		Connection con = ConnectBd.getConexao();
		StringBuilder temas = new StringBuilder();
		try {
			PreparedStatement statement = con.prepareStatement("select * from temas where pesquisa = '"+nomePesquisa+"'");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				temas.append(rs.getString("temas"));				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temas.toString();
	}
	
	public static String getRespostasPesquisaDAO(String nomePesquisa) {
		Connection con = ConnectBd.getConexao();
		StringBuilder respostas = new StringBuilder();
		try {
			PreparedStatement statement = con.prepareStatement("select * from respostas where pesquisa = '"+nomePesquisa+"'");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				respostas.append(rs.getString("seguimento")).append(";");
				respostas.append(rs.getString("campus")).append(";");
				respostas.append(rs.getString("curso")).append(";");
				respostas.append(rs.getString("respostas")).append("\n");				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return respostas.toString();
	}
}
