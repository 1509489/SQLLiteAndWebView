package com.pixelarts.sqlliteandwebview;

public class Contacts {

    private String name, number, age, gender, favoriteAnimal;

    public Contacts(String name, String number, String age, String gender, String favoriteAnimal) {
        this.name = name;
        this.number = number;
        this.age = age;
        this.gender = gender;
        this.favoriteAnimal = favoriteAnimal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFavoriteAnimal() {
        return favoriteAnimal;
    }

    public void setFavoriteAnimal(String favoriteAnimal) {
        this.favoriteAnimal = favoriteAnimal;
    }
}
