package com.epam.entity;


import org.springframework.stereotype.Component;

@Component
public class Mini {
    private Long id;
    private String name;

    public Mini()
    {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
