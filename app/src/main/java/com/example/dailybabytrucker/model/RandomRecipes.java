package com.example.dailybabytrucker.model;


public  class RandomRecipes {

    private final String id;
    private final String title;
    private final String image;
    private final String sourceUrl;


    public RandomRecipes(String id, String title, String image, String sourceUrl) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.sourceUrl = sourceUrl;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }
}
