public class Board {

  private Checker[] pieces;

  public Board() {
    pieces = new Checker[24];

    //Top pieces (black)
    pieces[0] = new Checker(false, 2, 1);
    pieces[1] = new Checker(false, 4, 1);
    pieces[2] = new Checker(false, 6, 1);
    pieces[3] = new Checker(false, 8, 1);
    pieces[4] = new Checker(false, 1, 2);
    pieces[5] = new Checker(false, 3, 2);
    pieces[6] = new Checker(false, 5, 2);
    pieces[7] = new Checker(false, 7, 2);
    pieces[8] = new Checker(false, 2, 3);
    pieces[9] = new Checker(false, 4, 3);
    pieces[10] = new Checker(false, 6, 3);
    pieces[11] = new Checker(false, 8, 3);

    //Bottom pieces (red)
    pieces[12] = new Checker(true, 1, 6);
    pieces[13] = new Checker(true, 3, 6);
    pieces[14] = new Checker(true, 5, 6);
    pieces[15] = new Checker(true, 7, 6);
    pieces[16] = new Checker(true, 2, 7);
    pieces[17] = new Checker(true, 4, 7);
    pieces[18] = new Checker(true, 6, 7);
    pieces[19] = new Checker(true, 8, 7);
    pieces[20] = new Checker(true, 1, 8);
    pieces[21] = new Checker(true, 3, 8);
    pieces[22] = new Checker(true, 5, 8);
    pieces[23] = new Checker(true, 7, 8);
  }

  private void capturePiece(Checker c) {
    c.setAlive(false);
    c.setCoords(-1, -1);
  }

  public void moveRedPiece(int pieceX, int pieceY, int x, int y) throws IllegalMoveException {
    if(findPiece(x, y) != null) {
      throw new IllegalMoveException("A piece is in the way of that move");
    }

    if(findPiece(pieceX, pieceY) == null) {
      throw new IllegalMoveException("There is no piece to move");
    }

    if(x < 1 || x > 8 || y < 1 || y > 8) {
      throw new IllegalMoveException("Move is off the board");
    }

    // TODO add color based logic on capturing
    // Capturing a piece
    if(pieceX - x == 2 && pieceY - y == 2 && findPiece(pieceX - 1, pieceY - 1) != null) {
      findPiece(pieceX, pieceY).setCoords(x, y);
      capturePiece(findPiece(pieceX - 1, pieceY - 1));
      return;
    }

    if(pieceX - x == -2 && pieceY - y == 2 && findPiece(pieceX + 1, pieceY - 1) != null) {
      findPiece(pieceX, pieceY).setCoords(x, y);
      capturePiece(findPiece(pieceX + 1, pieceY - 1));
      return;
    }

    if(findPiece(pieceX, pieceY).isKing()
        && pieceX - x == -2
        && pieceY - y == -2
        && findPiece(pieceX + 1, pieceY + 1) != null) {
      findPiece(pieceX, pieceY).setCoords(x, y);
      capturePiece(findPiece(pieceX + 1, pieceY + 1));
      return;
    }

    if(findPiece(pieceX, pieceY).isKing()
        && pieceX - x == 2
        && pieceY - y == -2
        && findPiece(pieceX - 1, pieceY + 1) != null) {
      findPiece(pieceX, pieceY).setCoords(x, y);
      capturePiece(findPiece(pieceX - 1, pieceY + 1));
      return;
    }

    if(x != pieceX + 1 && x != pieceX - 1) {
      throw new IllegalMoveException();
    }

    if(y != pieceY - 1 && y != pieceY + 1) {
      throw new IllegalMoveException("Pieces can only move one space at a time");
    }

    if (y != pieceY - 1 && !findPiece(pieceX, pieceY).isKing()) {
      throw new IllegalMoveException("Not kinged pieces can only move forward by one space");
    }

    findPiece(pieceX, pieceY).setCoords(x, y);
  }

  public void moveBlackPiece(int pieceX, int pieceY, int x, int y) throws IllegalMoveException {
    if(findPiece(x, y) != null) {
      throw new IllegalMoveException("A piece is in the way of that move");
    }

    if(findPiece(pieceX, pieceY) == null) {
      throw new IllegalMoveException("There is no piece to move");
    }

    if(x < 1 || x > 8 || y < 1 || y > 8) {
      throw new IllegalMoveException("Move is off the board");
    }

    // Capturing a piece
    if(pieceX - x == 2 && pieceY - y == -2 && findPiece(pieceX - 1, pieceY + 1) != null) {
      findPiece(pieceX, pieceY).setCoords(x, y);
      capturePiece(findPiece(pieceX - 1, pieceY + 1));
      return;
    }

    if(pieceX - x == -2 && pieceY - y == -2 && findPiece(pieceX + 1, pieceY + 1) != null) {
      findPiece(pieceX, pieceY).setCoords(x, y);
      capturePiece(findPiece(pieceX + 1, pieceY + 1));
      return;
    }

    if(findPiece(pieceX, pieceY).isKing()
        && pieceX - x == -2
        && pieceY - y == 2
        && findPiece(pieceX + 1, pieceY - 1) != null) {
      findPiece(pieceX, pieceY).setCoords(x, y);
      capturePiece(findPiece(pieceX + 1, pieceY - 1));
      return;
    }

    if(findPiece(pieceX, pieceY).isKing()
        && pieceX - x == 2
        && pieceY - y == 2
        && findPiece(pieceX - 1, pieceY - 1) != null) {
      findPiece(pieceX, pieceY).setCoords(x, y);
      capturePiece(findPiece(pieceX - 1, pieceY - 1));
      return;
    }

    if(x != pieceX + 1 && x != pieceX - 1) {
      throw new IllegalMoveException();
    }

    if(y != pieceY - 1 && y != pieceY + 1) {
      throw new IllegalMoveException("Pieces can only move one space at a time");
    }

    if (y != pieceY + 1 && !findPiece(pieceX, pieceY).isKing()) {
      throw new IllegalMoveException("Not kinged pieces can only move forward by one space");
    }

    findPiece(pieceX, pieceY).setCoords(x, y);
  }

  public void kingEligiblePieces() {
    for(Checker c : pieces) {
      if(c.isRed() && c.getY() == 1) {
        c.setKinged(true);
      } else if (!c.isRed() && c.getY() == 8) {
        c.setKinged(true);
      }
    }
  }

  public Checker findPiece(int x, int y) {
    for(Checker c : pieces) {
      if(c.getX() == x && c.getY() == y) {
        return c;
      }
    }
    return null;
  }
}
