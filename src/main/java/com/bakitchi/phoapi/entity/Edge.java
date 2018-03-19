package com.bakitchi.phoapi.entity;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Property;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author: Bakitchi
 * @Created-Time: 2018/3/19 上午10:15
 * @Description:
 */

@Entity(value = "KWS_EDGES")
public class Edge{
    public Edge() {
    }

    public Edge(String src, String tar){
        this.src = src;
        this.tar = tar;
    }
    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    @Property(value = "SOURCE")
    String src;

    public String getTar() {
        return tar;
    }

    public void setTar(String tar) {
        this.tar = tar;
    }

    @Property(value = "TARGET")
    String tar;
}
