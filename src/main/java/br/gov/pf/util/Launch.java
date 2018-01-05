package br.gov.pf.util;


import br.gov.pf.model.entity.Sex;
import br.gov.pf.model.entity.User;
import br.gov.pf.model.entity.UserRole;
import br.gov.pf.model.service.GenderService;
import br.gov.pf.model.service.UserRoleService;
import br.gov.pf.model.service.UserService;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

@Singleton
@Startup
public class Launch {

    @Inject
    private GenderService genderService;

    @Inject
    private UserRoleService userRoleService;

    @Inject
    private UserService userService;

    @PostConstruct
    public void init() {
        try {
            new Thread(() -> {
                try {
                    Launch.this.genderService.save(new Sex("Masculino", "M"));
                    Launch.this.genderService.save(new Sex("Feminino", "F"));
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

