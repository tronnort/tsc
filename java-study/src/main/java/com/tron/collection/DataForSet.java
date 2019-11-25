package com.tron.collection;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Objects;

//@Data
//@AllArgsConstructor
public class DataForSet {
    private String message;
    private Integer code;

    public DataForSet(String message, Integer code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "DataForSet{" +
                "message='" + message + '\'' +
                ", code=" + code +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataForSet that = (DataForSet) o;
        return Objects.equals(message, that.message) &&
                Objects.equals(code, that.code);
    }

    @Override
    public int hashCode() {

        return Objects.hash(message, code);
    }
}
