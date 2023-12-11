import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.tools.Tool;

public class Main implements Runnable {
    final int WIDTH = 1000;
    final int HEIGHT = 700;

    //Declare the variables needed for the graphics
    public JFrame frame;
    public Canvas canvas;
    public JPanel panel;

    public BufferStrategy bufferStrategy;

    public static void main(String[] args) {
        Main ex = new Main();   //creates a new instance of the game
        new Thread(ex).start();                 //creates a threads & starts up the code in the run( ) method
    }
    public Image Fish1Pic;
    public Image Fish2Pic;
    public Image Fish3Pic;
    public Image Fish4Pic;
    public Image sharkPic;
    public Image Fish5Pic;
    public Image Fish6Pic;

    public Image backround;

    public fishes Fish1;
    public fishes Fish2;
    public fishes Fish3;
    public fishes Fish4;
    public fishes Fish5;
    public fishes Fish6;
    public fishes shark;
    public Main() {


        setUpGraphics();

        //variable and objects
        //create (construct) the objects needed for the game and load up
        Fish2Pic= Toolkit.getDefaultToolkit().getImage("blueCuteFish.png");
        Fish2 = new fishes(334, 790);
        Fish1Pic= Toolkit.getDefaultToolkit().getImage("dory.png"); //load the picture
        Fish1= new fishes(255,255);
        Fish3Pic= Toolkit.getDefaultToolkit().getImage("fish3.png");
        Fish3= new fishes(467,567);
        Fish4Pic= Toolkit.getDefaultToolkit().getImage("butterly.png");
        Fish4= new fishes(478, 778);
        sharkPic= Toolkit.getDefaultToolkit().getImage("shark.png");
        shark= new fishes(90,10);
        Fish5Pic= Toolkit.getDefaultToolkit().getImage("purple.png");
        Fish5= new fishes(700,700);
        Fish6Pic= Toolkit.getDefaultToolkit().getImage("green.png");
        Fish6= new fishes(500,500);
        backround = Toolkit.getDefaultToolkit().getImage("sea.png");


    }// BasicGameApp()
    public void run() {

        //for the moment we will loop things forever.
        while (true) {

            moveThings();  //move all the game objects
            render();  // paint the graphics
            pause(20); // sleep for 10 ms
        }
    }
    public void moveThings()
    {
        Fish1.wrap();
        Fish2.wrap();
        Fish3.wrap();
        Fish4.wrap();
        Fish5.wrap();
        Fish6.wrap();
        shark.bounce();
    }
    public void pause(int time ){
        //sleep
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {

        }
    }
    private void setUpGraphics() {
        frame = new JFrame("Application Template");   //Create the program window or frame.  Names it.

        panel = (JPanel) frame.getContentPane();  //sets up a JPanel which is what goes in the frame
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));  //sizes the JPanel
        panel.setLayout(null);   //set the layout

        // creates a canvas which is a blank rectangular area of the screen onto which the application can draw
        // and trap input events (Mouse and Keyboard events)
        canvas = new Canvas();
        canvas.setBounds(0, 0, WIDTH, HEIGHT);
        canvas.setIgnoreRepaint(true);

        panel.add(canvas);  // adds the canvas to the panel.

        // frame operations
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //makes the frame close and exit nicely
        frame.pack();  //adjusts the frame and its contents so the sizes are at their default or larger
        frame.setResizable(false);   //makes it so the frame cannot be resized
        frame.setVisible(true);      //IMPORTANT!!!  if the frame is not set to visible it will not appear on the screen!

        // sets up things so the screen displays images nicely.
        canvas.createBufferStrategy(2);
        bufferStrategy = canvas.getBufferStrategy();
        canvas.requestFocus();
        System.out.println("DONE graphic setup");

    }
    private void render() {
        Graphics2D g = (Graphics2D) bufferStrategy.getDrawGraphics();
        g.clearRect(0, 0, WIDTH, HEIGHT);

        //draw the image of the astronaut
        g.drawImage(backround, 0, 0, WIDTH, HEIGHT, null);
        g.drawImage(Fish1Pic, Fish1.xpos, Fish1.ypos, Fish1.width, Fish1.height, null);
        g.drawImage(Fish2Pic, Fish2.xpos, Fish2.ypos, Fish2.width, Fish2.height, null);
        g.drawImage(Fish3Pic, Fish3.xpos, Fish3.ypos, Fish3.width, Fish3.height, null);
        g.drawImage(Fish4Pic, Fish4.xpos, Fish4.ypos, Fish4.width, Fish4.height, null);
        g.drawImage(sharkPic, shark.xpos, shark.ypos, shark.width, shark.height, null);
        g.drawImage(Fish5Pic, Fish5.xpos, Fish5.ypos, Fish5.width, Fish5.height, null);
        g.drawImage(Fish6Pic, Fish6.xpos, Fish6.ypos, Fish6.width, Fish6.height, null);



        g.dispose();

        bufferStrategy.show();
    }


}