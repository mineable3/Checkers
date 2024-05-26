import java.io.IOException;
import java.util.Scanner;

public class Game {

  private Board board;
  private Scanner scanner;
  private StringBuilder display;
  private boolean redGoing, playing;

  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_BLACK = "\u001B[30m";
  public static final String ANSI_RED = "\u001B[31m";
  public static final String ANSI_GREEN = "\u001B[32m";
  public static final String ANSI_YELLOW = "\u001B[33m";
  public static final String ANSI_BLUE = "\u001B[34m";
  public static final String ANSI_PURPLE = "\u001B[35m";
  public static final String ANSI_CYAN = "\u001B[36m";
  public static final String ANSI_WHITE = "\u001B[37m";

  public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
  public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
  public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
  public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
  public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
  public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
  public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
  public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

  public static final String RESET_CURSOR = "\033[H";
  public static final String CLEAR_PAST_CURSOR = "\033[2J";
  public static final String CLEAR_SCREEN = "\033[H\033[2J";

  public Game() {
    board = new Board();
    scanner = new Scanner(System.in);
    display = new StringBuilder();
    redGoing = true;
    playing = true;
  }

  public void startGame() {
    displayMenu();

    try {
      Runtime.getRuntime().exec("PAUSE");
    } catch (IOException e) {}

    while(playing) {
      displayGame();
      playerMove();
      displayGame();
      botMove();
    }
  }

  private void displayGame() {
    String letters = new String("abcdefgh");
    display.delete(0, display.length());
    display.append(CLEAR_SCREEN);
    display.append("   1  2  3  4  5  6  7  8\n");
    display.append("  ------------------------\n");
    for(int i = 0; i < 8; i++) {
      display.append(letters.charAt(i) + "|");
      for (int j = i; j < 8 + i; j++) {
        if(board.findPiece(j - i + 1, i+1) == null) {
          if(j % 2 == 0) {
            display.append(ANSI_WHITE_BACKGROUND + "   " + ANSI_RESET);
          } else {
            display.append(ANSI_RESET + "   ");
          }
        } else if (board.findPiece(j-i+1, i+1).isRed()) {
          if(board.findPiece(j-i+1, i+1).isKing()) {
            if(j % 2 == 0) {
              display.append(ANSI_WHITE_BACKGROUND + ANSI_RED + " 0 " + ANSI_RESET);
            } else {
              display.append(ANSI_RED + " 0 " + ANSI_RESET);
            }
          } else {
            if(j % 2 == 0) {
              display.append(ANSI_WHITE_BACKGROUND + ANSI_RED + " o " + ANSI_RESET);
            } else {
              display.append(ANSI_RED + " o " + ANSI_RESET);
            }
          }
        } else {
          if(board.findPiece(j-i+1, i+1).isKing()) {
            if(j % 2 == 0) {
              display.append(ANSI_WHITE_BACKGROUND + ANSI_BLACK + " 0 " + ANSI_RESET);
            } else {
              display.append(ANSI_BLACK + " 0 " + ANSI_RESET);
            }
          } else {
            if(j % 2 == 0) {
              display.append(ANSI_WHITE_BACKGROUND + ANSI_BLACK + " o " + ANSI_RESET);
            } else {
              display.append(ANSI_BLACK + " o " + ANSI_RESET);
            }
          }
        }

      }
      display.append("\n");
    }
    display.append("  ------------------------");
    System.out.println(display.toString());
  }

  private void playerMove() {
    System.out.println("Make your move: ");
    String move = scanner.nextLine();

    int pieceX = Integer.parseInt(move.substring(1, 2));
    int pieceY;

    switch(move.substring(0, 1)) {
      case "a":
        pieceY = 1;
        break;
      case "b":
        pieceY = 2;
        break;
      case "c":
        pieceY = 3;
        break;
      case "d":
        pieceY = 4;
        break;
      case "e":
        pieceY = 5;
        break;
      case "f":
        pieceY = 6;
        break;
      case "g":
        pieceY = 7;
        break;
      case "h":
        pieceY = 8;
        break;
      default:
        pieceY = -1;
    }

    int x = Integer.parseInt(move.substring(4, 5));
    int y;

    switch(move.substring(3, 4)) {
      case "a":
        y = 1;
        break;
      case "b":
        y = 2;
        break;
      case "c":
        y = 3;
        break;
      case "d":
        y = 4;
        break;
      case "e":
        y = 5;
        break;
      case "f":
        y = 6;
        break;
      case "g":
        y = 7;
        break;
      case "h":
        y = 8;
        break;
      default:
        y = -1;
    }

    try {
      board.moveRedPiece(pieceX, pieceY, x, y);
    } catch (IllegalMoveException e) {
      e.printStackTrace();
    }
  }

  private void botMove() {

    System.out.println("Make your move: ");
    String move = scanner.nextLine();

    int pieceX = Integer.parseInt(move.substring(1, 2));
    int pieceY;

    switch(move.substring(0, 1)) {
      case "a":
        pieceY = 1;
        break;
      case "b":
        pieceY = 2;
        break;
      case "c":
        pieceY = 3;
        break;
      case "d":
        pieceY = 4;
        break;
      case "e":
        pieceY = 5;
        break;
      case "f":
        pieceY = 6;
        break;
      case "g":
        pieceY = 7;
        break;
      case "h":
        pieceY = 8;
        break;
      default:
        pieceY = -1;
    }

    int x = Integer.parseInt(move.substring(4, 5));
    int y;

    switch(move.substring(3, 4)) {
      case "a":
        y = 1;
        break;
      case "b":
        y = 2;
        break;
      case "c":
        y = 3;
        break;
      case "d":
        y = 4;
        break;
      case "e":
        y = 5;
        break;
      case "f":
        y = 6;
        break;
      case "g":
        y = 7;
        break;
      case "h":
        y = 8;
        break;
      default:
        y = -1;
    }

    try {
      board.moveBlackPiece(pieceX, pieceY, x, y);
    } catch (IllegalMoveException e) {
      e.printStackTrace();
    }
  }

  private void displayMenu() {}
}
