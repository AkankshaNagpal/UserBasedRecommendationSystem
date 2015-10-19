# UserBasedRecommendationSystem
This project provides user based recommendation system on the basis of similar users. Apache Mahout Library is used for developing collaboration based recommendation

The idea behind this approach is that when we want to compute recommendations for a particular users, we look for other users with a similar taste and pick the 
recommendations from their items. For finding similar users, we have to compare their interactions. There are several methods for doing this. 

For this project, the correlation coefficient is being computed for comparing their interactions

#Input
Input file had more than 1.5 million records and size was approximately 1.5 GB.
We have used hadoop map reduce to reduce the input file data to get only relevant data.

Using Map Reduce we have performed mapping of userID and Business Id to required "long" format.

After performing, data transformation, we have used File writer to generate a CSV from dataset and provided that as input
to the Recommendation Model.

# Output

After performing required compution, Model will provide recommedation for users using Content Based Collaboration Model.

#Library Used:
Apache Mahout
JSONParser




