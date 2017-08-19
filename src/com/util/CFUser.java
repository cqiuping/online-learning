package com.util;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.common.LongPrimitiveIterator;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.EuclideanDistanceSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;
import org.apache.mahout.math.hadoop.similarity.cooccurrence.measures.PearsonCorrelationSimilarity;

import com.po.User;


/**
 * @author qiuping
 * 
 *
 */
public class CFUser {
	public int[] CFRes(int uid) throws IOException, TasteException {
		final int NEIGHBORHOOD_NUM = 2;
		final int RECOMMENDER_NUM = 3;
		String file = "F://myeclipsework/imooc2/WebRoot/data/user_course.csv";
		DataModel model = new FileDataModel(new File(file));
		UserSimilarity user = new EuclideanDistanceSimilarity(model);// 得到所有用户之间的欧几里得距离
		NearestNUserNeighborhood neighbor = new NearestNUserNeighborhood(
				NEIGHBORHOOD_NUM, user, model);// 找出所有用户的NUM个邻居user
		Recommender r = new GenericUserBasedRecommender(model, neighbor, user);// 得到推荐界面
		LongPrimitiveIterator iter = model.getUserIDs();
		int[] res = null;
		List<RecommendedItem> list = r.recommend(uid, RECOMMENDER_NUM);// 对uid对应的用户推荐R_NUM个item
		if (list.size() > 0) {
			res = new int[list.size()];
			System.out.printf("uid:%s", uid);
			for (int i = 0; i < list.size(); i++) {
				res[i] = (int) list.get(i).getItemID();
				System.out.printf("(%s,%f)", list.get(i).getItemID(), list.get(i).getValue());
			}
			System.out.println();
			return res;
		} else
			return null;
	}
}
