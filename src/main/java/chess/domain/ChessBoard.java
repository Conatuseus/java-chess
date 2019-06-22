package chess.domain;

import chess.domain.pieces.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChessBoard {

    private Map<Point, Piece> points = new HashMap<>();

    public ChessBoard() {
        points.put(PointFactory.of("a1"), new Rook(Color.WHITE));
        points.put(PointFactory.of("b1"), new Knight(Color.WHITE));
        points.put(PointFactory.of("c1"), new Bishop(Color.WHITE));
        points.put(PointFactory.of("d1"), new Queen(Color.WHITE));
        points.put(PointFactory.of("e1"), new King(Color.WHITE));
        points.put(PointFactory.of("f1"), new Bishop(Color.WHITE));
        points.put(PointFactory.of("g1"), new Knight(Color.WHITE));
        points.put(PointFactory.of("h1"), new Rook(Color.WHITE));
        for (int i = 1; i <= 8; ++i) {
            points.put(PointFactory.of(i, 2), new Pawn(Color.WHITE));
        }
        for (int i = 3; i <= 6; ++i) {
            for (int j = 1; j <= 8; ++j) {
                points.put(PointFactory.of(j, i), new Blank(Color.NONE));
            }
        }
        for (int i = 1; i <= 8; ++i) {
            points.put(PointFactory.of(i, 7), new Pawn(Color.BLACK));
        }
        points.put(PointFactory.of("a8"), new Rook(Color.BLACK));
        points.put(PointFactory.of("b8"), new Knight(Color.BLACK));
        points.put(PointFactory.of("c8"), new Bishop(Color.BLACK));
        points.put(PointFactory.of("d8"), new Queen(Color.BLACK));
        points.put(PointFactory.of("e8"), new King(Color.BLACK));
        points.put(PointFactory.of("f8"), new Bishop(Color.BLACK));
        points.put(PointFactory.of("g8"), new Knight(Color.BLACK));
        points.put(PointFactory.of("h8"), new Rook(Color.BLACK));
    }

//    public void play(Point source, Point target) {
//        if (points.get(source).equalsType(Type.BLANK)) {
//            throw new IllegalArgumentException("선택한 위치는 빈 칸입니다!");
//        }
//        if (points.get(source).equalsColor())
//    }

//    public boolean playOneStep(Color color, Point source, Point target) {
//        Piece currentPiece = points.get(source);
//        if (currentPiece == null || !currentPiece.isSameColor(color)) {
//            return false;
//        }
//
//        if (!currentPiece.isValidDirection(source, target)) {
//            return false;
//        }
//
//        List<Point> path = currentPiece.makePath(source, target);
//        for (Point point : path) {
//            if (points.get(point) != null)
//                return false;
//        }
//        updateUnitLocation(source, target);
//        return true;
//    }

    private void updateUnitLocation(Point source, Point target) {
        Piece currentPiece = points.get(source);
        points.put(target, currentPiece);
        points.put(source, null);
    }

    public void checkSourceAndTarget(Point source, Point target, Color colorOfTurn) {
        Piece sourcePiece = points.get(source);
        Piece targetPiece = points.get(target);

        if (!sourcePiece.equalsType(Type.BLANK)) {
            throw new IllegalArgumentException("말이 없다");
        }
        if (!sourcePiece.equalsColor(colorOfTurn)) {
            throw new IllegalArgumentException("색깔이 다르다");
        }
        if (targetPiece.equalsColor(colorOfTurn)) {
            throw new IllegalArgumentException("source와 target 색이 같다.");
        }
    }

    public List<Point> makePath(Point source, Point target) {
        Piece sourcePiece = points.get(source);
        Piece targetPiece = points.get(target);

        if (targetPiece.equalsType(Type.BLANK)) {
            return sourcePiece.move(source, target);
        }
        return sourcePiece.attack(source, target);
    }

    public void checkPath(List<Point> path){

//        for (Point point : path) {
//            if(!points.get(point).equalsType(Type.BLANK)){
//                throw new IllegalArgumentException("경로에 다른 말 있음.");
//            }
//        }
        path.stream()
                .filter(point -> !points.get(point).equalsType(Type.BLANK))
                .


    }
}