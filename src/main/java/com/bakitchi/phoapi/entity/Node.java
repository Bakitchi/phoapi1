package com.bakitchi.phoapi.entity;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Property;

import java.util.Vector;

/**
 * @Author: Bakitchi
 * @Created-Time: 2018/3/19 上午10:16
 * @Description:
 */
@Entity(value = "KWS_NODES")
public class Node{
    @Property(value = "NAME")
    String name;
    @Property(value = "TYPE")
    String type;
    @Property(value = "PROPERTY")
    String property;
    Vector<Node> nxt;
    public Node(){
        nxt = new Vector<Node>();
    }
    public Node(String name,String type,String property){
        this.name = name;
        this.type = type;
        this.property = property;
        nxt = new Vector<Node>();
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public Vector getNxt() {
        return nxt;
    }
}
