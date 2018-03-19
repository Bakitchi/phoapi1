package com.bakitchi.phoapi.dto;



/**
 * @Author: Bakitchi
 * @Created-Time: 2018/3/19 下午2:04
 * @Description:
 */
public class NodeDTO {
   private String name;

   private String type;

   private String property;

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

    public NodeDTO(String name, String type, String property) {

        this.name = name;
        this.type = type;
        this.property = property;
    }
}
