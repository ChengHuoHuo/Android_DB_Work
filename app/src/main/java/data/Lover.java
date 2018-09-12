package data;

/**
 * Created by 44223 on 2018/9/2.
 */

public class Lover {
    public int id;
    public String name;
    public String words;

    public Lover(int id) {
        super();
        this.id=id;
    }
    public Lover(int id, String name, String words) {
        super();
        this.id=id;
        this.name = name;
        this.words = words;
    }

    public Lover(String name, String words) {
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
        return "Lover{" +
                ", name='" + name + '\'' +
                ", words='" + words + '\'' +
                '}';
    }
}
