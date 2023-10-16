package org.example;

public class Cities {
    //id,name,state_id, country_id,latitude,longitude
    private int id;

    public int getState_code() {
        return state_code;
    }

    public void setState_code(int state_code) {
        this.state_code = state_code;
    }

    private String name;
    private int state_code;
    private int cid;
    private String code;
    private float latitude;
    private float longitude;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public Cities(int id, String name, int cid, String code,int state_code, float latitude, float longitude) {
        this.id = id;
        this.name = name;
        this.cid = cid;
        this.code = code;
        this.latitude = latitude;
        this.longitude = longitude;
        this.state_code = state_code;
    }

    @Override
    public String toString() {
        return "\nCities{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", state_code=" + state_code +
                ", cid=" + cid +
                ", code='" + code + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
