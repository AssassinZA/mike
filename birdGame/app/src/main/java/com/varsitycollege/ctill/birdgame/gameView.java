package com.varsitycollege.ctill.birdgame;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class gameView extends View {


    // ___________________________________Bitmaps_______________________________________________
    //______________________________________BIRD__________________________________________________
    //getting bird to flap wings (cheating)
    Bitmap bird [] = new Bitmap[2];
    //Setting initial X and Y coordinates to draw bird on screen.
    int birdX =10;
    int birdY =50;
    // Setting bird speed
    int birdSpeed =10;
    //collision?
    boolean ishit_flg =false;
    //_______________________________________Background & Life______________________________________
    Bitmap background;
    //Bitmap Array used to draw lives
    Bitmap life[] = new Bitmap [3];
    int lifeCount;
    //______________________________________________________________________________________________


    //_______________________________ on Screen text________________________________________________
    Paint score;
    Paint level;
    //______________________________________________________________________________________________


    //______________________________blue ball - used for collisions_________________________________
    //  Create X and Y coordinates and set ball speed
    int blueX;
    int blueY;
    int blueSpeed = 15;
    //create paint element that will be used to draw a blue ball.
    Paint bluePaint = new Paint();

    //Black Killer ball that takes a life:

    int blackX;
    int blackY;
    int blackSpeed = 30;
    Paint blackPaint = new Paint();

    //setting score:

    int setScore;


    public gameView(Context context)
    {
        super(context);

    //__________________________________ Preparing on Screen text & Ball____________________________

       // creating Score
        score = new Paint();
        score.setColor(Color.BLACK);
        score.setTypeface(Typeface.DEFAULT_BOLD);
        score.setTextSize(64);
        score.setAntiAlias(true);
        // creating level
        level = new Paint();
        level.setColor(Color.GRAY);
        level.setTypeface(Typeface.DEFAULT);
        level.setTextSize(64);
        level.setTextAlign(Paint.Align.CENTER);
        level.setAntiAlias(true);

        //creating the blue ball
        bluePaint.setColor(Color.BLUE);
        bluePaint.setAntiAlias(false);

        //creating the black killer ball
        blackPaint.setColor(Color.BLACK);
        blackPaint.setAntiAlias(false);



      // set initial score
        setScore = 0;



        //_________________________________________________________________________________________w_

        // Populating Bitmap Array - we will use this to decrease lives...
        life[0] = BitmapFactory.decodeResource(getResources(),R.drawable.smallalive);
        life[1] = BitmapFactory.decodeResource(getResources(),R.drawable.smalltrouble);
        life[2] = BitmapFactory.decodeResource(getResources(),R.drawable.smalldead);

        //setting number of lives
         lifeCount = 3;


    // Preparing backgroud and bird
        background = BitmapFactory.decodeResource(getResources(), R.drawable.treebackground);
        bird[0] = BitmapFactory.decodeResource(getResources(), R.drawable.wingsup);
        bird[1] = BitmapFactory.decodeResource(getResources(), R.drawable.wingsdown);




    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int canvasWidth = canvas.getWidth();
        int canvasHeight = canvas.getHeight();

        canvas.drawBitmap(background, 0, 0, null);

        //__________________________________________move bird_________________________________
        // get the heigt of the bird bitmap and set as mininum  Y axes:
        int minBirdY = bird[0].getHeight();

        //get height of canvase , set maximum Y axis 3 bird heigts above it
        int maxBirdY = canvasHeight -bird[0].getHeight()*3;

        // increment to move bird up a and down: 10 bits at a time up or down the Y axes

        birdY += birdSpeed;

        //setting bounds that bird can move in (Keeping bird on screen):

        if(birdY < minBirdY) birdY = minBirdY;
        if(birdY > maxBirdY) birdY = maxBirdY;
        birdSpeed +=2;

        if(ishit_flg)
        {
            // bird flaps wings
            canvas.drawBitmap(bird[0],birdX,birdY,null);
            ishit_flg = false;

        }


        else
        {
            canvas.drawBitmap(bird[1],birdX,birdY,null);

        }

        //_________________________________________move ball________________________________________

       // move ball accross screen at 15 pixels
        blueX -= blueSpeed;

        if(hitCheck(blueX,blueY))
        {
            setScore +=10;
            blueX = -100;
        }

        //if ball goes off left hand side of screen
        if(blueX < 0)
        {
            // draw the ball 20 pixels off the edge of the screen
            blueX = canvasWidth+20;
            //generate a random number between min and max birdY to draw the ball at a
            //different place every time

            blueY = (int)Math.floor(Math.random()*(maxBirdY - minBirdY)+ minBirdY);
        }

        canvas.drawCircle(blueX,blueY,20,bluePaint);


    // move black Killer ball accross the screen at 20 pixels
        blackX -= blackSpeed;

        // check if black ball has hit bird and lose a life:

        if(hitCheck(blackX,blackY))
        {
            blackX = -100;
            Toast.makeText(getContext(), "Boom", Toast.LENGTH_SHORT).show();
            lifeCount --;
            if(lifeCount == 0)
            {
                Toast.makeText(getContext(), "GAME OVER", Toast.LENGTH_SHORT).show();
            }


        }
        // if the ball has lef the screen on the Y axis

        if (blackX <0)
        {
            // redraw +200 off the screen width
            blackX = canvasWidth + 20 ;

            // generate a random number in the birds bounds and draw the black ball.
            blackY = (int)Math.floor(Math.random()*(maxBirdY - minBirdY)+ minBirdY);
        }


        canvas.drawCircle(blackX,blackY,60,blackPaint);

        for (int i=0; i <3 ; i++)
        {
            int x = (int)(1100 + life[0].getWidth()*1.5 *i);
            int y =0;

            if(i < lifeCount)
            {
                canvas.drawBitmap(life[0],x,y,null);
            }
            else
            {
                canvas.drawBitmap(life[1],x,y,null);
            }

        }

        canvas.drawText("Score : " + setScore, 20,60,score);
        canvas.drawText("Level 1",canvasWidth /2,60,level);
       // canvas.drawBitmap(life[0],1100,0,null);
       // canvas.drawBitmap(life[0],1200,0,null);
        //canvas.drawBitmap(life[0],1300,0,null);

    }

    public boolean hitCheck(int x, int y)
        { // if the x coordinates of the bird is smaller than the x coordinates of the ball
            //and the x coordinates of the ball is smaller than the width of the brid
            if (birdX < x && x < (birdX+ bird[0].getWidth())
                    //AND if the y coordinates of teh bird is smaller than the Y coordinates of the ball
                    //AND the y coordinates of the ball is less than the height of the bird = COLLISION
                    && birdY <y && y < birdY+ bird[0].getHeight())
            {
                return true;
            }

            return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

    if (event.getAction()== MotionEvent.ACTION_DOWN)
    {
        ishit_flg = true;
        birdSpeed =-20;
    }

    return true;

    }
}
