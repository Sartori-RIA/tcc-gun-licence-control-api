package br.gov.pf.util;


import br.gov.pf.model.entity.Sex;
import br.gov.pf.model.entity.UserRole;
import br.gov.pf.model.service.SexService;
import br.gov.pf.model.service.UserRoleService;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

@Singleton
@Startup
public class Launch {

    @Inject
    private SexService sexService;

    @Inject
    private UserRoleService userRoleService;

    @PostConstruct
    public void init() {
        try {
            new Thread(() -> {
                try {
                    Launch.this.sexService.save(new Sex("Masculino", "M"));
                    Launch.this.sexService.save(new Sex("Feminino", "F"));
                    Launch.this.userRoleService.save(new UserRole("ADMIN"));
                    Launch.this.userRoleService.save(new UserRole("INSTRUTOR"));
                    Launch.this.userRoleService.save(new UserRole("PSICOLOGO"));
                    Launch.this.userRoleService.save(new UserRole("CLIENT"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

