package com.softland.example.hackerrank.vsa;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
  
  Given the following structure print all categories and children as a list
  
Entreteiment
	Movies
		Terror
		Action
		SciFicction
	Music
		Rock
			Metal
			Alternative
		Opera
	Sport
		Soccer
		Futball
	
	
Output: Entreteiment, Movies, Terror, Action, SciFicction, Music, Rock, Metal, Alternative, Opera, Sport, Soccer, Futball
  
 */
public class Vsa01_Categories {

	public static void main(String[] args) {

		Category root = new Category("Entreteiment");
		
		Category Movies = new Category("Movies");
		Movies.addChildren("Terror");
		Movies.addChildren("Action");
		Movies.addChildren("SciFicction");
		
		Category Music = new Category("Music");
			Category rock = new Category("ROCK");
			rock.addChildren("Metal");
			rock.addChildren("Alternative");
		Music.addChildren(rock);
		Music.addChildren("Opera");
		
		Category Sport = new Category("Sport");
		Sport.addChildren("Soccer");
		Sport.addChildren("Futball");
		
		root.addChildren(Movies);
		root.addChildren(Music);
		root.addChildren(Sport);
		
		List<Category> res = getCategoryList(root);
		System.out.println(res); 
	}

	/*
	  La clave es usar una QUEUE para ir agregando los hijos y poder buscar los hijos de los hijos and so on.
	  
	 */
	static List<Category> getCategoryList(Category category) {
		Queue<Category> q = new LinkedList<Category>();
		List<Category> list = new LinkedList<Category>();
		
		if (category == null) return null;
		
		q.add(category);
		
		while(!q.isEmpty()) {
			Category tmp = q.poll();
			if (tmp != null) {
				list.add(tmp);
				if (tmp.children!=null && !tmp.children.isEmpty()) {
					for(Category c: tmp.children) {
						q.add(c);
					}
				}
			}
		}
		return list;
	}
}


class Category {
	String label;
	List<Category> children;
	
	Category(String label) {
		this.label = label;
	}
	
	public void addChildren(String c) {
		if (this.children == null)  this.children = new ArrayList<Category>();
		this.children.add(new Category(c));
	}
	
	public void addChildren(Category c) {
		if (children == null) children = new ArrayList<Category>();
		children.add(c);
	}
	
	public List<Category> getChildren() {
		if (this.children == null) this.children = new ArrayList<Category>();
		return this.children;
	}
	
	@Override
	public String toString() {
		return this.label;
	}
}



