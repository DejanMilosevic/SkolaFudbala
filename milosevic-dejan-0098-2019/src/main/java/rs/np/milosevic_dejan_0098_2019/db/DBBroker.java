package rs.np.milosevic_dejan_0098_2019.db;

import rs.np.milosevic_dejan_0098_2019.domain.AbstractDomainObject;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

/**
 * Predstavlja genericku klasu kojom se ostvaruje konekcija sa bazom podataka.
 * Sadrzi CRUD operacije kojom se komunicira sa bazom podataka i omogucava rad
 * sa tabelama u okviru nje.
 * 
 * @author Dejan Milosevic
 * @since 1.1.0
 */
public class DBBroker {

	/**
	 * Staticka instanca klase DBBroker
	 */
	private static DBBroker instance;

	/**
	 * Instanca klase Connection za povezivanje sa bazom podataka
	 */
	private Connection connection;

	/**
	 * Prazan konstruktor u okviru koga se vrsi povezivanje sa bazom podataka.
	 */
	private DBBroker() {
		try {
			Properties properties = new Properties();
			properties.load(new FileInputStream("config/dbconfig.properties"));
			//String url = properties.getProperty("url");
			String url = "jdbc:mysql://localhost:3306/skola_fudbala";
			String username = properties.getProperty("username");
			String password = properties.getProperty("password");
			connection = DriverManager.getConnection(url, username, password);
			connection.setAutoCommit(false);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * Vraca instancu za konekciju na bazu podataka.
	 * 
	 * @return vraca instancu za konekciju na bazu podataka kao Connection
	 */
	public Connection getConnection() {
		return connection;
	}

	/**
	 * Vraca instancu klase DBBroker.
	 * 
	 * Koristi se Singleton patern, pri cemu ukoliko je instanca jednaka null, tada
	 * se poziva privatni konstruktor u okviru kojeg se vrsi ostvarivanje konekcije
	 * sa bazom podataka koriscenjem url-a, username-a i lozinke koji se preuzimaju
	 * iz odgovarajuceg fajla.
	 * 
	 * To se vrsi samo jednom, a svaki sledeci put metoda vraca istu tu instancu.
	 * 
	 * @return instanca kao DBBroker
	 */
	public static DBBroker getInstance() {
		if (instance == null) {
			instance = new DBBroker();
		}
		return instance;
	}

	/**
	 * Vraca listu sa elementima apstraktne domenske klase.
	 * 
	 * Nastaje kao rezultat izvrsavanja SELECT upita nad bazom podataka.
	 * 
	 * @param ado domenski objekat sa podacima potrebnim za izvrsavanje SELECT upita
	 * 
	 * @return lista sa elementima apstraktne domenske klase
	 * 
	 * @throws SQLException ako je doslo do greske prilikom izvrsavanja SELECT upita
	 */
	public ArrayList<AbstractDomainObject> select(AbstractDomainObject ado) throws SQLException {
		String upit = "SELECT * FROM " + ado.nazivTabele() + " " + ado.alijas() + " " + ado.join() + " " + ado.uslov();
		System.out.println(upit);
		Statement s = connection.createStatement();
		ResultSet rs = s.executeQuery(upit);
		return ado.vratiListu(rs);
	}

	/**
	 * Izvrsava INSERT upit nad bazom podataka.
	 * 
	 * Koristi se za dodavanje novog reda u tabelu baze podataka.
	 * 
	 * @param ado domenski objekat sa podacima potrebnim za izvrsenje INSERT upita
	 * 
	 * @return pripremljen upit kao PreparedStatement
	 * 
	 * @throws SQLException ako dodje do greske prilikom ubacivanja novog reda u
	 *                      tabelu
	 */
	public PreparedStatement insert(AbstractDomainObject ado) throws SQLException {
		String upit = "INSERT INTO " + ado.nazivTabele() + " " + ado.koloneZaInsert() + " VALUES("
				+ ado.vrednostiZaInsert() + ")";
		System.out.println(upit);
		PreparedStatement ps = connection.prepareStatement(upit, Statement.RETURN_GENERATED_KEYS);
		ps.executeUpdate();
		return ps;
	}

	/**
	 * Izvrsava UPDATE upit nad bazom podataka.
	 * 
	 * Koristi se za izmenu postojeceg reda u tabeli baze podataka.
	 * 
	 * @param ado domenski objekat sa podacima potrebnim za izvrsenje UPDATE upita
	 * 
	 * @throws SQLException ako dodje do greske prilikom izmene postojeceg reda
	 *                      tabele
	 */
	public void update(AbstractDomainObject ado) throws SQLException {
		String upit = "UPDATE " + ado.nazivTabele() + " SET " + ado.vrednostiZaUpdate() + " WHERE "
				+ ado.vrednostZaPrimarniKljuc();
		System.out.println(upit);
		Statement s = connection.createStatement();
		s.executeUpdate(upit);
	}

	/**
	 * Izvrsava DELETE upit nad bazom podataka.
	 * 
	 * Koristi se za brisanje postojeceg reda u tabeli baze podataka.
	 * 
	 * @param ado domenski objekat sa podacima potrebnim za izvrsenje DELETE upita
	 * 
	 * @throws SQLException ako dodje do greske prilikom brisanja postojeceg reda
	 *                      tabele
	 */
	public void delete(AbstractDomainObject ado) throws SQLException {
		String upit = "DELETE FROM " + ado.nazivTabele() + " WHERE " + ado.vrednostZaPrimarniKljuc();
		System.out.println(upit);
		Statement s = connection.createStatement();
		s.executeUpdate(upit);
	}

}
