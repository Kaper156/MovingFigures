import java.util.List;

public class FigureManager {
    double speed;
    double CANVAS_W, CANVAS_H;

//    public static <T> void Move(List<T> figures)
//    {
//        for(T figure: figures)
//        {
//            figure.x = 2;
//        }
//
//    }

    public void MoveCircles(List<ExtCircle> circles)
    {
        for (ExtCircle figure: circles)
        {
            figure.x = figure.x + Math.cos(figure.angle * Math.PI / 180) * speed;
            figure.y = figure.y + Math.sin(figure.angle * Math.PI / 180) * speed;

            if (figure.x <= figure.width || figure.x >= CANVAS_W - figure.width * 2) {
                figure.angle = 180 - figure.angle;
            }

            if (figure.y <= figure.height || figure.y >= CANVAS_H - figure.height * 2) {
                figure.angle = 360 - figure.angle;
            }
        }
    }

    public void MoveSquares(List<ExtSquare> squares)
    {
        for (ExtSquare figure: squares)
        {
            figure.x = figure.x + Math.cos(figure.angle * Math.PI / 180) * speed;
            figure.y = figure.y + Math.sin(figure.angle * Math.PI / 180) * speed;

            if (figure.x <= figure.width || figure.x >= CANVAS_W - figure.width * 2) {
                figure.angle = 180 - figure.angle;
            }

            if (figure.y <= figure.height || figure.y >= CANVAS_H - figure.height * 2) {
                figure.angle = 360 - figure.angle;
            }
        }
    }

}
