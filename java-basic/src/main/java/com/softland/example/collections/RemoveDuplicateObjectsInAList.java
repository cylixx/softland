package com.softland.example.collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RemoveDuplicateObjectsInAList {

	public static void main(String[] args) {
		
		List<Blog> list = new ArrayList<>();
		list.add(new Blog("A", "Marco", "abc"));
		list.add(new Blog("B", "Sandra", "xal"));
		list.add(new Blog("C", "Ram", "mnc"));
		list.add(new Blog("A", "Marco", "abc"));
		list.add(new Blog("B", "Sandra", "xal"));
		System.out.println("----------- Original list data: -------------");
		System.out.println(list.toString());
		
		
		Set<Blog> s = new HashSet<Blog>(list);
		System.out.println("HashSet output: " + s.toString());
		//s.addAll(list);  //otra forma de asignar todos los elementos de la lista
		
		System.out.println("----------- Remove duplicate data: -------------");
		//list.clear();
		List<Blog> list2 = s.stream().collect(Collectors.toList());
		System.out.println(list2.toString());  
		
		// Solution #2 - using Ja 8 steram().distinct()
		List<Blog> list3 = list.stream().distinct().collect(Collectors.toList());
		System.out.println(list3.toString());
		
	}

}

class Blog {
	private String title;
    private String author;
    private String url;
    
	public Blog(String title, String author, String url) {
		super();
		this.title = title;
		this.author = author;
		this.url = url;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Blog other = (Blog) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("{title=%s, author=%s, url=%s}", title, author, url);
	}
	
}
