package Main;

import javafx.scene.image.Image;

/**
 * Created by Jekaterina on 30.12.2016.
 */
public class PipePic {
    private static Image cpipe = new Image("Main/img/c-pipe.png");
    private static Image ipipe = new Image("Main/img/i-pipe.png");
    private static Image tpipe = new Image("Main/img/t-pipe.png");
    private static Image xpipe = new Image("Main/img/x-pipe.png");

    public static Image getImage (PipePicType type) {
        switch (type) {
            case CPIPE:
                return cpipe;
            case IPIPE:
                return ipipe;
            case TPIPE:
                return tpipe;
            case XPIPE:
                return xpipe;
            default:
                //http://stackoverflow.com/questions/24863185/what-is-an-assertionerror-in-which-case-should-i-throw-it-from-my-own-code
                throw new AssertionError("Must not instantiate an element of this class");
        }
    }
}
