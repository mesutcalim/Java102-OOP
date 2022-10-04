package SwingUIDesktop.com.patikaklonu.View;

import SwingUIDesktop.com.patikaklonu.Helper.Config;
import SwingUIDesktop.com.patikaklonu.Helper.Helper;
import SwingUIDesktop.com.patikaklonu.Helper.Item;
import SwingUIDesktop.com.patikaklonu.Model.Course;
import SwingUIDesktop.com.patikaklonu.Model.Operator;
import SwingUIDesktop.com.patikaklonu.Model.Patika;
import SwingUIDesktop.com.patikaklonu.Model.User;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class OperatorGUI extends JFrame {

    private JPanel wrapper;
    private JTabbedPane tabbedPane1;
    private JLabel lbl_welcome;
    private JPanel pnl_top;
    private JButton btn_logout;
    private JPanel pnl_userList;
    private JScrollPane scrl_userList;
    private JTable tbl_userList;
    private JPanel pnl_user_form;
    private JTextField fld_user_name;
    private JTextField fld_user_uname;
    private JTextField fld_user_pass;
    private JComboBox cmb_user_type;
    private JButton btn_user_add;
    private JButton btn_user_delete;
    private JTextField fld_user_id;
    private JTextField fld_sh_user_name;
    private JTextField fld_sh_user_uname;
    private JComboBox cmb_sh_user_type;
    private JButton btn_user_sh;
    private JPanel pnl_patika_list;
    private JScrollPane scrl_patika_list;
    private JTable tbl_patika_list;
    private JPanel pnl_patika_add;
    private JTextField fld_patika_name;
    private JButton btn_patika_add;
    private JPanel pnl_user_sh;
    private JPanel pnl_course_list;
    private JScrollPane scrl_course_list;
    private JTable tbl_course_list;
    private JPanel pnl_course_add;
    private JTextField fld_course_name;
    private JTextField fld_course_lang;
    private JComboBox cmb_course_patika;
    private JComboBox cmb_course_user;
    private JButton btn_course_add;
    private DefaultTableModel mdl_user_list;
    private Object[] row_user_list;
    private final Operator operator;

    private DefaultTableModel mdl_patika_list;
    private Object[] row_patika_list;
    private JPopupMenu patikaMenu;
    private DefaultTableModel mdl_course_list;
    private Object[] row_course_list;

    public OperatorGUI(Operator operator){
        this.operator=operator;
        Helper.setLayout();
        add(wrapper);
        setSize(1000,500);
        int x= Helper.screenCenterPoint("x",getSize());
        int y=Helper.screenCenterPoint("y",getSize());
        setLocation(x,y);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setVisible(true);

        lbl_welcome.setText("Hoşgeldiniz: "+ operator.getName());

        //ModelUserList
        mdl_user_list = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                if(column == 0){
                    return  false;
                }
                return super.isCellEditable(row, column);
            }
        };


        Object[] col_user_list = {"ID","AD SOYAD","KULLANICI ADI","ŞİFRE","ÜYELİK TİPİ"};
        mdl_user_list.setColumnIdentifiers(col_user_list);
        row_user_list = new Object[col_user_list.length];

        loadUserModel();




        tbl_userList.setModel(mdl_user_list);
        tbl_userList.getTableHeader().setReorderingAllowed(false);

        tbl_userList.getSelectionModel().addListSelectionListener(e -> {
            try {
                String select_user_id = tbl_userList.getValueAt(tbl_userList.getSelectedRow(), 0).toString();
                fld_user_id.setText(select_user_id);
            }catch (Exception exception){
                System.out.println(exception.getMessage());
            }
        });

        tbl_userList.getModel().addTableModelListener(e -> {
            if(e.getType()== TableModelEvent.UPDATE){
                int user_id = Integer.parseInt(tbl_userList.getValueAt(tbl_userList.getSelectedRow(),0).toString());
                String user_name = tbl_userList.getValueAt(tbl_userList.getSelectedRow(),1).toString();
                String user_uname = tbl_userList.getValueAt(tbl_userList.getSelectedRow(),2).toString();
                String user_pass = tbl_userList.getValueAt(tbl_userList.getSelectedRow(),3).toString();
                String user_type = tbl_userList.getValueAt(tbl_userList.getSelectedRow(),4).toString();

                if(User.update(user_id, user_name, user_uname, user_pass, user_type)){
                    Helper.showMsg("done");
                    loadUserModel();
                    loadEducatorCombo();
                    loadCourseModel();
                }else {
                    Helper.showMsg("Bu kullanıcı adı alınmıştır. Lütfen farklı bir tane deneyiniz");


                }
            }
        });
        //##ModelUserList

        //Patika List
        patikaMenu = new JPopupMenu();
        JMenuItem updateMenu = new JMenuItem("Güncelle");
        JMenuItem deleteMenu = new JMenuItem("Sil");
        patikaMenu.add(updateMenu);
        patikaMenu.add(deleteMenu);

        updateMenu.addActionListener(e -> {
            int select_id = Integer.parseInt(tbl_patika_list.getValueAt(tbl_patika_list.getSelectedRow(),0).toString());
            UpdatePatikaGUI updateGUI = new UpdatePatikaGUI(Patika.getFetch(select_id));
            updateGUI.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadPatikaModel();
                    loadPatikaCombo();
                    loadCourseModel();
                }
            });
        });
        deleteMenu.addActionListener(e -> {
            if(Helper.confirm("sure")){
                int select_id = Integer.parseInt(tbl_patika_list.getValueAt(tbl_patika_list.getSelectedRow(),0).toString());
                if(Patika.delete(select_id)){
                    Helper.showMsg("done");
                    loadPatikaModel();
                    loadPatikaCombo();
                    loadCourseModel();
                }else{
                    Helper.showMsg("error");
                }
            }
        });

        mdl_patika_list = new DefaultTableModel();
        tbl_patika_list.setComponentPopupMenu(patikaMenu);
        Object[] col_patika_list = {"ID","Patika ADI"};
        mdl_patika_list.setColumnIdentifiers(col_patika_list);
        row_patika_list = new Object[col_patika_list.length];
        loadPatikaModel();

        tbl_patika_list.setModel(mdl_patika_list);
        tbl_patika_list.getTableHeader().setReorderingAllowed(false);
        tbl_patika_list.getColumnModel().getColumn(0).setMaxWidth(50);

        tbl_patika_list.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Point point = e.getPoint();
                int selected_row = tbl_patika_list.rowAtPoint(point);

                tbl_patika_list.setRowSelectionInterval(selected_row,selected_row);
            }
        });
        //##PatikaList


        //CourseList
        mdl_course_list = new DefaultTableModel();
        Object[] col_courseList = {"ID","Ders Adı","Programlama Dili","Patika","Eğitmen"};
        mdl_course_list.setColumnIdentifiers(col_courseList);
        row_course_list = new Object[col_courseList.length];
        loadCourseModel();
        tbl_course_list.setModel(mdl_course_list);
        tbl_course_list.getColumnModel().getColumn(0).setMaxWidth(50);
        tbl_course_list.getTableHeader().setReorderingAllowed(false);
        loadPatikaCombo();
        loadEducatorCombo();
        //##CourseList

        btn_user_add.addActionListener(e -> {
            if(Helper.isEmpty(fld_user_name) || Helper.isEmpty(fld_user_uname) || Helper.isEmpty(fld_user_pass)){
                Helper.showMsg("fill");
            }
            else{
                String name = fld_user_name.getText();
                String username = fld_user_uname.getText();
                String pass = fld_user_pass.getText();
                String type = cmb_user_type.getSelectedItem().toString();
                if(User.add(name,username,pass,type)){
                    loadUserModel();
                    loadEducatorCombo();

                    fld_user_name.setText(null);
                    fld_user_uname.setText(null);
                    fld_user_pass.setText(null);
                    Helper.showMsg("done");
                }
            }
        });
        btn_user_delete.addActionListener(e -> {
            if(Helper.isEmpty(fld_user_id)){
                Helper.showMsg("fill");
            }
            else{
                if(Helper.confirm("sure")){
                    int user_id = Integer.parseInt(fld_user_id.getText());
                    if(User.delete(user_id)){
                        Helper.showMsg("done");
                        loadUserModel();
                        loadEducatorCombo();
                        loadCourseModel();
                        fld_user_id.setText(null);
                    }else{
                        Helper.showMsg("error");
                    }
                }

            }

        });
        btn_user_sh.addActionListener(e -> {
            String name = fld_sh_user_name.getText();
            String username = fld_user_uname.getText();
            String type= cmb_sh_user_type.getSelectedItem().toString();
            String query = User.searchQuery(name,username,type);

            loadUserModel(User.searhcUserList(query));

            fld_sh_user_name.setText(null);
            fld_sh_user_uname.setText(null);
            cmb_sh_user_type.setSelectedIndex(0);
        });
        btn_logout.addActionListener(e -> {
            dispose();
            LoginGUI login = new LoginGUI();
        });
        btn_patika_add.addActionListener(e -> {
            if(Helper.isEmpty(fld_patika_name)){
                Helper.showMsg("fill");
            }else{
                if(Patika.add(fld_patika_name.getText())){
                    Helper.showMsg("done");
                    loadPatikaModel();
                    loadPatikaCombo();
                    loadCourseModel();
                }else{
                    Helper.showMsg("error");
                }

            }
        });
        btn_course_add.addActionListener(e -> {
            Item patikaItem = (Item) cmb_course_patika.getSelectedItem();
            Item userItem = (Item) cmb_course_user.getSelectedItem();
            if(Helper.isEmpty(fld_course_name) || Helper.isEmpty(fld_course_lang)){
                    Helper.showMsg("fill");
            }else{
                if(Course.add(userItem.getKey(), patikaItem.getKey(),fld_course_name.getText(),fld_course_lang.getText())){
                    Helper.showMsg("done");
                    loadCourseModel();

                    fld_course_name.setText(null);
                    fld_course_lang.setText(null);
                }else{
                    Helper.showMsg("error");
                }
            }
        });
    }

    private void loadCourseModel() {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_course_list.getModel();
        clearModel.setRowCount(0);
        for(Course obj: Course.getList()){
            int i=0;
            row_course_list[i++]=obj.getId();
            row_course_list[i++]=obj.getName();
            row_course_list[i++]=obj.getLang();
            row_course_list[i++]=obj.getPatika().getName();
            row_course_list[i++]=obj.getEducator().getName();
            mdl_course_list.addRow(row_course_list);
        }
    }

    private void loadPatikaModel() {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_patika_list.getModel();
        clearModel.setRowCount(0);
        for(Patika obj:Patika.getList()){
            int i=0;
            row_patika_list[i++]=obj.getId();
            row_patika_list[i++]=obj.getName();
            mdl_patika_list.addRow(row_patika_list);
        }
    }

    public void loadUserModel(){
        DefaultTableModel clearModel = (DefaultTableModel) tbl_userList.getModel();
        clearModel.setRowCount(0);
        for(User obj: User.getList()){
            int i=0;
            row_user_list[i++]= obj.getId();
            row_user_list[i++]= obj.getName();
            row_user_list[i++]= obj.getUserName();
            row_user_list[i++]= obj.getPass();
            row_user_list[i++]= obj.getType();
            mdl_user_list.addRow(row_user_list);

        }
    }
    public void loadUserModel(ArrayList<User> list){
        DefaultTableModel clearModel = (DefaultTableModel) tbl_userList.getModel();
        clearModel.setRowCount(0);
        for(User obj: list){
            int i=0;
            row_user_list[i++]= obj.getId();
            row_user_list[i++]= obj.getName();
            row_user_list[i++]= obj.getUserName();
            row_user_list[i++]= obj.getPass();
            row_user_list[i++]= obj.getType();
            mdl_user_list.addRow(row_user_list);

        }
    }
    public void loadPatikaCombo(){
        cmb_course_patika.removeAllItems();
        for(Patika p: Patika.getList()){
            cmb_course_patika.addItem(new Item(p.getId(), p.getName()));
        }
    }
    public void loadEducatorCombo(){
        cmb_course_user.removeAllItems();
        for(User obj: User.getList()){
            if(obj.getType().equals("Educator")){
                cmb_course_user.addItem(new Item(obj.getId(), obj.getName()));
            }

        }
    }

    public static void main(String[] args) {
        Helper.setLayout();
        Operator op =new Operator(1,"mesut","meutaryus","123456","operator");
        OperatorGUI opGUI=new OperatorGUI(op);


    }
}
