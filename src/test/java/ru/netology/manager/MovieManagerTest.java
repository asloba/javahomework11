package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MovieManagerTest {
    private MovieManager manager = new MovieManager();
    Movie first = new Movie(1, 1, "Бладшот", "боевик", "https://img1.ru");
    Movie second = new Movie(2, 2, "Вперёд", "мультфильм", "https://img2.ru");
    Movie third = new Movie(3, 3, "Отель «Белград»", "комедия", "https://img3.ru");
    Movie fourth = new Movie(4, 4, "Джентльмены", "боевик", "https://img4.ru");
    Movie fifth = new Movie(5, 5, "Человек-невидимка", "ужасы", "https://img5.ru");
    Movie sixth = new Movie(6, 6, "Тролли. Мировой тур", "мультфильм", "https://img6.ru");
    Movie seventh = new Movie(7, 7, "Номер один", "комедия", "https://img7.ru");
    Movie eighth = new Movie(8, 8, "Двойник", "драма", "https://img8.ru");
    Movie ninth = new Movie(9, 9, "Ещё по одной", "драма", "https://img9.ru");
    Movie tenth = new Movie(10, 10, "Иллюзия обмана", "триллер", "https://img10.ru");
    Movie eleventh = new Movie(11, 11, "Охота", "драма", "https://img11.ru");

    @Test
    void shouldAddMovie() {
        Movie[] expected = new Movie[]{first};
        manager.add(first);

        assertArrayEquals(expected, manager.getAll());
    }

    @Test
    void shouldShowMoviesToTDefault() {
        Movie[] expected = new Movie[]{tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);

        assertArrayEquals(expected, manager.getAll());
    }

    @Test
    void shouldShowIfMoviesMoreThanDefault() {
        Movie[] expected = new Movie[]{eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second};
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        manager.add(eleventh);

        assertArrayEquals(expected, manager.getAll());
    }

    @Test
    void shouldShowMoviesInConstructor() {
        MovieManager manager = new MovieManager(3);
        Movie[] expected = new Movie[] {third, second, first};
        manager.add(first);
        manager.add(second);
        manager.add(third);

        assertArrayEquals(expected, manager.getAll());
    }

    @Test
    void shouldReturnZeroMovies() {
        MovieManager manager = new MovieManager(0);
        Movie[] expected = new Movie[0];
        manager.add(first);
        manager.add(second);
        assertArrayEquals(expected, manager.getAll());
    }


}