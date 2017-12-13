package org.smart4j.chapter2.model;

/**
 * Created by admin on 2017/12/13.
 */
public class Customer {

    private long id;

    private String name;

    private  String contact;

    private  String telephone;

    private String email;

    private String remark;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", contact='" + contact + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
