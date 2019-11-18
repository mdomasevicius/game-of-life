package lt.coderetreat.game;

import org.junit.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameOfLifeTest {

    @Test
    public void singleCellDies() {
        // given
        var initialWorld = new World(Set.of(new Cell(50, 50)));

        // when
        var afterOneTickWorld = initialWorld.tick();

        //then
        assertTrue(afterOneTickWorld.isEmpty());
    }

    @Test
    public void stillLife() {
        // given
        var initialWorld = new World(
            Set.of(
                new Cell(50, 50),
                new Cell(50, 51),
                new Cell(51, 50),
                new Cell(51, 51)
            ));

        // when
        var afterOneTickWorld = initialWorld.tick();

        //
        assertEquals(afterOneTickWorld.aliveCells, initialWorld.aliveCells);
    }

    @Test
    public void oscillators() {
        // given
        var initialWorld = new World(
            Set.of(
                new Cell(49, 50),
                new Cell(50, 50),
                new Cell(51, 50)
            ));

        // when
        var afterOneTickWorld = initialWorld.tick();

        //
        assertEquals(
            afterOneTickWorld.aliveCells,
            Set.of(
                new Cell(50, 49),
                new Cell(50, 50),
                new Cell(50, 51)
            ));
    }
}
