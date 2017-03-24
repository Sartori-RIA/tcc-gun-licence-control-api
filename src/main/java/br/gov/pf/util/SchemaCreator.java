package br.gov.pf.util;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Persistence;

public class SchemaCreator {

	public static void main(String[] args) {
		
		SchemaCreator schemaCreator = new SchemaCreator();
		
		Persistence.generateSchema("sinarm", null);
				
	}
	
	
}
/** CRIAR AUTOMATICAMENTE AS TABELAS */