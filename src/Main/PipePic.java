package Main;

import javafx.scene.image.Image;

public class PipePic {
    private static final Image cpipe = new Image("/Main/img/c-pipe.png");
    private static final Image ipipe = new Image("/Main/img/i-pipe.png");
    private static final Image start = new Image("/Main/img/start.png");
    private static final Image finish = new Image("/MAin/img/finish.png");

    public static Image getImage (PipePicType type) {
        switch (type) {
            case CPIPE:
                return cpipe;
            case IPIPE:
                return ipipe;
            case START:
                return start;
            case FINISH:
                return finish;
            default:
                throw new AssertionError(type.name());
        }
    }
}
