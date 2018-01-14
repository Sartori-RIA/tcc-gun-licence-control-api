package br.gov.pf.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sartori on 28/10/2017
 */
public class PredicateBuilder implements Serializable {
    private static final long serialVersionUID = 1L;
    private StringBuilder builder;
    private Integer startPosition;
    private Integer maxResult;
    private List<Parameter> params;
    private String customWhere;
    private String select;
    private String from;
    private String clazz;

    private String orderBy;
    private boolean isDesc;

    public PredicateBuilder(Class<?> clazz) {
        params = new ArrayList<>();
        builder = new StringBuilder();
        select = "Select o ";
        this.clazz = clazz.getName();
        from = " FROM " + this.clazz + " o ";
    }

    public PredicateBuilder andEquals(String field, Object value) {
        this.mountQuery("=", " AND", field, value);
        return this;
    }

    public PredicateBuilder andNotEquals(String field, Object value) {
        this.mountQuery("<>", " AND", field, value);
        return this;
    }

    public PredicateBuilder andLike(String field, Object value) {
        this.mountQuery("LIKE", " AND", field, value + "%");
        return this;
    }

    public PredicateBuilder orEquals(String field, Object value) {
        this.mountQuery("=", " OR", field, value);
        return this;
    }

    public PredicateBuilder orNotEquals(String field, Object value) {
        this.mountQuery("<>", " OR", field, value);
        return this;
    }

    public PredicateBuilder orLike(String field, Object value) {
        this.mountQuery("LIKE", " OR", field, value + "%");
        return this;
    }

    public PredicateBuilder andMoreThanInclusive(String field, Object value) {
        this.mountQuery(">=", "AND", field, value);
        return this;
    }

    public PredicateBuilder orMoreThanInclusive(String field, Object value) {
        this.mountQuery(">=", "OR", field, value);
        return this;
    }

    public PredicateBuilder andLessThanInclusive(String field, Object value) {
        this.mountQuery("<=", "AND", field, value);
        return this;
    }

    public PredicateBuilder orLessThanInclusive(String field, Object value) {
        this.mountQuery("<=", "OR", field, value);
        return this;
    }

    public PredicateBuilder andMoreThanExclusive(String field, Object value) {
        this.mountQuery(">", "AND", field, value);
        return this;
    }

    public PredicateBuilder orMoreThanExclusive(String field, Object value) {
        this.mountQuery(">", "OR", field, value);
        return this;
    }

    public PredicateBuilder andLessThanExclusive(String field, Object value) {
        this.mountQuery("<", "AND", field, value);
        return this;
    }

    public PredicateBuilder orLessThanExclusive(String field, Object value) {
        this.mountQuery("<", "OR", field, value);
        return this;
    }

    public PredicateBuilder andIn(String field, Object value) {
        this.mountQuery("IN", "AND", field, value);
        return this;
    }

    public PredicateBuilder orIn(String field, Object value) {
        this.mountQuery("IN", "OR", field, value);
        return this;
    }

    public PredicateBuilder andNotIn(String field, Object value) {
        this.mountQuery("NOT IN", "AND", field, value);
        return this;
    }

    public PredicateBuilder orNotIn(String field, Object value) {
        this.mountQuery("NOT IN", "OR", field, value);
        return this;
    }

    private void mountQuery(String condition, String preposition, String field, Object value) {
        if (!this.params.isEmpty()) {
            builder.append(preposition);
        } else {
            builder.append(" WHERE ");
        }
        String paramName = field.replace(".", "");
        Parameter parameter = new Parameter(paramName, value);
        int i = 0;
        while (params.contains(parameter)) {
            i++;
            parameter.setName(parameter.getName() + i);
        }
        params.add(parameter);
        builder.append(" o.").append(field).append(" ");
        builder.append(condition);
        builder.append(" :" + parameter.getName());
        builder.append(" ");
    }

    public PredicateBuilder limit(Integer startPosition, Integer maxResult) {
        this.startPosition = startPosition;
        this.maxResult = maxResult;
        return this;
    }

    public PredicateBuilder orderByAsc(String[] orderBy) {
        this.isDesc = false;
        orderBy(orderBy);
        return this;
    }

    public PredicateBuilder orderByDesc(String[] orderBy) {
        this.isDesc = true;
        orderBy(orderBy);
        return this;
    }

    public PredicateBuilder orderByAsc(String orderBy) {
        this.isDesc = false;
        this.orderBy = "o." + orderBy;
        return this;
    }

    public PredicateBuilder orderByDesc(String orderBy) {
        this.isDesc = true;
        this.orderBy = "o." + orderBy;
        return this;
    }

    public PredicateBuilder customWhere(String custoWhere) {
        this.customWhere = custoWhere;
        return this;
    }

    public PredicateBuilder setParameter(String paramName, Object value) {
        params.add(new Parameter(paramName, value));
        return this;
    }

    private void orderBy(String[] orders) {
        if (orders.length > 0) {
            this.orderBy = "";
            int i = 0;
            for (String order : orders) {
                i++;
                this.orderBy += " o." + order;
                this.orderBy += (i < orders.length ? ", " : "");
            }
        }
    }

    public Integer getStartPosition() {
        return startPosition;
    }

    public Integer getMaxResult() {
        return maxResult;
    }

    public StringBuilder getQueryCount() {
        StringBuilder query = new StringBuilder();
        query.append("SELECT count(o) ").append(builder);
        return query;
    }

    public StringBuilder getQuery() {
        StringBuilder query = new StringBuilder();

        query.append(this.select).append(" ").append(from).append(" ").append(builder);
        if (customWhere != null) {
            query.append(builder.toString().contains("WHERE") ? " AND " : " WHERE");
            query.append(" " + customWhere + " ");
        }
        if (orderBy != null && orderBy.length() > 0)
            query.append(" ORDER BY " + orderBy + (isDesc ? " DESC" : " ASC"));
        return query;
    }

    public PredicateBuilder setSelect(String select) {
        this.select = select;
        return this;
    }

    public PredicateBuilder setFrom(String from) {
        this.from = from;
        return this;
    }

    public void setBuilder(StringBuilder builder) {
        this.builder = builder;
    }

    public List<Parameter> getParams() {
        return params;
    }

    public void setParams(List<Parameter> params) {
        this.params = params;
    }

    public String getClazz() {
        return clazz;
    }

}
