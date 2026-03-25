package rvt;
    import javax.swing.JPanel;
    import java.awt.*;
public class GrafikasPanelis  extends JPanel {
    public GrafikasPanelis(){
        
    }
    public GrafikasPanelis(LayoutManager layout){
        super(layout);
    }
    public GrafikasPanelis(boolean isDoubleBuffered){
        super(isDoubleBuffered);
    }
    public GrafikasPanelis(LayoutManager layout, boolean isDoubleBuffered){
        super(layout, isDoubleBuffered);
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.drawRect(50, 50, 100, 100);
        g.setColor(Color.BLACK);
        g.drawRect(60, 90,40, 60);
        g.drawRect(110, 60,30, 30);
        g.setColor(Color.RED);
        g.drawLine(150, 50, 100, 20);
        g.drawLine(50, 50, 100, 20);
        g.setColor(Color.YELLOW);
        g.fillOval(93, 30, 15, 15);
    }
    
}

