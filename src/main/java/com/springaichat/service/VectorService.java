package com.springaichat.service;

import java.util.List;

import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.stereotype.Service;

@Service
public class VectorService {

	private final VectorStore vectorStore;

	public VectorService(VectorStore vectorStore) {
		this.vectorStore = vectorStore;
	}

	public void loadData() {

		List<Document> documents = List.of(

				new Document("Employees can apply for annual leave through the HR portal."),

				new Document("Employees can reset their password using the Forgot Password option."),

				new Document("Employees can view salary slips from the Payroll section."));

		vectorStore.add(documents);
	}

	public List<Document> search(String question) {

		return vectorStore.similaritySearch(SearchRequest.builder().query(question).topK(1).build());
	}
}
