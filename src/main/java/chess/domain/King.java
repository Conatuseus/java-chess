package chess.domain;

import chess.domain.movepatterns.KingPattern;
import chess.domain.movepatterns.MovePattern;

import java.util.ArrayList;
import java.util.List;

public class King {
    private final MovePattern movePattern = new KingPattern();
    private final Integer color;

    public King(Integer color) {
        this.color = color;
    }

    public boolean isValidMovePattern(Point source, Point target) {
        return movePattern.canMove(source, target);
    }

    public List<Point> makePath(Point source, Point target) {
        return new ArrayList<>();
    }
}
