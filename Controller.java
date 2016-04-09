import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

class Controller implements ActionListener {
    View view;
    
    public Controller(View view) {
        this.view = view;
        addActionListeners();
    }
    
    private void addActionListeners() {
        view.tl.addActionListener(this);
        view.tc.addActionListener(this);
        view.tr.addActionListener(this);
        view.ml.addActionListener(this);
        view.mc.addActionListener(this);
        view.mr.addActionListener(this);
        view.bl.addActionListener(this);
        view.bc.addActionListener(this);
        view.br.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        view.tl.setText("O");
    }
}