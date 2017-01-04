package Main;

import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

/**
 * Created by Jekaterina on 02.01.2017.
 */
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
        this.T = t;
        this.R = r;
        this.B = b;
        this.L = l;

        setImage();
        setInitialImageAngle();
        setFlow(false);
    }

    public void rotateClockwise(){
        if (this.picType == PipePicType.START || this.picType == PipePicType.FINISH){
            return;                     //kui objektideks on START või FINISH ei tee nendega midagi
        }

        boolean temp = this.T;
        this.T = this.L;
        this.L = this.B;
        this.B = this.R;
        this.R = temp;
        double newAngle = (this.getRotate() + 90) % 360;
        this.setRotate(newAngle);
    }

    public void rotateCounterClockwise(){
        if (this.picType == PipePicType.START || this.picType == PipePicType.FINISH){
            return;                     //kui objektideks on START või FINISH ei tee nendega midagi
        }

        boolean temp = this.T;
        this.T = this.R;
        this.R = this.B;
        this.B = this.L;
        this.L = temp;
        double newAngle = (this.getRotate() - 90) % 360;
        this.setRotate(newAngle);
    }

    public void setPosition(int x, int y){
        this.Position = new Position(x, y);
    }

    public int x(){
        return this.Position.X;
    }

    public int y(){
        return this.Position.Y;
    }

    private void setImage(){
        int count = (this.T ? 1 : 0)    //Kui torus on olemas avatud ots üleval, tagasta 1
                + (this.R ? 1 : 0)      //Kui torus on olemas avatud ots paremal, tagasta 1
                + (this.B ? 1 : 0)      //Kui torus on olemas avatud ots all, tagasta 1
                + (this.L ? 1 : 0);     //Kui torus on olemas avatud ots vasakul, tagasta 1


        switch(count){
            case 2:                                 //Kui torus on 2 avatud otsa, joonistatakse kas IPIPE või CPIPE
                if ((this.T && this.B) || (this.L && this.R)) {
                    this.picType = PipePicType.IPIPE; //IPIPE siis, kui avatud otsad on üleval ja all või vasakul ja paremal
                } else {                              //vastasel juhul CPIPE
                    this.picType = PipePicType.CPIPE;
                }
                break;                                //break on oluline, kuna vastasel juhul kontrollitud muutujad
            case 1:                                   //kontrollitakse järgmises protsessis
                if (this.R){
                    this.picType = PipePicType.START;
                } else {
                    this.picType = PipePicType.FINISH;
                }
                break;
        }

        Image pic = PipePic.getImage(this.picType);

        backgroundImage = new BackgroundImage[]{
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

    public boolean hasFlow(){
        return hasFlow;
    }

    private void updateBackground(){
        BackgroundFill[] fills = new BackgroundFill[]{
                new BackgroundFill(hasFlow ? Color.LIGHTBLUE : Color.WHITESMOKE,
                        CornerRadii.EMPTY,
                        null)
        };

        Background back = new Background(fills, backgroundImage);
        this.setBackground(back);
    }

    private void setInitialImageAngle(){
        double angle = 0;
        switch(this.picType){
            case CPIPE:
                if(this.L && this.B)
                    angle = 0;
                else if(this.T && this.L)
                    angle = 90;
                else if(this.T && this.R)
                    angle = 180;
                else if(this.R && this.B)
                    angle = 270;
                break;
            case IPIPE:
                if (this.T && this.B) {
                    angle = 0;
                }else if (this.L && this.R){
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
        this.setRotate(angle);
    }
}

