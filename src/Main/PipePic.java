package Main;

import javafx.scene.image.Image;

/**
 * Created by Jekaterina on 30.12.2016.
 */
public class PipePic {
    private static final Image cpipe = new Image("/Main/img/c-pipe.png");
    private static final Image ipipe = new Image("/Main/img/i-pipe.png");
    private static final Image tpipe = new Image("/Main/img/t-pipe.png");
    private static final Image xpipe = new Image("/Main/img/x-pipe.png");
    private static final Image start = new Image("/Main/img/start.png");
    private static final Image finish = new Image("/MAin/img/finish.png");

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
            case START:
                return start;
            case FINISH:
                return finish;
            default:
                //http://stackoverflow.com/questions/24863185/what-is-an-assertionerror-in-which-case-should-i-throw-it-from-my-own-code
                throw new AssertionError(type.name());
        }
    }
}
