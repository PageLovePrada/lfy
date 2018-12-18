package com.lfy.test;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
public class play
{
    //定义该图形中所需的组件的引用
    private Frame f;
    private JButton bt; 
    
    //方法
   play()//构造方法
    {
        madeFrame();
    }
    
    public void madeFrame()
    {
        f = new Frame("My Frame");
        
        //对Frame进行基本设置。
        f.setBounds(300,100,600,500);//对框架的位置和大小进行设置
        f.setLayout(new FlowLayout(FlowLayout.CENTER,5,5));//设计布局
        
        bt = new JButton("男人都是大猪蹄子!!!");
        
        //将组件添加到Frame中
        f.add(bt);
        
        //加载一下窗体上的事件
        myEvent();
        
        //显示窗体
        f.setVisible(true);
    }
    
    private void myEvent()
    {
        f.addWindowListener(new WindowAdapter()//窗口监听
        {
            public void windowClosing(WindowEvent e)
            {
                System.out.println("呵呵,走好不送！");
                System.exit(0);
            }
        });

        bt.addActionListener(new ActionListener()//按钮监听
        {
            public void actionPerformed(ActionEvent e)
            {
                 System.out.println("离我远点!");
            }
        });
        bt.addMouseListener(new MouseAdapter()//鼠标监听
        {
            private int count = 1; 
            private int mouseCount = 1;
            public void mouseEntered(MouseEvent e)
            {
                System.out.println("你瞅啥");
            }
            public void mouseClicked(MouseEvent e)
            {
                if(e.getClickCount()==2)
                   System.out.println("别碰我");
                else System.out.println("别碰我");
            }
        });
    }
    
    public static void main(String[] agrs)
    {
        new play();
    }
}