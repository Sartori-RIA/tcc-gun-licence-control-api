package br.gov.pf.util;

import javax.persistence.Persistence;

public class SchemaCreator {

	public static void main(String[] args) {
		
		SchemaCreator schemaCreator = new SchemaCreator();
		
		Persistence.generateSchema("sinarm", null);
				
	}
	
	
}
/** CRIAR AUTOMATICAMENTE AS TABELAS */

/**
 * URL
 * http://localhost:8080/api/guns
 * http://localhost:8080/api/clients
 * http://localhost:8080/api/examinators
 */