package br.edu.fesa.TotalMedia.enumerator;

public enum Genre {

    ACTION(1),
    ADVENTURE(2),
    ANIMATION(3),
    BIOGRAPHY(4),
    COMEDY(5),
    CRIME(6),
    DOCUMENTARY(7),
    DRAMA(8),
    FAMILY(9),
    FANTASY(10),
    HISTORY(11),
    HORROR(12),
    MUSIC(13),
    MYSTERY(14),
    ROMANCE(15),
    SCIENCE_FICTION(16),
    THRILLER(17),
    WAR(18),
    WESTERN(19),
    SPORT(20),
    MUSICAL(21),
    SUSPENSE(22),
    SUPERHERO(23),
    REALITY(24),
    TALK_SHOW(25),
    NEWS(26),
    GAME_SHOW(27),
    TERRITORY(28);

    private final int id;

    Genre(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    // Método para obter o enum a partir do ID
    public static Genre fromId(int id) {
        for (Genre genre : Genre.values()) {
            if (genre.getId() == id) {
                return genre;
            }
        }
        throw new IllegalArgumentException("Unknown Genre ID: " + id);
    }
}
