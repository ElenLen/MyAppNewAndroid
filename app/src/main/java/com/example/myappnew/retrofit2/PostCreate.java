package com.example.myappnew.retrofit2;

import java.util.Date;

public class PostCreate {
    /*
    * CREATE - Response 201
    * https://reqres.in/api/users
    * {
        "name": "morpheus",
        "job": "leader",
        "id": "638",
        "createdAt": "2021-07-04T04:22:20.217Z"
        }
    * ***************************
    * UPDATE - Response 200
    https://reqres.in/api/users/2
    {
        "name": "morpheus",
        "job": "zion resident",
        "updatedAt": "2021-07-04T05:30:41.373Z"
    }
    * */
    private String name;
    private String job;
    private String id;
    private Date createdAt;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                ", id='" + id + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }

    public PostCreate(String name, String job) {
        this.name = name;
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }


}
