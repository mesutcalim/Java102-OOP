package SwingUIDesktop.com.patikaklonu.View;

import SwingUIDesktop.com.patikaklonu.Helper.Config;
import SwingUIDesktop.com.patikaklonu.Helper.Helper;
import SwingUIDesktop.com.patikaklonu.Model.Patika;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdatePatikaGUI extends JFrame {
    private JPanel wrapper;
    private Patika patika;
    private JTextField fld_patika_name;
    private JButton btn_update;

    public UpdatePatikaGUI(Patika patika) {

        this.patika = patika;
        add(wrapper);
        setSize(300,150);
        setLocation(Helper.screenCenterPoint("x",getSize()),Helper.screenCenterPoint("y",getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setVisible(true);

        fld_patika_name.setText(patika.getName());


        btn_update.addActionListener(e -> {
            if(Helper.isEmpty(fld_patika_name)){
                Helper.showMsg("fill");
            }
            else{
                if(Patika.update(patika.getId(), fld_patika_name.getText())){
                    Helper.showMsg("done");

                }
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        Helper.setLayout();
        Patika p = new Patika(1,"Frontend");
        UpdatePatikaGUI up = new UpdatePatikaGUI(p);
    }
}
