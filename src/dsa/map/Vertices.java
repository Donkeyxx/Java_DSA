package dsa.map;

/**
 * TODO
 *
 * @author kepler
 * @date 2023-08-13 15:09
 */
public class Vertices {
    //顶点可以是任意类型的对象,例如可以将城市表示为包含名字,人口和市长等信息的对象
    private String cityName;
    private int population;
    private String mayor;

    public Vertices(String cityName, int population, String mayor) {
        this.cityName = cityName;
        this.population = population;
        this.mayor = mayor;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getMayor() {
        return mayor;
    }

    public void setMayor(String mayor) {
        this.mayor = mayor;
    }
}
