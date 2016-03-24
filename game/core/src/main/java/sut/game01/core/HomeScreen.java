package sut.game01.core;
import playn.core.Font;
import react.UnitSlot;
import tripleplay.game.UIScreen;
import tripleplay.game.ScreenStack;
import tripleplay.ui.*;
import tripleplay.ui.layout.AxisLayout;
import static playn.core.PlayN.graphics;

public class HomeScreen extends UIScreen{
	    private final ScreenStack ss;
        private final TestScreen testScreen;

    public static final Font TITLE_FONT =
            graphics().createFont("Helvetica", Font.Style.PLAIN, 24);
        private Root root;

    public HomeScreen (ScreenStack ss){
 	    this.ss = ss;
        this.testScreen = new TestScreen(ss);
 }

    @Override
    public void wasShown(){
        super.wasShown();
        root = iface.createRoot(
                AxisLayout.vertical().gap(15),
                SimpleStyles.newSheet(),layer);
        root.addStyles(Style.BACKGROUND
                .is(Background.bordered("images/aa.png", 0xFF99CCFF, 5)
                .inset(5,10)));
        root.setSize(width(), height());
        root.add(new Label("EVENT DRIVEN PROGRAMMING")
        .addStyles(Style.FONT.is(HomeScreen.TITLE_FONT)));

        root.add(new Button("Start").onClick(new UnitSlot(){
            public void onEmit(){
                ss.push(testScreen);
            }
        }));
    }

}