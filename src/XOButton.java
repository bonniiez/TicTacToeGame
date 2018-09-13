import javax.swing.*;

public class XOButton extends JButton{
    int stage = 0;
    int xpos;
    int ypos;

    public XOButton(int x, int y){
        xpos = x;
        ypos = y;

    }

    public int getStage() {
        return stage;
    }

    public int getXpos() {
        return xpos;
    }

    public int getYpos() {
        return ypos;
    }

    public void setStage(int stage) {
        this.stage = stage;
    }
}
