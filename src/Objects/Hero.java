/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import Functionality.Constants;
import static Functionality.Globals.instance;
import Functionality.MP3;
import GUI.GameMedium;
import GUI.MainMenu;
import GUI.SubmitNickname;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniel-PC
 */
public class Hero extends Element {

    JFrame frame;
    Element[][] matrix;
    java.awt.event.KeyEvent event;
    private boolean isDead;

    public Hero(int positionX, int positionY, JFrame frame) {
        super(positionX, positionY);
        this.frame = frame;
        this.isDead = false;
    }

    public KeyEvent getEvent() {
        return event;
    }

    public void setEvent(KeyEvent event) {
        this.event = event;
    }

    public void move(Element[][] matrix, java.awt.event.KeyEvent event) {
        Element evaluedElement;
        try {
            switch (event.getKeyCode()) {
                case KeyEvent.VK_DOWN:
                    if (!(this.getPositionX() < 0) || (this.getPositionX() > 19) || (this.getPositionY() < 0) || (this.getPositionY() > 19)) {
                        evaluedElement = matrix[this.getPositionX()][this.getPositionY() + 1];
                        if ((evaluedElement.getClass().getSimpleName().equals("Door"))) {
                            this.win();
                            break;
                        }
                        if ((evaluedElement.isIndestructible()) || (!evaluedElement.canBeStomped())) {
                            break;
                        } else {
                            if ((evaluedElement.getClass().getSimpleName().equals("Balloon")) || (evaluedElement.getClass().getSimpleName().equals("Barrell"))) {
                                this.die();
                                return;
                            } else {
                                if (matrix[this.getPositionX()][this.getPositionY() + 1].getClass().getSimpleName().equals("Power")) {
                                    Constants.BOMB_RANGE += 1;
                                }
                                matrix[this.getPositionX()][this.getPositionY() + 1] = this;
                                instance.getCurrentMatrix().getMatrix()[this.getPositionX()][this.getPositionY() + 1].getImageLabel().setLocation(this.getPositionX() * Constants.IMAGE_SIZE, (this.getPositionY() + 1) * Constants.IMAGE_SIZE);
                                matrix[this.getPositionX()][this.getPositionY()] = new EmptySpace(0, 0);
                                instance.getCurrentMatrix().getMatrix()[this.getPositionX()][this.getPositionY()].getImageLabel().setLocation(this.getPositionX() * Constants.IMAGE_SIZE, this.getPositionY() * Constants.IMAGE_SIZE);
                                instance.getFrame().repaint();
                                this.setPosition(this.getPositionX(), this.getPositionY() + 1);
                                instance.setHeroPositionX(this.getPositionX());
                                instance.setHeroPositionY(this.getPositionY());
                                break;
                            }
                        }
                    }

                case KeyEvent.VK_UP:
                    if (!(this.getPositionX() < 0) || (this.getPositionX() > 19) || (this.getPositionY() < 0) || (this.getPositionY() > 19)) {
                        evaluedElement = matrix[this.getPositionX()][this.getPositionY() - 1];
                        if ((evaluedElement.getClass().getSimpleName().equals("Door"))) {
                            this.win();
                            break;
                        }
                        if ((evaluedElement.isIndestructible()) || (!evaluedElement.canBeStomped())) {
                            break;
                        } else {
                            if ((evaluedElement.getClass().getSimpleName().equals("Balloon")) || (evaluedElement.getClass().getSimpleName().equals("Barrell"))) {
                                this.die();
                                break;
                            } else {
                                if (matrix[this.getPositionX()][this.getPositionY() - 1].getClass().getSimpleName().equals("Power")) {
                                    Constants.BOMB_RANGE += 1;
                                }
                                matrix[this.getPositionX()][this.getPositionY() - 1] = this;
                                instance.getCurrentMatrix().getMatrix()[this.getPositionX()][this.getPositionY() - 1].getImageLabel().setLocation(this.getPositionX() * Constants.IMAGE_SIZE, (this.getPositionY() - 1) * Constants.IMAGE_SIZE);
                                matrix[this.getPositionX()][this.getPositionY()] = new EmptySpace(0, 0);
                                instance.getCurrentMatrix().getMatrix()[this.getPositionX()][this.getPositionY()].getImageLabel().setLocation(this.getPositionX() * Constants.IMAGE_SIZE, this.getPositionY() * Constants.IMAGE_SIZE);
                                instance.getFrame().repaint();
                                this.setPosition(this.getPositionX(), this.getPositionY() - 1);
                                instance.setHeroPositionX(this.getPositionX());
                                instance.setHeroPositionY(this.getPositionY());
                                break;
                            }
                        }
                    }

                case KeyEvent.VK_LEFT:
                    evaluedElement = matrix[this.getPositionX() - 1][this.getPositionY()];
                    if ((evaluedElement.getClass().getSimpleName().equals("Door"))) {
                        this.win();
                        break;
                    }
                    if (!(this.getPositionX() < 0) || (this.getPositionX() > 19) || (this.getPositionY() < 0) || (this.getPositionY() > 19)) {
                        if ((evaluedElement.isIndestructible()) || (!evaluedElement.canBeStomped())) {
                            break;
                        } else {
                            if ((evaluedElement.getClass().getSimpleName().equals("Balloon")) || (evaluedElement.getClass().getSimpleName().equals("Barrell"))) {
                                this.die();
                                break;
                            } else {
                                if (matrix[this.getPositionX() - 1][this.getPositionY()].getClass().getSimpleName().equals("Power")) {
                                    Constants.BOMB_RANGE += 1;
                                }
                                matrix[this.getPositionX() - 1][this.getPositionY()] = this;
                                instance.getCurrentMatrix().getMatrix()[this.getPositionX() - 1][this.getPositionY()].getImageLabel().setLocation((this.getPositionX() - 1) * Constants.IMAGE_SIZE, this.getPositionY() * Constants.IMAGE_SIZE);
                                matrix[this.getPositionX()][this.getPositionY()] = new EmptySpace(0, 0);
                                instance.getCurrentMatrix().getMatrix()[this.getPositionX()][this.getPositionY()].getImageLabel().setLocation(this.getPositionX() * Constants.IMAGE_SIZE, this.getPositionY() * Constants.IMAGE_SIZE);
                                this.setPosition(this.getPositionX() - 1, this.getPositionY());
                                instance.setHeroPositionX(this.getPositionX());
                                instance.setHeroPositionY(this.getPositionY());

                                break;
                            }
                        }
                    }

                case KeyEvent.VK_RIGHT:
                    if (!(this.getPositionX() < 0) || (this.getPositionX() > 19) || (this.getPositionY() < 0) || (this.getPositionY() > 19)) {
                        evaluedElement = matrix[this.getPositionX() + 1][this.getPositionY()];
                        if ((evaluedElement.getClass().getSimpleName().equals("Door"))) {
                            this.win();
                            break;
                        }
                        if ((evaluedElement.isIndestructible()) || (!evaluedElement.canBeStomped())) {
                            break;
                        } else {
                            if ((evaluedElement.getClass().getSimpleName().equals("Balloon")) || (evaluedElement.getClass().getSimpleName().equals("Barrell"))) {
                                this.die();
                                break;
                            } else {
                                if (matrix[this.getPositionX() + 1][this.getPositionY()].getClass().getSimpleName().equals("Power")) {
                                    Constants.BOMB_RANGE += 1;
                                }
                                matrix[this.getPositionX() + 1][this.getPositionY()] = this;
                                instance.getCurrentMatrix().getMatrix()[this.getPositionX() + 1][this.getPositionY()].getImageLabel().setLocation((this.getPositionX() + 1) * Constants.IMAGE_SIZE, this.getPositionY() * Constants.IMAGE_SIZE);

                                matrix[this.getPositionX()][this.getPositionY()] = new EmptySpace(0, 0);

                                instance.getCurrentMatrix().getMatrix()[this.getPositionX()][this.getPositionY()].getImageLabel().setLocation(this.getPositionX() * Constants.IMAGE_SIZE, this.getPositionY() * Constants.IMAGE_SIZE);
                                instance.getFrame().repaint();
                                this.setPosition(this.getPositionX() + 1, this.getPositionY());
                                instance.setHeroPositionX(this.getPositionX());
                                instance.setHeroPositionY(this.getPositionY());

                                break;
                            }
                        }
                    }
                case KeyEvent.VK_CONTROL:
                    placeBomb();

                default:
                    break;

            }

        } catch (java.lang.ArrayIndexOutOfBoundsException e) {

        }
    }

