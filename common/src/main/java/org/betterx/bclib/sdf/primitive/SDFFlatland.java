package org.betterx.bclib.sdf.primitive;

public class SDFFlatland extends SDFPrimitive {
    @Override
    public float getDistance(float x, float y, float z) {
        return y;
    }
}
