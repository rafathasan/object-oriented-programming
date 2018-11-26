/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userFrame.adminFrame;

import classes.user.CustomJLabelButton;
import deviceListener.LabelButtonListener;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.MouseEvent;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;

/**
 *
 * @author rafikhan
 */
public class RevenueGenarateButton extends CustomJLabelButton{
    public RevenueGenarateButton() {
        setText("Revenue");
        setHorizontalAlignment(CENTER);
        setOpaque(true);
        setFont(new Font("Serif", Font.BOLD, 18));
        frame = new RevenueGenarateForm();
        title = "Revenue";
    }
}
