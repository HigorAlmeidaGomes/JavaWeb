package com.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.web.model.Produto;
import com.web.util.FabricaConexao;

public class ProdutoDAO {

	private static final String INSERT_INTO = "INSERT INTO PRODUTO (NOME,DESCRICAO,QUANTIDADE,VALOR) VALUES (?,?,?,?)";
	private static final String CONSULTAR_SQL = "SELECT * FROM PRODUTO WHERE DESCRICAO LIKE ?";
	private static final String CONSULTAR_SQL_ID = "SELECT * FROM PRODUTO WHERE PRODUTO_COD = ?";
	private static final String LISTAR_SQL = "SELECT * FROM PRODUTO";
	private static final String UPDATE_SQL = "UPDATE PRODUTO SET NOME = ?, DESCRICAO = ?, QUANTIDADE = ?, VALOR = ? WHERE PRODUTO_COD = ?";

	public void inserirProduto(Produto produto) {
		try (Connection conex = FabricaConexao.getConexao()) {
			PreparedStatement inserir = conex.prepareStatement(INSERT_INTO);
			inserir.setString(1, produto.getNome());
			inserir.setString(2, produto.getDescricao());
			inserir.setDouble(3, produto.getQuantidade());
			inserir.setDouble(4, produto.getValor());
			inserir.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public ArrayList<Produto> consultar(String descricao) {
		ArrayList<Produto> listar = new ArrayList<Produto>();
		try (Connection conexao = FabricaConexao.getConexao();
				PreparedStatement consulta = conexao.prepareStatement(CONSULTAR_SQL);) {
			consulta.setString(1, "%" + descricao.toUpperCase() + "%");

			ResultSet resultado = consulta.executeQuery();

			while (resultado.next()) {
				Produto produto = new Produto();
				produto.setCodigo(resultado.getInt("PRODUTO_COD"));
				produto.setNome(resultado.getString("NOME"));
				produto.setDescricao(resultado.getString("DESCRICAO"));
				produto.setQuantidade(resultado.getDouble("QUANTIDADE"));
				produto.setValor(resultado.getDouble("Valor"));
				listar.add(produto);
			}
			resultado.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listar;
	}

	public ArrayList<Produto> listarTodos() {
		ArrayList<Produto> listar = new ArrayList<Produto>();
		try (Connection conexao = FabricaConexao.getConexao();
				PreparedStatement consulta = conexao.prepareStatement(LISTAR_SQL);) {

			ResultSet resultado = consulta.executeQuery();

			while (resultado.next()) {
				Produto produto = new Produto();
				produto.setCodigo(resultado.getInt("PRODUTO_COD"));
				produto.setNome(resultado.getString("NOME"));
				produto.setDescricao(resultado.getString("DESCRICAO"));
				produto.setQuantidade(resultado.getDouble("QUANTIDADE"));
				produto.setValor(resultado.getDouble("Valor"));
				listar.add(produto);
			}
			resultado.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listar;
	}

	public void updateProduto(Produto produto) {
		try (Connection conexao = FabricaConexao.getConexao()) {
			PreparedStatement consultar = conexao.prepareStatement(UPDATE_SQL);
			consultar.setString(1, produto.getNome());
			consultar.setString(2, produto.getDescricao());
			consultar.setDouble(3, produto.getQuantidade());
			consultar.setDouble(4, produto.getValor());
			consultar.setInt(5, produto.getCodigo());

			consultar.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public Produto consultar(int id) {
		Produto produto = new Produto();
		try (Connection conexao = FabricaConexao.getConexao();
				PreparedStatement consulta = conexao.prepareStatement(CONSULTAR_SQL_ID);) {
			consulta.setInt(1, id);

			ResultSet resultado = consulta.executeQuery();

			if (resultado.next()) {
				produto.setCodigo(resultado.getInt("PRODUTO_COD"));
				produto.setNome(resultado.getString("NOME"));
				produto.setDescricao(resultado.getString("DESCRICAO"));
				produto.setQuantidade(resultado.getDouble("QUANTIDADE"));
				produto.setValor(resultado.getDouble("Valor"));
			}
			resultado.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return produto;
	}

}
