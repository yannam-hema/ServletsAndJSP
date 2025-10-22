package HibernateOneToOne;
public class App 
{
    public static void main( String[] args )
    {
        Address ad = new Address();
        ad.setAddline("#99");
        ad.setCity("Giddalur");
        ad.setState("AP");
        ad.setPincode(523357);
        
        Employee ep = new Employee();
        ep.setName("lahari");
        ep.setAid(ad);
        HibernateManager hbm = new HibernateManager();
        hbm.insertData(ep);
    }
}
