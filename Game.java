import java.io.IOException;
import java.util.Scanner;

public class Game {

  public Board board;
  private Scanner scanner;
  private StringBuilder display;
  private boolean playing;

  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_BLACK = "\u001B[90m";
  public static final String ANSI_RED = "\u001B[91m";
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
  public static final String ANSI_WHITE_BACKGROUND = "\u001B[107m";

  public static final String RESET_CURSOR = "\033[H";
  public static final String CLEAR_PAST_CURSOR = "\033[2J";
  public static final String CLEAR_SCREEN = "\033[H\033[2J";

  public Game() {
    board = new Board();
    scanner = new Scanner(System.in);
    display = new StringBuilder();
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
      board.kingEligiblePieces();
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
        if(board.findPiece(locationFromDisplay(i, j)) == null || !board.findPiece(locationFromDisplay(i, j)).isAlive()) {
          if(j % 2 == 0) {
            display.append(ANSI_WHITE_BACKGROUND + "   " + ANSI_RESET);
          } else {
            display.append(ANSI_BLACK_BACKGROUND + "   " + ANSI_RESET);
          }
        } else if(board.findPiece(locationFromDisplay(i, j)).isRed()) {
          if(board.findPiece(locationFromDisplay(i, j)).isKing()) {
            if(j % 2 == 0) {
              display.append(ANSI_WHITE_BACKGROUND + ANSI_RED + " 0 " + ANSI_RESET);
            } else {
              display.append(ANSI_RED + ANSI_BLACK_BACKGROUND + " 0 " + ANSI_RESET);
            }
          } else {
            if(j % 2 == 0) {
              display.append(ANSI_WHITE_BACKGROUND + ANSI_RED + " o " + ANSI_RESET);
            } else {
              display.append(ANSI_RED + ANSI_BLACK_BACKGROUND + " o " + ANSI_RESET);
            }
          }
        } else {
          if(board.findPiece(locationFromDisplay(i, j)).isKing()) {
            if(j % 2 == 0) {
              display.append(ANSI_WHITE_BACKGROUND + ANSI_BLACK + " 0 " + ANSI_RESET);
            } else {
              display.append(ANSI_BLACK + ANSI_BLACK_BACKGROUND + " 0 " + ANSI_RESET);
            }
          } else {
            if(j % 2 == 0) {
              display.append(ANSI_WHITE_BACKGROUND + ANSI_BLACK + " o " + ANSI_RESET);
            } else {
              display.append(ANSI_BLACK + ANSI_BLACK_BACKGROUND + " o " + ANSI_RESET);
            }
          }
        }
      }
      display.append("\n");
    }
    display.append("  ------------------------");
    System.out.println(display.toString());
  }

  private int locationFromDisplay(int i, int j) {
    String num = String.valueOf(i) + String.valueOf(j);

    switch(num) {
      case "01":
        return 1;
      case "03":
        return 2;
      case "05":
        return 3;
      case "07":
        return 4;
      case "11":
        return 5;
      case "13":
        return 6;
      case "15":
        return 7;
      case "17":
        return 8;
      case "23":
        return 9;
      case "25":
        return 10;
      case "27":
        return 11;
      case "29":
        return 12;
      case "33":
        return 13;
      case "35":
        return 14;
      case "37":
        return 15;
      case "39":
        return 16;
      case "45":
        return 17;
      case "47":
        return 18;
      case "49":
        return 19;
      case "411":
        return 20;
      case "55":
        return 21;
      case "57":
        return 22;
      case "59":
        return 23;
      case "511":
        return 24;
      case "67":
        return 25;
      case "69":
        return 26;
      case "611":
        return 27;
      case "613":
        return 28;
      case "77":
        return 29;
      case "79":
        return 30;
      case "711":
        return 31;
      case "713":
        return 32;
    }
    return -1;
  }

  private void playerMove() {
    System.out.println("Make your move: ");
    String move = scanner.nextLine();

    if(move.equals("exit")) {
      playing = false;
      return;
    }

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

    board.movePiece((pieceY-1)*4+((pieceX+1)/2), (y-1)*4+((x+1)/2));
  }

  private void displayMenu() {}
}
