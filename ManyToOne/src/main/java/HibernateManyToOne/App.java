package HibernateManyToOne;

public class App {
    public static void main(String[] args) {
        Publisher p = new Publisher();
        p.setPname("Penguin Random House");
        p.setEmail("penguin@gmail.com");
        p.setPhone(630123783L);

        Book b1 = new Book();
        b1.setName("Why We Sleep");
        b1.setAuthor("Matthew Walker");
        b1.setCost(350);
        b1.setRating(5);
        b1.setPub(p);

        Book b2 = new Book();
        b2.setName("Unfinished");
        b2.setAuthor("Priyanka Chopra");
        b2.setCost(400);
        b2.setRating(5);
        b2.setPub(p);

        // add both books to publisher
        p.getBooks().add(b1);
        p.getBooks().add(b2);

        HibernateManager hbm = new HibernateManager();
        hbm.insertPublisher(p);
        hbm.close();
    }
}
