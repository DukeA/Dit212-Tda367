package Model.GameObjects;


import Model.GameObjects.Physics.CircleBody;

/**
 * Created by DukeA on 2017-05-12.
 */
public class SDownBrick  extends Brick {

    private  Enum value;
    private float speedValue;

    public SDownBrick(float xPos, float yPos, float width, float height) {
        super(xPos,yPos, width,height);
        this.value = BrickType.SLOW_DOWN_BALL;

    }

    public void setSpeed() {
        if (this.equals(null)) {
            this.speedValue=+100;
        }
    }
    public float getSpeed() {
        return this.speedValue;
    }
    public

    //TODO What else needs to be here?
}
