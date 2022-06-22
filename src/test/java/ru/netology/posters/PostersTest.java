package ru.netology.posters;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PostersTest {

    Posters item1 = new Posters("Бладшот");
    Posters item2 = new Posters("Вперед");
    Posters item3 = new Posters("Отель Белград");
    Posters item4 = new Posters("Джентльмены");
    Posters item5 = new Posters("Человек-невидимка");
    Posters item6 = new Posters("Тролли. Мировой тур");
    Posters item7 = new Posters("Номер один");

    @Test
    public void test() {

        PostersRepository repo = new PostersRepository();
        repo.saveNewPoster(item1);
        repo.saveNewPoster(item2);
        repo.saveNewPoster(item3);
        repo.saveNewPoster(item4);
        repo.saveNewPoster(item5);
        repo.saveNewPoster(item6);
        repo.saveNewPoster(item7);

        repo.removePoster(item2.getPosterName());

        Posters[] expected = {item1, item3, item4, item5, item6, item7};
        Posters[] actual = repo.getItems();

        Assertions.assertArrayEquals(expected, actual);
    }
}
