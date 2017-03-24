package br.gov.pf.model.service;

import br.gov.pf.model.dao.AbstractDAO;
import br.gov.pf.util.JPAUtil;

import java.util.List;


public class AbstractService<PK, T> {
	
	protected AbstractDAO<PK, T> dao;
	
	public void save(T entity){
        try{
            JPAUtil.beginTransaction();
            dao.save(entity);            
            JPAUtil.commit();
            
        }
        catch(Exception e){
        	e.printStackTrace();
            JPAUtil.rollBack();
        }
        finally{
			JPAUtil.closeEntityManager();
		}
    }
	
	public void update(T entity){
        try{
            JPAUtil.beginTransaction();            
            dao.update(entity);
            JPAUtil.commit();
        }
        catch(Exception e){            
            JPAUtil.rollBack();
        }
        finally{
			JPAUtil.closeEntityManager();
		}
    }
	
	public void delete(T entity){
        try{
            JPAUtil.beginTransaction();            
            dao.delete(entity);
            JPAUtil.commit();
        }
        catch(Exception e){            
            JPAUtil.rollBack();
        }
        finally{
			JPAUtil.closeEntityManager();
		}
    }
	
	public void deleteById(PK pk){
		T entity = null;
		try{
            JPAUtil.beginTransaction();
            entity = dao.getById(pk);
            dao.delete(entity);
            JPAUtil.commit();
        }
        catch(Exception e){            
            JPAUtil.rollBack();
        }
        finally{
			JPAUtil.closeEntityManager();
		}
    }
	
	public T getById(PK pk){
		T entity = null;
		
		try{
            JPAUtil.beginTransaction();            
            entity = dao.getById(pk);
            JPAUtil.commit();
        }
        catch(Exception e){            
            JPAUtil.rollBack();
        }
        finally{
			JPAUtil.closeEntityManager();
		}
		
		return entity;
	}
	
	public T getByProperty(String propertyName, String propertyValue){
		T entity = null;		
		try{
            JPAUtil.beginTransaction();            
            entity = dao.getByProperty(propertyName, propertyValue);
            JPAUtil.commit();
        }
        catch(Exception e){            
            JPAUtil.rollBack();
            e.printStackTrace();
        }
        finally{
			JPAUtil.closeEntityManager();
		}			
		
		return entity;
	}
	
	public T getByTwoProperties(String firstPropertyName, String firstPropertyValue, String secondPropertyName, String secondPropertyValue){
		T entity = null;		
		try{
            JPAUtil.beginTransaction();            
            entity = dao.getByTwoProperties(firstPropertyName, firstPropertyValue, secondPropertyName, secondPropertyValue);
            JPAUtil.commit();
        }
        catch(Exception e){            
            JPAUtil.rollBack();
            e.printStackTrace();
        }
        finally{
			JPAUtil.closeEntityManager();
		}			
		
		return entity;
	}
	
	public List<T> listByProperty(String propertyName, String propertyValue){
		List<T> entity = null;		
		try{
            JPAUtil.beginTransaction();            
            entity = dao.listByProperty(propertyName, propertyValue);
            JPAUtil.commit();
        }
        catch(Exception e){            
            JPAUtil.rollBack();
            e.printStackTrace();
        }
        finally{
			JPAUtil.closeEntityManager();
		}			
		
		return entity;
	}
	
	public List<T> findAll(){
        return dao.findAll();
    }
}
