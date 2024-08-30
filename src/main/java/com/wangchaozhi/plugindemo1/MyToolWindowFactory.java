package com.wangchaozhi.plugindemo1;

import com.intellij.openapi.project.DumbAware;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.components.JBLabel;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;

import javax.swing.*;

public class MyToolWindowFactory implements ToolWindowFactory, DumbAware {

    @Override
    public void createToolWindowContent(Project project, ToolWindow toolWindow) {

        JPanel panel = new JPanel();
        JBLabel label = new JBLabel("Hello, Java Plugin!");
        JButton button = new JButton("Click Me!");


        button.addActionListener(e -> JOptionPane.showMessageDialog(panel, "Button Clicked!"));

        panel.add(label);
        panel.add(button);


        ContentFactory contentFactory = ContentFactory.getInstance();
        Content content = contentFactory.createContent(panel, "", false);
        toolWindow.getContentManager().addContent(content);
    }
}
