package br.gov.pf.util;


import br.gov.pf.model.service.*;

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

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

