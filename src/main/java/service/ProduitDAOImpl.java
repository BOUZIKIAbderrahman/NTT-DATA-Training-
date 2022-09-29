package service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;

import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import dao.ProduitDAO;
import entities.Produit;
import util.HibernateUtil;


public class ProduitDAOImpl implements ProduitDAO {
	private static final Logger logger = Logger.getLogger(ProduitDAOImpl.class.getName());

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return HibernateUtil.getSessionFactory();
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Could not create SessionFactory", e);
			throw new IllegalStateException("Could not create SessionFactory");
		}
	} 
	
	@Override
	public void addProduit(Produit produit) {
		Session session = this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(produit);
		session.getTransaction().commit();
		logger.info("Produit saved successfully, Produit Details="+produit);
	}

	@Override
	public void updateProduit(Produit produit) {
		Session session = this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.update(produit);
		session.getTransaction().commit();
		logger.info("Produit updated successfully, Produit Details="+produit);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Produit> listProduits() {
		Session session = this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		List<Produit> ProduitsList = session.createQuery("from Produit").list();
		session.getTransaction().commit();
		
		return ProduitsList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Produit> selectCatByKeyword(String keyWord) {
		Session session = this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		List<Produit> ProduitsList = session.createQuery("from Produit c WHERE c.nom LIKE '%"+keyWord+"%'").list();
		session.getTransaction().commit();
		
		return ProduitsList;
	}
	@Override
	public Produit getProduitById(int id) {
		Session session = this.sessionFactory.getCurrentSession();	
		session.beginTransaction();
		Produit produit = (Produit) session.load(Produit.class, new Integer(id));
		session.getTransaction().commit();
		//logger.info("Produit loaded successfully, Produit details="+produit);
		return produit;
	}

	@Override
	public void removeProduit(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		Produit produit = (Produit) session.load(Produit.class, new Integer(id));
		
		if(null != produit){
			session.delete(produit);
		}
		session.getTransaction().commit();
		logger.info("Produit deleted successfully, Produit details="+produit);
	}
}
