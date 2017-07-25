package com.nosql.mongodb;

import java.util.ArrayList;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;

public class MongoDBPractice {
	public static void main(String args[]) {
		try {
			MongoDBConnectionUtility mongoDBConnectionUtility = new MongoDBConnectionUtility();
			MongoDBPractice mongoDBPractice = new MongoDBPractice();

			mongoDBConnectionUtility.getConnection();
			mongoDBConnectionUtility.getDatabase("san_database");
			mongoDBConnectionUtility.getCollection("newstore");

			/****************************Insert************************/
			//To insert one document
			Document document = mongoDBPractice.buildOneDocument();
			mongoDBConnectionUtility.insertOneDocument(document);

			//To insert many documents
			ArrayList<Document> arrayList = mongoDBPractice.buildManyDocuments();
			mongoDBConnectionUtility.insertManyDocuments(arrayList);

			//To get count of documents in a Collection
			long count = mongoDBConnectionUtility.countDocuments();
			System.out.println("Count of documents : "+count);


			/******************************Find***********************/
			Bson filter;
			ArrayList<Document> arrListResultDocuments = new ArrayList<Document>();

			//Query all documents from collection
			ArrayList<Document>  arrListAllDocuments = mongoDBConnectionUtility.findAllDocuments();
			System.out.println("All Documents:");
			for(Document d:arrListAllDocuments) System.out.println(d.toJson());

			//Query all documents with one equalto condition
			System.out.println("All Documents(with item rice):");
			filter = Filters.eq("item", "rice");

			//Query all documents with one notequalto condition
			System.out.println("All Documents(without item rice):");
			filter = Filters.ne("item", "rice");

			//Query all documents with one greater than condition
			System.out.println("All Documents(with quantity > 10):");
			filter = Filters.gt("quantity", 10);

			//Query all documents with one less than condition
			System.out.println("All Documents(with quantity < 100):");
			filter = Filters.lt("quantity", 100);

			//Query all documents with one greaterthanequalto condition
			System.out.println("All Documents(with quantity >= 10):");
			filter = Filters.gte("quantity", 10);

			//Query all documents with one lessthanequalto condition
			System.out.println("All Documents(with quantity <= 5):");
			filter = Filters.lte("quantity", 5);

			//Query all documents with in condition
			System.out.println("All Documents(with quantity in 5,10,50):");
			filter = Filters.in("quantity", 5,10,50);//Method 1
			ArrayList<Integer> values = new ArrayList<Integer>();
			values.add(5);
			values.add(10);
			values.add(50);
			filter = Filters.in("quantity", values);//Method 2

			//Query all documents with not in condition
			System.out.println("All Documents(with quantity not in 5,10,50):");
			filter = Filters.nin("quantity", 5,10,50);

			//Query all documents with and condition
			System.out.println("All Documents(with quantity not in 5,10,50 and item pepper):");
			filter = Filters.and(Filters.nin("quantity",5,10,50),Filters.eq("item","pepper"));//Method 1
			Bson f1 = Filters.nin("quantity", 5,10,50);
			Bson f2 = Filters.eq("item", "pepper");
			ArrayList<Bson> filters = new ArrayList<Bson>();
			filters.add(f1);
			filters.add(f2);
			filter = Filters.and(filters);//Method 2

			//Query all documents with condition on embedded array object
			System.out.println("");
			f1 = Filters.eq("city", "SanDiego");
			filter = Filters.elemMatch("location", f1);



			arrListResultDocuments = mongoDBConnectionUtility.findDocumentsWithCriteria(filter);
			for(Document d:arrListResultDocuments) System.out.println(d.toJson());

			//Query documents with projection
			filter = Filters.eq("item","rice");
			Bson projection = Projections.exclude("colors","location");
			arrListResultDocuments = mongoDBConnectionUtility.findDocumentsWithCriteriaAndProjection(filter, projection);
			for(Document d:arrListResultDocuments) System.out.println(d.toJson());

			/*******************************************Update*************************/
			Bson criteria = Filters.eq("item","rice");
			Bson newValue = new Document("quantity",500);
			Document updatedDocument = new Document("$set",newValue);
			mongoDBConnectionUtility.updateManyDocuments(criteria, updatedDocument);

			/**********************************************Delete***********************/
			filter = Filters.eq("item","pepper");
			mongoDBConnectionUtility.deleteDocuments(filter);

			//mongoDBConnectionUtility.test();

			mongoDBConnectionUtility.closeConnection();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public Document buildOneDocument() {
		Document document = new Document();
		document.put("_id", 1);
		document.put("item", "rice");
		document.put("quantity", 10);

		ArrayList<String> arrColors = new ArrayList<String>();
		arrColors.add("white");
		arrColors.add("brown");
		document.put("colors", arrColors);

		ArrayList<Document> arrAddressList = new ArrayList<Document>();
		Document address1 = new Document();
		address1.put("city", "DogCity");
		address1.put("buildingno", "622");
		address1.put("state", "AA");

		Document address2 = new Document();
		address2.put("city", "Gillroy");
		address2.put("buildingno", "711");
		address2.put("state", "AA");

		arrAddressList.add(address1);
		arrAddressList.add(address2);

		document.put("location", arrAddressList);

		return document;
	}

	public ArrayList<Document> buildManyDocuments() {
		Document document = new Document();
		document.put("_id", 2);
		document.put("item", "nailpolish");
		document.put("quantity", 10);
		ArrayList<String> arrColors = new ArrayList<String>();
		arrColors.add("green");
		arrColors.add("red");
		document.put("colors", arrColors);
		ArrayList<Document> arrAddressList = new ArrayList<Document>();
		Document address1 = new Document();
		address1.put("city", "DogCity");
		address1.put("buildingno", "101");
		address1.put("state", "AA");
		Document address2 = new Document();
		address2.put("city", "Gillroy");
		address2.put("buildingno", "711");
		address2.put("state", "OR");
		arrAddressList.add(address1);
		arrAddressList.add(address2);
		document.put("location", arrAddressList);

		Document document1 = new Document();
		document1.put("_id", 3);
		document1.put("item", "salt");
		document1.put("quantity", 100);

		ArrayList<Document> arrayList = new ArrayList<Document>();
		arrayList.add(document);
		arrayList.add(document1);

		return arrayList;
	}
}