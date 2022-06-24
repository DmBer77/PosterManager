package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PostersManagerTest {

    @Test
    public void shouldAdd_0_NewPosters() {
        PostersManager manager = new PostersManager(new PostersRepository());

        String[] expected = {};
        String[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAdd_1_NewPosters() {
        PostersManager manager = new PostersManager(new PostersRepository());
        manager.addNewPosters("F1");

        String[] expected = {"F1"};
        String[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddSomeNewPosters() {
        PostersManager manager = new PostersManager(new PostersRepository());
        manager.addNewPosters("F1");
        manager.addNewPosters("F2");
        manager.addNewPosters("F3");
        manager.addNewPosters("F4");
        manager.addNewPosters("F5");

        String[] expected = {"F1", "F2", "F3", "F4", "F5"};
        String[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddSomeNewPostersAndRemoveOne() {
        PostersManager manager = new PostersManager(new PostersRepository());
        manager.addNewPosters("F1");
        manager.addNewPosters("F2");
        manager.addNewPosters("F3");
        manager.addNewPosters("F4");
        manager.addNewPosters("F5");

        manager.removePosters("F5");


        String[] expected = {"F1", "F2", "F3", "F4"};
        String[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowResentPostersByDefault() {
        PostersManager manager = new PostersManager(new PostersRepository());
        manager.addNewPosters("F1");
        manager.addNewPosters("F2");
        manager.addNewPosters("F3");
        manager.addNewPosters("F4");
        manager.addNewPosters("F5");
        manager.addNewPosters("F6");
        manager.addNewPosters("F7");
        manager.addNewPosters("F8");
        manager.addNewPosters("F9");
        manager.addNewPosters("F10");
        manager.addNewPosters("F11");
        manager.addNewPosters("F12");
        manager.addNewPosters("F13");
        manager.addNewPosters("F14");
        manager.addNewPosters("F15");

        String[] expected = {"F15", "F14", "F13", "F12", "F11", "F10", "F9", "F8", "F7", "F6"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowResentPostersIfNumberOfResentFilmLessThanTotal() {
        PostersManager manager = new PostersManager(new PostersRepository(5));
        manager.addNewPosters("F1");
        manager.addNewPosters("F2");
        manager.addNewPosters("F3");
        manager.addNewPosters("F4");
        manager.addNewPosters("F5");
        manager.addNewPosters("F6");
        manager.addNewPosters("F7");
        manager.addNewPosters("F8");
        manager.addNewPosters("F9");
        manager.addNewPosters("F10");
        manager.addNewPosters("F11");
        manager.addNewPosters("F12");
        manager.addNewPosters("F13");
        manager.addNewPosters("F14");
        manager.addNewPosters("F15");

        String[] expected = {"F15", "F14", "F13", "F12", "F11"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowResentPostersIfNumberOfResentFilmMoreThanTotal() {
        PostersManager manager = new PostersManager(new PostersRepository(17));
        manager.addNewPosters("F1");
        manager.addNewPosters("F2");
        manager.addNewPosters("F3");
        manager.addNewPosters("F4");
        manager.addNewPosters("F5");
        manager.addNewPosters("F6");
        manager.addNewPosters("F7");
        manager.addNewPosters("F8");
        manager.addNewPosters("F9");
        manager.addNewPosters("F10");
        manager.addNewPosters("F11");
        manager.addNewPosters("F12");
        manager.addNewPosters("F13");
        manager.addNewPosters("F14");
        manager.addNewPosters("F15");

        String[] expected = {"F15", "F14", "F13", "F12", "F11", "F10", "F9", "F8", "F7", "F6", "F5", "F4", "F3", "F2", "F1"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowResentPostersAfterAddingAndRemovingIfNumberOfResentFilmLessThanTotal() {
        PostersManager manager = new PostersManager(new PostersRepository(7));
        manager.addNewPosters("F1");
        manager.addNewPosters("F2");
        manager.addNewPosters("F3");
        manager.addNewPosters("F4");
        manager.addNewPosters("F5");
        manager.addNewPosters("F6");
        manager.addNewPosters("F7");
        manager.addNewPosters("F8");
        manager.addNewPosters("F9");
        manager.addNewPosters("F10");
        manager.addNewPosters("F11");
        manager.addNewPosters("F12");
        manager.addNewPosters("F13");
        manager.addNewPosters("F14");
        manager.addNewPosters("F15");

        manager.removePosters("F13");
        manager.removePosters("F10");
        manager.removePosters("F2");

        String[] expected = {"F15", "F14", "F12", "F11", "F9", "F8", "F7"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowResentPostersAfterAddingAndRemovingIfNumberOfResentFilmMoreThanTotal() {
        PostersManager manager = new PostersManager(new PostersRepository(17));
        manager.addNewPosters("F1");
        manager.addNewPosters("F2");
        manager.addNewPosters("F3");
        manager.addNewPosters("F4");
        manager.addNewPosters("F5");
        manager.addNewPosters("F6");
        manager.addNewPosters("F7");
        manager.addNewPosters("F8");
        manager.addNewPosters("F9");
        manager.addNewPosters("F10");
        manager.addNewPosters("F11");
        manager.addNewPosters("F12");
        manager.addNewPosters("F13");
        manager.addNewPosters("F14");
        manager.addNewPosters("F15");

        manager.removePosters("F1");
        manager.removePosters("F3");
        manager.removePosters("F10");
        manager.removePosters("F14");

        String[] expected = {"F15", "F13", "F12", "F11", "F9", "F8", "F7", "F6", "F5", "F4", "F2"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindItemByNameIfThatItemIsPresent() {
        PostersManager manager = new PostersManager(new PostersRepository());
        manager.addNewPosters("F1");
        manager.addNewPosters("F2");
        manager.addNewPosters("F12");

        manager.findByName("F2");

        String[] expected = {"F2"};
        String[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindItemByNameIfThatItemIsNotPresent() {
        PostersManager manager = new PostersManager(new PostersRepository());
        manager.addNewPosters("F1");
        manager.addNewPosters("F5");
        manager.addNewPosters("F12");

        manager.findByName("F2");

        String[] expected = {null};
        String[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldDeleteAllItems() {
        PostersManager manager = new PostersManager(new PostersRepository());

        manager.removeAll();

        String[] expected = {};
        String[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

}
