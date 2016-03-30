package sut.game01.core;
import static playn.core.PlayN.*;

import playn.core.Mouse;
import playn.core.Touch;
import sut.game01.core.Character.Zealot;
import  tripleplay.game.Screen;
import tripleplay.game.ScreenStack;
import playn.core.Image;
import playn.core.ImageLayer;

public class TestScreen extends Screen {

    private final ScreenStack ss;
    private final ImageLayer back;
    private final ImageLayer bg;
    private  Zealot z;

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
        this.layer.add(bg); //ใส่ BG
        this.layer.add(back); // ปุ่ม Back
         z = new Zealot(560f,400f);
        this.layer.add(z.layer());
    }

    public void update(int delta) {
        this.z.update(delta);
    }
}