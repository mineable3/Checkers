public class Tile {

  private int index, row;
  private Checker piece;

  public Tile(int index, int row) {
    this.index = index;
    this.row = row;
  }

  public Tile(int index, int row, Checker piece) {
    this(index, row);
    this.piece = piece;
  }

  public int getIndex() {
    return index;
  }

  public int getRow() {
    return row;
  }

  public Checker getPiece() {
    return piece;
  }

  public void setPiece(Checker p) {
    this.piece = p;
  }
}
