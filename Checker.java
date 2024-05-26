public class Checker {

  private boolean kinged, alive, red;
  private int location;

  public Checker(boolean red, int location) {
    this.red = red;
    this.location = location;
    kinged = false;
    alive = true;
  }

  public int getLocation() {
    return location;
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

  public void setLocation(int location) {
    this.location = location;
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
