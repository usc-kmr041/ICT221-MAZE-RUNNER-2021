package mazerunner.engine;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class GameEngineTest {
    @Test
    public void testGenerateMap(){
        Map Map = new Map();
        Map.GenerateMap(4);
    }
    @Test
    public void testMove(){
        Map Map = new Map();
        Map.move('u');
    }
    @Test
    public void testPrintMap(){
        Map Map = new Map();
        Map.PrintMap();
    }
}
