package com.data.datachange.module.system.model;

import java.io.Serializable;

/**
 * @author lz
 * 2018/5/28 13:03
 */
public class Func implements Serializable{

    private static final long serialVersionUID = -1L;
    private Integer id;
    private String name;
    private String ret;
    private String dl;
    private String type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getRet() {
        return ret;
    }

    public void setRet(String ret) {
        this.ret = ret;
    }

    public String getDl() {
        return dl;
    }

    public void setDl(String dl) {
        this.dl = dl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Func{" + "id=" + id + ", name='" + name + '\'' + ", ret='" + ret + '\'' + ", dl='" + dl + '\'' + ", type='" + type + '\'' + '}';
    }
}
