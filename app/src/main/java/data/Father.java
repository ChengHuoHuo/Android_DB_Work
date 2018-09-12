package data;

/**
 * Created by 44223 on 2018/9/2.
 */

public class Father {
    public int id;
    public String name;
    public String words;

    public Father(int id) {
        super();
        this.id=id;
    }
    public Father(int id,String name,String words) {
        super();
        this.id=id;
        this.name = name;
        this.words = words;
    }

    public Father(String name,String words) {
        super();
        this.name = name;
        this.words = words;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getWords() {
        return words;
    }

    public void setWords(String words) {
        this.words = words;
    }

    @Override
    public String toString() {
        return "Father{" +
                ", name='" + name + '\'' +
                ", words='" + words + '\'' +
                '}';
    }
}
