package maze.chenghuohuo.dbwork;

/**
 * Created by 44223 on 2018/9/7.
 */

public class Fit {
    private String name;
    private int imageId;

    public Fit(String name, int imageId){
        this.name=name;
        this.imageId=imageId;
    }
    public String getName(){
        return name;
    }
    public int getImageId(){
        return imageId;
    }
}
