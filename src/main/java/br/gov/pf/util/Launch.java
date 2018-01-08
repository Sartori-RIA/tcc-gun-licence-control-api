package br.gov.pf.util;


import br.gov.pf.model.entity.Gender;
import br.gov.pf.model.entity.User;
import br.gov.pf.model.entity.UserRole;
import br.gov.pf.model.service.GenderService;
import br.gov.pf.model.service.UserRoleService;
import br.gov.pf.model.service.UserService;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import java.util.Date;

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
                    Launch.this.genderService.save(new Gender("Masculino", "M"));
                    Launch.this.genderService.save(new Gender("Feminino", "F"));
                    Launch.this.userRoleService.save(new UserRole("ADMIN"));
                    Launch.this.userRoleService.save(new UserRole("DELEGADO"));
                    Launch.this.userRoleService.save(new UserRole("INSTRUTOR"));
                    Launch.this.userRoleService.save(new UserRole("PSICOLOGO"));
                    Launch.this.userRoleService.save(new UserRole("CIVIL"));

                    User admin = new User();
                    admin.setName("nome do admin");
                    admin.setPassword("123456");
                    admin.setCep("85020530");
                    admin.setStreet("Avenida Cezar Stange");
                    admin.setAddressNumber("104");
                    admin.setCity("Guarapuvava");
                    admin.setComplement("casa");
                    admin.setCpf("111111");
                    admin.setDateOfBirth(new Date());
                    admin.setEmail("email@email.com");
                    admin.setGender(this.genderService.getById(1L));
                    admin.setRole(this.userRoleService.getById(1L));
                    admin.setState("Paraná");
                    admin.setNeighborhood("Boqueirao");


                    User delegado = new User();
                    delegado.setName("nome do delegado");
                    delegado.setPassword("123456");
                    delegado.setCep("85020530");
                    delegado.setStreet("Avenida Cezar Stange");
                    delegado.setAddressNumber("104");
                    delegado.setCity("Guarapuvava");
                    delegado.setComplement("casa");
                    delegado.setCpf("222222");
                    delegado.setDateOfBirth(new Date());
                    delegado.setEmail("email@email.com");
                    delegado.setGender(this.genderService.getById(1L));
                    delegado.setRole(this.userRoleService.getById(2L));
                    delegado.setState("Paraná");
                    delegado.setNeighborhood("Boqueirao");

                    User instrutor = new User();
                    instrutor.setName("nome do instrutor");
                    instrutor.setPassword("123456");
                    instrutor.setStreet("Avenida Cezar Stange");
                    instrutor.setAddressNumber("104");
                    instrutor.setCep("85020530");
                    instrutor.setCity("Guarapuvava");
                    instrutor.setComplement("casa");
                    instrutor.setCpf("333333");
                    instrutor.setDateOfBirth(new Date());
                    instrutor.setEmail("email@email.com");
                    instrutor.setGender(this.genderService.getById(1L));
                    instrutor.setRole(this.userRoleService.getById(3L));
                    instrutor.setState("Paraná");
                    instrutor.setNeighborhood("Boqueirao");

                    User psicologo = new User();
                    psicologo.setName("nome do psicologo");
                    psicologo.setPassword("123456");
                    psicologo.setStreet("Avenida Cezar Stange");
                    psicologo.setAddressNumber("104");
                    psicologo.setCep("85020530");
                    psicologo.setCity("Guarapuvava");
                    psicologo.setComplement("casa");
                    psicologo.setCpf("444444");
                    psicologo.setDateOfBirth(new Date());
                    psicologo.setEmail("email@email.com");
                    psicologo.setGender(this.genderService.getById(1L));
                    psicologo.setRole(this.userRoleService.getById(4L));
                    psicologo.setState("Paraná");
                    psicologo.setNeighborhood("Boqueirao");

                    User client = new User();
                    client.setName("nome do cliente");
                    client.setPassword("123456");
                    client.setStreet("Avenida Cezar Stange");
                    client.setAddressNumber("104");
                    client.setCep("85020530");
                    client.setCity("Guarapuvava");
                    client.setComplement("casa");
                    client.setCpf("555555");
                    client.setDateOfBirth(new Date());
                    client.setEmail("email@email.com");
                    client.setGender(this.genderService.getById(1L));
                    client.setRole(this.userRoleService.getById(5L));
                    client.setState("Paraná");
                    client.setNeighborhood("Boqueirao");

                    Launch.this.userService.save(admin);
                    Launch.this.userService.save(instrutor);
                    Launch.this.userService.save(delegado);
                    Launch.this.userService.save(psicologo);
                    Launch.this.userService.save(client);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

