package com.example.myappnew.retrofit2;

import com.example.myappnew.retrofit2.PostCreate;

import java.util.Date;

public class PutUpdate extends PostCreate {
    /*
    * UPDATE - Response 200
    https://reqres.in/api/users/2
    {
        "name": "morpheus",
        "job": "zion resident"
    }
    *** Response 200
    {
        "name": "morpheus",
        "job": "zion resident",
        "updatedAt": "2021-07-04T05:30:41.373Z"
    }
    * */
    public PutUpdate(String name, String job, Date updatedAt) {
        super(name, job);
        setUpdatedAt(updatedAt);
    }

    private Date updatedAt;

    public Date getUpdatedAt() {
        return updatedAt;
    }

    @Override
    public String toString() {
        return "PutUpdate{" +
                "name='" + super.getName() + '\'' +
                "job='" + super.getJob() + '\'' +
                "updatedAt='" + updatedAt + '\'' +
                '}';
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
