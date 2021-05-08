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

public class PostWindow extends JFrame {
    public PostWindow() {
        super("POST - WebBuddy");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(1200, 500);

        JTextField url = new JTextField(30);

        JTextField headers = new JTextField(30);

        JLabel instructionsLabel = new JLabel("Type your \"URL\" in the URL box below, then type your parameters in the form of param=value&param2=value2&param3=value3 in the \"Parameters\" box below. Then press the enter key.", JLabel.CENTER);

        add(instructionsLabel, BorderLayout.NORTH);

        PostUrlTextFieldActionEventListener urlTextFieldListener = new PostUrlTextFieldActionEventListener(url, headers);

        JPanel textFieldPanel = new JPanel(new GridLayout(0, 1));

        JLabel urlLabel = new JLabel("URL:", JLabel.CENTER);

        textFieldPanel.add(urlLabel);

        url.addActionListener(urlTextFieldListener);

        textFieldPanel.add(url);

        JLabel headersLabel = new JLabel("Headers (in the form of: key=value&otherkey=othervalue):", JLabel.CENTER);

        textFieldPanel.add(headersLabel);

        headers.addActionListener(urlTextFieldListener);

        textFieldPanel.add(headers);

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
