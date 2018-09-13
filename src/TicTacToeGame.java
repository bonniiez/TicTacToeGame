import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class TicTacToeGame extends JFrame {

    int DimensionSize = 3;    // 3 = 3x3 box 4 = 4x4

    Dimension buttonSize = (new Dimension(240, 240));

    XOButton[] buttons = new XOButton[9];

    int[][] PlayingBoard = new int[3][3];

    int turn = 1;

    final XOButton button0 = new XOButton(0,0);
    final XOButton button1 = new XOButton(1,0);
    final XOButton button2 = new XOButton(2,0);
    final XOButton button3 = new XOButton(0,1);
    final XOButton button4 = new XOButton(1,1);
    final XOButton button5 = new XOButton(2,1);
    final XOButton button6 = new XOButton(0,2);
    final XOButton button7 = new XOButton(1,2);
    final XOButton button8 = new XOButton(2,2);

    public TicTacToeGame(String name) {
        super(name);
        setResizable(false);
    }


    public void SetUpGame(final Container pane) {
        final JPanel GameBoard = new JPanel();
        GameBoard.setLayout(new GridLayout(DimensionSize,DimensionSize));

        buttons[0] = button0;
        buttons[1] = button1;
        buttons[2] = button2;
        buttons[3] = button3;
        buttons[4] = button4;
        buttons[5] = button5;
        buttons[6] = button6;
        buttons[7] = button7;
        buttons[8] = button8;

        for(int i = 0; i < 9; i++){
            buttons[i].setIcon(new ImageIcon("src/images/blank.png"));
            buttons[i].setPreferredSize(buttonSize);
            GameBoard.add(buttons[i]);
            final int z = i;
            buttons[i].addMouseListener(new MouseAdapter() {
                public void mouseEntered(MouseEvent evt) {
                    if(buttons[z].getStage() == 0) {
                        buttons[z].setIcon(new ImageIcon("src/images/border.jpeg"));
                    }
                }

                public void mouseExited(MouseEvent evt) {
                    if(buttons[z].getStage() == 0){
                    buttons[z].setIcon(new ImageIcon("src/images/blank.png"));
                    }
                }

                public void mouseClicked(MouseEvent evt) {
                    if(buttons[z].getStage() == 0){
                        buttons[z].setStage(turn);
                        if(turn == 1){
                            buttons[z].setIcon(new ImageIcon("src/images/x_image.png"));
                            PutPieceOnBoard(buttons[z].getXpos(),buttons[z].getYpos());
                            CheckWin();
                            turn = -1;
                        } else {
                            buttons[z].setIcon(new ImageIcon("src/images/o_image.png"));
                            PutPieceOnBoard(buttons[z].getXpos(),buttons[z].getYpos());
                            CheckWin();
                            turn = 1;
                        }
                    }
                }
            });
        }
        pane.add(GameBoard, BorderLayout.NORTH);
    }

    public void PutPieceOnBoard(int x, int y){
        PlayingBoard[x][y] = turn;
    }

    public void CheckWin(){

        if(((PlayingBoard[0][0]==PlayingBoard[1][0]) && (PlayingBoard[0][0]==PlayingBoard[2][0]) && ((PlayingBoard[0][0]== 1) || (PlayingBoard[0][0] == -1))) ||
           ((PlayingBoard[0][1]==PlayingBoard[1][1]) && (PlayingBoard[0][1]==PlayingBoard[2][1]) && ((PlayingBoard[0][1]== 1) || (PlayingBoard[0][1] == -1))) ||
           ((PlayingBoard[0][2]==PlayingBoard[1][2]) && (PlayingBoard[0][2]==PlayingBoard[2][2]) && ((PlayingBoard[0][2]== 1) || (PlayingBoard[0][2] == -1))) ||
           ((PlayingBoard[0][0]==PlayingBoard[0][1]) && (PlayingBoard[0][0]==PlayingBoard[0][2]) && ((PlayingBoard[0][0]== 1) || (PlayingBoard[0][0] == -1))) ||
           ((PlayingBoard[1][0]==PlayingBoard[1][1]) && (PlayingBoard[1][0]==PlayingBoard[1][2]) && ((PlayingBoard[1][0]== 1) || (PlayingBoard[1][0] == -1))) ||
           ((PlayingBoard[2][0]==PlayingBoard[2][1]) && (PlayingBoard[2][0]==PlayingBoard[2][2]) && ((PlayingBoard[2][0]== 1) || (PlayingBoard[2][0] == -1))) ||
           ((PlayingBoard[0][0]==PlayingBoard[1][1]) && (PlayingBoard[1][1]==PlayingBoard[2][2]) && ((PlayingBoard[0][0]== 1) || (PlayingBoard[0][0] == -1))) ||
           ((PlayingBoard[0][2]==PlayingBoard[1][1]) && (PlayingBoard[0][2]==PlayingBoard[2][0]) && ((PlayingBoard[0][2]== 1) || (PlayingBoard[0][2] == -1))) ){
            createAndShowWinMessage();
        }
    }

    private static void createAndShowGUI() {
        //Create and set up the window.
        TicTacToeGame frame = new TicTacToeGame("Tic Tac Toe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.SetUpGame(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }

    void createAndShowWinMessage() {
        if(turn == 1) {
            JOptionPane.showMessageDialog(this, "X has won the game!", "You Win!", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        } else {
            JOptionPane.showMessageDialog(this, "O has won the game!", "You Win!", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
    }

    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}