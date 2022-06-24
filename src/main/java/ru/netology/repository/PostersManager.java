package ru.netology.repository;

public class PostersManager {
    private final PostersRepository repository;

    public PostersManager(PostersRepository repository) {
        this.repository = repository;
    }

    public void addNewPosters(String poster) {
        repository.addNewPosters(poster);
    }

    public void removePosters(String poster) {
        repository.removePosters(poster);
    }

    public void removeAll() {
        repository.removeAll();
    }

    public String[] findAll() {
        return repository.findAll();
    }

    public String[] findLast() {
        return repository.findLast();
    }

    public void findByName(String poster) {
        repository.findByName(poster);
    }

}
