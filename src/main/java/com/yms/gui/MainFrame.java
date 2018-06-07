package com.yms.gui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainFrame extends JFrame {
    private JPanel p;
    private JLabel lblTitle,lblSearch;
    private JTextField txtSearch;
    private JButton per1,per2,per3,btnSearch;

    public MainFrame() {
        super("主页");
        p = new JPanel(new FlowLayout(FlowLayout.CENTER));

        lblTitle = new JLabel("Welcome to TeleMemo ");
        lblTitle.setFont(new Font("Ubuntu",Font.BOLD,25));
        lblSearch = new JLabel("搜 索: ");
        lblSearch.setFont(new Font("宋体",Font.BOLD,20));

        txtSearch = new JTextField("Search what you want",15);
        txtSearch.setFont(new Font("宋体",Font.ITALIC,17));

        per1 = new JButton("家人");
        per2 = new JButton("朋友");
        per3 = new JButton("老师");
        btnSearch = new JButton("搜索");


        //设置标题
        JPanel p1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        p1.add(lblTitle);
        p.add(p1);

        //设置搜索框
        JPanel p2 = new JPanel(new FlowLayout(FlowLayout.CENTER,20,20));
        p2.add(txtSearch);
        p2.add(btnSearch);
        p.add(p2);

        //设置按钮
        JPanel p3 = new JPanel(new FlowLayout(FlowLayout.CENTER,10,10));
        p3.add(per1);
        p3.add(per2);
        p3.add(per3);
        p.add(p3);


        //添加到Frame
        this.add(p);
        this.setSize(400,400);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        new MainFrame();
    }

}

