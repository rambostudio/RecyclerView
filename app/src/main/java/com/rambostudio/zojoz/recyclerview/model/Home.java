package com.rambostudio.zojoz.recyclerview.model;

import java.util.List;

/**
 * Created by rambo on 30/3/2560.
 */

public class Home {
    String title;
    List<Person> personList;

    public Home(String title, List<Person> personList) {
        this.title = title;
        this.personList = personList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }
}
