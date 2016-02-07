package com.vengeful.sloths.View.MainMenuView.Commands;

import com.vengeful.sloths.View.MainMenuView.DefaultMenuComponent;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Alex on 2/5/2016.
 */
public class FocusTextCommand extends MenuCommand{
    private TextArea textField;
    private DefaultMenuComponent hack;
    public FocusTextCommand(TextArea textField, DefaultMenuComponent hack) {
        this.hack = hack;
        this.textField = textField;
    }

    public void execute() {
        this.hack.setSelected(true);
        this.textField.requestFocus();
    }
}
