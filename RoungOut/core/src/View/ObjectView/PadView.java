package View.ObjectView;

import Model.GameObjects.Board;
import Model.GameObjects.IPlayer;
import Model.GameObjects.Player;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.PolygonSprite;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Polygon;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DukeA on 2017-05-02.
 */
public class PadView implements IViews {

    private Board Pads;
    private ShapeRenderer shapeRenderer;
    private  ShapeRenderer shapeRenderer2;
    private Polygon polygon;
    private int WIDTH;
    private int HEIGHT;

    float[] vertices = new float[] {

    };


    public PadView(int width, int height,ShapeRenderer shapeRenderer, Board board) {
        this.WIDTH = width;
        this.HEIGHT = height;
        this.shapeRenderer = shapeRenderer;
        this.shapeRenderer2 = shapeRenderer;
        this.polygon = new Polygon();
        this.Pads = board;

    }

    public void render(float delta) {
        List<Player> p = new ArrayList<Player>(Pads.getPlayers());
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.BLUE);
        shapeRenderer.rect(p.get(0).getPad().getPadXPos(),
                p.get(0).getPad().getPadYPos(),
                p.get(0).getPad().getOriginX(),
                p.get(0).getPad().getOriginY(),
                p.get(0).getPad().getWidth(),
                p.get(0).getPad().getLength(),
                1,1,
                p.get(0).getPad().getAngle());
        shapeRenderer.end();


        shapeRenderer2.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer2.setColor(Color.LIME);
        shapeRenderer2.rect(
                p.get(1).getPad().getPadXPos(),
                p.get(1).getPad().getPadYPos(),
                p.get(1).getPad().getOriginX(),
                p.get(1).getPad().getOriginY(),
                p.get(1).getPad().getWidth(),
                p.get(1).getPad().getLength(),
                1,1,
                p.get(1).getPad().getAngle());
        shapeRenderer2.end();
    }


    public void reSize(int width, int height) {

    }

    public void dispose() {
        shapeRenderer.dispose();
    }

    @Override
    public void update(float delta) {

    }

}
