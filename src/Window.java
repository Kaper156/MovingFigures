import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


public class Window extends JFrame {
    ContextPanel canvas;
    Timer timer;

    public Window() {
        super("Window");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Size
//        setPreferredSize(new Dimension(700, 500));
//        setResizable(false); // Дабы не обсчитывать динамическое изменение окна

        //Conatiner
        Container container = getContentPane(); // Контейнер для эелментов окна
        container.setLayout(new BorderLayout());

        // CANVAS
        canvas = new ContextPanel();
        canvas.setPreferredSize(new Dimension(700,400));


        //Timer
        timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                canvas.repaint();
            }
        });
        timer.start();

        // ComandPan
        JPanel cmdPanel = new JPanel();
        cmdPanel.setLayout(new BoxLayout(cmdPanel, BoxLayout.X_AXIS)); //Есть спейсер
        cmdPanel.add(Box.createHorizontalStrut(5));

        //SwitchModCmb
        String[] mods = {"Круги", "Квадраты"};
        JComboBox<String> cmbMod = new JComboBox(mods);
        cmbMod.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    if (e.getItem() == mods[1]) {
                        canvas.changeState(new StateSquare(canvas));
                    } else {
                        canvas.changeState(new StateCircles(canvas));
                    }
                }
            }
        });
        cmdPanel.add(cmbMod);
        cmdPanel.add(Box.createHorizontalStrut(15));

        //Btns for add\rem
        JButton btnAdd = new JButton("+");
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                canvas.addFigure();
            }
        });
        JButton btnRem = new JButton("-");
        btnRem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                canvas.removeFigure();
            }
        });
        cmdPanel.add(btnAdd);
        cmdPanel.add(Box.createHorizontalStrut(5));
        cmdPanel.add(btnRem);
        cmdPanel.add(Box.createHorizontalStrut(5));

        //Btns for timer
        JButton btnTimeStart = new JButton("Start");
        btnTimeStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timer.restart();
            }
        });
        JButton btnTimerStop = new JButton("Stop");
        btnTimerStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timer.stop();
            }
        });

        cmdPanel.add(btnTimeStart);
        cmdPanel.add(Box.createHorizontalStrut(5));
        cmdPanel.add(btnTimerStop);

        container.add(cmdPanel, BorderLayout.NORTH);
        container.add(canvas, BorderLayout.CENTER);

        // Показывай круги
        cmbMod.setSelectedIndex(1);

        this.setVisible(true);
    }


    public static void main(String[] args) {
        Window window = new Window();
        window.pack();

    }
}
