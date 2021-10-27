package sun;


/**
 xuehao: '2018120205', tiwen: '36.6', jkm: null, xcm: null
 */
public class User{
    private String xuehao;
    private String tiwen;
    private String jkm;
    private String xcm;

    public String getXuehao() {
        return xuehao;
    }

    public void setXuehao(String xuehao) {
        this.xuehao = xuehao;
    }

    public String getTiwen() {
        return tiwen;
    }

    public void setTiwen(String tiwen) {
        this.tiwen = tiwen;
    }

    public String getJkm() {
        return jkm;
    }

    public void setJkm(String jkm) {
        this.jkm = jkm;
    }

    public String getXcm() {
        return xcm;
    }

    public void setXcm(String xcm) {
        this.xcm = xcm;
    }

    @Override
    public String toString() {
        return "User{" +
                "xuehao='" + xuehao + '\'' +
                ", tiwen='" + tiwen + '\'' +
                ", jkm='" + jkm + '\'' +
                ", xcm='" + xcm + '\'' +
                '}';
    }
}
