/**
 * Created by 1 on 5/23/2016.
 */
public class AdapterApp {
    public static void main(String[] args) {
        VectorGraphicsInterface g1 = new VectorAdapterFromRaster1(new RasterGraphics());
        g1.drawline();
        g1.drawSquare();
    }
}

interface VectorGraphicsInterface{
    void drawline();
    void drawSquare();
}

class RasterGraphics{
    void drawRasterLine(){
        System.out.println("Draw line");
    }

    void drawRasterSquare(){
        System.out.println("Draw square");
    }
}

/**
 * adapter realized using inheritance
 */
class VectorAdapterFromRaster extends RasterGraphics implements VectorGraphicsInterface{

    @Override
    public void drawline() {
        drawRasterLine();
    }

    @Override
    public void drawSquare() {
        drawRasterSquare();
    }
}

/**
 * adapter using composition
 */
class VectorAdapterFromRaster1 implements VectorGraphicsInterface{

    RasterGraphics raster = null;
    public VectorAdapterFromRaster1(RasterGraphics raster){
        this.raster = raster;
    }

    @Override
    public void drawline() {
        raster.drawRasterLine();
    }

    @Override
    public void drawSquare() {
        raster.drawRasterSquare();
    }
}