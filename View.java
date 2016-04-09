import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

class View extends JFrame {
    
    GridLayout grid = new GridLayout(3, 3);
    JButton tl, tc, tr, ml, mc, mr, bl, bc, br;
    
    public View() {
        super("tic-tac-toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addComponentsToPane(getContentPane());
        pack();
        setVisible(true);
    }

    public void addComponentsToPane(final Container pane) {
        final JPanel panel = new JPanel();
        panel.setLayout(grid);        
        panel.setPreferredSize(new Dimension(300, 300));

        tl = new JButton();
        tc = new JButton();
        tr = new JButton();
        ml = new JButton();
        mc = new JButton();
        mr = new JButton();
        bl = new JButton();
        bc = new JButton();
        br = new JButton();
        
        tl.getPreferredSize();
        tc.getPreferredSize();
        tr.getPreferredSize();
        ml.getPreferredSize();
        mc.getPreferredSize();
        mr.getPreferredSize();
        bl.getPreferredSize();
        bc.getPreferredSize();
        br.getPreferredSize();
        
        panel.add(tl);
        panel.add(tc);
        panel.add(tr);
        panel.add(ml);
        panel.add(mc);
        panel.add(mr);
        panel.add(bl);
        panel.add(bc);
        panel.add(br);
        
        pane.add(panel);
    }
    
    public void endGame() {
        tl.setEnabled(false);
        tc.setEnabled(false);
        tr.setEnabled(false);
        ml.setEnabled(false);
        mc.setEnabled(false);
        mr.setEnabled(false);
        bl.setEnabled(false);
        bc.setEnabled(false);
        br.setEnabled(false);
    }
}