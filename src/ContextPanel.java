import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class ContextPanel extends JPanel  {
    Vector<MovingCircle> circles;
    Vector<MovingSquare> squares;
    private StateDraw stateDraw;

    ContextPanel()
    {
        super();
        circles = new Vector<>();
        squares = new Vector<>();
        // По дефолту рисуй круги
        stateDraw = new StateCircles(this);
    }

    public void changeState(StateDraw stateDraw)
    {
        this.stateDraw = stateDraw;
    }

    public void addFigure()
    {
        stateDraw.addFigure();
    }

    public void removeFigure()
    {
        stateDraw.removeFigure();
    }

//    public void paint(Graphics g) {
//        for (MovingCircle figure : circles)
//        {
//            figure.MoveSelf();
//        }
//        for (MovingSquare figure : squares)
//        {
//            figure.MoveSelf();
//        }
//        g.setColor(Color.BLACK);
//        g.fillRect(0,0,700, 400);
//        g.setColor(Color.green);
//        stateDraw.draw((Graphics2D) g);
//    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (MovingCircle figure : circles)
        {
            figure.MoveSelf();
        }
        for (MovingSquare figure : squares)
        {
            figure.MoveSelf();
        }
        g.setColor(Color.BLACK);
        g.fillRect(0,0,700, 400);
        g.setColor(Color.green);
        stateDraw.draw((Graphics2D) g);
    }
}
