package io.zerocontribution.summer.ai.pathfinding;

import com.esotericsoftware.minlog.Log;
import io.zerocontribution.summer.components.PairMap;
import io.zerocontribution.summer.struct.Pair;

public class IsometricTileMap implements TileBasedMap {

    private int width;
    private int height;
    private PairMap tilePairMap;

    public IsometricTileMap(int width, int height, PairMap tilePairMap) {
        this.width = width;
        this.height = height;
        this.tilePairMap = tilePairMap;
    }

    @Override
    public int getWidthInTiles() {
        return width;
    }

    @Override
    public int getHeightInTiles() {
        return height;
    }

    @Override
    public void pathFinderVisited(int x, int y) {
        Log.debug("Pathfinding.AStar", x + "," + y);
    }

    @Override
    public boolean blocked(Mover mover, int x, int y) {
        return tilePairMap.map.containsKey(Pair.get(x, y));
    }

    @Override
    public float getCost(Mover mover, int sx, int sy, int tx, int ty) {
        return 1;
    }

}
