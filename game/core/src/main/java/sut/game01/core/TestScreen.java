package sut.game01.core;
import static playn.core.PlayN.*;

import playn.core.Mouse;
import playn.core.Touch;
import  tripleplay.game.Screen;
import tripleplay.game.ScreenStack;
import playn.core.Image;
import playn.core.ImageLayer;

public class TestScreen extends Screen {

    private final ScreenStack ss;
    private final ImageLayer back;
    private final ImageLayer bg;

    public TestScreen(final ScreenStack ss) {

        this.ss = ss;
        Image bgImage = assets().getImage("images/bg.png");
         this.bg = graphics().createImageLayer(bgImage);

        Image backImage = assets().getImage("images/back.png");
         this.back = graphics().createImageLayer(backImage);

        back.addListener(new Mouse.LayerAdapter() {
            @Override
            public void onMouseUp(Mouse.ButtonEvent event) {
                ss.remove(ss.top()); //back screen //popScreen
            }

        });
    }

    @Override
    public void wasShown() {
        super.wasShown();
        this.layer.add(bg);
        this.layer.add(back);
    }


}