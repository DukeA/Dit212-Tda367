package Tests;

import Model.GameObjects.Physics.RectangleBody;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Ken Bäcklund
 */
class RectangleBodyTest {

    private static final float THRESHOLD = 0.0001f;

    private static final float XPOS = 100f;
    private static final float YPOS = -100f;
    private static final float WIDTH = 40f;
    private static final float HEIGHT = 20f;
    private static final float ANGLE = (float) Math.PI / 2f;   // =45 degrees
    private static final float SPEED = 10f;

    private RectangleBody body;



    @BeforeEach
    void setUp() {
        body = new RectangleBody(XPOS, YPOS, WIDTH, HEIGHT, ANGLE, SPEED);
    }

    @Test
    void getX() {
        Assertions.assertEquals(XPOS, body.getX(), THRESHOLD);
    }

    @Test
    void getY() {
        Assertions.assertEquals(YPOS, body.getY(), THRESHOLD);
    }

    @Test
    void getWidth() {
        Assertions.assertEquals(WIDTH, body.getWidth(), THRESHOLD);
    }

    @Test
    void getHeight() {
        Assertions.assertEquals(HEIGHT, body.getHeight(), THRESHOLD);
    }

    @Test
    void getAngle() {
        double expectedAngle = (ANGLE + 8f*Math.PI) % (2f*Math.PI);
        Assertions.assertEquals(expectedAngle, body.getAngle(), THRESHOLD);
    }

    @Test
    void getSpeed() {
        Assertions.assertEquals(SPEED, body.getSpeed(), THRESHOLD);
    }

    @Test
    void setX() {
        float expectedX = XPOS + 10f;
        body.setX(expectedX);
        Assertions.assertEquals(expectedX, body.getX(), THRESHOLD);
    }

    @Test
    void setY() {
        float expectedY = YPOS - 10f;
        body.setY(expectedY);
        Assertions.assertEquals(expectedY, body.getY(), THRESHOLD);
    }

    @Test
    void setPosition() {
        float expectedX = XPOS + 10f;
        float expectedY = YPOS - 10f;
        body.setPosition(expectedX, expectedY);
        Assertions.assertEquals(expectedX, body.getX(), THRESHOLD);
        Assertions.assertEquals(expectedY, body.getY(), THRESHOLD);
    }

    @Test
    void setSize() {
        float expectedX = WIDTH + 10f;
        float expectedY = HEIGHT - 10f;
       // body.setSize(expectedX, expectedY);
        body.setWidth(expectedX);
        body.setHeight(expectedY);
        Assertions.assertEquals(expectedX, body.getWidth(), THRESHOLD);
        Assertions.assertEquals(expectedY, body.getHeight(), THRESHOLD);
    }

    @Test
    void setAngle() {
        float maxAngle = (float)(2f*Math.PI);
        float minAngle = -maxAngle;
        for (float a = minAngle; a < maxAngle; a += maxAngle/32f) {
            double expectedAngle = (a + 8f*Math.PI) % (2f*Math.PI);
            body.setAngle(a);
            Assertions.assertEquals(expectedAngle, body.getAngle(), THRESHOLD);
        }
    }

    @Test
    void setSpeed() {
        float expectedSpeed = SPEED + 100f;
        body.setSpeed(expectedSpeed);
        Assertions.assertEquals(expectedSpeed, body.getSpeed(), THRESHOLD);
    }

    @Test
    void setMaxSpeed() {
        body.setMaxSpeed(SPEED);
        body.setSpeed(SPEED + 10f);
        Assertions.assertEquals(SPEED, body.getSpeed(), THRESHOLD);
    }

    @Test
    void distanceTwoRectangles() {

        float otherWidth = HEIGHT;     // Same dimensions with a 90 degree turn
        float otherHeight = WIDTH;

        float range = 2f*(WIDTH + HEIGHT);

        RectangleBody other = new RectangleBody(0f, 0f, otherWidth, otherHeight);
        body.setPosition(0f, 0f);

        System.out.printf("%.2f   %.2f\n", body.distance(other), other.distance(body));

        for (float ry = -range; ry < range; ry++) {
            for (float rx = -range; rx < range; rx++) {
                other.setPosition(rx, ry);

            }
        }

    }

    @Test
    void distanceOtherBody() {
        // TODO:  Measure distance to Body of different type (ie. CircleBody)
        // CircleBody cBody = new CircleBody(cXPos, cYPos, cRadius, cAngle, cSpeed);
        //fail("Tests.distanceCircleRectangle() not yet implemented.");
    }

    @Test
    void move() {
        for (double a = -2f*Math.PI; a < 2f*Math.PI; a += Math.PI/64f) {
            double expectedX = body.getX() + Math.cos(ANGLE) * SPEED;
            double expectedY = body.getY() + Math.sin(ANGLE) * SPEED;
            body.move();
            Assertions.assertEquals(expectedX, body.getX(), THRESHOLD);
            Assertions.assertEquals(expectedY, body.getY(), THRESHOLD);
        }
    }

}