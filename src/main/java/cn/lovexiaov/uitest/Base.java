package cn.lovexiaov.uitest;


import android.graphics.Point;
import com.android.uiautomator.core.*;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class Base extends UiAutomatorTestCase {

  protected UiDevice device;

  protected int pxWidth;
  protected int pxHeight;
  protected Point dpSize;

  @Override
  protected void setUp() throws Exception {
    super.setUp();
    device = getUiDevice();

    dpSize = device.getDisplaySizeDp();

    log("The display dp size is: %s * %s", dpSize.x, dpSize.y);

    pxWidth = device.getDisplayWidth();
    pxHeight = device.getDisplayHeight();

    log("The display px size is: %s * %s", pxWidth, pxHeight);
  }

  protected boolean power() {
    return device.pressKeyCode(26);
  }

  protected void log(String s, Object... args) {
    String msg = String.format(s, args);
    System.out.println(msg);
  }

  protected void home() {
    device.pressHome();
  }

  protected void back() {
    device.pressBack();
  }

  protected void swipeDown() {
    device.swipe(pxWidth / 2, pxHeight / 2, pxWidth / 2, pxHeight, 10);
  }

  protected void swipeUp() {
    device.swipe(pxWidth / 2, pxHeight / 2, pxWidth / 2, 0, 10);
  }

  protected void swipeBack() {
    device.swipe(pxWidth / 2, pxHeight / 2, 0, pxHeight / 2, 10);
  }

  protected void swipeForward() {
    device.swipe(pxWidth / 2, pxHeight / 2, pxWidth, pxHeight / 2, 10);
  }

  protected void clickItemByText(String text) throws UiObjectNotFoundException {
    new UiScrollable(
        new UiSelector().scrollable(true)
    ).scrollIntoView(
        new UiSelector().text(text)
    );
    new UiObject(
        new UiSelector().text(text)
    ).click();
  }

  public void testSwipe() {
    for (int i = 0; i < 4; i++) {
      swipeBack();
    }
  }

  @Override
  protected void tearDown() throws Exception {
    super.tearDown();
    device.pressHome();
    device = null;
  }
}
