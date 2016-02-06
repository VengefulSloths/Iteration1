package com.vengeful.sloths.View.MainMenuView.Commands;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Alex on 2/5/2016.
 */
public class FocusTextCommand extends MenuCommand{
    private TextArea textField;
    public FocusTextCommand(TextArea textField) {
        this.textField = textField;
    }

    public void execute() {
        this.textField.requestFocus();
    }
}
