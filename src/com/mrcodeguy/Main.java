/*
Copyright 2021 Ian Haas

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */

package com.mrcodeguy;

import javax.swing.*;
import java.awt.*;

/**
 * Main class for WebBuddy
 *
 * @author Ian Haas
 */
public class Main extends JFrame {

    /**
     * Creates the main window for WebBuddy
     *
     * @author Ian Haas
     */
    public Main() {
        super("WebBuddy");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(1200, 500);

        JLabel welcomeLabel = new JLabel("Welcome to WebBuddy. Select one of the buttons below to get started.", JLabel.CENTER);

        add(welcomeLabel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout());

        MethodButtonActionEventListener buttonListener = new MethodButtonActionEventListener();

        JButton getButton = new JButton("GET");
        JButton postButton = new JButton("POST");

        getButton.addActionListener(buttonListener);
        postButton.addActionListener(buttonListener);

        buttonPanel.add(getButton);
        buttonPanel.add(postButton);

        add(buttonPanel, BorderLayout.SOUTH);

        ToolbarActionListener menuListener = new ToolbarActionListener();

        JMenu fileMenu = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Quit");
        exitItem.addActionListener(menuListener);
        fileMenu.add(exitItem);

        JMenuBar mainBar = new JMenuBar();
        mainBar.add(fileMenu);
        setJMenuBar(mainBar);
    }

    /**
     * Initializes WebBuddy
     *
     * @author Ian Haas
     * @param args Not Used
     */
    public static void main(String[] args) {
        Main main = new Main();
        main.setVisible(true);
    }
}
