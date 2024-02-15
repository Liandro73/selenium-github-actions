package br.com.liandro.steps.hooks;

import br.com.liandro.utils.Utils;
import io.cucumber.java.*;

public class Hooks {

    @Before(order = 0)
    public void start() {
        Utils.setUp();
    }

    @After
    public static void tearDown() {
        Utils.stop();
    }

}
