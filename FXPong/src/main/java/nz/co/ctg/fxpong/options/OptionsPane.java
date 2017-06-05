/*******************************************************************************
 * Copyright (c) 2016 CTG Games Limited.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package nz.co.ctg.fxpong.options;

import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class OptionsPane extends BorderPane {
  
  public OptionsPane(String title) {
    setTop(new Label(title));
    GridPane form = new GridPane();
    form.addRow(0, new Label("Music"), new CheckBox());
    form.addRow(1, new Label("Audio"), new CheckBox());
    setCenter(form);
  }
  
}
