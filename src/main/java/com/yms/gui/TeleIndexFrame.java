package com.yms.gui;

import com.yms.comm.ServiceNameHelper;
import com.yms.comm.VectorForPersonFactory;
import com.yms.domain.Friend;
import com.yms.domain.Kinsfolk;
import com.yms.domain.Teacher;
import com.yms.start.TeleMemo;
import sun.awt.image.codec.JPEGParam;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TeleIndexFrame extends JFrame  implements ListSelectionListener {
    private JPanel p;

    private JPanel north;
    private JPanel west;
    private JPanel south;
    private JPanel east;
    private JPanel center;

    private JScrollPane jsnorth;
    private JScrollPane jswest;


    private JScrollPane jssouth;
    private JScrollPane jseast;
    private JScrollPane jscenter;

    private DefaultTableModel tableModel;
    private JTable table;
    ListSelectionModel selectionMode = null;

    JTextField txtSearch;

    JButton btnSearch;





    public void valueChanged(ListSelectionEvent e) {
        /**
         * 当用户选取表格数据时会出发ListSelectionEvent,使用ListSelectionListener界面来处理这一事件
         */
        String tempString = "";
        // JTable的getSelectedRows()与getSelectedColumns()方法会返回
        // 已取表格cell的index Array数据
        int[] rows = table.getSelectedRows();
        int[] columns = table.getSelectedColumns();
        for (int i = 0; i < rows.length; i++) {
            // JTable的getValueAt()方法会返回某行的cell数据，返回值是Object数据类型
            // 一次要自动转成String数据类型
            for (int j = 0; j < columns.length; j++) {
                tempString = tempString + ""
                        + (String) table.getValueAt(rows[i], columns[j]);
                System.out.println("第" + rows[i] + "行,第" + columns[j] + "列数据为： " + tempString);

            }

        }
    }


    public TeleIndexFrame() {
        super("欢迎来到TeleMemo!");
        p = new JPanel(new BorderLayout(0,0));


        //北部布局
        north = new JPanel(new FlowLayout(FlowLayout.CENTER));
        txtSearch = new JTextField("Search what you want",15);
        txtSearch.setFont(new Font("宋体",Font.ITALIC,17));
        btnSearch = new JButton("搜索");
        north.add(txtSearch);
        north.add(btnSearch);
        jsnorth = new JScrollPane(north);


        //西部布局
        west = new JPanel(new FlowLayout(FlowLayout.CENTER));
        west.setPreferredSize(new Dimension(70, 0));
        JLabel lblWest = new JLabel("分类");
        lblWest.setFont(new Font("宋体",Font.PLAIN,20));
        JButton btn1 = new JButton("家人");
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               tableModel.setDataVector(VectorForPersonFactory.getKinsfolkData(), ServiceNameHelper.getKinsfolkName());
                System.out.println(tableModel.getDataVector().toString());
            }
        });
        JButton btn2 = new JButton("朋友");
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tableModel.setDataVector(VectorForPersonFactory.getFriendData(), ServiceNameHelper.getFriendName());
            }
        });
        JButton btn3 = new JButton("老师");
        btn3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tableModel.setDataVector(VectorForPersonFactory.getTeacherData(), ServiceNameHelper.getTeacherName());
            }
        });
        west.add(lblWest);
        west.add(btn1);
        west.add(btn2);
        west.add(btn3);
        jswest = new JScrollPane(west);

        //南部布局
        south = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel lblCpy = new JLabel("版权所有2018");
        south.add(lblCpy);
        jssouth = new JScrollPane(south);

        //东部布局
        east = new JPanel(new FlowLayout(FlowLayout.CENTER));
        east.setPreferredSize(new Dimension(70, 0));
        JLabel lblEast = new JLabel("操作");
        lblEast.setFont(new Font("宋体",Font.PLAIN,20));
        final JButton btn4 = new JButton("添加");
        btn4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Object [] options = {"亲人","朋友","老师"};
                final int A = 1;
                final int B = 2;
                final int C = 3;

                int sel = JOptionPane.showOptionDialog(null,
                        "请选择你添加的类型!",
                        "选择",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.WARNING_MESSAGE,
                        null,
                        options,
                        options[0]);
                if (sel != JOptionPane.CLOSED_OPTION) {
                    switch (sel+1) {
                        case A:{
                            TeleIndexFrame.addPersonView(A);
                        }break;
                        case B: {
                            TeleIndexFrame.addPersonView(B);
                        }break;
                        case C: {
                            TeleIndexFrame.addPersonView(C);
                        }break;

                    }
                }

            }
        });
        JButton btn5 = new JButton("删除");
        btn5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                delPerson();
            }
        });
        JButton btn6 = new JButton("恢复");
        JButton btn7 = new JButton("备份");
        JButton btn8 = new JButton("保存");
        east.add(lblEast);
        east.add(btn4);
        east.add(btn5);
        east.add(btn8);
        east.add(btn6);
        east.add(btn7);
        jseast = new JScrollPane(east);

        //中间布局
        //必须把table加入到JScroLLpane中,不然无法显示标题
        //center = new JPanel(new FlowLayout(FlowLayout.CENTER));
        DefaultTableCellRenderer r = new DefaultTableCellRenderer();//设置表格数据居中
        r.setHorizontalAlignment(JLabel.CENTER);
        tableModel = new DefaultTableModel();
        table = new JTable(tableModel);
        table.setDefaultRenderer(Object.class, r);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        selectionMode = table.getSelectionModel();// 取得table的ListSelectionModel.
        selectionMode.addListSelectionListener(this);
       // center.add(table);
        jscenter = new JScrollPane(table);

        //分别加入到边界布局中
        p.add(jsnorth,BorderLayout.NORTH);
        p.add(jswest,BorderLayout.WEST);
        p.add(jssouth,BorderLayout.SOUTH);
        p.add(jseast,BorderLayout.EAST);
        p.add(jscenter,BorderLayout.CENTER);

        //添加到Frame
        this.add(p);
        this.setSize(800,400);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //初始化数据
        tableModel.setDataVector(VectorForPersonFactory.getTeacherData(), ServiceNameHelper.getTeacherName());
    }


    private static void addPersonView(final int match) {
        int txtFieldLength = 16;
        int hgap = 5;
        int vgap = 5;
        final Frame frame2 = new JFrame();
        JPanel p2 = new JPanel(new FlowLayout(FlowLayout.LEFT,5,5));

        JPanel p21 = new JPanel(new FlowLayout(FlowLayout.CENTER,hgap ,vgap));
        JLabel lbladd1 = new JLabel("电话 : ");
        final JTextField txtadd1 = new JTextField(txtFieldLength);
        txtadd1.setName("无");
        p21.add(lbladd1);
        p21.add(txtadd1);
        p2.add(p21);

        JPanel p22 = new JPanel(new FlowLayout(FlowLayout.CENTER,hgap ,vgap));
        JLabel lbladd2 = new JLabel("名字 : ");
        final JTextField txtadd2 = new JTextField(txtFieldLength);
        txtadd2.setName("无");
        p22.add(lbladd2);
        p22.add(txtadd2);
        p2.add(p22);


        JPanel p23 = new JPanel(new FlowLayout(FlowLayout.CENTER,hgap ,vgap));
        JLabel lbladd3 = new JLabel("地址 : ");
        final JTextField txtadd3 = new JTextField(txtFieldLength);
        txtadd3.setName("无");
        p23.add(lbladd3);
        p23.add(txtadd3);
        p2.add(p23);

        final JTextField txtadd4 = new JTextField("",txtFieldLength);
        txtadd4.setName("无");
        final JTextField txtadd5 = new JTextField("",txtFieldLength);
        txtadd5.setName("无");
        final JTextField txtadd6 = new JTextField("",txtFieldLength);
        txtadd6.setName("无");
        final JTextField txtadd7 = new JTextField("",txtFieldLength);
        txtadd7.setName("无");
        switch (match) {
            case 1: {
                JPanel p24 = new JPanel(new FlowLayout(FlowLayout.CENTER,hgap ,vgap));
                JLabel lbladd4 = new JLabel("称呼 : ");
                p24.add(lbladd4);
                p24.add(txtadd4);
                p2.add(p24);


                JPanel p25 = new JPanel(new FlowLayout(FlowLayout.CENTER,hgap ,vgap));
                JLabel lbladd5 = new JLabel("职业 : ");
                p25.add(lbladd5);
                p25.add(txtadd5);
                p2.add(p25);

                JPanel p26 = new JPanel(new FlowLayout(FlowLayout.CENTER,hgap ,vgap));
                JLabel lbladd6 = new JLabel("微信 : ");
                p26.add(lbladd6);
                p26.add(txtadd6);
                p2.add(p26);

            }break;
            case 2:{
                JPanel p24 = new JPanel(new FlowLayout(FlowLayout.CENTER,hgap ,vgap));
                JLabel lbladd4 = new JLabel("E-Mail : ");
                p24.add(lbladd4);
                p24.add(txtadd4);
                p2.add(p24);


                JPanel p25 = new JPanel(new FlowLayout(FlowLayout.CENTER,hgap ,vgap));
                JLabel lbladd5 = new JLabel("QQ : ");
                p25.add(lbladd5);
                p25.add(txtadd5);
                p2.add(p25);

                JPanel p26 = new JPanel(new FlowLayout(FlowLayout.CENTER,hgap ,vgap));
                JLabel lbladd6 = new JLabel("微信 : ");
                p26.add(lbladd6);
                p26.add(txtadd6);
                p2.add(p26);
            }break;
            case 3: {
                JPanel p24 = new JPanel(new FlowLayout(FlowLayout.CENTER,hgap ,vgap));
                JLabel lbladd4 = new JLabel("称呼 : ");
                p24.add(lbladd4);
                p24.add(txtadd4);
                p2.add(p24);


                JPanel p25 = new JPanel(new FlowLayout(FlowLayout.CENTER,hgap ,vgap));
                JLabel lbladd5 = new JLabel("教授 : ");
                p25.add(lbladd5);
                p25.add(txtadd5);
                p2.add(p25);

                JPanel p26 = new JPanel(new FlowLayout(FlowLayout.CENTER,hgap ,vgap));
                JLabel lbladd6 = new JLabel("学校 : ");
                p26.add(lbladd6);
                p26.add(txtadd6);
                p2.add(p26);

                JPanel p27 = new JPanel(new FlowLayout(FlowLayout.CENTER,hgap ,vgap));
                JLabel lbladd7 = new JLabel("E-Mail : ");
                p27.add(lbladd7);
                p27.add(txtadd7);
                p2.add(p27);
            }break;
        }

        JPanel p27 = new JPanel(new FlowLayout(FlowLayout.CENTER,45 ,15));
        JButton btn1 = new JButton("确定");
        JButton btn2 = new JButton("取消");
        p27.add(btn1);
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switch (match) {
                    case 1: {
                        TeleMemo.getInstance().addPerson(
                                new Kinsfolk(
                                        txtadd1.getText(),
                                        txtadd2.getText(),
                                        txtadd3.getText(),
                                        txtadd4.getText(),
                                        txtadd5.getText(),
                                        txtadd6.getText()));
                    }break;
                    case 2: {
                        TeleMemo.getInstance().addPerson(
                                new Friend(txtadd1.getText(),
                                        txtadd2.getText(),
                                        txtadd3.getText(),
                                        txtadd4.getText(),
                                        txtadd5.getText(),
                                        txtadd6.getText()));
                    }break;
                    case 3: {
                        TeleMemo.getInstance().addPerson(
                                new Teacher(txtadd1.getText(),
                                        txtadd2.getText(),
                                        txtadd3.getText(),
                                        txtadd4.getText(),
                                        txtadd5.getText(),
                                        txtadd6.getText(),
                                        txtadd7.getText()));
                    }break;
                }

                frame2.setVisible(false);

            }
        });
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame2.setVisible(false);
            }
        });
        p27.add(btn2);
        p2.add(p27);


        frame2.add(p2);

        frame2.setTitle("添加");
        frame2.setSize(250,350);
        frame2.setLocationRelativeTo(null);
        frame2.setResizable(false);
        frame2.setVisible(true);
        //frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



    }

    private void delPerson() {
        int index[] = table.getSelectedRows();
        if ( index.length == 0 ) {
            JOptionPane.showMessageDialog(this,"请选择要删除的记录","提示",JOptionPane.PLAIN_MESSAGE);
        } else {
            int k = JOptionPane.showConfirmDialog(this,
                    "你确定要删除该联系人",
                    "删除",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
            if( k == JOptionPane.YES_NO_OPTION) {
                String phoneId = table.getValueAt(index[0],0).toString();
                if (TeleMemo.getInstance().delPersonByPhone(phoneId)) {
                    JOptionPane.showMessageDialog(null,
                            "成功删除该联系人!",
                            "提示",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null,
                            "删除联系人失败!",
                            "错误",
                            JOptionPane.ERROR_MESSAGE);
                }
            }

        }
    }


    public static void main(String[] args) {

        TeleIndexFrame.addPersonView(1);
    }
}
