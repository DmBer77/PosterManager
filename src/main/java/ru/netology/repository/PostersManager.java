package ru.netology.repository;

public class PostersManager {

    protected String [] posters = new String[0];
    protected int numberOfResentFilm;

    public PostersManager() {
        numberOfResentFilm = 10;
    }
    public PostersManager(int numberOfResentFilm) {
        this.numberOfResentFilm = numberOfResentFilm;
    }

    public void addNewPosters(String posterForAdd) {
        String [] tmp = new String[posters.length + 1];
        for (int i = 0; i < posters.length; i++) {
            tmp[i] = posters[i];
        }
        tmp[tmp.length - 1] = posterForAdd;
        posters = tmp;
    }

    public void removePosters(String posterForRemove) {
        String[] tmp = new String[posters.length - 1];
        int copyToIndex = 0;
        for (String poster : posters) {
            if (!poster.equals(posterForRemove)) {
                tmp[copyToIndex] = poster;
                copyToIndex++;
            }
        }
        posters = tmp;
    }

    public String [] findAll() {
        return posters;
    }

    public String [] findLast() {
        int resultLength;
        if (posters.length < numberOfResentFilm){
            resultLength = posters.length;
        } else {
            resultLength = numberOfResentFilm;
        }
        String[] resentPosters = new String[resultLength];
        for (int i = 0; i < resentPosters.length; i++) {
            resentPosters[i] = posters[posters.length - 1 - i];
        }
        return resentPosters;
    }
}
