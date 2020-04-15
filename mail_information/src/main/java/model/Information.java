package model;

public class Information {
    private String languages;
    private int size;
    public Information(){

    }
    public Information(String languages,int size){
        this.languages=languages;
        this.size=size;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}

