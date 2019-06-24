package chess.domain.pieces;

import chess.domain.Point;
import chess.domain.PointFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BlankTest {

    @Test
    void 정상_생성_Test() {
        assertDoesNotThrow(() -> new Blank(Color.NONE));
    }

    @Test
    void 이동_Test() {
        Blank blank = new Blank(Color.NONE);
        Point source = PointFactory.of("d5");
        Point target = PointFactory.of("h1");
        assertThrows(IllegalArgumentException.class, () -> blank.action(source, target, false));
    }

    @Test
    void 공격_Test() {
        Blank blank = new Blank(Color.NONE);
        Point source = PointFactory.of("d5");
        Point target = PointFactory.of("h1");
        assertThrows(IllegalArgumentException.class, () -> blank.action(source, target, true));
    }
}
