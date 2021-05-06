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

import java.awt.event.*;

public class MethodButtonActionEventListener implements ActionListener {
    public void actionPerformed(ActionEvent event) {
        if (event.getActionCommand().equals("GET")) {
            GetWindow getWindow = new GetWindow();
            getWindow.setVisible(true);
        } else if (event.getActionCommand().equals("POST")) {
            PostWindow postWindow = new PostWindow();
            postWindow.setVisible(true);
        }
    }
}