    @Override
    public void setLabel() {
        ImageIcon hero = new ImageIcon(Hero.class.getResource("/Images/bomberman.png"));
        this.getImageLabel().setIcon(hero);

    }

    @Override
    public Image setImage() throws MalformedURLException {
        //ImageIcon hero = new ImageIcon(Hero.class.getResource("/Images/bomberman.png"));
        //this.getImageLabel().setIcon(hero);

        BufferedImage hero = null;
        try {
            hero = ImageIO.read(Barrell.class.getResource("/Images/bomberman.png"));

        } catch (IOException ex) {
            Logger.getLogger(Barrell.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hero;
    }

    @Override
    public boolean canBeStomped() {
        return true;
    }

    @Override
    public boolean isIndestructible() {
        return false;
    }

    @Override
    public void die() {
        this.isDead = true;
        instance.getMusic().close();
        instance.getChrono().stopTimer();
        instance.getCurrentMatrix().getMatrix()[this.getPositionX()][this.getPositionY()] = new EmptySpace(0, 0);
        for (int row = 0; row < instance.getCurrentMatrix().getMatrix().length; row++) {
            for (int col = 0; col < instance.getCurrentMatrix().getMatrix().length; col++) {
                //if (instance.getCurrentMatrix().getMatrix()[row][col].getClass().getSimpleName().equals("Balloon")) {
                instance.getCurrentMatrix().getMatrix()[row][col].interrupt();
                // }
            }
        }
        MP3 lostMusic = new MP3("/Sounds/lost.mp3");
        lostMusic.play();
        int retry = JOptionPane.showConfirmDialog(null,
                "YOU DIED!\nRetry?",
                "Confirmation Message", JOptionPane.YES_NO_OPTION);

        if (retry == 0) {
            try {
                lostMusic.close();
                instance.getCurrentMatrix().empty();
                GameMedium newGame = new GameMedium();

                instance.getCurrentMatrix().fill();
                instance.paintFrame();

                newGame.setEnabled(true);
                newGame.setVisible(true);
                this.frame.setEnabled(false);
                this.frame.setVisible(false);
            } catch (MalformedURLException ex) {
                Logger.getLogger(Hero.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            lostMusic.close();
            instance.getCurrentMatrix().empty();
            MainMenu menuWindow = new MainMenu();
            menuWindow.setVisible(true);
            this.frame.setEnabled(false);
            this.frame.setVisible(false);
        }

    }

    public void win() {
        instance.getMusic().close();
        MP3 win = new MP3("/Sounds/win.mp3");
        win.play();
        this.isDead = true;
        instance.getChrono().stopTimer();
        instance.setCurrentPlayerTime(instance.getChrono().getTime());
        for (int row = 0; row < instance.getCurrentMatrix().getMatrix().length; row++) {
            for (int col = 0; col < instance.getCurrentMatrix().getMatrix().length; col++) {
                //if (instance.getCurrentMatrix().getMatrix()[row][col].getClass().getSimpleName().equals("Balloon")) {
                instance.getCurrentMatrix().getMatrix()[row][col].interrupt();
                // }
            }
        }

        SubmitNickname newWindow = new SubmitNickname(instance.getFrame(), true);
        newWindow.setVisible(true);

    }

    public void placeBomb() {
        Bomb bomb = new Bomb(this.getPositionX(), this.getPositionY(), this);
        instance.getCurrentMatrix().getMatrix()[this.getPositionX()][this.getPositionY()].setLabel("bomb.gif");
        instance.getCurrentMatrix().getMatrix()[this.getPositionX()][this.getPositionY()].setIsBomb(true);
        bomb.start();
    }

    @Override
    public void run() {
        System.out.println("Hero Started");
        try {
            while (this.isDead == false) {
                this.move(matrix, this.getEvent());
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        this.interrupt();
    }
}
