package br.gov.pf.util;


import br.gov.pf.model.entity.*;
import br.gov.pf.model.service.*;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import java.util.ArrayList;
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

    @Inject
    private CountryService countryService;
    @Inject
    private StateService stateService;
    @Inject
    private CityService cityService;
    @Inject
    private AddressService addressService;

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

                    Launch.this.countryService.save(new Country("Brasil"));

                    Launch.this.stateService.save(new State("Paraná", "PR", this.countryService.getById(1L)));
                    Launch.this.stateService.save(new State("Rio Grande do Sul", "RS", this.countryService.getById(1L)));
                    Launch.this.stateService.save(new State("Santa Catarina", "SC", this.countryService.getById(1L)));

                    Launch.this.cityService.save(new City("Guarapuava", this.stateService.getById(1L)));
                    Launch.this.cityService.save(new City("Foz do Iguaçu", this.stateService.getById(1L)));
                    Launch.this.cityService.save(new City("Garuva", this.stateService.getById(3L)));
                    Launch.this.cityService.save(new City("Blumenau", this.stateService.getById(3L)));
                    Launch.this.cityService.save(new City("Porto Alegre", this.stateService.getById(2L)));

                    Address address = new Address();
                    address.setAddressNumber("104");
                    address.setCity(this.cityService.getById(1L));
                    address.setCep("85020-530");
                    address.setStreet("Avenida Cezar Stange");
                    address.setComplement("casa");
                    address.setNeighborhood("Boqueirao");
                    this.addressService.save(address);

                    ArrayList<Address> addressArrayList = new ArrayList();
                    addressArrayList.add(this.addressService.getById(1L));
                    User admin = new User();
                    admin.setName("nome do admin");
                    admin.setPassword("123456");
                    admin.setAddressList(addressArrayList);
                    admin.setCpf("10150393911");
                    admin.setDateOfBirth(new Date());
                    admin.setEmail("email@email.com");
                    admin.setGender(this.genderService.getById(1L));
                    admin.setRole(this.userRoleService.getById(1L));

                    User delegado = new User();
                    delegado.setName("nome do delegado");
                    delegado.setPassword("123456");
                    delegado.setAddressList(addressArrayList);
                    delegado.setCpf("10150393911");
                    delegado.setDateOfBirth(new Date());
                    delegado.setEmail("email@email.com");
                    delegado.setGender(this.genderService.getById(1L));
                    delegado.setRole(this.userRoleService.getById(2L));

                    User instrutor = new User();
                    instrutor.setName("nome do instrutor");
                    instrutor.setPassword("123456");
                    instrutor.setAddressList(addressArrayList);
                    instrutor.setCpf("10150393911");
                    instrutor.setDateOfBirth(new Date());
                    instrutor.setEmail("email@email.com");
                    instrutor.setGender(this.genderService.getById(1L));
                    instrutor.setRole(this.userRoleService.getById(3L));

                    User psicologo = new User();
                    psicologo.setName("nome do psicologo");
                    psicologo.setPassword("123456");
                    psicologo.setAddressList(addressArrayList);
                    psicologo.setCpf("10150393911");
                    psicologo.setDateOfBirth(new Date());
                    psicologo.setEmail("email@email.com");
                    psicologo.setGender(this.genderService.getById(1L));
                    psicologo.setRole(this.userRoleService.getById(4L));

                    User client = new User();
                    client.setName("nome do cliente");
                    client.setPassword("123456");
                    client.setAddressList(addressArrayList);
                    client.setCpf("10150393911");
                    client.setDateOfBirth(new Date());
                    client.setEmail("email@email.com");
                    client.setGender(this.genderService.getById(1L));
                    client.setRole(this.userRoleService.getById(5L));

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

