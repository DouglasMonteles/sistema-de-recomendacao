package com.sistema.recomendacao;

import java.io.IOException;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.eval.RecommenderEvaluator;
import org.apache.mahout.cf.taste.impl.eval.AverageAbsoluteDifferenceRecommenderEvaluator;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.common.RandomUtils;

public class Avaliador {

	public static void main(String[] args) throws IOException, TasteException {
		
		RandomUtils.useTestSeed();
		
		DataModel model = new Recomendador().getModeloDeFilmes();
		RecommenderEvaluator evaluator = new AverageAbsoluteDifferenceRecommenderEvaluator();
		RecomendadorBuilder builder = new RecomendadorBuilder();
		
		double error = evaluator.evaluate(builder, null, model, 0.9, 1.0);
		
		System.out.println("A taxa de erro do sistema de recomendação é: " + error);
		
	}
	
}
