package homework4.entity;

import org.hibernate.annotations.OptimisticLock;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "quantity")
    private Long quaitity;

    @Column(name = "price")
    private Double price;

    @Column(name = "something")
    @OptimisticLock(excluded = true)
    private String something;

    @Version
    long version;

    public Product(){

    }

    public Product(String name, Long quaitity, Double price) {
        this.name = name;
        this.quaitity = quaitity;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getQuaitity() {
        return quaitity;
    }

    public void setQuaitity(Long quaitity) {
        this.quaitity = quaitity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getSomething() {
        return something;
    }

    public void setSomething(String something) {
        this.something = something;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quaitity=" + quaitity +
                ", price=" + price +
                ", something='" + something + '\'' +
                ", version=" + version +
                '}';
    }
}
