package br.gov.pf.util;

import br.gov.pf.security.PassGeneretor;

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
 * http://localhost:8080/sinarm/api/guns
 * http://localhost:8080/sinarm/api/clients
 * http://localhost:8080/sinarm/api/examinators
 */