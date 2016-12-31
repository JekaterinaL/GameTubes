package Main;

import javafx.scene.image.Image;
import javafx.scene.layout.*;


/**
 * Created by Jekaterina on 30.12.2016.
 */
//Region klass võimaldab luua väli muutuva suurusega??
//https://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/Region.html
public class Pipe extends Region {

    private boolean T;  //top
    private boolean R;  //right
    private boolean B;  //bottom
    private boolean L;  //left

    private PipePicType picType;

    //Edasi loon klassi, kust genereeritakse suvaline mäguväli
    public Pipe(boolean t, boolean r, boolean b, boolean l){
        this.T = t;
        this.R = r;
        this.B = b;
        this.L = l;

        setImage();
    }

    private void setImage() {
        int count = (this.T ? 1 : 0)    //Kui torus on olemas avatud ots üleval, tagasta 1
                + (this.R ? 1 : 0)      //Kui torus on olemas avatud ots paremal, tagasta 1
                + (this.B ? 1 : 0)      //Kui torus on olemas avatud ots all, tagasta 1
                + (this.L ? 1 : 0);     //Kui torus on olemas avatud ots vasakul, tagasta 1

        switch (count) {
            case 4:
                this.picType = PipePicType.XPIPE;   //Kui torus on 4 avatud otsa, joonistatakse XPIPE
                break;
            case 3:
                this.picType = PipePicType.TPIPE;   //Kui torus on 3 avatud otsa, joonistatakse TPIPE
                break;
            case 2:                                 //Kui torus on 2 avatud otsa, joonistatakse kas IPIPE või CPIPE
                if ((this.T && this.B) || (this.L && this.R)) {
                    this.picType = PipePicType.IPIPE; //IPIPE siis, kui avatud otsad on üleval ja all või vasakul ja paremal
                } else {                              //vastasel juhul CPIPE
                    this.picType = PipePicType.CPIPE;
                }
                break;
        }

    }
}

