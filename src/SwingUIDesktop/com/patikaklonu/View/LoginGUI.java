package SwingUIDesktop.com.patikaklonu.View;

import SwingUIDesktop.com.patikaklonu.Helper.Config;
import SwingUIDesktop.com.patikaklonu.Helper.Helper;
import SwingUIDesktop.com.patikaklonu.Model.Operator;
import SwingUIDesktop.com.patikaklonu.Model.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGUI extends JFrame {
    private JPanel wrapper;
    private JPanel wtop;
    private JPanel wbottom;
    private JTextField fld_login_uname;
    private JPasswordField fld_login_pass;
    private JButton btn_login;

    public LoginGUI(){
        add(wrapper);
        setSize(400,450);
        setLocation(Helper.screenCenterPoint("x",getSize()),Helper.screenCenterPoint("y",getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setResizable(false);
        setVisible(true);
        btn_login.addActionListener(e -> {
            if(Helper.isEmpty(fld_login_uname)||Helper.isEmpty(fld_login_pass)){
                Helper.showMsg("fill");
            }else{
                User u = User.getFetch(fld_login_uname.getText(),fld_login_pass.getText());
                if(u == null){
                    Helper.showMsg("Kullanıcı Bulunamadı");
                }else{
                    switch (u.getType()){
                        case "Operator":
                            OperatorGUI op = new OperatorGUI((Operator) u);
                            break;
                        case"Educator":
                            EducatorGUI edu = new EducatorGUI();
                            break;
                        case "Student":
                            StudentGUI stu = new StudentGUI();
                            break;
                    }
                    dispose();

                }

            }

        });
    }

    public static void main(String[] args) {
        Helper.setLayout();
        LoginGUI login = new LoginGUI();
    }
}
