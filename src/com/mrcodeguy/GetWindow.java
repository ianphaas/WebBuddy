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
 * Class used to make GET requests
 *
 * @author Ian Haas
 */
public class GetWindow extends JFrame {

    /**
     * Creates a window used to make GET requests
     *
     * @author Ian Haas
     */
    public GetWindow() {
        super("GET - WebBuddy");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(1200, 500);

        JLabel instructionsLabel = new JLabel("<html>Enter the URL (with parameters) of the page you wish to retrieve using the GET method, then press the enter key. Once the operation finishes, the page source will be displayed in the terminal.</html>", JLabel.CENTER);

        add(instructionsLabel, BorderLayout.NORTH);

        GetUrlTextFieldActionEventListener urlTextFieldListener = new GetUrlTextFieldActionEventListener();

        JPanel textFieldPanel = new JPanel(new GridLayout(0, 1));

        JLabel urlLabel = new JLabel("URL:", JLabel.CENTER);

        textFieldPanel.add(urlLabel);

        JTextField url = new JTextField(30);

        url.addActionListener(urlTextFieldListener);

        textFieldPanel.add(url);

        add(textFieldPanel, BorderLayout.CENTER);

        ToolbarActionListener listener = new ToolbarActionListener();

        JMenu fileMenu = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Quit");
        exitItem.addActionListener(listener);
        fileMenu.add(exitItem);

        JMenuBar mainBar = new JMenuBar();
        mainBar.add(fileMenu);
        setJMenuBar(mainBar);
    }
}
