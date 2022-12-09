package cz.spsmb.game;

import java.awt.event.KeyEvent;

public class KeyListener implements java.awt.event.KeyListener {
    char A;
    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println(e.getKeyChar());
        A = e.getKeyChar();
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
