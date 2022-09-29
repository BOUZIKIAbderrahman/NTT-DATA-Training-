
package actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import entities.Categorie;
import entities.Produit;
import dao.CategorieDAO;
import dao.ProduitDAO;
import service.CategorieDAOImpl;
import service.ProduitDAOImpl;

public class ProduitAction extends ActionSupport implements ServletRequestAware, SessionAware {

	private static final long serialVersionUID = 1L;
	private List<Produit> listProduits = new ArrayList<Produit>();
	private List<Categorie> listCategories = new ArrayList();

	public List<Categorie> getListCategories() {
		return listCategories;
	}

	public void setListCategories(List<Categorie> listCategories) {
		this.listCategories = listCategories;
	}

	private ArrayList<String> listPseudos = new ArrayList<String>();
	private int idCategorie;

	public int getIdCategorie() {
		return idCategorie;
	}

	public void setIdCategorie(int idCategorie) {
		this.idCategorie = idCategorie;
	}

	private Categorie categorie;

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	ProduitDAO cs = new ProduitDAOImpl();
	private int idProduit;
	private String nomProduit;

	public String getNomProduit() {
		return nomProduit;
	}

	public void setNomProduit(String nomProduit) {
		this.nomProduit = nomProduit;
	}

	private String photo;

	private int prix;

	private int quantite;

	public int getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(int idProduit) {
		this.idProduit = idProduit;
	}

	public ProduitDAO getCs() {
		return cs;
	}

	public void setCs(ProduitDAO cs) {
		this.cs = cs;
	}

	private String pseudo;

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	private Produit theProduit;

	// private File photo;

	private HttpServletRequest servletRequest;
	private Map<String, Object> maSession;

	public List<Produit> getListProduits() {
		return listProduits;
	}

	public void setListProduits(List<Produit> listProduis) {
		this.listProduits = listProduis;
	}

	public ArrayList<String> getListPseudos() {
		return listPseudos;
	}

	public void setListPseudos(ArrayList<String> listPseudos) {
		this.listPseudos = listPseudos;
	}

	public Produit getTheProduit() {
		return theProduit;
	}

	public void setTheProduit(Produit theProduit) {
		this.theProduit = theProduit;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public String enregistrer() {

		Produit Produit = new Produit();
		CategorieDAO cDao = new CategorieDAOImpl();
		Categorie cat = cDao.getCategorieById(idCategorie);
		Produit.setCategorie(cat);
		Produit.setNomProduit(nomProduit);
		Produit.setPrix(prix);
		Produit.setPhoto(photo);
		Produit.setQuantite(quantite);

		cs.addProduit(Produit);
		for (Produit catt : cs.listProduits()) {
			listProduits.add(catt);
		}
		System.out.println(listProduits.size());

		return "success";

	}

	public Map<String, Object> getMaSession() {
		return maSession;
	}

	public void setMaSession(Map<String, Object> maSession) {
		this.maSession = maSession;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public HttpServletRequest getServletRequest() {
		return servletRequest;
	}

	public String lister() {
		
		ProduitDAO cs = new ProduitDAOImpl();
		CategorieDAO cDao = new CategorieDAOImpl();
		Categorie cat = cDao.getCategorieById(idCategorie);
		listProduits = cat.getProduits();

		return "success";
	}

	public String listerAll() {

		ProduitDAO cs = new ProduitDAOImpl();

		listProduits = (ArrayList<Produit>) cs.listProduits();

		return "success";
	}

	public String supprimer() {

		cs.removeProduit(idProduit);
		ProduitDAO cs = new ProduitDAOImpl();
		listProduits = (ArrayList<Produit>) cs.listProduits();
		return "success";
	}

	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub

	}

	public String listePseudosContact() {
		ProduitDAO cs = new ProduitDAOImpl();
		// listPseudos = new ArrayList<String>(cs.listPseudos());
		return "success";
	}

	public String detailsContact() {
		ProduitDAO cs = new ProduitDAOImpl();

		if (getPseudo() != null && !getPseudo().equals("")) {
			listProduits = new ArrayList<>(cs.selectCatByKeyword(pseudo));
		}

		return "success";
	}

	public String saisir() {
		CategorieDAO cs = new CategorieDAOImpl();
		listCategories = cs.listCategories();
		return "success";
	}

}
