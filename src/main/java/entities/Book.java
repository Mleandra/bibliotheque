package entities;

import java.util.Date;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "title", nullable = false, length = 250)
    private String title;

    @Column(name = "price")
    private double price;

    @Column(name = "dateEdition")
    private Date dateEdition;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CATEGORY_ID")

    private Category category;


    public Book(String title, double price, Date dateEdition, Category category) {

        this.title = title;
        this.price = price;
        this.dateEdition = dateEdition;
        this.category = category;
    }

    public Book() {

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getDateEdition() {
        return dateEdition;
    }

    public void setDateEdition(Date dateEdition) {
        this.dateEdition = dateEdition;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +'\'' +
                ", title='" + title + '\'' +
                ", price=" + price +'\'' +
                ", dateEdition=" + dateEdition +'\'' +
                ", category=" + category +
                '}';
    }
}
