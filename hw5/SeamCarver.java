import edu.princeton.cs.algs4.*;
public class SeamCarver {
    public Picture picture;
    public double[][] energy;

    public SeamCarver(Picture picture) {
        this.picture = picture;
    }


    public Picture picture(){return picture;}                       // current picture
    public     int width(){return picture.width();}                         // width of current picture
    public     int height(){return picture.height();}                        // height of current picture
    public  double energy(int x, int y){return energy[x][y];}            // energy of pixel at column x and row y

    public   int[] findHorizontalSeam(){
        return null;
    }            // sequence of indices for horizontal seam
    public   int[] findVerticalSeam(){
        return null;
    }              // sequence of indices for vertical seam


    public void removeHorizontalSeam(int[] seam){
        picture = SeamRemover.removeHorizontalSeam(picture,seam);
    }
    // remove horizontal seam from picture
    public void removeVerticalSeam(int[] seam){
        picture = SeamRemover.removeHorizontalSeam(picture,seam);
    }
    // remove vertical seam from picture
}

