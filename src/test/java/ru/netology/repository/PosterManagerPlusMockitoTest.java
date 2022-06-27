package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;

public class PosterManagerPlusMockitoTest {
    PostersRepository repository = Mockito.mock (PostersRepository.class);
    PostersManager manager = new PostersManager (repository);

    @Test
    public void shouldFindItemByNameIfThatItemIsPresent() {

        String[] posters = {"F1", "F2", "F3", "F4", "F5"};
        doReturn(posters).when(repository).findAll();

        String[] expected = {"F1", "F2", "F3", "F4", "F5"};
        String[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldCountAllElements() {

        String[] posters = {"F1", "F2", "F3", "F4", "F5"};
        doReturn(posters).when(repository).countAllElements();

        int expected = 5;
        int actual = manager.countAllElements();

        Assertions.assertEquals(expected, actual);
    }
}
