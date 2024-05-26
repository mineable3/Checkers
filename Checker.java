public class Checker {

  private boolean kinged, alive, red;
  private int x,y;

  public Checker(boolean red, int x, int y) {
    this.red = red;
    this.x = x;
    this.y = y;
    kinged = false;
    alive = true;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public boolean isKing() {
    return kinged;
  }

  public boolean isAlive() {
    return alive;
  }

  public boolean isRed() {
    return red;
  }

  public void setX(int x) {
    this.x = x;
  }

  public void setY(int y) {
    this.y = y;
  }

  public void setCoords(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public void setKinged(boolean kinged) {
    this.kinged = kinged;
  }

  public void setAlive(boolean alive) {
    this.alive = alive;
  }

  public void setRed(boolean red) {
    this.red = red;
  }
}
