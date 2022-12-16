package ru.skypro.automationSocks.entity;

import java.io.Serializable;
import java.util.Objects;

public class SocksId implements Serializable {

    private String socksColor;
    private Integer socksCotton;

    public SocksId() {
    }

    public SocksId(String socksColor, Integer socksCotton) {
        this.socksColor = socksColor;
        this.socksCotton = socksCotton;
    }

    public String getSocksColor() {
        return socksColor;
    }

    public void setSocksColor(String socksColor) {
        this.socksColor = socksColor;
    }

    public Integer getSocksCotton() {
        return socksCotton;
    }

    public void setSocksCotton(Integer socksCotton) {
        this.socksCotton = socksCotton;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SocksId socksId = (SocksId) o;
        return Objects.equals(socksColor, socksId.socksColor) && Objects.equals(socksCotton, socksId.socksCotton);
    }

    @Override
    public int hashCode() {
        return Objects.hash(socksColor, socksCotton);
    }
}
