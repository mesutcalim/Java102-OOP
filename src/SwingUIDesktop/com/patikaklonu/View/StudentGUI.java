package SwingUIDesktop.com.patikaklonu.View;

import SwingUIDesktop.com.patikaklonu.Helper.Config;
import SwingUIDesktop.com.patikaklonu.Helper.Helper;

import javax.swing.*;

public class StudentGUI extends JFrame{
    private JPanel wrapper;

    public StudentGUI(){
        add(wrapper);
        setSize(400,450);
        setLocation(Helper.screenCenterPoint("x",getSize()),Helper.screenCenterPoint("y",getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setResizable(false);
        setVisible(true);
    }
}
