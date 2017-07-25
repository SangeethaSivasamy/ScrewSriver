package com.nosql.mongodb;


import java.util.ArrayList;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.DB;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

public class MongoDBConnectionUtility {
	private MongoClient mongoClient;
	private MongoDatabase mongoDatabase;
	private MongoCollection<Document> mongoCollection;

	public void getConnection() {
		mongoClient = new MongoClient("18.220.18.131",27017);
	}

	public void getDatabase(String databaseName) {
		mongoDatabase = mongoClient.getDatabase(databaseName);
	}

	public void getCollection(String collectionName) {
		mongoCollection = mongoDatabase.getCollection(collectionName);
	}

	public void closeConnection() {
		mongoClient.close();
	}

	public void insertOneDocument(Document document) {
		mongoCollection.insertOne(document);
	}

	public void insertManyDocuments(ArrayList<Document> arrayList) {
		mongoCollection.insertMany(arrayList);
	}

	public long countDocuments() {
		return mongoCollection.count();
	}

	public ArrayList<Document> findAllDocuments() {
		MongoCursor<Document> mongoCursor = mongoCollection.find().iterator();
		ArrayList<Document> arrayList = new ArrayList<Document>();
		try {
			while(mongoCursor.hasNext()) {
				arrayList.add(mongoCursor.next());
			}
		} finally {
			mongoCursor.close();
		}
		return arrayList;
	}

	public ArrayList<Document> findDocumentsWithCriteria(Bson criteria) {
		MongoCursor<Document> mongoCursor = mongoCollection.find(criteria).iterator();
		ArrayList<Document> arrayList = new ArrayList<Document>();
		try {
			while(mongoCursor.hasNext()) {
				arrayList.add(mongoCursor.next());
			}
		} finally {
			mongoCursor.close();
		}
		return arrayList;
	}

	public ArrayList<Document> findDocumentsWithCriteriaAndProjection(Bson criteria,Bson projec) {
		MongoCursor<Document> mongoCursor = mongoCollection.find(criteria).projection(projec).iterator();
		ArrayList<Document> arrayList = new ArrayList<Document>();
		try {
			while(mongoCursor.hasNext()) {
				arrayList.add(mongoCursor.next());
			}
		} finally {
			mongoCursor.close();
		}
		return arrayList;
	}

	public void updateManyDocuments(Bson criteria,Bson newValue) {
		UpdateResult  updateResult = mongoCollection.updateMany(criteria, newValue);
		System.out.println(updateResult);
	}

	public void deleteDocuments(Bson criteria) {
		DeleteResult deleteResult = mongoCollection.deleteMany(criteria);
		System.out.println(deleteResult);
	}

	public void test() {
		Bson filter = Filters.and(Filters.eq("_id",1),Filters.eq("quantity",500));
		MongoCursor<Document> mongoCursor = mongoCollection.find(filter).projection(Projections.exclude("colors","location") ).iterator();
		ArrayList<Document> arrayList = new ArrayList<Document>();
		try {
			while(mongoCursor.hasNext()) {
				//arrayList.add(mongoCursor.next());
				System.out.println(mongoCursor.next());
			}
		} finally {
			mongoCursor.close();
		}
	}
}
