package lt.coderetreat.game;

import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.Set;

@ToString
@RequiredArgsConstructor
@EqualsAndHashCode
public class Cell {
    public final Integer x;
    public final Integer y;

    Set<Cell> neighbours() {
        return Set.of(
            new Cell(x - 1, y - 1),
            new Cell(x, y - 1),
            new Cell(x + 1, y - 1),
            new Cell(x - 1, y),
            new Cell(x + 1, y),
            new Cell(x - 1, y + 1),
            new Cell(x + 1, y + 1),
            new Cell(x, y + 1)
        );
    }
}
