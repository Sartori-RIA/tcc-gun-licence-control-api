package br.gov.pf.model;

/**
 * Created by sartori on 13/05/17.
 */
public class User {
    private String name;
    private String sex;
    private String Address;
    private String dateOfBirth;
    private String cpf;
    private String cep;
    private String city;
    private String neighborhood;
    private String addressNumber;
    private String passwd;
    private String type;

    public User() {
    }

    public User(String name, String sex, String address,
                String dateOfBirth, String cpf, String cep, String city,
                String neighborhood, String addressNumber, String passwd) {
        setName(name);
        setSex(sex);
        setAddress(address);
        setDateOfBirth(dateOfBirth);
        setCpf(cpf);
        setCep(cep);
        setCity(city);
        setNeighborhood(neighborhood);
        setAddressNumber(addressNumber);
        setPasswd(passwd);
        setType("Cliente");
    }

    public User(String name, String sex,
                String address, String dateOfBirth,
                String cpf, String cep, String city,
                String neighborhood, String addressNumber,
                String passwd, String type) {
        setName(name);
        setSex(sex);
        setAddress(address);
        setDateOfBirth(dateOfBirth);
        setCpf(cpf);
        setCep(cep);
        setCity(city);
        setNeighborhood(neighborhood);
        setAddressNumber(addressNumber);
        setPasswd(passwd);
        setType(type);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getAddressNumber() {
        return addressNumber;
    }

    public void setAddressNumber(String addressNumber) {
        this.addressNumber = addressNumber;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
