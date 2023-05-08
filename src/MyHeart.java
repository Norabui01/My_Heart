//Author: Ngoc Bui
//Date: 04/07/2023
//Purpose: Create fat hearts

import javax.swing.*;
import java.awt.*;
public class MyHeart extends JPanel{
    int strokeWeight = 1;

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        this.setBackground(Color.BLACK);

        drawFatHearts(g, 420, 0);

    }
    public void drawFatHearts(Graphics g, int xCenter1, int radius){
        Color[] color = new Color[]{Color.RED, Color.RED, Color.RED,
                new Color(240, 0, 0),
                new Color(250, 0, 100),
                Color.WHITE, Color.WHITE,
                new Color(250, 0, 150),
                new Color(255, 100, 170)
        };
        int color_index = 0;

        int xCenter2 = xCenter1 + 30;
        int yCenter = 160;

        int angleChange = 4;
        int changeMax = 19;

        int iterations = 300;
        for(int num = 0; num < iterations; num ++){
            drawHalfLeftHeart(g, xCenter1, yCenter, radius, angleChange, color[color_index]);
            drawHalfRightHeart(g, xCenter2, yCenter, radius, angleChange, color[color_index]);
            color_index += 1;
            if(color_index > 8){
                color_index = 0;
            }

            xCenter1 -= 3;
            xCenter2 += 3;
            yCenter += 8;
            radius += 5;

            angleChange += 1;
            if(angleChange > changeMax) {
                angleChange = 4;
                yCenter = 180;
                xCenter1 += 2;
                xCenter2 -= 2;
            }
        }
    }

    private void drawHalfLeftHeart(Graphics g, int xCenter, int yCenter,
                                   int radius, int angleDecrease, Color color){
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(strokeWeight));

        int angle = 315;
        int minAngle = 80;
        int angleBottomHeart = 110;

        while(angle > minAngle) {
            int x1 = xCenter + (int)(radius * Math.cos(Math.toRadians(angle)));
            int y1 = yCenter + (int)(radius * Math.sin(Math.toRadians(angle)));

            g.setColor(color);
            g.drawLine(x1, y1, x1 + 1, y1 + 1);

            angle -= angleDecrease;
            radius += 6;
            if(angle < angleBottomHeart){
                radius += 11;
            }
        }
    }

    private void drawHalfRightHeart(Graphics g, int xCenter, int yCenter,
                                    int radius, int angleIncrement, Color color){
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(strokeWeight));

        int angle = 225;
        int maxAngle = 460;
        int angleTopHeart = 430;

        while(angle < maxAngle) {
            int x1 = xCenter + (int)(radius * Math.cos(Math.toRadians(angle)));
            int y1 = yCenter + (int)(radius * Math.sin(Math.toRadians(angle)));

            g.setColor(color);
            g.drawLine(x1, y1, x1 + 1, y1 + 1);

            angle += angleIncrement;
            radius += 6;
            if(angle > angleTopHeart){
                radius += 11;
            }
        }
    }

    public static void main(String[] args){
        int winWid = 900;
        int winHie = 700;
        JFrame myFrame = new JFrame("My Fat Heart - Ngoc Bui");
        myFrame.setSize(winWid, winHie);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        myFrame.add(new MyHeart());
        myFrame.setVisible(true);
    }
}
