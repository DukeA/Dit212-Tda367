package Model.GameObjects;

/**
 * Created by Deltagare on 2017-05-01.
 */
public interface IPlayer {
    int getPoints();
    Pad getPad(); // We send the whole object to the ones who want it
}
