package br.gov.pf.model.service;

import br.gov.pf.model.Gun;
import br.gov.pf.model.dao.GunDAO;


public class GunService extends AbstractService<Integer, Gun>{
     
    public GunService(){
        dao = new GunDAO();
    }   
}
