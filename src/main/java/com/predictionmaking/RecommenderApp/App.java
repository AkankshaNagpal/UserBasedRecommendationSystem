package com.predictionmaking.RecommenderApp;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.ThresholdUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.UserBasedRecommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
    	DataModel model = new FileDataModel(new File("data/review.csv"));
    	
    	UserSimilarity similarity = new PearsonCorrelationSimilarity(model);
    	
    	UserNeighborhood neighborhood = new ThresholdUserNeighborhood(0.1, similarity, model);
    	
    	UserBasedRecommender recommender 
    	                   = new GenericUserBasedRecommender(model, neighborhood, similarity);
    	
    	for(long i =1; i< 400000; i++)
    	{
    	System.out.println("\n");
    	System.out.println("Recommendation for user " + i + ":" );
    	List<RecommendedItem> recommendations = recommender.recommend(i,5);
    	for (RecommendedItem recommendation : recommendations) {
    	 System.out.println(recommendation);
    	}
    	}
    }
}
