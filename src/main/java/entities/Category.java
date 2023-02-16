package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Category")
public class Category {
    @Id
    @GeneratedValue
    @Column(name = "CATEGORY_ID")
    private int categoryId;

    @Column(name = "CATEGORY_TITLE", nullable = false, length = 250)
    private String title;

    @Column(name = "CATEGORY_NBBOOK", nullable = false, length = 50)
    private int nbBook;


    public Category() {
    }

    public Category(int id, String title, int nbBook) {
        this.categoryId =id;
        this.title = title;
        this.nbBook = nbBook;
    }

    public Category(String title, int nbBook) {
        this.title = title;
        this.nbBook = nbBook;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNbBook() {
        return nbBook;
    }

    public void setNbBook(int nbBook) {
        this.nbBook = nbBook;
    }

    @Override
    public String toString() {
        return "Category [categoryId=" + categoryId + ", title=" + title + ", nbBook=" + nbBook + "]";
    }

}