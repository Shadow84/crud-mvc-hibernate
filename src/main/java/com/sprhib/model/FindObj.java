package com.sprhib.model;


public class FindObj {
    private String field;

    private String from;

    private String to;

    private String sort;


    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FindObj findObj = (FindObj) o;

        if (field != null ? !field.equals(findObj.field) : findObj.field != null) return false;
        if (from != null ? !from.equals(findObj.from) : findObj.from != null) return false;
        if (to != null ? !to.equals(findObj.to) : findObj.to != null) return false;
        return !(sort != null ? !sort.equals(findObj.sort) : findObj.sort != null);

    }

    @Override
    public int hashCode() {
        int result = field != null ? field.hashCode() : 0;
        result = 31 * result + (from != null ? from.hashCode() : 0);
        result = 31 * result + (to != null ? to.hashCode() : 0);
        result = 31 * result + (sort != null ? sort.hashCode() : 0);
        return result;
    }
}
