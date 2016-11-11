package Main;

import Main.PomoController;
import Main.PomoService;

/**
 * Created by adamfranzen on 11/10/16.
 */
public class Main {
    public static void main(String[] args) {

        new PomoController(new PomoService());
    }
}
