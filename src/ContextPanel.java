import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class ContextPanel extends JPanel {
    Vector<ExtCircle> circles;
    Vector<ExtSquare> squares;
    private StateDraw stateDraw;
    private int speed = 15;

    ContextPanel() {
        super();
        circles = new Vector<>();
        squares = new Vector<>();
        // По дефолту рисуй круги
        stateDraw = new StateSquare(this);
    }

    public void changeState(StateDraw stateDraw) {
        this.stateDraw = stateDraw;
    }

    public void addFigure() {
        stateDraw.addFigure();
    }

    public void removeFigure() {
        stateDraw.removeFigure();
    }

    private void MoveCircles() {
        double  width = this.getWidth(),
                height = this.getHeight();
        for (ExtCircle figure : circles) {
            double dx =  Math.cos(figure.angle * Math.PI / 180) * speed;
            double dy =  Math.sin(figure.angle * Math.PI / 180) * speed;

            figure.x += dx;
            figure.y += dy;

            if (figure.x <= 0 || figure.x >= width - figure.width) {
                figure.angle = 180 - figure.angle;
                figure.x -= dx;
            }

            if (figure.y <= 0 || figure.y >= height - figure.height) {
                figure.angle = 360 - figure.angle;
                figure.y -= dy;
            }
        }
    }

    private void MoveSquares() {
        double  width = this.getWidth(),
                height = this.getHeight();
        for (ExtSquare figure : squares)  {
            double dx =  Math.cos(figure.angle * Math.PI / 180) * speed;
            double dy =  Math.sin(figure.angle * Math.PI / 180) * speed;

            figure.x += dx;
            figure.y += dy;

            if (figure.x <= 0 || figure.x >= width - figure.width) {
                figure.angle = 180 - figure.angle;
                figure.x -= dx;
            }

            if (figure.y <= 0 || figure.y >= height - figure.height) {
                figure.angle = 360 - figure.angle;
                figure.y -= dy;
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        MoveCircles();
        MoveSquares();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        g.setColor(Color.green);
        stateDraw.draw((Graphics2D) g);
    }
}
