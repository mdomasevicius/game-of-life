package lt.coderetreat.game;

import lombok.RequiredArgsConstructor;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toSet;

@RequiredArgsConstructor
public class World {
    public final Set<Cell> aliveCells;

    public World tick() {
        Set<Cell> toKill = cellsToKill();

        Set<Cell> toSpawn = aliveCells.stream()
            .flatMap(c -> c.neighbours().stream())
            .filter(neighbourCell -> !aliveCells.contains(neighbourCell))
            .filter(emptyNeighbourCell -> has3LiveNeighbours(emptyNeighbourCell))
            .collect(toSet());

        var newLiveCellSet = new HashSet<>(aliveCells);
        newLiveCellSet.removeAll(toKill);
        newLiveCellSet.addAll(toSpawn);

        return new World(newLiveCellSet);
    }

    private Set<Cell> cellsToKill() {
        return Stream.concat(
            aliveCells.stream().filter(c -> hasLessThan2LiveNeighbours(c)),
            aliveCells.stream().filter(c -> hasMoreThan3LiveNeighbours(c))
        ).collect(toSet());
    }

    private boolean has3LiveNeighbours(Cell emptyCell) {
        for (int i = 0; i < 10; i++) {

        }
        return emptyCell.neighbours().stream()
            .filter(aliveCells::contains)
            .count() == 3;
    }



    private boolean hasLessThan2LiveNeighbours(Cell cell) { ;
        return cell.neighbours().stream()
            .filter(aliveCells::contains)
            .count() < 2;
    }

    private boolean hasMoreThan3LiveNeighbours(Cell cell) {
        return cell.neighbours().stream()
            .filter(aliveCells::contains)
            .count() > 3;
    }

    public boolean isEmpty() {
        return aliveCells.isEmpty();
    }
}
