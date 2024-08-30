package com.wangchaozhi.plugindemo1.tool.service.impl;

import com.wangchaozhi.plugindemo1.tool.service.ToolWindowService;
import com.wangchaozhi.plugindemo1.tool.view.window.frame.RightToolWindow;
import com.intellij.openapi.project.Project;

import javax.swing.*;

/**
 * @author ZhangYuanSheng
 * @version 1.0
 */
public class ToolWindowServiceImpl implements ToolWindowService {

    private final Project project;

    public ToolWindowServiceImpl(Project project) {
        this.project = project;
    }

    @Override
    public JComponent getContent() {
        return new RightToolWindow(project);
    }
}
