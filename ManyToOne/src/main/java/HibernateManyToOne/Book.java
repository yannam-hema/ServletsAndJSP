package HibernateManyToOne;

import javax.persistence.*;

@Entity
@Table(schema = "gqt_hib", name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bid;

    @Column
    private String name;

    @Column
    private String author;

    @Column
    private int cost;

    @Column
    private int rating;

    @ManyToOne
    @JoinColumn(name = "pub_bid", referencedColumnName = "pid")
    private Publisher pub;

    // Getters and setters
    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Publisher getPub() {
        return pub;
    }

    public void setPub(Publisher pub) {
        this.pub = pub;
    }
}
