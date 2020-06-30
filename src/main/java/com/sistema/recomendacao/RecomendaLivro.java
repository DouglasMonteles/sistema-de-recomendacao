package com.sistema.recomendacao;

import java.io.IOException;
import java.util.List;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;

public class RecomendaLivro {

	public static void main(String[] args) throws IOException, TasteException {
		
		DataModel livros = new Recomendador().getModeloLivros();
		Recommender recommender = new RecomendadorBuilder().buildRecommender(livros);
		
		System.out.println("Usuário 04");
		
		List<RecommendedItem> recommendations = recommender.recommend(4, 4); // id do usuario e qtd de recomendacoes
		
		for (RecommendedItem it : recommendations) {
			System.out.println("Usuário 01, estes livros combinam com você: ");
			System.out.println(it);
		}
		
	}
	
}
