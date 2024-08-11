# A simple, command line, two player, checkers program

## Use

Start by running the program. Red will always play first and the game will be played from Red's point of view.
A legal move is defined by selecting the piece to move and the desired ending location for that piece. The game uses an alphanumeric
coordinate system. Enter the information with the following syntax.
```
<Piece location> <Ending location>
```
For example, if you want to make the opening move be the top left piece for red. This is what you should enter
```
   1  2  3  4  5  6  7  8
  ------------------------
a|    o     o     o     o 
b| o     o     o     o    
c|    o     o     o     o 
d|                        
e|                        
f| o     o     o     o    
g|    o     o     o     o 
h| o     o     o     o    
  ------------------------
Make your move:
f1 e2
```

## Graphics
The graphics may look different depending on the font, zoom, and colors of the terminal used.
I tested the program on the Windows 11 Command Prompt and Ubuntu 24.04 Terminal.
