package br.gov.pf.resource;

import javax.ws.rs.Path;

import br.gov.pf.model.Gun;
import br.gov.pf.model.service.GunService;
import org.apache.log4j.Logger;



@Path("/guns")
public class GunResource extends AbstractResource<Integer, Gun>{
	
	private static final Logger LOGGER = Logger.getLogger(GunResource.class);

	public GunResource() {
		service = new GunService();
	}
	
}
