package Main;

import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;


public final class Pipe extends Region {
    public boolean T;  //top
    public boolean R;  //right
    public boolean B;  //bottom
    public boolean L;  //left
    public boolean flowChecked;

    private Position Position;

    private PipePicType picType;
    private boolean hasFlow;
    private BackgroundImage[] backgroundImage;

    public Pipe(boolean t, boolean r, boolean b, boolean l){
        T = t;
        R = r;
        B = b;
        L = l;

        setImage();
        setInitialImageAngle();
        setFlow(false);
    }

    public void rotateClockwise(){
        if (this.picType == PipePicType.START || this.picType == PipePicType.FINISH){
            return;                     //kui objektideks on START või FINISH ei tee nendega midagi
        }

        boolean temp = T;
        T = L;
        L = B;
        B = R;
        R = temp;
        double newAngle = (this.getRotate() + 90);
        setRotate(newAngle);
    }

    public void rotateCounterClockwise(){
        if (this.picType == PipePicType.START || this.picType == PipePicType.FINISH){
            return;                     //kui objektideks on START või FINISH ei tee nendega midagi
        }

        boolean temp = T;
        T = R;
        R = B;
        B = L;
        L = temp;
        double newAngle = (this.getRotate() - 90);
        setRotate(newAngle);
    }

    public void setPosition(int x, int y){
        Position = new Position(x, y);
    }

    public int x(){
        return Position.X;
    }

    public int y(){
        return Position.Y;
    }

    private void setImage(){
        int count = (T ? 1 : 0)    //Kui torus on avatud ots üleval, tagasta 1
                + (R ? 1 : 0)      //Kui torus on avatud ots paremal, tagasta 1
                + (B ? 1 : 0)      //Kui torus on avatud ots all, tagasta 1
                + (L ? 1 : 0);     //Kui torus on avatud ots vasakul, tagasta 1


        switch(count){
            case 2:                              //Kui torus on 2 avatud otsa, joonistatakse kas IPIPE või CPIPE
                if ((T && B) || (L && R)) {
                    picType = PipePicType.IPIPE; //IPIPE siis, kui avatud otsad on üleval-all või vasakul-paremal
                } else {                         //vastasel juhul CPIPE
                    picType = PipePicType.CPIPE;
                }
                break;
            case 1:
                if (R){
                    picType = PipePicType.START;
                } else {
                    picType = PipePicType.FINISH;
                }
                break;
        }

        Image pic = PipePic.getImage(picType);

        backgroundImage = new BackgroundImage[]{    //torude joonistamine
                new BackgroundImage(pic,
                        BackgroundRepeat.NO_REPEAT,
                        BackgroundRepeat.NO_REPEAT,
                        BackgroundPosition.DEFAULT,
                        BackgroundSize.DEFAULT)
        };
    }

    public void setFlow(boolean newFlow){
        hasFlow = newFlow;
        updateBackground();
    }

    public boolean hasFlow(){                                   //hasFlow muutuja väärtus kättesaadav klassis Main
        return hasFlow;
    }

    private void updateBackground(){
        BackgroundFill[] fills = new BackgroundFill[]{
                new BackgroundFill(hasFlow ? Color.LIGHTBLUE : Color.WHITESMOKE,
                        CornerRadii.EMPTY,
                        null)
        };

        Background back = new Background(fills, backgroundImage);
        setBackground(back);
    }

    private void setInitialImageAngle(){                        //esmane pildi nurk
        double angle = 0;
        switch(this.picType){
            case CPIPE:
                if(L && B)
                    angle = 0;
                else if(T && L)
                    angle = 90;
                else if(T && R)
                    angle = 180;
                else if(R && B)
                    angle = 270;
                break;
            case IPIPE:
                if (T && B) {
                    angle = 0;
                }else if (L && R){
                    angle = 90;
                }
                break;
            case START:
            case FINISH:
                angle = 0;
                break;
            default:
                throw new AssertionError(this.picType.name());
        }
        setRotate(angle);
    }
}

