package br.gov.pf.util;

/**
 * Created by sartori on 28/10/2017
 */
public class Parameter {

    private String name;
    private Object value;

    public Parameter(String name, Object value) {
        setName(name);
        setValue(value);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        return ((Parameter)obj).getName().equals(this.name);
    }

}
