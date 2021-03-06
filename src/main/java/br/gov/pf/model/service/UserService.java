package br.gov.pf.model.service;

import br.gov.pf.model.dao.AbstractDAO;
import br.gov.pf.model.dao.UserDAO;
import br.gov.pf.model.entity.Address;
import br.gov.pf.model.entity.User;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sartori on 13/07/17.
 */
@Stateless
public class UserService extends AbstractService<Long, User> {
    @Inject
    private UserDAO dao;

    @Inject
    private UserRoleService roleService;

    @Inject
    private AddressService addressService;

    @Override
    public AbstractDAO<Long, User> getDAO() {
        return this.dao;
    }

    @Override
    public User save(User entity) throws Exception {
        if (entity.getRole() == null)
            entity.setRole(roleService.getByProperty("description", "CIVIL"));
        if (entity.getAddressList() == null) {
            return super.save(entity);
        } else {
            User temp = entity;
            List<Address> addresses = entity.getAddressList();
            temp.setAddressList(null);
            User user = super.save(temp);
            User finalUser = getById(user.getId());
            List<Address> addressesList = new ArrayList<>();
            addresses.forEach(value ->{
                try {
                    addressesList.add(addressService.save(value));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            finalUser.setAddressList(addressesList);
            return super.update(finalUser);
        }
    }

    @Override
    public User update(User entity) throws Exception {

        return super.update(entity);
    }
}
