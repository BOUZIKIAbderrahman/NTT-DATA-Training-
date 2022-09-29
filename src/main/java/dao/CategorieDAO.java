package dao;

import java.util.List;

import entities.*;

public interface CategorieDAO {
	public void addCategorie(Categorie categorie);
	public void updateCategorie(Categorie categorie);
	public List<Categorie> listCategories();
	public List<String> listPseudos();
	
	public List<Categorie> selectCatByKeyword(String keyWord);
	public Categorie getCategorieById(int id);
	public void removeCategorie(int id);
}
