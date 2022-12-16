package ru.skypro.automationSocks.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(schema = "public", name = "socksmaintable")
@IdClass(SocksId.class)
public class Socks {

    @Column(name = "socks_color")
    @Id
    private String socksColor;
    @Id
    @Column(name = "socks_cotton")
    private Integer socksCotton;
    @Column(name = "socks_count")
    private Integer socksCount;

    public Socks() {
    }

    public Socks(String socksColor, Integer socksCotton, Integer socksCount) {
        this.socksColor = socksColor;
        this.socksCotton = socksCotton;
        this.socksCount = socksCount;
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

    public Integer getSocksCount() {
        return socksCount;
    }

    public void setSocksCount(Integer socksCount) {
        this.socksCount = socksCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Socks socks = (Socks) o;
        return Objects.equals(socksColor, socks.socksColor) && Objects.equals(socksCotton, socks.socksCotton) && Objects.equals(socksCount, socks.socksCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(socksColor, socksCotton, socksCount);
    }

    @Override
    public String toString() {
        return "Socks{" +
                "socksColor='" + socksColor + '\'' +
                ", socksCotton=" + socksCotton +
                ", socksCount=" + socksCount +
                '}';
    }
}
