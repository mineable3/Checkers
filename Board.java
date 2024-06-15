public class Board {

  private Checker[] pieces;

  public Board() {
    pieces = new Checker[24];

    //Top pieces (black)
    pieces[0] = new Checker(false, 1);
    pieces[1] = new Checker(false, 2);
    pieces[2] = new Checker(false, 3);
    pieces[3] = new Checker(false, 4);
    pieces[4] = new Checker(false, 5);
    pieces[5] = new Checker(false, 6);
    pieces[6] = new Checker(false, 7);
    pieces[7] = new Checker(false, 8);
    pieces[8] = new Checker(false, 9);
    pieces[9] = new Checker(false, 10);
    pieces[10] = new Checker(false, 11);
    pieces[11] = new Checker(false, 12);

    //Bottom pieces (red)
    pieces[12] = new Checker(true, 21);
    pieces[13] = new Checker(true, 22);
    pieces[14] = new Checker(true, 23);
    pieces[15] = new Checker(true, 24);
    pieces[16] = new Checker(true, 25);
    pieces[17] = new Checker(true, 26);
    pieces[18] = new Checker(true, 27);
    pieces[19] = new Checker(true, 28);
    pieces[20] = new Checker(true, 29);
    pieces[21] = new Checker(true, 30);
    pieces[22] = new Checker(true, 31);
    pieces[23] = new Checker(true, 32);
  }

  private void capturePiece(Checker c) {
    c.setAlive(false);
    c.setLocation(-1);
  }

  public void movePiece(int start, int end) {
    if(checkMoveIsLegal(start, end)) {
      if(Math.abs(start - end) > 6) {
        // capturePiece(something);
      }
      findPiece(start).setLocation(end);
    } else {
      System.out.println("That is not a legal move");
    }
  }

  public void kingEligiblePieces() {
    for(Checker c : pieces) {
      if(c.isRed() && (c.getLocation() == 1 || c.getLocation() == 2 || c.getLocation() == 3 || c.getLocation() == 4)) {
        c.setKinged(true);
      } else if (!c.isRed() && (c.getLocation() == 29 || c.getLocation() == 30 || c.getLocation() == 31 || c.getLocation() == 32)) {
        c.setKinged(true);
      }
    }
  }

  public Checker findPiece(int location) {
    for(Checker c : pieces) {
      if(c.getLocation() == location) {
        return c;
      }
    }
    return null;
  }

  private boolean checkRedLegalMove(boolean kinged, int start, int end) {
    if(start == 1 ||
        start == 2 ||
        start == 3 ||
        start == 4 ||
        start == 9 ||
        start == 10 ||
        start == 11 ||
        start == 12 ||
        start == 17 ||
        start == 18 ||
        start == 19 ||
        start == 20 ||
        start == 25 ||
        start == 26 ||
        start == 27 ||
        start == 28) {
      if(end == start - 4 || end == start - 3) {
        return true;
      } else if(kinged && (end == start + 4 || end == start + 5)) {
        return true;
      } else if((end == start - 9 && findPiece(start - 4) != null) || (end == start - 7 && findPiece(start - 3) != null)) {
        return true;
      } else if(kinged && (end == start + 7 && findPiece(start + 4) != null) || (end == start + 9 && findPiece(start + 5) != null)) {
        return true;
      }
    }

    if(start == 5 ||
        start == 6 ||
        start == 7 ||
        start == 8 ||
        start == 13 ||
        start == 14 ||
        start == 15 ||
        start == 16 ||
        start == 21 ||
        start == 22 ||
        start == 23 ||
        start == 24 ||
        start == 29 ||
        start == 30 ||
        start == 31 ||
        start == 32) {
      if(end == start - 4 || end == start - 5) {
        return true;
      } else if(kinged && (end == start + 4 || end == start + 3)) {
        return true;
      } else if((end == start - 9 && findPiece(start - 5) != null) || (end == start - 7 && findPiece(start - 4) != null)) {
        return true;
      } else if(kinged && (end == start + 7 && findPiece(start + 3) != null) || (end == start + 9 && findPiece(start + 4) != null)) {
        return true;
      }
    }
    return false;
  }

  private boolean checkBlackLegalMove(boolean kinged, int start, int end) {
    if(start == 1 ||
        start == 2 ||
        start == 3 ||
        start == 4 ||
        start == 9 ||
        start == 10 ||
        start == 11 ||
        start == 12 ||
        start == 17 ||
        start == 18 ||
        start == 19 ||
        start == 20 ||
        start == 25 ||
        start == 26 ||
        start == 27 ||
        start == 28) {
      if(end == start + 4 || end == start + 5) {
        return true;
      } else if(kinged && (end == start - 4 || end == start - 3)) {
        return true;
      } else if((end == start + 9 && findPiece(start + 5) != null) || (end == start + 7 && findPiece(start + 4) != null)) {
        return true;
      } else if(kinged && (end == start - 9 && findPiece(start - 4) != null) || (end == start - 7 && findPiece(start - 3) != null)) {
        return true;
      }
    }

    if(start == 5 ||
        start == 6 ||
        start == 7 ||
        start == 8 ||
        start == 13 ||
        start == 14 ||
        start == 15 ||
        start == 16 ||
        start == 21 ||
        start == 22 ||
        start == 23 ||
        start == 24 ||
        start == 29 ||
        start == 30 ||
        start == 31 ||
        start == 32) {
      if(end == start + 4 || end == start + 3) {
        return true;
      } else if(kinged && (end == start - 4 || end == start - 5)) {
        return true;
      } else if((end == start + 7 && findPiece(start + 3) != null) || (end == start + 9 && findPiece(start + 5) != null)) {
        return true;
      } else if(kinged && (end == start - 9 && findPiece(start - 5) != null) || (end == start - 7 && findPiece(start - 4) != null)) {
        return true;
      }
    }

    return false;
  }

  public boolean checkMoveIsLegal(int start, int end) {
    Checker source = findPiece(start);

    if(findPiece(end) != null || source == null) {
      return false;
    }

    if(start < 1 || start > 32 || end < 1 || end > 32 || start == end) {
      return false;
    }

    if(source.isRed()) {
      return checkRedLegalMove(source.isKing(), start, end);
    } else {
      return checkBlackLegalMove(source.isKing(), start, end);
    }
  }
}
